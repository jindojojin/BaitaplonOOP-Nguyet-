package GUI.Infor_GUI;

import GUI.InforGraphic;
import Infor.*;
import Infor.Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel_rectangle extends JPanel implements InforGraphic {
    int x_top;
    int y_top;
    int x_button;
    int y_button;
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
    Panel_rectangle father_PanelRectangfle =null;
    public Panel_rectangle getFather_PanelRectangfle() {
        return father_PanelRectangfle;
    }
    public void setFather_PanelRectangfle(Panel_rectangle father_PanelRectangfle) {
        this.father_PanelRectangfle = father_PanelRectangfle;
    }

    Class expressionClass;
    ArrayList<Panel_rectangle> list_implement = new ArrayList<>();
    String name_of_class;
    ArrayList<Method> methods ;
    ArrayList<Attribute> attributes;
    int toadoX,toadoY;

    public int getToadoX() {
        return toadoX;
    }

    public int getToadoY() {
        return toadoY;
    }

    public Panel_rectangle(Class c, int toadoX, int toadoY) {
        initSize(c);
        this.expressionClass =c;
        setLocation(toadoX,toadoY);
        setVisible(true);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        name_of_class = c.getClassInfor().getName_class();
        methods= c.getMethods();
        attributes=c.getAttributes();
        System.out.println("Da vao contructor cua Panel_rectangle");

        this.toadoX=toadoX;
        this.toadoY=toadoY;
        x_top=this.getX()+this.getWidth()/2;
        y_top=this.getY();
        x_button =x_top;
        y_button = y_top+this.getHeight();

    }
    //khoi tao kich thuoc cua panel
    private void initSize(Class c) {
        int max_heigth = c.getAttributes().size()+c.getMethods().size()+2;
        int max_width =25;
        if(c.getMethods().size() >0) {
            for (Method m : c.getMethods()) {
                if(m !=null) {
                    int l1 = m.getName().length() + m.getReturn_Type().length() + 2;
                    if (m.getList_Variable().size() > 0) {
                        for (Variable v : m.getList_Variable()) {
                            l1 += v.toString().length();
                        }
                    }
                    if (max_width < l1) max_width = l1;
                }
            }
            this.setSize(max_width* SIZE_KITU, max_heigth*(DOCAOCHU + KHOANGCACHDONG));
        }

    }

    public Class getExpressionClass() {
        return expressionClass;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        this.draw(g);
        System.out.println("Da vao Panel_rectangle.paintComponent()");
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
//                    if (attribute.getAccess_Modify() != null) {
//                        if (attribute.getAccess_Modify().equals("public")) {
//                            g2d.drawString("+", 2, y);
//                        } else if(attribute.getAccess_Modify().equals("private")) {
//                            g2d.drawString("-", 2, y);
//                        } else g2d.drawString("#", 2, y);
//                    }
//                    g2d.drawString(attribute.getReturn_type() + " " + attribute.getName(), 10, y);
                    g2d.drawString(attribute.toString(),10,y);
                }

            }
        }
        y+= KHOANGCACHDONG;
        g2d.drawLine(1,y+5, this.getWidth()-5,y+5);

        if(methods.size()>0) {
            for (Method method : methods) {
                y += DOCAOCHU + KHOANGCACHDONG;
                if(method !=null) {
                    if(method.getAccess_Modify()!=null) {
                        if (method.getAccess_Modify().equals("public")) {
                            g2d.drawString("+", 2, y);
                        } else if(method.getAccess_Modify().equals("private")){
                            g2d.drawString("-", 2, y);
                        } else g2d.drawString("#", 2, y);

                    }

                    String method_infor = ""; //phan in ra man hinh
                    if (method.isIs_Abstract_Method()) {
                        method_infor = "abstract " + method_infor;
                    }
                    method_infor += method.getReturn_Type() + " " + method.getName() + "( ";
                    if (method.getList_Variable() != null) {
                        for (Variable v : method.getList_Variable()) {
                            method_infor += v.toString() + ", ";
                        }
                        method_infor = method_infor.substring(0, method_infor.length() - 2) + " )";
                    }
                    g2d.drawString(method_infor, 10, y);
                }
            }
        }

        System.out.println("da vao draw()");
    }

}
