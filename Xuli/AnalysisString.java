package Xuli;

import Infor.Attribute;
import Infor.ClassInfor;
import Infor.Method;
import Infor.Variable;

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
    // phan tich cac bien trong phuong thuc
    public Method analysisMethod(String str, String name_Class) {
        String access_Modify = null;
        boolean is_Abstract_Method = false;
        String return_Type = null;
        String name = null;
        ArrayList<Variable> list_Variable = null;

        boolean is_Contructor =false;
        if(str.indexOf(name_Class) >= 0) is_Contructor=true;

        if(str.indexOf("static ") >0){  //cat bo chu static
            int index = str.indexOf("static ");
            String temp= str.substring(0,index)+str.substring(index+7,str.length());
            str=temp;
        }
        String[] list = str.split("\\s");
        if (str.indexOf("abstract") > 0)
            is_Abstract_Method = true;

        String listVariable = str.substring(str.indexOf("(")+1,str.indexOf(")"));
        if (listVariable.length()>3){
            list_Variable=analysis_list_Variable(listVariable);
        }

        if (list[0].equals("public") || list[0].equals("protected") || list[0].equals("private")) {
            access_Modify = list[0];
            if (str.indexOf("abstract") >= 0) {
                is_Abstract_Method = true;
                if (list[2].equals("void")) {
                    name= advance_fix(list[3]);
                }
                else {
                    return_Type= list[2];
                    name= advance_fix(list[3]);
                }
            }else {
                if (list[1].equals("void")) {
                    name= advance_fix(list[2]);
                }
                else {
                    if(is_Contructor){
                        name =advance_fix(list[1]);
                    }else {
                        return_Type = list[1];
                        name = advance_fix(list[2]);
                    }
                }
            }
            //phan tich cac variable ??????
        }else { //abstract void ten();
            access_Modify="default";
            if (str.indexOf("abstract") >= 0) {
                is_Abstract_Method = true;
                if (list[1].equals("void")) {
                    name= advance_fix(list[2]);
                }
                else {
                    return_Type= list[1];
                    name= advance_fix(list[2]);
                }
            }else {
                if (list[0].equals("void")) {
                    name= advance_fix(list[1]);
                }
                else {
                    return_Type= list[0];
                    name= advance_fix(list[1]);
                }
            }

        }

        return new Method(access_Modify, is_Abstract_Method, return_Type, name, list_Variable);
    }
    //phan tich 1 dong chua method
    public ArrayList<Variable> analysis_list_Variable(String str){  // int a, int b
        ArrayList<Variable> result= new ArrayList<>();
        String name;
        String type;
        if (str.indexOf(",") >=0){
            String[] list = str.split(",");
            for (int i=0; i< list.length; i++){
                String[] list2= list[i].trim().split(" ");
                type= list2[0];
                name= list2[1];
                System.out.println(name);
                result.add( new Variable(name,type));
            }
        }
        else {
            String[] list2= str.trim().split(" ");
            type= list2[0];
            name= list2[1];
            result.add(new Variable(name,type));
        }
        return result;
    }
    //phan tich thuoc tinh
    public Attribute AnalysisAttribute(String str) {
        String name = null;
        String return_type = null;
        String access_Modify = null;
        String value = null;
        boolean is_Attribute_Property = false;
        boolean is_const = false;

        //int x = str.indexOf("static");// public int a = 7;
        String[] list = str.split(" ");
        if (list[0].equals("public") || list[0].equals("protected") || list[0].equals("private")) {
            access_Modify= list[0];
            if (list[1].equals("static")) {
                is_Attribute_Property = true;
                if (list[2].equals("final")) {
                    is_const = true;
                    return_type = list[3];
                    name = simple_fix(list[4]);
                    if (list[5].equals("=")){
                        value=list[6];
                    }

                } else {
                    return_type = list[2];
                    name = simple_fix(list[3]);
                }
            }
            else {//
                if (list[1].equals("final")) {
                    is_const = true;
                    return_type = list[2];
                    name = simple_fix(list[3]);
                    value = list[5];
                } else {
                    return_type = list[1];
                    name = simple_fix(list[2]);
                }
            }
        }
        else {//public static final int a = 5;
            if (list[0].equals("static")) {
                is_Attribute_Property = true;
                if (list[1].equals("final")) {
                    is_const = true;
                    return_type = list[2];
                    name = simple_fix(list[3]);
                    value = list[5];
                }
                else {
                    return_type = list[1];
                    name = simple_fix(list[2]);
                    value= list[4];
                }
            }
            else {
                if (list[0].equals("final")) {
                    is_const = true;
                    return_type = list[1];
                    name = simple_fix(list[2]);
                    value = list[4];
                }
                else {
                    return_type = list[0];
                    name = simple_fix(list[1]);
                    value= list[3];
                }
            }
        }

        return new Attribute(name,return_type,access_Modify,value,is_Attribute_Property,is_const);

    }
}