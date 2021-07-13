/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoGridLayout extends JFrame {
    public DemoGridLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridLayout layout = new GridLayout(2, 5);
        
        this.getContentPane().setLayout(layout);
        
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton("Button " + (i + 1));
            this.getContentPane().add(btn);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new DemoGridLayout();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
