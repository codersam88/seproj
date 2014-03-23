/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binpacking;

import java.util.LinkedList;

/**
 *
 * @author mc13mt49
 */
public class PMmodifier {
    private int PM_ID;
    private LinkedList PMlist;
    private LinkedList VMlist;
    int VM_num=0;
    void initPMs(int totalPMs){
        for(int i = 0;i<totalPMs;i++){
            PMlist.add(new PMstruct());
        }
    }
    protected void addVM(int capy){
        int i=0;
        for(;i<PMlist.size();i++){
            if(((PMstruct)PMlist.get(i)).resCap >= capy){
                VMstruct temp = new VMstruct();
                temp.VM_ID = genVMID();
                temp.cap = capy;
                ((PMstruct)PMlist.get(i)).VMlist.add(temp);
                break;
            }
        }
        if(i==PMlist.size()+1){
            
        }
        
    }
    protected void addVM(int PM_ID,int VM_ID, int cap){
        
    }
    
    String genVMID(){
        String VM_ID="VM_";
        if(VM_num<9){
            VM_ID=VM_ID+"0"+VM_num;
        }
        else{
            VM_ID=VM_ID+VM_num;
        }
        return VM_ID;
    }
}

