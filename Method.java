import java.util.Arrays;

public class Method {
    String name;
    String return_Type;
    String access_Modify;
    boolean is_Abstract_Class;
    Variable[] list_Variable;

    public Method(String name, String return_Type, String access_Modify, boolean is_Abstract_Class, Variable[] list_Variable) {
        this.name = name;
        this.return_Type = return_Type;
        this.access_Modify = access_Modify;
        this.is_Abstract_Class = is_Abstract_Class;
        this.list_Variable = list_Variable;
    }

    @Override
    public String toString() {
        return "Method{" +
                "name='" + name + '\'' +
                ", return_Type='" + return_Type + '\'' +
                ", access_Modify='" + access_Modify + '\'' +
                ", is_Abstract_Class=" + is_Abstract_Class +
                ", líst_Variable=" + Arrays.toString(list_Variable) +
                '}';
    }
}

