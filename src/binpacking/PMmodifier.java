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
    final int noOfPMs=2;
    private final int pmCount=6;
    private int PM_ID;
    private LinkedList PMlist;
    private LinkedList VMlist;
    int VM_num=0;

    public PMmodifier() {
        initPMs(pmCount);
        System.out.println("initing");
        
    }
    
    
    void initPMs(int totalPMs){
        PMlist = new LinkedList();
        for(int i = 0;i<totalPMs;i++){
            PMlist.add(new PMstruct());
            ((PMstruct)PMlist.get(i)).PM_NO="PM_"+(i+1);
            ((PMstruct)PMlist.get(i)).resCap=100;
            //((PMstruct)PMlist.get(i)).onState=true;
        }
        //System.out.println("the size of list is "+PMlist.size());
    }
    
    public static void main(String[] args){
        PMmodifier pm = new PMmodifier();
        
        pm.addVM("VM 1", 20);
        pm.addVM("VM 2",90);
        pm.addVM("VM 3", 50);
        pm.addVM("VM 4", 60);
        pm.addVM("VM 5", 60);
    }
    
    protected void addVM(String VM_ID, int capy){
        int i=0;
        /*for(;i<PMlist.size();i++){
            for(int j=0;j<((PMstruct)PMlist.get(i)).VMlist.size();j++){
                
            }
        }*/
        for(;i<PMlist.size();i++){
            if(((PMstruct)PMlist.get(i)).resCap >= capy){
                //if(!((PMstruct)PMlist.get(i)).onState){
                    //System.err.println("changing state of pm "+((PMstruct)PMlist.get(i)).PM_NO);
                    ((PMstruct)PMlist.get(i)).onState=true;
                    System.out.println("state now "+((PMstruct)PMlist.get(i)).onState);
                    System.out.println("state now next state "+((PMstruct)PMlist.get(i+1)).onState);
                    //System.err.println(((PMstruct)PMlist.get(i)).onState);
                //}
                VMstruct temp = new VMstruct();
                temp.VM_ID = VM_ID;
                temp.cap = capy;
                ((PMstruct)PMlist.get(i)).VMlist.add(temp);
                ((PMstruct)PMlist.get(i)).resCap=
                        ((PMstruct)PMlist.get(i)).resCap-capy;
                //System.out.println("VM has been added in pm no "+ 
                  //      ((PMstruct)PMlist.get(i)).PM_NO);
                //System.out.println("the residual cap of pm is "+ 
                  //      ((PMstruct)PMlist.get(i)).resCap);
                break;
            }
        }
        if(i==PMlist.size()){
            System.out.println("sorry no enough space");
        }
        
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
    
    void deleteVM(String VM_ID){
        
        for(int i=0;i<PMlist.size();i++){
            for(int j=0;j<((PMstruct)PMlist.get(i)).VMlist.size();j++){ 
//                if((VMstruct((PMstruct)PMlist.get(i)).VMlist.))
            
            } 
            break;
        }
    }
    
    int getPMCount(){
        return PMlist.size();
    }
    String getPMID(int i){
        return ((PMstruct)PMlist.get(i)).PM_NO;
    }
    
    boolean getOnStatus(int i){
        System.out.println("in geton "+((PMstruct)PMlist.get(i)).onState);
        System.out.println("i value here "+ i);
        return ((PMstruct)PMlist.get(i)).onState;
        
    }
    
    int getResCap(int i){
        return ((PMstruct)PMlist.get(i)).resCap;
    }
    
    String getPMNo(int i){
        return ((PMstruct)PMlist.get(i)).PM_NO;
    }
}

