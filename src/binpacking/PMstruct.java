/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binpacking;

import java.util.LinkedList;

/**
 *
 * @author sam
 */
public class PMstruct {
    String PM_NO;
    private PMstruct PMlist;
    LinkedList VMlist;
    int resCap;
    boolean onState=false;

    public PMstruct() {
        VMlist = new LinkedList();
    }
    
    
}
