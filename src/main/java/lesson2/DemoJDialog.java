/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tiennh
 */
public class DemoJDialog extends JFrame {
    private JButton btnMsg, btnConfirm, btnInput, btnFile;
    private JFileChooser fChooser;
    private JLabel lblImg;
    
    public DemoJDialog() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.fChooser = new JFileChooser();
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("jpg", "png", "jpeg");
        this.fChooser.setFileFilter(imgFilter);

        this.lblImg = new JLabel();
        this.btnMsg = new JButton("Message");
        this.btnConfirm = new JButton("Confirm");
        this.btnInput = new JButton("Input");
        this.btnFile = new JButton("File");
        
        this.getContentPane().add(this.btnMsg);
        this.getContentPane().add(this.btnConfirm);
        this.getContentPane().add(this.btnInput);
        this.getContentPane().add(this.btnFile);
        this.getContentPane().add(this.lblImg);
        
        this.addAction();
    }
    
    private void addAction() {
        DemoJDialog that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equals("Message")) {
                    JOptionPane.showMessageDialog(that,
                        "Message Dialog", "Demo", JOptionPane.PLAIN_MESSAGE);
                } else if (cmd.equals("Confirm")) {
                    JOptionPane.showConfirmDialog(that,
                        "Bạn có người yêu chưa?", "Demo", JOptionPane.INFORMATION_MESSAGE);
                } else if (cmd.equals("Input")) {
                    String kq = JOptionPane.showInputDialog(that, "Hãy nhập tên người yêu: ");
                    System.out.println(kq);
                } else {
                    int returnValue = that.fChooser.showOpenDialog(that);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File f = that.fChooser.getSelectedFile();
                        String path = that.fChooser.getSelectedFile().getAbsolutePath();
                        
                        ImageIcon icon = new ImageIcon(path);
                        that.lblImg.setIcon(icon);
                    }
                }
            }
        };
        
        this.btnMsg.addActionListener(listener);
        this.btnConfirm.addActionListener(listener);
        this.btnInput.addActionListener(listener);
        this.btnFile.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new DemoJDialog();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
