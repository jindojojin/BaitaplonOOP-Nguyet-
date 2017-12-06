package Infor;

import java.util.ArrayList;

/**
 * Created by DELL on 11/7/2017.
 */
public class ThanhPhanClass {
    public int level =0;
    public boolean isFatherClass = false;

    ClassInfor classInfor;
    ArrayList<Attribute> attributes;
    ArrayList<Method> methods;

    public ThanhPhanClass(ClassInfor classInfor, ArrayList<Attribute> attributes, ArrayList<Method> methods) {
        this.classInfor = classInfor;
        this.attributes = attributes;
        this.methods = methods;
    }

    public ClassInfor getClassInfor() {
        return classInfor;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public ArrayList<Method> getMethods() {
        return methods;
    }

    @Override
    public String toString() {
        return "ThanhPhanClass{" +
                "classInfor=" + classInfor +
                ", attributes=" + attributes +
                ", methods=" + methods +
                '}';
    }
}