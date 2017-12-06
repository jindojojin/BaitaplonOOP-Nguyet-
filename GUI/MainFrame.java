package GUI;

import GUI.Infor_GUI.Khungclass;
import Infor.ThanhPhanClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements InforGraphic {
    private JScrollPane scrollPane;

    private ArrayList<ThanhPhanClass> listThanhPhanClasses;
    private ArrayList<Khungclass> listRec= new ArrayList<>();

    public MainFrame(ArrayList<ThanhPhanClass> listThanhPhanClasses) throws HeadlessException{
        setVisible(true);
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.listThanhPhanClasses = listThanhPhanClasses;
        initDiagram();
        System.out.println("da initDiagram xong");
        MainLabel paper = new MainLabel(listRec);
        scrollPane = new JScrollPane(paper,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
    }


    public ArrayList<Khungclass> getListRec() {
        return listRec;
    }

    int last_X =10;
    int last_Y =10;
    int max_Heigth=0;

    public void initDiagram() {
        boolean flagLevel = false;
        //System.out.println("da vao MainFrame.initDiagram");
        for(int i=0;;i++){  // duyet tat ca cac level
            for(ThanhPhanClass c : listThanhPhanClasses){
                if(c.level == i){
                    flagLevel= true; //danh dau la ton tai class o level nay
                    Khungclass newPanelRectangle = new Khungclass(c,last_X,last_Y);
                    if(c.level >0) {
                        for (Khungclass khungclass : listRec) {  // duyet tat ca cac panel o tren de tim panel dai dien cho lop cha
                            if (khungclass.getExpressionThanhPhanClass().isFatherClass) {
                                if (c.getClassInfor().getFather_Class().equals(khungclass.getExpressionThanhPhanClass().getClassInfor().getName_class())) {
                                    newPanelRectangle.setFather_PanelRectangfle(khungclass);
                                }
                            }
                        }
                    }
                    listRec.add(newPanelRectangle);
                    last_X+= newPanelRectangle.getWidth() + KHOANGCACH;
                    if(max_Heigth < newPanelRectangle.getHeight()) max_Heigth= newPanelRectangle.getHeight();
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
