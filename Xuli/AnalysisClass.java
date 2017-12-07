package Xuli;

import Infor.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AnalysisClass {
    final String regexClass = "(?<accessmodify>p\\w*\\s+)?(?<abstract>(abstract\\s+))?((?<interface>interface\\s+)|(class\\s+))(?<name>\\w+\\s*)(?<implements>implements\\s+(\\w+\\s*\\,*\\s*)+)?(extends\\s+(?<fartherClass>\\w+\\s*))?(?<implements2>implements\\s+(\\w+\\s*\\,*\\s*)+)?";
    final Pattern patternClass = Pattern.compile(regexClass);
    final String regexAttibute = "(?<accessmodify>p\\w+\\s+)?(?<static>\\s*static\\s+)?(?<final>\\s*final\\s+)?(?<returnType>\\w*\\s+)(?<name>\\w*)(\\s*\\=(?<value>\\s*\\w*\\d*))?";
    final Pattern patternAttribute = Pattern.compile(regexAttibute);
    final String regexMethod = "(?<accessmodify>\\w*p\\w*\\s+)?(?<static>static\\s+)?(?<abstract>abstract)?(?<returnType>\\w+\\s+)(?<name>\\w+\\s*)(?<variables>\\((\\s*\\w*\\.*(\\s*\\<(\\s*\\w*\\s*\\,?)*\\>)?\\s*\\w+\\s*\\,*)*\\))";
    final Pattern patternMethod = Pattern.compile(regexMethod);

    int check_braces = 0; // bien de kiem tra xem str dang phan tich co o trong 1 method khong dua vao "{" va "}", hoat dong giong stack
    //xoa bo phan thua trong 1 dong
    public static String fix_Line(String str) {

        int pos, pos2;
        if (str.startsWith("//")) return null;// bat dau bang "//" thi la comment => tra ve null.
        if (str.startsWith("import")) return null;
        if (str.startsWith("package")) return null;
        if (str.indexOf(";") < 0 && str.indexOf("{") < 0 && str.indexOf("}") < 0) return null;

//        while ((pos = str.indexOf("/*")) >=0) {// vi tri dau xuat hien cua /*
//            pos2 = str.indexOf("*/");
//            str = str.substring(0, pos) + str.substring(pos2 + 2, str.length()).trim();
//        }// cat lay hai doan ngoai cmt

        if ((pos = str.indexOf("//")) >= 0) str = str.substring(0, pos).trim();

        return str;
    }
    //ham kiem tra str dang xet co nam trong 1 method khong
    public boolean is_In_Method(String str) {
        if (check_braces > 1) {
            check_braces += (" " + str + " ").split("\\{").length - 1;
            check_braces -= (" " + str + " ").split("}").length - 1;
            return true;
        }
        check_braces += (" " + str + " ").split("\\{").length - 1;
        check_braces -= (" " + str + " ").split("}").length - 1;
        return false;
    }
    //phan tich cac thanh phan trong mot class
    public ThanhPhanClass analysis(File file) {
        ClassInfor classInfor = null;
        ArrayList<Method> methods = new ArrayList<>();
        ArrayList<Attribute> attributes = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String str = fix_Line(sc.nextLine().trim());
                if (str == null ) continue;
                if (is_In_Method(str)== true) continue;
                Matcher matcher;
                if((matcher=patternClass.matcher(str)).find() == true){
                    System.out.println("Class: "+str);
                    classInfor = analysisClassInfor(matcher);
                    continue;
                }else if((matcher=patternMethod.matcher(str)).find() == true){
                    methods.add(analysisMethod(matcher));
                    continue;
                }else if((matcher=patternAttribute.matcher(str)).find()== true){
                    attributes.add(analysisAttribute(matcher));
                    continue;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay thanhPhanClass");
        }

        ThanhPhanClass thanhPhanClass = new ThanhPhanClass(classInfor, attributes, methods);
        return thanhPhanClass;

    }

    private ClassInfor analysisClassInfor(Matcher matcher) {
        String name_class;
        String access_Modify;
        String father_Class;
        boolean is_Abstract_Class =false;
        boolean is_Interface =false;
        ArrayList<String> implements_=new ArrayList<>();
        name_class=matcher.group("name");
        access_Modify=matcher.group("accessmodify");
        father_Class=matcher.group("fartherClass");
        if(matcher.group("abstract") != null) is_Abstract_Class =true;
        if(matcher.group("interface")!=null) is_Interface =true;
        String string = matcher.group("implements");
        if (string!= null){
            implements_= analysis_implement(string);
        }
        string = matcher.group("implements2");
        if (string!= null){
            implements_= analysis_implement(string);
        }

        return new ClassInfor(name_class,access_Modify,father_Class,is_Abstract_Class,is_Interface,implements_);
    }

    public ArrayList<String> analysis_implement( String str){
            ArrayList<String> implements_= new ArrayList<>();
            int i= str.indexOf("implements");
            String temp= str.substring(i+10, str.length());
            String[] list= temp.split(",");
            for (int j=0; j< list.length; j++){
                implements_.add(list[j].trim());
            }
            return implements_;
    }


    private Method analysisMethod(Matcher matcher) {
        String access_Modify=matcher.group("accessmodify");
        boolean is_Abstract_Method=false;
        if(matcher.group("abstract")!=null) is_Abstract_Method=true;
        String return_Type =matcher.group("returnType");
        String name=matcher.group("name");
        ArrayList<Variable> list_Variable= analysisVariable(matcher.group("variables"));
        return new Method(access_Modify,is_Abstract_Method,return_Type,name,list_Variable);
    }

    private ArrayList<Variable> analysisVariable(String variables) {
        ArrayList<Variable> result= new ArrayList<>();
        String name;
        String type;

        final String regex = "(?<type>\\w+(\\<(\\w*\\s*\\,?\\s*\\w*\\s*)*\\>)?\\s+)(?<name>\\w+\\s*)\\,?";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(variables);
        while (matcher.find()) {
            name=matcher.group("name");
            type=matcher.group("type");
            result.add(new Variable(name,type));
        }

        return result;
    }

    private Attribute analysisAttribute(Matcher matcher) {
        String name =matcher.group("name");
        String return_type=matcher.group("returnType");
        String access_Modify=matcher.group("accessmodify");
        String value=matcher.group("value");
        boolean is_Attribute_Property=false;
        if (matcher.group("static")!= null) is_Attribute_Property=true;
        boolean is_const=false;
        if(matcher.group("final")!= null) is_const=true;
        return new Attribute(name,return_type,access_Modify,value,is_Attribute_Property,is_const);
    }

}
