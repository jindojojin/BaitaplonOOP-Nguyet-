package Xuli;

import Xuli.AnalysisData;
import Xuli.Method;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class AnalysisFile {
    //xoa bo phan thua trong 1 dong
    public static String fix_Line(String str) {

        int pos, pos2;
        if(str.startsWith("//")) return null;// bat dua bang // thi tra ve null. tuc doan sau bo.

        while((pos = str.indexOf("/*")) >0){// vi tri dau xuat hien cua /*
            pos2= str.indexOf("*/");
            str= str.substring(0,pos)+str.substring(pos2+2,str.length()).trim();
        }// cat lay hai doan ngoai cmt

        if((pos = str.indexOf("//")) >0) str= str.substring(0,pos).trim();

        return str;
    }

    public File_ analysis(File file){

        Class class_= null;
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Attribute> attributes = new ArrayList<>();

        AnalysisData dataTo = new AnalysisData();

        try{

            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = fix_Line(sc.nextLine().trim());
//                System.out.println(str);
                if (str == null) continue;
                if(str.indexOf("class")>0 && str.endsWith("{")) {
                    class_ = dataTo.AnalysisClass(str);
                    continue;
                }

                if(str.startsWith("public")||
                        str.startsWith("protected")||
                        str.startsWith("private")){
                    if(str.endsWith(";")) {
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

        if(class_==null) return null;

        return new File_(class_,attributes,methods);

    }

}