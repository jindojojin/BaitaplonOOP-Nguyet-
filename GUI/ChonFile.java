/*
 * Created by JFormDesigner on Wed Nov 15 07:25:44 ICT 2017
 */

package GUI;

import Infor.Class;
import Xuli.AnalysisClass;
import Xuli.AnalysisFolder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Linh Tran Quang
 */
public class ChonFile extends JFrame {
    ArrayList<Class> list_class = new ArrayList<>(); // danh sach de luu cac class sau khi da phan tich
    public File folder;
    public boolean ok_button_press;
    public ChonFile() {
        initComponents();
        setVisible(true);
        setResizable(false);
        ok_button_press = false;
        thong_tin.setText("Nhan nut \"CHON DUONG DAN\" de mo thu muc chua chuong trinh can phan tich");
    }

    public ArrayList<Class> getList_class() {
        return list_class;
    }

    private void Click_ChonDuongDan(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Chon thu muc chua chuong trinh can phan tich");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = jfc.showDialog(null,"Select");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isDirectory()) {
                folder=jfc.getSelectedFile();
                thong_tin.setText(folder.getAbsolutePath());

            }
        }
    }

    private void Click_cancel(ActionEvent e) {
        // TODO add your code here
        System.exit(0);
    }

    private void Click_OK(ActionEvent e) {
        // TODO add your code here
        if(folder == null){
            JOptionPane.showMessageDialog(null,"Hay chon duong dan truoc","ERROR!",1);
        }else {
            AnalysisFolder anf = new AnalysisFolder();
            anf.lay_File_Java(folder);
            ArrayList<File> list_java_file = anf.getList_class(); //danh sach cac file co duoi .java
            if(list_java_file.size() == 0){
                JOptionPane.showMessageDialog(null,"Thu muc khong chua file java nao","Error!!",1);
            }else {
                this.ok_button_press = true;
                System.out.println("da bam ok");
                phan_tich_tung_file(list_java_file);
                setVisible(false);

            }
        }
    }
    //        phan tich cac file .java
    private void phan_tich_tung_file(ArrayList<File> list_java_file) {
        AnalysisClass phan_tich_file_java = new AnalysisClass();
        for (File file : list_java_file) {
            list_class.add(phan_tich_file_java.analysis(file));
        }
    }

    private void Click_help(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(null,"Chua hoan thien chuc nang nay","Error!!",1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Linh Tran Quang
        contentPanel = new JPanel();
        thong_tin = new JLabel();
        buttonBar = new JPanel();
        button1 = new JButton();
        okButton = new JButton();
        cancelButton = new JButton();
        helpButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== contentPanel ========
        {

            // JFormDesigner evaluation mark
            contentPanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), contentPanel.getBorder())); contentPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
            contentPanel.setLayout(contentPanelLayout);
            contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup()
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(thong_tin, GroupLayout.PREFERRED_SIZE, 503, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(118, Short.MAX_VALUE))
            );
            contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(thong_tin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
            );
        }
        contentPane.add(contentPanel, BorderLayout.WEST);

        //======== buttonBar ========
        {
            buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
            buttonBar.setLayout(new GridBagLayout());
            ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 85, 80};
            ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

            //---- button1 ----
            button1.setText("CHON DUONG DAN");
            button1.addActionListener(e -> Click_ChonDuongDan(e));
            buttonBar.add(button1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- okButton ----
            okButton.setText("OK");
            okButton.addActionListener(e -> Click_OK(e));
            buttonBar.add(okButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.addActionListener(e -> Click_cancel(e));
            buttonBar.add(cancelButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- helpButton ----
            helpButton.setText("Help");
            helpButton.addActionListener(e -> Click_help(e));
            buttonBar.add(helpButton, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(buttonBar, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Linh Tran Quang
    private JPanel contentPanel;
    private JLabel thong_tin;
    private JPanel buttonBar;
    private JButton button1;
    private JButton okButton;
    private JButton cancelButton;
    private JButton helpButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
