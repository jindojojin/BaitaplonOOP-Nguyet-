package Xuli;

import Infor.Attribute;
import Infor.ClassInfor;
import Infor.Class;
import Infor.Method;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AnalysisClass {
    //xoa bo phan thua trong 1 dong
    public static String fix_Line(String str) {

        int pos, pos2;
        if(str.startsWith("//")) return null;// bat dau bang "//" thi la comment => tra ve null.

        while((pos = str.indexOf("/*")) >0){// vi tri dau xuat hien cua /*
            pos2= str.indexOf("*/");
            str= str.substring(0,pos)+str.substring(pos2+2,str.length()).trim();
        }// cat lay hai doan ngoai cmt

        if((pos = str.indexOf("//")) >0) str= str.substring(0,pos).trim();

        return str;
    }

    int check_braces=0; // bien de kiem tra xem str dang phan tich co o trong 1 method khong dua vao "{" vaf "}", hoat dong giong stack

    //ham kiem tra str dang xet co nam trong 1 method khong
    public boolean is_In_Method(String str){
        if (check_braces >=1) {
            check_braces += (" "+str+" ").split("\\{").length -1;
            check_braces -= (" " + str + " ").split("}").length - 1;
            return true;
        }
        check_braces += (" "+str+" ").split("\\{").length -1;
        check_braces -= (" " + str + " ").split("}").length - 1;
        return false;
    }

    //phan tich file
    public Class analysis(File file){

        ClassInfor classInfor = null;
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Attribute> attributes = new ArrayList<>();

        AnalysisString dataTo = new AnalysisString();

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = fix_Line(sc.nextLine().trim());
//                System.out.println(str);
                if (str == null) continue;
                if(str.indexOf(" class ")>0) {
                    classInfor = dataTo.analysisClassInfor(str);
                    continue;
                }

                if(is_In_Method(str) == true) continue;
                else{
                    if(str.indexOf("{") <0 ) {
                        attributes.add(dataTo.AnalysisAttribute(str));
                        continue;
                    }else{
                        methods.add(dataTo.AnalysisMethod(str));
                        continue;
                    }

                }
            }

        }catch (FileNotFoundException e){
            System.out.println("Khong tim thay file");
        }catch (IOException e) {
            e.printStackTrace();
        }

        return new Class(classInfor,attributes,methods);

    }

}
