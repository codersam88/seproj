/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

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
    JPanel PMPanel;        
    JPanel butPanel;
    
    Dimension butDim = new Dimension(150,200);

    public BestInter2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        mainWind = new JFrame("Bin packing and VM consolidation");
        PMPanel = new JPanel();
        butPanel = new JPanel(new FlowLayout());
        
        
        mainWind.setSize(600,600);
        mainWind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWind.getContentPane().setLayout(new BoxLayout(mainWind.getContentPane(), BoxLayout.Y_AXIS));
        pmr= new PMmodifier();
        buildGUI();
        
        
        //mainWind.pack();
        mainWind.setVisible(true);
    }
    
    
    
    
    void setSizes(int noOfPMs){
        
        int framWidth = (noOfPMs*(butDim.height))+10;
        PMPanel.setSize(framWidth,300 );
        butPanel.setSize(framWidth,100);
        mainWind.setSize(framWidth, 400);
    }
    
    void buildGUI(){
        int PMCount = pmr.getPMCountA();
        String[] PM_IDs= new String[PMCount];
        for(int i=0; i< PMCount; i++){
            //System.out.println("i value "+i);
            PM_IDs[i] = pmr.getPMIDA(i);
            
        }
        
        createPMs(PMCount,PM_IDs);
        
        setSizes(PMCount);
        
        System.out.println("PM count id " +PMCount);
        
        JButton[] but= new JButton[6];
        but[0] = new JButton("add VM");
        butPanel.add(but[0]);
        but[1] = new JButton("delete VM");
        butPanel.add(but[1]);
        but[2] = new JButton("switch on PM");
        butPanel.add(but[2]);
        but[3] = new JButton("switch off PM");
        butPanel.add(but[3]);
        but[4] = new JButton("consolidate");
        butPanel.add(but[4]);
        addButtonListeners(but);
        
        
        
    }
    
    void createPMs(int noOfPMs,String[] PMNms){
        //int noOfPMs=pmr.getPMCount();
        
        JPanel[] PMArr = new JPanel[noOfPMs];
        
        for(int i=0; i < PMArr.length; i++){
            PMArr[i] = new JPanel();
            PMArr[i].setLayout(new BoxLayout(PMArr[i], BoxLayout.Y_AXIS));
            PMArr[i].setBorder(BorderFactory.createLineBorder(Color.black)); 
            PMArr[i].setPreferredSize(butDim);
            if(!pmr.getOnStatusA(i)){
                PMArr[i].disable();
                //System.out.println("the "+i+" th pm is "+pmr.getOnStatus(i));
            }
            //System.out.println("residual cap "+pmr.getResCap(i));
            //System.out.println("residual cap "+pmr.getPMNo((i)));
            PMPanel.add(PMArr[i]);
            mainWind.add(PMPanel);
            mainWind.add(butPanel);
            
        }
        for(int i=0;i<pmr.getPMCountA();i++){
            if(pmr.getOnStatusA(i)==true){
                
                for(int j=0;j<pmr.getVMCount(i);j++){
                    String VM_ID=pmr.getVMID(i,j);
                    System.out.println("vm id returned "+VM_ID);
                    int VMCap=pmr.getVMCap(i,j);
                    JLabel lbl=new JLabel(VM_ID+" "+VMCap);
                    Dimension dim = new Dimension(butDim.width,2*VMCap);
                    lbl.setBorder(BorderFactory.createLineBorder(Color.black));
                    lbl.setMaximumSize(dim);
                    PMArr[i].add(lbl);
                    
                }
                int resCap=pmr.getResCapA(i);
                JLabel remCap=new JLabel("Rem Cap "+resCap);
                remCap.setMaximumSize(new Dimension(butDim.width,2*resCap));
                remCap.setBorder(BorderFactory.createLineBorder(Color.black));
                PMArr[i].add(remCap);
            }
        }
        
    }
    
    void addButtonListeners(JButton[] buts){
        buts[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
    }
    
    
}
