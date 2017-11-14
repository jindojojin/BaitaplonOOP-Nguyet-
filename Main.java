import GUI.MainFrame;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<File_> list_File = new ArrayList<>();


    public static void main(String[] args) {


//        System.out.println("Nhap vao duong dan thu muc chua chuong trinh can phan tich");
//        Scanner sc = new Scanner(System.in);
//        String path_folder = sc.nextLine().trim();
//        File folder = new File(path_folder);
//        File[] files = folder.listFiles();
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

        MainFrame fr = new MainFrame();
    }


}