/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sam
 */
public class MyDialogs extends JDialog{
   private String value1 = null;
   private String value2 = null;
   private JTextField input1;
   private JTextField input2;
   private boolean valueAccepted=false;
   public static void main(String[] args){
       MyDialogs m= new MyDialogs(null, "hello");
       
   }
 
   public MyDialogs(Frame owner, String title) {
       
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
      input1 = new JTextField(32);
      input2 = new JTextField();
      getContentPane().add(new JLabel("VM ID"));
      getContentPane().add(input1);
      getContentPane().add(new JLabel("capacity"));
      getContentPane().add(input2);
      getContentPane().add(btnPanel);
      pack();
       setVisible(true);
   }
 
   public String[] getValues() {
       String[] values=new String[2];
       values[0]=value1;
       values[1]=value2;
       return values;
   }

   private void okButton() {
      value1 = input1.getText();
      value2 = input2.getText();
      valueAccepted=true;
      dispose();
   }

   private void noButton() {
      value1 = null;
      dispose();
   }
   boolean areAccepted(){
       return valueAccepted;
   }
}