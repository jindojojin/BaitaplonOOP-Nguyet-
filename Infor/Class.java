package Infor;

import java.util.ArrayList;

/**
 * Created by DELL on 11/7/2017.
 */
public class Class {
    public int level =0;

    ClassInfor class_Infor_;
    ArrayList<Attribute> attribute;
    ArrayList<Method> methods;

    public Class(ClassInfor class_Infor_, ArrayList<Attribute> attribute, ArrayList<Method> methods) {
        this.class_Infor_ = class_Infor_;
        this.attribute = attribute;
        this.methods = methods;
    }

    public ClassInfor getClass_Infor_() {
        return class_Infor_;
    }

    public ArrayList<Attribute> getAttribute() {
        return attribute;
    }

    public ArrayList<Method> getMethods() {
        return methods;
    }

    @Override
    public String toString() {
        return "Class{" +
                "class_Infor_=" + class_Infor_ +
                ", attribute=" + attribute +
                ", methods=" + methods +
                '}';
    }
}