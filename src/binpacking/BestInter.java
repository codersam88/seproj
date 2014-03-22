/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author mc13mt49
 */
public class BestInter {
    
    JFrame start;
    JButton lod;
    
    BestInter(){
        start = new JFrame("Load GUI");
        start.setLayout(new BorderLayout());
        
        lod = new JButton("Load");
        Dimension dim = new Dimension(500,400);
        Dimension dim1 = new Dimension(10,5);
        lod.setSize(dim1);
        start.add(lod,BorderLayout.CENTER);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setSize(dim);
        start.setVisible(true);
        
        
        
    }
    
    public static void main(String[] args){
        
        BestInter b = new BestInter();
    }
    
}
