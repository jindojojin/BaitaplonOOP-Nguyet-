import Infor.Method;
import Infor.Variable;

import java.util.ArrayList;

public class Test {
    public String advance_fix(String str) {
        int pos = str.indexOf("(");
        if (pos > 0) return str.substring(0, pos);
        return str;

    }
    public static void main(String[] args) {
        Test t = new Test();
        Method a = t.analysis_Method("public abstract String ten( String str, int a, int c )");
        Method b = t.analysis_Method("public double ten()");
        Method c = t.analysis_Method("abstract String ten( String str )");
        Method d = t.analysis_Method("String ten( String str )");
        Method e = t.analysis_Method("public String ten( String str )");
        Method f = t.analysis_Method("public abstract String ten( )");

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        System.out.println(e.toString());
        System.out.println(f.toString());

    }

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

    public Method analysis_Method(String str) {
        String access_Modify = null;
        boolean is_Abstract_Method = false;
        String return_Type = null;
        String name = null;
        ArrayList<Variable> list_Variable = null;

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
                    return_Type= list[1];
                    name= advance_fix(list[2]);
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
}
