package Infor;

import java.util.ArrayList;
import java.util.Arrays;

public class Method {
    String access_Modify;
    boolean is_Abstract_Method;
    String return_Type;
    String name;
    ArrayList<Variable> list_Variable;

    public Method(String access_Modify, boolean is_Abstract_Method, String return_Type, String name, ArrayList<Variable> list_Variable) {
        this.access_Modify = access_Modify;
        this.is_Abstract_Method = is_Abstract_Method;
        this.return_Type = return_Type;
        this.name = name;
        this.list_Variable = list_Variable;
    }

    public String getAccess_Modify() {
        return access_Modify;
    }

    public void setAccess_Modify(String access_Modify) {
        this.access_Modify = access_Modify;
    }

    public boolean isIs_Abstract_Method() {
        return is_Abstract_Method;
    }

    public void setIs_Abstract_Method(boolean is_Abstract_Method) {
        this.is_Abstract_Method = is_Abstract_Method;
    }

    public String getReturn_Type() {
        return return_Type;
    }

    public void setReturn_Type(String return_Type) {
        this.return_Type = return_Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Variable> getList_Variable() {
        return list_Variable;
    }

    public void setList_Variable(ArrayList<Variable> list_Variable) {
        this.list_Variable = list_Variable;
    }

    @Override
    public String toString() {
        String result="";
        if(access_Modify.equals("public")){
            result+="+ ";
        }
        if(access_Modify.equals("private")){
            result +="- ";
        }
        if(access_Modify.equals("protected")){
            result+="# ";
        }
        if(access_Modify.equals("default")){
            result+="~ ";
        }
        if(is_Abstract_Method){
            result+= "abstract ";
        }
        result+= name+"( ";
        if(list_Variable != null) {
            for (Variable v : list_Variable) {
                result += v.type + ", ";
            }
            result = result.substring(0, result.length() - 2); //cat bo " ," o cuoi   int a,
        }
        result+=")";
        if(return_Type!= null) {
            result +=": "+ return_Type;
        }

        return result;
    }
}

