package GUI;

import Infor.ThanhPhanClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements InforGraphic {
    private JScrollPane scrollPane;

    private ArrayList<ThanhPhanClass> listThanhPhanClasses;
    private ArrayList<Khungclass> listKhungClass = new ArrayList<>();

    public MainFrame(ArrayList<ThanhPhanClass> listThanhPhanClasses) throws HeadlessException{
        setVisible(true);
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.listThanhPhanClasses = listThanhPhanClasses;
        initDiagram(); // dat vi tri cho khungclass
        //System.out.println("da initDiagram xong");
        MainLabel paper = new MainLabel(listKhungClass);
        scrollPane = new JScrollPane(paper,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }


    public ArrayList<Khungclass> getListKhungClass() {
        return listKhungClass;
    }

    int last_X =10;
    int last_Y =10;
    int max_Heigth=0;

    public void initDiagram() {
        boolean flagLevel = false;
        //System.out.println("da vao MainFrame.initDiagram");
        for(int i=0;;i++){  // duyet tat ca cac level
            for(ThanhPhanClass thanhPhanClass : listThanhPhanClasses){
                if(thanhPhanClass.level == i){
                    flagLevel= true; //danh dau la ton tai class o level nay
                    Khungclass newKhungClass = new Khungclass(thanhPhanClass,last_X,last_Y);
                    if(thanhPhanClass.level >0) {
                        for (Khungclass khungclass : listKhungClass) {  // duyet tat ca cac panel o tren de tim panel dai dien cho lop cha
                            if (khungclass.getExpressionThanhPhanClass().isFatherClass) {
                                if (thanhPhanClass.getClassInfor().getFather_Class().equals(khungclass.getExpressionThanhPhanClass().getClassInfor().getName_class())) {
                                    newKhungClass.setKhungClassCha(khungclass);
                                }
                            }
                        }
                    }
                    listKhungClass.add(newKhungClass);
                    last_X+= newKhungClass.getWidth() + KHOANGCACH;
                    if(max_Heigth < newKhungClass.getHeight()) max_Heigth= newKhungClass.getHeight();
                }
            }
            if (flagLevel == false) break;
            flagLevel = false;
            last_Y+=max_Heigth+ KHOANGCACH;
            last_X =10;
            max_Heigth =0;
        }
    }

}
