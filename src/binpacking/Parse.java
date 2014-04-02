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

/**
 *
 * @author sam
 */
public class Parse {
    Path pth;
    PMmodifier pmr;

    public Parse(File fil) throws IOException {
        pmr = new PMmodifier();
        pth = fil.toPath();
        parseFile();
        
        
    }
    
    
    
    public static void main(String[] args) throws IOException{
        
    }
    void parseFile() throws IOException{
        Scanner scan = new Scanner(pth);
        //scan.useDelimiter("|");
        //for(;scan.hasNextLine();){
                parseCurrLine(scan.nextLine());
        //}
        
    }
    
    void parseCurrLine(String li){
        Scanner scanL = new Scanner(li);
        scanL.useDelimiter("=");
        if(scanL.hasNext()){
            String VM_ID = scanL.next();
            int cap = Integer.parseInt(scanL.next());
            pmr.addVM(VM_ID, cap);
            
            System.out.println(VM_ID+" "+cap);
            
        }
    
}
}
