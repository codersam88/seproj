/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author sam
 */
public class BestInter2 {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        BestInter2 b2 = new BestInter2();
    }
    PMmodifier pmr;
    JFrame mainWind;
    
    Dimension butDim = new Dimension(150,200);

    public BestInter2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        mainWind = new JFrame("Bin packing and VM consolidation");
        mainWind.setSize(600,600);
        mainWind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWind.getContentPane().setLayout(new FlowLayout());
        pmr= new PMmodifier();
        buildGUI();
        
        
        //mainWind.pack();
        mainWind.setVisible(true);
    }
    
    void createPMs(int noOfPMs){
        //int noOfPMs=pmr.getPMCount();
        
        Button[] PMArr = new Button[noOfPMs];
        for(int i=0; i < PMArr.length; i++){
            PMArr[i] = new Button("PM_NO"+i);
            PMArr[i].setPreferredSize(butDim);
            mainWind.add(PMArr[i]);
            
        }
    }
    
    
    void setFrameSize(int noOfPMs){
        int framWidth = (noOfPMs*(butDim.height))+10;
        mainWind.setSize(framWidth,400 );
    }
    
    void buildGUI(){
        int PMCount = pmr.getPMCount();
        String[] PM_IDs= new String[PMCount];
        for(int i=0; i< PMCount; i++){
            PM_IDs[i] = pmr.getPMID(i);
        }
        createPMs(PMCount);
        setFrameSize(PMCount);
        System.out.println("PM count id " +PMCount);
    }
    
}
