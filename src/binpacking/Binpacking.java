/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sampath
 */
public class Binpacking {

    private JFrame mainFrm;
    private JPanel systems;
    private JPanel butns;
    JButton addVm;
    JButton delVm;

    public Binpacking() {
        mainFrm = new JFrame("Bin Pacing");
        mainFrm.setLayout(new BoxLayout(mainFrm,BoxLayout.Y_AXIS));
        systems = new JPanel(new FlowLayout());
        addButtons(systems);
        
        mainFrm.add(systems);        
        butns=new JPanel(new FlowLayout());
        addVm=new JButton("Add Vm");
        delVm=new JButton("Delete a Vm");
        
        mainFrm.add(butns);
        mainFrm.pack();
        mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrm.setVisible(true);        
    }
    
    
    
    public static void main(String[] args) {
        Binpacking strt = new Binpacking();
    }
    
    void addButtons(JPanel pnl){
        int totButns=3;
        JButton butArr[] = new JButton[totButns];
        for( int lmt=0 ; lmt < totButns ; lmt++ ){
            butArr[lmt]=new JButton("System "+(lmt+1));
            butArr[lmt].setBackground(Color.red);
            pnl.add(butArr[lmt]);
        }
    }
    
}
