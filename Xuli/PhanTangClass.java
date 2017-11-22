package Xuli;

import Infor.Class;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhanTangClass {
    public TreeMap<Integer,ArrayList<Class>> treeMap = new TreeMap<>();

    public void setLevel(Class cl, ArrayList<Class> listClass){
        for(Class cl2 : listClass){
            if(cl2.getClassInfor().getFather_Class() != null) {
                if (cl2.getClassInfor().getFather_Class().equals(cl.getClassInfor().getName_class())) {
                    cl.isFatherClass = true;
                    cl2.level=cl.level+1;
                    System.out.println(cl2.level);
                    setLevel(cl2, listClass);

                }
            }
        }
    }
    //
}
