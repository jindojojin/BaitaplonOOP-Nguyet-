package Xuli;

import GUI.ChonFile;

import java.io.File;
import java.util.ArrayList;

public class AnalysisFolder{
    private ArrayList<File> list_class;

    public AnalysisFolder() {
        list_class = new ArrayList<>();
    }

    public void lay_File_Java(File folder){
        File[] list_file = folder.listFiles();
        for(File file : list_file){
            if(file.isDirectory()){
                lay_File_Java(file);
            }else {
                if(file.getName().endsWith(".java")){
                    list_class.add(file);
                }
            }
        }
    }

    public ArrayList<File> getList_class() {
        return list_class;
    }
}
