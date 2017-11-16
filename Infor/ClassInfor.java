package Infor;

import java.util.ArrayList;

public class ClassInfor {
    String name_class;
    String access_Modify;
    String father_Class;
    boolean is_Abstract_Class;
    ArrayList<String> implements_;

    public ClassInfor(String name_class, String access_Modify, String father_Class, boolean is_Abstract_Class, ArrayList<String> implements_) {
        this.name_class = name_class;
        this.access_Modify = access_Modify;
        this.father_Class = father_Class;
        this.is_Abstract_Class = is_Abstract_Class;
        this.implements_ = implements_;
    }

    @Override
    public String toString() {
        return "ClassInfor{" +
                "name_class='" + name_class + '\'' +
                ", access_Modify='" + access_Modify + '\'' +
                ", father_Class='" + father_Class + '\'' +
                ", implements_=" + implements_ +
                '}';
    }
}
