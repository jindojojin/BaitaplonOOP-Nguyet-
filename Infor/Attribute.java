package Infor;

/**
 * Created by DELL on 11/7/2017.
 */
public class Attribute {
    String name;
    String return_type;
    String access_Modify;
    String value;
    boolean is_Attribute_Property;
    boolean is_const;

    public Attribute(String name, String return_type, String access_Modify, String value, boolean is_Attribute_Property, boolean is_const) {
        this.name = name;
        this.return_type = return_type;
        this.access_Modify = access_Modify;
        this.value = value;
        this.is_Attribute_Property = is_Attribute_Property;
        this.is_const = is_const;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", return_type='" + return_type + '\'' +
                ", access_Modify='" + access_Modify + '\'' +
                ", value='" + value + '\'' +
                ", is_Attribute_Property=" + is_Attribute_Property +
                ", is_const=" + is_const +
                '}';
    }
}
