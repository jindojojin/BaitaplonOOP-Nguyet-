import java.util.ArrayList;

public class Class {
    String name_class;
    String access_Modify;
    String father_Class;
    ArrayList<String> implements_;

    public Class(String name_class, String access_Modify, String father_Class, ArrayList<String> implements_) {
        this.name_class = name_class;
        this.access_Modify = access_Modify;
        this.father_Class = father_Class;
        this.implements_ = implements_;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name_class='" + name_class + '\'' +
                ", access_Modify='" + access_Modify + '\'' +
                ", father_Class='" + father_Class + '\'' +
                ", implements_=" + implements_ +
                '}';
    }
}
