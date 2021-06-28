/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tiennh
 */
public class DemoAWT extends Frame implements ActionListener {
    private Button btnYellow, btnRed, btnExit;
    private Label lblText;
    
    public DemoAWT(String title) {
        this.setTitle(title);

        this.setLayout(new FlowLayout());
        this.btnRed = new Button("Red");
        this.btnYellow = new Button("Yellow");
        this.btnExit = new Button("Exit");
        this.lblText = new Label("Hello Poly");
        
        this.add(this.btnYellow);
        this.add(this.btnRed);
        this.add(this.btnExit);
        this.add(this.lblText);
        
        this.btnYellow.addActionListener(this);
        this.btnRed.addActionListener(this);
        this.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Yellow")) {
            this.setBackground(Color.yellow);
            this.lblText.setText("Hello ong vàng");
        } else if (cmd.equals("Red")) {
            this.setBackground(Color.red);
            this.lblText.setText("Hello ong nâu");
        } else {
            System.exit(0);
        }
    }
    
}
