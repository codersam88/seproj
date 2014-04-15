/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author sam
 */
public class Parse2 {
    Path pth;
    PMmodifier pmr;
    BestInter b1;
    int ec=0;
    int StartP(File fil) throws IOException{
        b1=new BestInter();
        pmr = new PMmodifier();
        pmr.initPMsA();
        pth=fil.toPath();
        Scanner scan=new Scanner(pth);
        
        for(;scan.hasNextLine();){
            //System.out.println(scan.next());
            try {
               parseCurrLine(scan.nextLine());
               if(ec==1){
                   return 1;
               }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Parse2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Parse2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ec==0){
       return 0; 
        }
        else{
            return 1;
        }
    }
   void parseCurrLine(String li) throws ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, InstantiationException{
        Scanner scanL = new Scanner(li);
        scanL.useDelimiter("=");
        int c=0,d=0,f=0;
        if(scanL.hasNext()){
            c=1;
            String VM_ID = scanL.next();
            
            try{if(scanL.hasNext()){
               d=1;
            int cap = Integer.parseInt(scanL.next());
            if(cap<20||cap>100){
                ec=1;
                b1.errors(3);
            }
            System.out.println(cap);
            pmr.addVMA(VM_ID, cap);
            f++;
            }
                
            }
            catch(java.util.NoSuchElementException e){
                ec=1;
               b1.errors(2);
               
            }
            catch(java.lang.NumberFormatException e){
                ec=1;
                b1.errors(1);
            }            
            
            
            
        }
        if(c==0||d==0){
            ec=1;
            b1.errors(1);
        }
        
     
}
  
}
