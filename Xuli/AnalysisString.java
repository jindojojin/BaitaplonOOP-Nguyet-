package Xuli;

import Infor.Attribute;
import Infor.ClassInfor;
import Infor.Method;

import java.util.ArrayList;

public class AnalysisString {
    //ham cat bo ki tu thua  "{"   ","    ";"
    public String simple_fix(String str) {
        if (str.endsWith("{") ||
                str.endsWith(";") ||
                str.endsWith(",") ) {
            return str.substring(0,str.length()-1);
        }
        return str;
    }

    // ham lay ra ten cua method
    public String advance_fix(String str) {
        int pos = str.indexOf("(");
        if(pos>0) return str.substring(0,pos);
        return str;

    }

    public ClassInfor analysisClassInfor(String str){   // phan tich dong chua class
        String[] list = str.split(" ");// cat xau ra cac tu boi dau cach
        String access_Modify = list[0];
        String name = simple_fix(list[2]);
        if(list.length <= 4) {      // truong hop khong extends va khong implements

            return new ClassInfor(name,access_Modify,null,null);
        }else {// co ke thua va cai dat
            String father_Class=null;
            ArrayList<String> implements_ = new ArrayList<>();
            for(int i = 3;i<list.length;i++){
                if(list[i].equals("extends")){
                    father_Class = list[i+1];
                    //i++;
                }

                if(list[i].equals("implements")){
                    for(int j=i+1;j<list.length;j++){
                        if(list[j].equals("extends")) break;

                        if(!(list[j].equals("{") || list[j].equals(","))){
                            implements_.add(simple_fix(list[j]));
                            i++;
                        }
                    }
                }
            }

            return new ClassInfor(list[2],list[0],father_Class,implements_);
        }

    }

    public Method AnalysisMethod(String str) { //phan tich 1 dong chua method

        String acces_Modify;
        String return_Type;
        String name;
        String[] list = str.split(" ");
        acces_Modify = list[0];
        if (list[1].equals("static")) {

            return_Type = "static " + list[2];
            name = advance_fix(list[3]);

        } else {

            if (list[1].indexOf("(") >= 0) { // truong hop khong co kieu tra ve / contructor
                return_Type = null;
                name = advance_fix(list[1]);
            } else {
                return_Type = list[1];
                name = advance_fix(list[2]);
            }
        }
        return null;
    }

    public Attribute AnalysisAttribute(String str){
        String[] list = str.split(" ");
        return null;
    }

    //return
}