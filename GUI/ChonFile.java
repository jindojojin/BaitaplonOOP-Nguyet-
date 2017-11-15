/*
 * Created by JFormDesigner on Wed Nov 15 07:25:44 ICT 2017
 */

package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;

/**
 * @author Linh Tran Quang
 */
public class ChonFile extends JFrame {
    public File folder;
    public boolean ok_button_press;
    public ChonFile() {
        initComponents();
        setVisible(true);
        ok_button_press = false;
    }

    public File getFolder() {
        return this.folder;
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
            this.ok_button_press = true;
            System.out.println("da bam ok");
            setVisible(false);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Linh Tran Quang
        contentPanel = new JPanel();
        button1 = new JButton();
        thong_tin = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        helpButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== contentPanel ========
        {
            //---- button1 ----
            button1.setText("CHON DUONG DAN");
            button1.addActionListener(e -> Click_ChonDuongDan(e));

            GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
            contentPanel.setLayout(contentPanelLayout);
            contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup()
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup()
                            .addComponent(thong_tin, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addGap(0, 104, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
            );
            contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(thong_tin, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addGap(17, 17, 17))
            );
        }
        contentPane.add(contentPanel, BorderLayout.WEST);

        //======== buttonBar ========
        {
            buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
            buttonBar.setLayout(new GridBagLayout());
            ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 85, 80};
            ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

            //---- okButton ----
            okButton.setText("OK");
            okButton.addActionListener(e -> Click_OK(e));
            buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.addActionListener(e -> Click_cancel(e));
            buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- helpButton ----
            helpButton.setText("Help");
            buttonBar.add(helpButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(buttonBar, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Linh Tran Quang
    private JPanel contentPanel;
    private JButton button1;
    private JLabel thong_tin;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JButton helpButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
