/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoBorderLayout extends JFrame {
    public DemoBorderLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        BorderLayout layout = new BorderLayout();
        this.getContentPane().setLayout(layout);
        
        JButton btnCenter = new JButton("Button Center");
        JButton btnTop = new JButton("Button Page Start");
        JButton btnBottom = new JButton("Button Page End");
        JButton btnLeft = new JButton("Button Line Start");
        JButton btnRight = new JButton("Button Line End");
        
        this.getContentPane().add(btnCenter, BorderLayout.CENTER);
        this.getContentPane().add(btnTop, BorderLayout.PAGE_START);
        this.getContentPane().add(btnBottom, BorderLayout.PAGE_END);
        this.getContentPane().add(btnLeft, BorderLayout.LINE_START);
        this.getContentPane().add(btnRight, BorderLayout.LINE_END);

    }

    public static void main(String[] args) {
        JFrame frame2 = new DemoBorderLayout();
        frame2.setSize(500, 500);
        frame2.setVisible(true);
    }
}
