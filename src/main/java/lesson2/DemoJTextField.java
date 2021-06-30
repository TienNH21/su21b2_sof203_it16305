/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author tiennh
 */
public class DemoJTextField extends JFrame {
    private JTextField txtEmpty, txtUsername, txtFullname;
    private JTextField txtEditable, txtEnabled;

    public DemoJTextField() {
        this.txtEmpty = new JTextField();
        this.txtUsername = new JTextField("TienNH21");
        this.txtFullname = new JTextField(20);
        
        this.txtEditable = new JTextField("Editable", 20);
        this.txtEnabled = new JTextField("Enabled", 20);
        
        this.txtEditable.setEditable(false);
        this.txtEnabled.setEnabled(false);

        this.getContentPane().setLayout(new FlowLayout());

        this.getContentPane().add(this.txtEmpty);
        this.getContentPane().add(this.txtUsername);
        this.getContentPane().add(this.txtFullname);
        this.getContentPane().add(this.txtEditable);
        this.getContentPane().add(this.txtEnabled);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        DemoJTextField gui = new DemoJTextField();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
