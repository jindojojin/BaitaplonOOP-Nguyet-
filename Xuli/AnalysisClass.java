package Xuli;

import Infor.Attribute;
import Infor.ThanhPhanClass;
import Infor.ClassInfor;
import Infor.Method;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class AnalysisClass {
    int check_braces = 0; // bien de kiem tra xem str dang phan tich co o trong 1 method khong dua vao "{" va "}", hoat dong giong stack

    //xoa bo phan thua trong 1 dong
    public static String fix_Line(String str) {

        int pos, pos2;
        if (str.startsWith("//")) return null;// bat dau bang "//" thi la comment => tra ve null.
        if (str.startsWith("import")) return null;
        if (str.startsWith("package")) return null;
        if (str.indexOf(";") < 0 && str.indexOf("{") < 0 && str.indexOf("}") < 0) return null;

//        while ((pos = str.indexOf("/*")) >=0) {// vi tri dau xuat hien cua /*
//            pos2 = str.indexOf("*/");
//            str = str.substring(0, pos) + str.substring(pos2 + 2, str.length()).trim();
//        }// cat lay hai doan ngoai cmt

        if ((pos = str.indexOf("//")) >= 0) str = str.substring(0, pos).trim();

        return str;
    }

    //ham kiem tra str dang xet co nam trong 1 method khong
    public boolean is_In_Method(String str) {
        if (check_braces > 1) {
            check_braces += (" " + str + " ").split("\\{").length - 1;
            check_braces -= (" " + str + " ").split("}").length - 1;
            return true;
        }
        check_braces += (" " + str + " ").split("\\{").length - 1;
        check_braces -= (" " + str + " ").split("}").length - 1;
        return false;
    }

    //phan tich cac thanh phan trong mot class
    public ThanhPhanClass analysis(java.io.File file) {
        System.out.println("Da vao AnalysisClass");
        boolean is_Inteface=false;
        ClassInfor classInfor = null;
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Attribute> attributes = new ArrayList<>();

        AnalysisString dataTo = new AnalysisString();

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = fix_Line(sc.nextLine().trim());

                if (str == null) continue;
                if (is_In_Method(str) == true) continue;  // neu la 1 dong trong method thi xet luon dong tiep theo

                    if (str.indexOf(" class ") >= 0 || str.indexOf(" interface ")>=0 ) {
                        if (str.indexOf(" interface ")>=0){
                            is_Inteface = true;
                        }
                            //System.out.println("class: " + str);
                        classInfor = dataTo.analysisClassInfor(str);
                        continue;
                    } else {
                        if (str.indexOf("{") < 0) {// khong co { thi la thuoc tinh
                            if (str.equals("}"))
                                continue;// truong hop doc duoc dau } ( ket thuc thi tiep tuc phan tich dong tiep theo
                            //System.out.println("attribute: " + str);
                            attributes.add(dataTo.AnalysisAttribute(str));
                            continue;
                        } else {
                            //System.out.println("method: " + str);
                            methods.add(dataTo.analysisMethod(str, classInfor.getName_class()));
                            continue;
                        }

                    }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay thanhPhanClass");
        }

        ThanhPhanClass thanhPhanClass = new ThanhPhanClass(classInfor, attributes, methods);
        if(is_Inteface == true) thanhPhanClass.getClassInfor().setIs_Interface(true);
        return thanhPhanClass;

    }

}
