/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

/**
 *
 * @author tiennh
 */
public class DemoJPasswordField extends JFrame {
    private JPasswordField txtPwd;
    private JButton btnToggle;
    private ImageIcon iconOn, iconOff;
    private boolean showPwd;

    public DemoJPasswordField() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.btnToggle = new JButton();
        this.txtPwd = new JPasswordField();
        this.iconOn = new ImageIcon("src/main/java/lesson2/on.png");
        this.iconOff = new ImageIcon("src/main/java/lesson2/off.png");
        
        this.showPwd = false;
        this.btnToggle.setIcon(this.iconOff);

        this.txtPwd.setEchoChar('~');
        this.txtPwd.setColumns(20);
        
        this.getContentPane().add(this.txtPwd);
        this.getContentPane().add(this.btnToggle);
        this.addAction();
    }
    
    private void addAction() {
        DemoJPasswordField that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.showPwd = !that.showPwd;
                
                if (that.showPwd) {
                    that.btnToggle.setIcon(that.iconOn);
                    that.txtPwd.setEchoChar( (char)0 );
                } else {
                    that.btnToggle.setIcon(that.iconOff);
                    that.txtPwd.setEchoChar( '~' );
                }
            }
        };

        this.btnToggle.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new DemoJPasswordField();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
