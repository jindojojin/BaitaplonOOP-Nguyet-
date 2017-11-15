package Xuli;

import Xuli.Method;

import java.util.ArrayList;

/**
 * Created by DELL on 11/7/2017.
 */
public class File_ {
    Class class_;
    ArrayList<Attribute> attribute;
    ArrayList<Method> methods;

    public File_(Class class_, ArrayList<Attribute> attribute, ArrayList<Method> methods) {
        this.class_ = class_;
        this.attribute = attribute;
        this.methods = methods;
    }

    @Override
    public String toString() {
        return "File_{" +
                "class_=" + class_ +
                ", attribute=" + attribute +
                ", methods=" + methods +
                '}';
    }
}