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

    public String getName() {
        return name;
    }

    public String getReturn_type() {
        return return_type;
    }

    public String getAccess_Modify() {
        return access_Modify;
    }

    public String getValue() {
        return value;
    }

    public boolean isIs_Attribute_Property() {
        return is_Attribute_Property;
    }

    public boolean isIs_const() {
        return is_const;
    }

    @Override
    public String toString() {
        String result = "";
        if(access_Modify!=null) {
            if (this.access_Modify.trim().equals("public")) {
                result = result + "+ ";
            }

            if (this.access_Modify.trim().equals("protected")) {
                result = result + "# ";
            }

            if (this.access_Modify.trim().equals("private")) {
                result = result + "- ";
            }
        }else {
            result+="~ ";
        }

        result = result + this.name;
        if (value!= null){
            result = result + " = ";
            result = result + this.value;
        }
        result = result + " : ";
        result = result + this.return_type + " ";
        if (this.is_Attribute_Property)
            result = result + "static" + " ";
        if (this.is_const)
            result = result + "final"+ " ";
        return result;
    }

}
