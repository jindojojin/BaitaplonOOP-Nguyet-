package Xuli;

import java.io.File;
import java.util.ArrayList;

public class AnalysisFolder{
    private ArrayList<File> list_class;

    public AnalysisFolder() {
        list_class = new ArrayList<>();
    }

    public ArrayList<File> getList_class() {
        return list_class;
    }

    public void lay_File_Java(File folder){// nhan vao mot folder chua cac file
        File[] list_file = folder.listFiles();// list file trong folder
        for(File file : list_file){
            if(file.isDirectory()){//ham kiem tra co phai la mot folder hay khong
                lay_File_Java(file);//neu la folder thi phan tich tiep
            }else {
                if(file.getName().endsWith(".java")){
                    list_class.add(file);
                }
            }
        }
    }
}
