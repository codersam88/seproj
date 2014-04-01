/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.util.Scanner;

/**
 *
 * @author sam
 */
public class Parse {
    
    public static void main(String[] args){
        Parse p = new Parse();
        p.parseFile();
    }
    void parseFile(){
        String path = "/test.txt";
        Scanner scan = new Scanner(path);
        scan.useDelimiter("|");
        for(;scan.hasNext();){
            String VM_ID = scan.next();
            int cap = Integer.parseInt(scan.next());
            System.out.println(VM_ID+" "+cap);
        }
        
    }
}
