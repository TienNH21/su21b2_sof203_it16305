/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author tiennh
 */
public class DemoJRadioButton extends JFrame {
    private JRadioButton rdoCat, rdoDog;
    private ImageIcon iconCat, iconDog;
    private ButtonGroup btnGr;

    public DemoJRadioButton() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.iconCat = new ImageIcon("src/main/java/lesson2/cat.png");
        this.iconDog = new ImageIcon("src/main/java/lesson2/dog.png");
        
        this.rdoCat = new JRadioButton("Cat", this.iconCat, true);
        this.rdoDog = new JRadioButton("Dog", this.iconDog, false);
        
        this.btnGr = new ButtonGroup();
        
        this.btnGr.add(rdoCat);
        this.btnGr.add(rdoDog);
        
        this.getContentPane().add(this.rdoCat);
        this.getContentPane().add(this.rdoDog);
    }
    
    public static void main(String[] args) {
        DemoJRadioButton gui = new DemoJRadioButton();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
