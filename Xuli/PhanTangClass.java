package Xuli;

import Infor.ThanhPhanClass;

import java.util.ArrayList;

public class PhanTangClass {

    public void setLevel(ThanhPhanClass cl, ArrayList<ThanhPhanClass> listThanhPhanClasses){

        for(ThanhPhanClass cl2 : listThanhPhanClasses){
            if(cl2.getClassInfor().getFather_Class() != null) {
                if (cl2.getClassInfor().getFather_Class().equals(cl.getClassInfor().getName_class())) {
                    cl.isFatherClass = true;
                    cl2.level=cl.level+1;
                    System.out.println(cl2.level);
                    setLevel(cl2, listThanhPhanClasses);
                }
            }
        }
    }

}
