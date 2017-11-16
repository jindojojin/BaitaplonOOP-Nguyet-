import GUI.ChonFile;
import GUI.Infor_GUI.Panel_rectangle;
import Xuli.AnalysisClass;
import Xuli.AnalysisFolder;
import Infor.Class;
import Xuli.PhanTangClass;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Class> list_File = new ArrayList<>();


    public static void main(String[] args) {

        ChonFile c = new ChonFile(); // mo giao dien chon file

        while (!c.ok_button_press){
            System.out.print("");  //doi phan tich xong cac file .java
        }

        ArrayList<Class>  list_Class = c.getList_class();

//        JFrame jr = new JFrame();
//        jr.setVisible(true);
//        jr.setSize(2000,1000);
//        jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jr.setLayout(new FlowLayout());
//
//        int x=0; int y=0;
//        Panel_rectangle rg = new Panel_rectangle(list_Class.get(1),12,15);
//        jr.add(rg);
        JFrame jr = new JFrame();
        jr.setVisible(true);
        jr.setSize(1000,1000);
        FlowLayout flowLayout = new FlowLayout();
        jr.setLayout(null);
        jr.setTitle("jframe");
        jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Panel_rectangle> list_Rectangle = new ArrayList<>();

        PhanTangClass p =new PhanTangClass();
        p.phancap(list_Class);

        for(Class cls : list_Class){
            System.out.println(cls.getClass_Infor_().getName_class()+": "+cls.level);
        }
        System.out.println(p.treeMap);

    }


}