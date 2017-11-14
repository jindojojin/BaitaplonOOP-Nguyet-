package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private JPanel panel1;
    private JButton chonChuongTrinhButton;

    public MainFrame() {
        chonChuongTrinhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("asdfasdfasdfsd");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
