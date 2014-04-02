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
        Path  fPath = Paths.get("test.txt");
        Scanner scan = new Scanner(fPath);
        scan.useDelimiter("|");
        System.out.println(scan.next()+scan.next()+scan.next()+scan.next()+scan.next());
        /*scan.useDelimiter("|");
        for(;scan.hasNext();){
            String VM_ID = scan.next();
            int cap = Integer.parseInt(scan.next());
            System.out.println(VM_ID+" "+cap);
        }*/
        
    }
}
