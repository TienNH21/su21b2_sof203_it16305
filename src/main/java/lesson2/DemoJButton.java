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
import javax.swing.JOptionPane;

/**
 *
 * @author tiennh
 */
public class DemoJButton extends JFrame {
    private JButton btnText, btnIcon;

    public DemoJButton() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.btnText = new JButton("Click me");
        
        ImageIcon icon = new ImageIcon("src/main/java/lesson2/cat.png");
        this.btnIcon = new JButton("Cat");
        this.btnIcon.setIcon(icon);
        
        this.getContentPane().add(this.btnText);
        this.getContentPane().add(this.btnIcon);

        this.addAction();
    }
    
    private void addAction() {
        DemoJButton that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("src/main/java/lesson2/cat.png");
                JOptionPane.showMessageDialog(that, "Meow", "Clicked", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        };

        this.btnIcon.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        DemoJButton gui = new DemoJButton();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
