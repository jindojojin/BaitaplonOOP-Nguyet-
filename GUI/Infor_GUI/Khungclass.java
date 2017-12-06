package GUI.Infor_GUI;

import GUI.InforGraphic;
import Infor.*;
import Infor.ThanhPhanClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Khungclass extends JPanel implements InforGraphic {
    int x_top;
    int y_top;
    int x_button;
    int y_button;
    int toadoX,toadoY;// toa do cua khung class nay
    public int getToadoX() {
        return toadoX;
    }
    public int getToadoY() {
        return toadoY;
    }
    public int getX_top() {
        return x_top;
    }
    public int getY_top() {
        return y_top;
    }
    public int getX_button() {
        return x_button;
    }
    public int getY_button() {
        return y_button;
    }
    Khungclass father_PanelRectangfle =null;
    public Khungclass getFather_PanelRectangfle() {
        return father_PanelRectangfle;
    }

    public void setFather_PanelRectangfle(Khungclass father_PanelRectangfle) {
        this.father_PanelRectangfle = father_PanelRectangfle;
    }
    ThanhPhanClass expressionThanhPhanClass;// file the hien tren khung
    public ThanhPhanClass getExpressionThanhPhanClass() {
        return expressionThanhPhanClass;
    }
    //ArrayList<Khungclass> list_implement = new ArrayList<>();
    String name_of_class;
    ArrayList<Method> methods ;

    ArrayList<Attribute> attributes;
    public Khungclass(ThanhPhanClass c, int toadoX, int toadoY) {
        initSize(c); //khoi tao kich thuoc phu hop voi du lieu vao
        this.expressionThanhPhanClass =c;
        setLocation(toadoX,toadoY);
        setVisible(true);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        name_of_class = c.getClassInfor().getName_class();
        methods= c.getMethods();
        attributes=c.getAttributes();
        //System.out.println("Da vao contructor cua Khungclass");

        this.toadoX=toadoX;
        this.toadoY=toadoY;
        x_top=this.getX()+this.getWidth()/2;
        y_top=this.getY();
        x_button =x_top;
        y_button = y_top+this.getHeight();

    }
    //khoi tao kich thuoc cua panel

    private void initSize(ThanhPhanClass c) {
        int max_heigth = c.getAttributes().size()+c.getMethods().size()+2;
        int max_width =15;
        if(c.getMethods().size() >0) {
            for (Method m : c.getMethods()) {
                if(m !=null) {
                    int l1 = m.toString().length();
                    if (max_width < l1) max_width = l1;
                }
            }
        }
        if(c.getAttributes().size() >0){
            for(Attribute a : c.getAttributes()){
                int l1 = a.toString().length();
                if(max_width<l1) max_width=l1;
            }
        }
        this.setSize(max_width* SIZE_KITU, max_heigth*(DOCAOCHU + KHOANGCACHDONG));

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        this.draw(g);
        //System.out.println("Da vao Khungclass.paintComponent()");
    }


    public void draw(Graphics2D g2d){
        g2d.draw(new java.awt.Rectangle(1, 1,this.getWidth()-3,this.getHeight()-3));
        g2d.drawString(name_of_class, 10, DOCAOCHU);
        g2d.drawLine(1, DOCAOCHU + KHOANGCACHDONG, this.getWidth()-3, DOCAOCHU + KHOANGCACHDONG);
        int y= 15;
        if(attributes.size()>0) {
            for (Attribute attribute : attributes) {
                y += DOCAOCHU + KHOANGCACHDONG;
                if(attribute!=null) {
                    g2d.drawString(attribute.toString(),8,y);
                }
            }
        }
        y+= KHOANGCACHDONG;
        g2d.drawLine(1,y+5, this.getWidth()-5,y+5);

        if(methods.size()>0) {
            for (Method method : methods) {
                y += DOCAOCHU + KHOANGCACHDONG;
                if(method !=null) {
                    g2d.drawString(method.toString(), 8, y);
                }
            }
        }

        //System.out.println("da vao draw()");
    }

}
