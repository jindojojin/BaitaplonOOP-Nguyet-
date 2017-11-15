package Xuli;

import GUI.ChonFile;

import java.io.File;
import java.util.ArrayList;

public class AnalysisFolder {
    public static ArrayList<File> list_class = new ArrayList<>();

    public AnalysisFolder() {
        list_class.add(ChonFile.folder);
    }
}
