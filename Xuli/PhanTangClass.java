package Xuli;

import Infor.Class;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhanTangClass {
    public TreeMap<Integer,ArrayList<Class>> treeMap = new TreeMap<>();
    public void phancap(ArrayList<Class> arr){
        for (Class cl: arr ) {
            thangcap(arr,cl);  //thang cap cho father_class cua cl  ;
        }
        for(Class cl: arr){
            int level = cl.level;
            if(treeMap.containsKey(level)){
                treeMap.get(level).add(cl);
            }else {
                ArrayList<Class> list = new ArrayList<>();
                list.add(cl);
                treeMap.put(level,list);
            }
        }
    }

    private void thangcap(ArrayList<Class> arr, Class cl) {
        if(cl.getClass_Infor_().getFather_Class()!=null){
            for(Class cl2: arr) {
                if (cl2.getClass_Infor_().getName_class().equals(cl.getClass_Infor_().getFather_Class())) {
                    cl2.level = cl.level + 1;
                    thangcap(arr,cl2);
                    return;
                }
            }
        }
    }

}
