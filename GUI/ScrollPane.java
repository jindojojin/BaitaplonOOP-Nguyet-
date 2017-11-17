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

    private int khoangcach=70;
    private ArrayList<Class> listCl;
    private ArrayList<Panel_rectangle> listRec= new ArrayList<>();

    public ScrollPane(ArrayList<Class> listCl) throws HeadlessException{
        setVisible(true);
        setSize(500,1000);
        this.listCl = listCl;
        initDiagram();
        System.out.println("da initDiagram xong");
        paper.setIcon(new ImageIcon("/root/Pictures/white-tailed-eagle-adler-bald-eagle-close-53151.jpeg"));
        scrollPane.setViewportView(paper);
        add(scrollPane);
    }


    public ArrayList<Panel_rectangle> getListRec() {
        return listRec;
    }

    int last_X =10;
    int last_Y =10;
    int max_Heigth=0;

    public void initDiagram() {
        boolean flagLevel = false;
        System.out.println("da vao ScrollPane.initDiagram");
        for(int i=0;;i++){  // duyet tat ca cac level
            for(Class c : listCl){
                if(c.level == i){
                    System.out.println("Da vao ScrollPane.initDiagram.if(c.level =="+ i);
                    flagLevel= true; //danh dau la ton tai class o level nay
                    Panel_rectangle newPanelRectangle = new Panel_rectangle(c,last_X,last_Y);
                    System.out.println("Da khoi tao 1 rectangle");
                    this.add(newPanelRectangle);
                    System.out.println("Da add rectangle vao paper");
                    if(c.level >0) {
                        for (Panel_rectangle panel_rectangle : listRec) {  // duyet tat ca cac panel o tren de tim panel dai dien cho lop cha
                            if (panel_rectangle.getAclass().is_Father_Class) {
                                if (c.getClass_Infor_().getFather_Class().equals(panel_rectangle.getAclass().getClass_Infor_().getName_class())) {
                                    newPanelRectangle.setFather_PanelRectangfle(panel_rectangle);
                                }
                            }
                        }
                    }
                    listRec.add(newPanelRectangle);
                    last_X+= newPanelRectangle.getWidth() + khoangcach;
                    if(max_Heigth < newPanelRectangle.getHeight()) max_Heigth= newPanelRectangle.getHeight();
                }
            }
            if (flagLevel == false) break;
            flagLevel = false;

            last_Y+=max_Heigth+khoangcach;
            last_X =10;
            max_Heigth =0;
        }
    }

}
