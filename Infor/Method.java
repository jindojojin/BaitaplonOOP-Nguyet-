package Infor;

import java.util.ArrayList;
import java.util.Arrays;

public class Method {
    String name;
    String return_Type;
    String access_Modify;
    boolean is_Abstract_Method;
    ArrayList<Variable> list_Variable;

    public Method(String name, String return_Type, String access_Modify, boolean is_Abstract_Method, ArrayList<Variable> list_Variable) {
        this.name = name;
        this.return_Type = return_Type;
        this.access_Modify = access_Modify;
        this.is_Abstract_Method = is_Abstract_Method;
        this.list_Variable = list_Variable;
    }

    public String getName() {
        return name;
    }

    public String getReturn_Type() {
        return return_Type;
    }

    public String getAccess_Modify() {
        return access_Modify;
    }

    public boolean isIs_Abstract_Method() {
        return is_Abstract_Method;
    }

    public ArrayList<Variable> getList_Variable() {
        return list_Variable;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", return_Type='" + return_Type + '\'' +
                ", access_Modify='" + access_Modify + '\'' +
                ", is_Abstract_Method=" + is_Abstract_Method +
                ", list_Variable=" + list_Variable.toString() +
                '}';
    }
}

