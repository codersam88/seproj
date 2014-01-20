/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sampath
 */
public class Binpacking {

    private JFrame mainFrm;

    public Binpacking() {
        mainFrm = new JFrame("Bin Pacing");
        addButtons();
        mainFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrm.setVisible(true);        
    }
    
    
    
    public static void main(String[] args) {
        Binpacking strt = new Binpacking();
    }
    
    void addButtons(){
        int totButns=3;
        JButton butArr[] = new JButton[totButns];
        for( int lmt=0 ; lmt < totButns ; lmt++ ){
            
        }
    }
    
}
