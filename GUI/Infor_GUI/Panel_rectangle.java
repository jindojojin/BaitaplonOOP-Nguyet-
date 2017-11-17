package GUI.Infor_GUI;

import Infor.*;
import Infor.Class;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_rectangle extends JPanel {
    int x_top;
    int y_top;
    int x_button;
    int y_button;
    int docaochu=20;
    int khoangcachdong=10;
    int size_kitu =9;
    Panel_rectangle father_PanelRectangfle =null;

    public Panel_rectangle getFather_PanelRectangfle() {
        return father_PanelRectangfle;
    }

    public void setFather_PanelRectangfle(Panel_rectangle father_PanelRectangfle) {
        this.father_PanelRectangfle = father_PanelRectangfle;
    }

    Class aclass ;
    ArrayList<Panel_rectangle> list_implement = new ArrayList<>();
    
    String name_of_class;
    ArrayList<Method> methods ;
    ArrayList<Attribute> attributes;
    public Panel_rectangle(Class c, int toadoX, int toadoY) {
        initSize(c);
        this.aclass =c;
        setLocation(toadoX,toadoY);
        setVisible(true);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        name_of_class = c.getClass_Infor_().getName_class();
        methods= c.getMethods();
        attributes=c.getAttribute();
        System.out.println("Da vao contructor cua Panel_rectangle");

        x_top=this.getX()+this.getWidth()/2;
        y_top=this.getY();
        x_button =x_top;
        y_button = y_top+this.getHeight();
    }


    private void initSize(Class c) {
        int max_heigth = c.getAttribute().size()+c.getMethods().size()+2;
        int max_width =15;
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
            this.setSize(max_width*size_kitu , max_heigth*(docaochu+khoangcachdong));
        }

    }

    public Class getAclass() {
        return aclass;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        this.draw(g);
        this.drawLine(g);
        System.out.println("Da vao Panel_rectangle.paintComponent()");
    }

    private void drawLine(Graphics2D g) {
        if(father_PanelRectangfle!= null){
            g.drawLine(x_top,y_top,father_PanelRectangfle.x_button,father_PanelRectangfle.y_button);
        }
    }

    public void draw(Graphics2D g2d){
        g2d.draw(new java.awt.Rectangle(1, 1,this.getWidth()-3,this.getHeight()-3));
        g2d.drawString(name_of_class, 10, docaochu);
        g2d.drawLine(1, docaochu+khoangcachdong, this.getWidth()-3, docaochu+khoangcachdong);
        int y= 15;
        if(attributes.size()>0) {
            for (Attribute attribute : attributes) {
                y += docaochu + khoangcachdong;
                if(attribute!=null) {
                    if (attribute.getAccess_Modify() != null) {
                        if (attribute.getAccess_Modify().equals("public")) {
                            g2d.drawString("+", 2, y);
                        } else if(attribute.getAccess_Modify().equals("private")) {
                            g2d.drawString("-", 2, y);
                        } else g2d.drawString("#", 2, y);
                    }
                    g2d.drawString(attribute.getReturn_type() + " " + attribute.getName(), 10, y);
                }

            }
        }
        y+=khoangcachdong;
        g2d.drawLine(1,y+5, this.getWidth()-5,y+5);

        if(methods.size()>0) {
            for (Method method : methods) {
                y += docaochu + khoangcachdong;
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
