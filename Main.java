import GUI.ChonFile;
import GUI.Infor_GUI.Panel_rectangle;
import GUI.ScrollPane;
import Infor.Class;
import Xuli.PhanTangClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Class> list_File = new ArrayList<>();


    public static void main(String[] args) {

        ChonFile c = new ChonFile(); // mo giao dien chon file

        while (!c.ok_button_press){
            System.out.print("");  //doi phan tich xong cac file .java  (wait for  button Ok be clicked)
        }

        ArrayList<Class>  list_Class = c.getList_class();
        PhanTangClass p =new PhanTangClass();
        for(Class cl :list_Class) {
            p.setLevel(cl, list_Class);
        }
        for(Class cls : list_Class){
            System.out.println(cls.getClass_Infor_().getName_class()+": "+cls.level);
        }







        System.out.println("Da vao phan cap class");
        ScrollPane frame =new ScrollPane(list_Class);
        frame.setResizable(true);
    }


}