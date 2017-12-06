package GUI;

import GUI.Infor_GUI.Khungclass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainLabel extends JLabel implements InforGraphic {
    ArrayList<Khungclass> list_Rec;

    public MainLabel(ArrayList<Khungclass> list_Rec) {
        this.list_Rec = list_Rec;
        this.setPreferredSize(new Dimension(10000,10000));
        for(Khungclass rec : list_Rec){
            this.add(rec);
        }
    }
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        this.drawLine(g2d);

    }

    public void drawLine(Graphics2D g){
        for (Khungclass rec : list_Rec){
            if(rec.getFather_PanelRectangfle() != null){
                Khungclass father = rec.getFather_PanelRectangfle();
                g.drawLine(rec.getX_top(),rec.getY_top(),rec.getX_top(),rec.getY_top()-KHOANGCACH/2);
                g.drawLine(rec.getX_top(),rec.getY_top()-KHOANGCACH/2,father.getX_button(),rec.getY_top()-KHOANGCACH/2);
                g.drawLine(father.getX_button(),rec.getY_top()-KHOANGCACH/2,father.getX_button(),father.getY_button());
            }
        }
    }
}
