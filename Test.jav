import Infor.Attribute;
import Infor.ClassInfor;
import Infor.Variable;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

}



    public Attribute phantichthuoctinh(String str) {
        String name = null;
        String return_type = null;
        String access_Modify = null;
        String value = null;
        boolean is_Attribute_Property = false;
        boolean is_const = false;

        //su dung cac ham indexOf(str) : tra ve vi tri cua xau str trong xau dang xet
        // vd :
        int x = str.indexOf("static");// public static int a;=> x =7   (" neu x >0 thi xau str co mat trong xau")

            list[] = str.split(" ");
        // kiem tra xem co tu "static" trong xau khong , neu co thi is_Attribute_Property = true;
        // kiem tra xem co tu "final" trong xau khong, neu co thi is_const = true => co value, neu khong khong thi value = null;
        // cat xau ra boi dau " ", split(" ")
        // th1: co muc truy cap
        if // co muc truy cap {
            if // la bien tinh{
                if( // la hang so){
                else // neu khong la hang so
        { return_type = list[2]
    }
    }
    }






        return new Attribute(name,return_type,access_Modify,value,is_Attribute_Property,is_const);
    }



    public  static int check_braces = 0;
    public static boolean is_In_Method(String str){

        if (check_braces >1) {
            check_braces += (" "+str+" ").split("\\{").length -1;
            check_braces -= (" " + str + " ").split("}").length - 1;
            return true;
        }
        check_braces += (" "+str+" ").split("\\{").length -1;
        check_braces -= (" " + str + " ").split("}").length - 1;
        return false;
    }

    public static String simple_fix(String str) {
        if (str.endsWith("{") ||
                str.endsWith(";") ||
                str.endsWith(",") ) {
            str=str.substring(0,str.length()-1);
        }

        if (str.startsWith(",")){
            str=str.substring(1,str.length());
        }

        String[] list = str.split(",");
        return str;
    }

    // cat bo ki tu "(" de lay ra ten cua method
    public static String advance_fix(String str) {
        int pos = str.indexOf("(");
        if(pos>0) return str.substring(0,pos);
        return str;

    }

    public static ClassInfor analysisClassInfor(String str){
        String name_Class = null;
        String access_Modify = null;
        String father_Class=null;
        boolean is_Abstract_Class = false;
        ArrayList<String> implements_ = new ArrayList<>();

        if((" "+str).indexOf(" abstract ") >=0) is_Abstract_Class = true;

        String[] list = str.split(" ");

        if(is_Abstract_Class){
            if(list[0].equals("abstract")){
                name_Class=list[2];
                access_Modify= "public";
            }else {
                access_Modify=list[0];
                name_Class=list[3];
            }
        }else{
            if(list[1].equals("class")){
                access_Modify=list[0];
                name_Class=list[2];
            }else{
                access_Modify="default";
                name_Class=list[1];
            }
        }

        for(int i = 2;i<list.length;i++){
            if(list[i].equals("extends")){
                father_Class = list[i+1];
                //i++;
            }

            if(list[i].equals("implements")){
                for(int j=i+1;j<list.length;j++){
                    if(list[j].equals("extends")) break;

                    if(!list[j].equals("{") && !list[j].equals(",")){

                        String temp =simple_fix(list[j]);
                        if(temp.indexOf(",") > 0){
                            for(String s : temp.split(",")){
                                implements_.add(s);
                            }
                        }else implements_.add(temp);
                        i++;
                    }
                }
            }
        }

        if(implements_.isEmpty()) implements_=null;
        return new ClassInfor(name_Class,access_Modify,father_Class,is_Abstract_Class,implements_);
    }
}
