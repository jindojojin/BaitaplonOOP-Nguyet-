package Xuli;

import Infor.Attribute;
import Infor.ClassInfor;
import Infor.Method;

import java.util.ArrayList;

public class AnalysisString {
    //ham cat bo ki tu thua  "{"   ","    ";"
    public String simple_fix(String str) {
        if (str.endsWith("{") ||
                str.endsWith(";") ||
                str.endsWith(",")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    // cat bo ki tu "(" de lay ra ten cua method
    public String advance_fix(String str) {
        int pos = str.indexOf("(");
        if (pos > 0) return str.substring(0, pos);
        return str;

    }

    // phan tich dong chua class
    public ClassInfor analysisClassInfor(String str) {
        String name_Class = null;
        String access_Modify = null;
        String father_Class = null;
        boolean is_Abstract_Class = false;
        ArrayList<String> implements_ = new ArrayList<>();

        if ((" " + str).indexOf(" abstract ") >= 0) is_Abstract_Class = true;

        String[] list = str.split(" ");

        if (is_Abstract_Class) {
            //2 truong hop "abstract class X" va "public abstract class X"
            if (list[0].equals("abstract")) {
                name_Class = list[2];
                access_Modify = "public";
            } else {
                access_Modify = list[0];
                name_Class = list[3];
            }
        } else {
            // 2 truong hop " <acess modify> class X" va "class X"
            if (list[1].equals("class")) {
                access_Modify = list[0];
                name_Class = list[2];
            } else {
                access_Modify = "default";
                name_Class = list[1];
            }
        }

        for (int i = 2; i < list.length; i++) {
            if (list[i].equals("extends")) {
                father_Class = list[i + 1];
                //i++;
            }

            if (list[i].equals("implements")) {
                for (int j = i + 1; j < list.length; j++) {
                    if (list[j].equals("extends")) break;

                    if (!list[j].equals("{") && !list[j].equals(",")) {

                        String temp = simple_fix(list[j]);
                        if (temp.indexOf(",") > 0) {  // truong hop "implements X,Y"   => se cat ra X va Y rieng
                            for (String s : temp.split(",")) {
                                implements_.add(s);
                            }
                        } else implements_.add(temp);
                        i++;
                    }
                }
            }
        }

        if (implements_.isEmpty()) implements_ = null;
        return new ClassInfor(name_Class, access_Modify, father_Class, is_Abstract_Class, implements_);
    }

    //phan tich 1 dong chua method
    public Method AnalysisMethod(String str) {

        String acces_Modify;
        String return_Type;
        String name;
        String[] list = str.split(" ");
        acces_Modify = list[0];
        if (list[1].equals("static")) {

            return_Type = "static " + list[2];
            name = advance_fix(list[3]);

        } else {

            if (list[1].indexOf("(") >= 0) { // truong hop khong co kieu tra ve / contructor
                return_Type = null;
                name = advance_fix(list[1]);
            } else {
                return_Type = list[1];
                name = advance_fix(list[2]);
            }
        }
        return null;
    }

    //phan tich thuoc tinh
    public Attribute AnalysisAttribute(String str) {
        String[] list = str.split(" ");
        return null;
    }

    //return
}