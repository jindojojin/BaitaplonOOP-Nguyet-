package GUI;

import GUI.Infor_GUI.Panel_rectangle;
import Infor.Class;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class ScrollPane extends JFrame {
    private JScrollPane scrollPane = new JScrollPane();
    private JLabel paper = new JLabel();

    private int khoangcach=50;
    private ArrayList<Class> listCl;
    //private ArrayList<Panel_rectangle> listRec= new ArrayList<>();

    public ScrollPane(ArrayList<Class> listCl){
        setVisible(true);
        setSize(1000,1000);
        this.listCl = listCl;
        initDiagram();
        paper.setIcon(new ImageIcon("/root/Pictures/white-tailed-eagle-adler-bald-eagle-close-53151.jpeg"));
        scrollPane.setViewportView(paper);
        add(scrollPane);
    }

    int last_X =10;
    int last_Y =10;
    int max_Heigth=0;

    public void initDiagram() {
        boolean flag = false;
        System.out.println("da vao ScrollPane.initDiagram");
        for(int i=0;;i++){  // duyet tat ca cac level
            for(Class c : listCl){
                if(c.level == i){
                    System.out.println("Da vao ScrollPane.initDiagram.if(c.level =="+ i);
                    flag= true; //danh dau la ton tai class o level nay
                    Panel_rectangle newPanelRectangle = new Panel_rectangle(c,last_X,last_Y);
                    paper.add(newPanelRectangle);
                    last_X+= newPanelRectangle.getWidth() + khoangcach;
                    if(max_Heigth < newPanelRectangle.getHeight()) max_Heigth= newPanelRectangle.getHeight();
                }
            }
            if (flag == false) return;
            last_Y+=max_Heigth+khoangcach;
            last_X =10;
        }
    }

}
