/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sam
 */
public class DelDialog extends JDialog{
   private int value1 = 0;
   private int value2 = 0;
   PMmodifier pmr = new PMmodifier();
   private JComboBox input1;
   private JComboBox input2;
   private boolean valueAccepted=false;
   public static void main(String[] args){
       MyDialogs m= new MyDialogs(null, "hello");
       
   }
 
   public DelDialog(Frame owner, String title) {
       
      super(owner, title, true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
      JPanel btnPanel = new JPanel();
      JButton okBtn   = new JButton("Accept");
      JButton noBtn   = new JButton("Cancel");
      btnPanel.add(okBtn);
      okBtn.addActionListener(new ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent ae) {
            okButton();
         }
      });
      noBtn.addActionListener(new ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent ae) {
            noButton();
         }
      });
      btnPanel.add(noBtn);
      fillBoxes();
      input1.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent ae) {
              int PMNo = input1.getSelectedIndex();
              input2.removeAllItems();
              for(int i=0;i<pmr.getVMCount(PMNo);i++){
                  input2.addItem(pmr.getVMID(PMNo, i));
              }
          }
      });
      getContentPane().add(new JLabel("select PM"));
      getContentPane().add(input1);
      getContentPane().add(new JLabel("select VM"));
      getContentPane().add(input2);
      getContentPane().add(btnPanel);
      pack();
       setVisible(true);
   }
   
   void fillBoxes(){
       input1 = new JComboBox();
       
       for(int i=0;i<pmr.getPMCountA();i++){
           input1.addItem(pmr.getPMIDA(i));
       }
       input2 = new JComboBox();
       
   }
 
   public int[] getValues() {
       int[] values=new int[2];
       values[0]=value1;
       values[1]=value2;
       return values;
   }

   private void okButton() {
      value1 = input1.getSelectedIndex();
      value2 = input2.getSelectedIndex();
      valueAccepted=true;
      dispose();
   }

   private void noButton() {
      //value1 = null;
      dispose();
   }
   boolean areAccepted(){
       return valueAccepted;
   }
    
}
