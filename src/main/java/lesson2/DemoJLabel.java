/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author tiennh
 */
public class DemoJLabel extends JFrame {
    private JLabel lblIcon, lblUsername, lblFullname;
    
    public DemoJLabel() {
        this.lblIcon = new JLabel();
        this.lblUsername = new JLabel("TienNH21");
        this.lblFullname = new JLabel("FPT Polytechnic", SwingConstants.RIGHT);
        
        this.getContentPane().setLayout(new FlowLayout());
        
        ImageIcon catIcon = new ImageIcon("src/main/java/lesson2/kitty.png");
        this.lblIcon.setIcon(catIcon);
        catIcon.getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
//        this.lblIcon.setSize();

        this.getContentPane().add(this.lblIcon);
        this.getContentPane().add(this.lblUsername);
        this.getContentPane().add(this.lblFullname);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        DemoJLabel gui = new DemoJLabel();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
