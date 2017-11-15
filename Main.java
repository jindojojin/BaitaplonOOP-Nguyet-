import GUI.ChonFile;
import Xuli.AnalysisClass;
import Xuli.AnalysisFolder;
import Infor.Class;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Class> list_File = new ArrayList<>();


    public static void main(String[] args) {
//
//        AnalysisClass al = new AnalysisClass();
//        for (File file : files) {
//            if (file.getName().endsWith(".java")) {
//                list_File.add(al.analysis(file));
//            }
//        }
//
//
//        for (Class file : list_File) {
//            System.out.println(file.toString());
//        }
        ChonFile c = new ChonFile(); // mo giao dien chon file

        while (c.ok_button_press == false) {// neu chua chon folder thi chuong trinh khong chay tiep
            System.out.println("");
        }

        File folder = c.getFolder();
        AnalysisFolder anf = new AnalysisFolder();
        anf.lay_File_Java(folder);
        ArrayList<File> list_class = anf.getList_class();

        AnalysisClass an = new AnalysisClass();
        for (File file : list_class) {

        }

    }


}