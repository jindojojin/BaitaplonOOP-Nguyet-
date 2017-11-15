import GUI.ChonFile;
import Xuli.AnalysisFolder;
import Xuli.File_;

import java.util.ArrayList;

public class Main {
    public static ArrayList<File_> list_File = new ArrayList<>();


    public static void main(String[] args) {
//
//        AnalysisFile al = new AnalysisFile();
//        for (File file : files) {
//            if (file.getName().endsWith(".java")) {
//                list_File.add(al.analysis(file));
//            }
//        }
//
//
//        for (File_ file : list_File) {
//            System.out.println(file.toString());
//        }
        ChonFile c = new ChonFile();
        c.init();

    }


}