package GUI.Infor_GUI;

import Infor.*;
import Infor.Class;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class main2 {
    public static void main(String[] args) {
        Variable x1 = new Variable("bien1","int");
        Variable x2 = new Variable("bien2","boolean");
        Variable x3 = new Variable("bien3","double");

        ArrayList<Variable> listVariable = new ArrayList<>();
        listVariable.add(x1);
        listVariable.add(x2);
        listVariable.add(x3);

        ClassInfor classInfor = new ClassInfor("Linh","public",null,true,null);
        Method method = new Method("method1","int","public",true,listVariable);
        Attribute attribute = new Attribute("attribute1","float",null,null,true,true);
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Attribute> attributes = new ArrayList<>();
        methods.add(method);
        attributes.add(attribute);
        methods.add(method);
        attributes.add(attribute);
        methods.add(method);
        attributes.add(attribute);
        Class aClass = new Class(classInfor,attributes,methods);

        JFrame jr = new JFrame();
        jr.setVisible(true);
        jr.setSize(1000,1000);
        jr.setLayout(null);
        Panel_rectangle n =new Panel_rectangle(aClass,100,20);
        n.setVisible(true);
        jr.setTitle("jframe");
        jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jr.add(n);


    }
}
