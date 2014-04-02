/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author sam
 */
public class Parse {
    
    public static void main(String[] args) throws IOException{
        Parse p = new Parse();
        p.parseFile();
    }
    void parseFile() throws IOException{
        Path  fPath = Paths.get("test2");
        Scanner scan = new Scanner(fPath);
        //scan.useDelimiter("|");
        for(;scan.hasNextLine();){
                parseCurrLine(scan.nextLine());
        }
        
    }
    
    void parseCurrLine(String li){
        Scanner scanL = new Scanner(li);
        scanL.useDelimiter("=");
        if(scanL.hasNext()){
            String VM_ID = scanL.next();
            String cap = scanL.next();
            System.out.println(VM_ID+" "+cap);
            
        }
    
}
}
