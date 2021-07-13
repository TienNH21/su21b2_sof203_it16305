/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoFlowLayout extends JFrame {
    public DemoFlowLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.RIGHT);
        this.getContentPane().setLayout(layout);
        
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton( "Button " + (i + 1) );
            this.getContentPane().add(btn);
        }
    }

    public static void main(String[] args) {
        JFrame frame2 = new DemoFlowLayout();
        frame2.setSize(500, 500);
        frame2.setVisible(true);
    }
}
