package Xuli;

import Infor.Class;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhanTangClass {
    public TreeMap<Integer,ArrayList<Class>> treeMap = new TreeMap<>();

    public void setLevel(Class cl, ArrayList<Class> listClass){
        for(Class cl2 : listClass){
            if(cl2.getClass_Infor_().getFather_Class() != null) {
                if (cl2.getClass_Infor_().getFather_Class().equals(cl.getClass_Infor_().getName_class())) {
                    cl.is_Father_Class = true;
                    cl2.level=cl.level+1;
                    System.out.println(cl2.level);
                    setLevel(cl2, listClass);

                }
            }
        }
    }
    //
}
