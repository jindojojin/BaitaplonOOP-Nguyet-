import GUI.ChonFile;
import Xuli.AnalysisClass;
import Xuli.AnalysisFolder;
import Infor.Class;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Class> list_File = new ArrayList<>();


    public static void main(String[] args) {

        ChonFile c = new ChonFile(); // mo giao dien chon file

        while (!c.ok_button_press){
            System.out.print("");
        }
        System.out.println("da ra ngoai");
        //System.out.println(c.getList_class());
//        for (Class classs : c.getList_class()){
//            System.out.println(classs.toString());
//        }

    }


}