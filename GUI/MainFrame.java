package GUI;

import GUI.Infor_GUI.Panel_rectangle;
import Infor.Class;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements InforGraphic {
    private JScrollPane scrollPane;

    private ArrayList<Class> listClass;
    private ArrayList<Panel_rectangle> listRec= new ArrayList<>();

    public MainFrame(ArrayList<Class> listClass) throws HeadlessException{
        setVisible(true);
        setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.listClass = listClass;
        initDiagram();
        System.out.println("da initDiagram xong");
        Label paper = new Label(listRec);
        scrollPane = new JScrollPane(paper,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
        System.out.println("da vao MainFrame.initDiagram");
        for(int i=0;;i++){  // duyet tat ca cac level
            for(Class c : listClass){
                if(c.level == i){
                    flagLevel= true; //danh dau la ton tai class o level nay
                    Panel_rectangle newPanelRectangle = new Panel_rectangle(c,last_X,last_Y);
                    if(c.level >0) {
                        for (Panel_rectangle panel_rectangle : listRec) {  // duyet tat ca cac panel o tren de tim panel dai dien cho lop cha
                            if (panel_rectangle.getExpressionClass().isFatherClass) {
                                if (c.getClassInfor().getFather_Class().equals(panel_rectangle.getExpressionClass().getClassInfor().getName_class())) {
                                    newPanelRectangle.setFather_PanelRectangfle(panel_rectangle);
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
