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
    private final int pmCount=6;
    private int PM_ID;
    private LinkedList PMlist;
    private static PMstruct[] PMArray;
    private LinkedList VMlist;
    private VMstruct[] VMArray;
    int VM_num=0;

    public PMmodifier() {
        
        //System.out.println("initing");
        
    }
    
    
    void initPMs(int totalPMs){
        PMlist = new LinkedList();
        for(int i = 0;i<totalPMs;i++){
            PMlist.add(new PMstruct());
            ((PMstruct)PMlist.get(i)).PM_NO="PM "+(i+1);
            ((PMstruct)PMlist.get(i)).resCap=100;
            //((PMstruct)PMlist.get(i)).onState=true;
        }
        //System.out.println("the size of list is "+PMlist.size());
    }
    void initPMsA(){
        PMArray=new PMstruct[pmCount];
        for(int i = 0;i<pmCount;i++){
            PMArray[i]= new PMstruct();
            //System.out.println("in initing "+PMArray[i]);
            PMArray[i].PM_NO="PM "+(i+1);
            PMArray[i].resCap=100;
            //System.out.println(PMArray[i]);
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
    void changeState(int i){
        PMArray[i].onState=true;
    }
    protected void addVMA(String VM_ID, int capy){
        if(checkName(VM_ID)){
        int i=0;
        /*for(;i<PMlist.size();i++){
            for(int j=0;j<((PMstruct)PMlist.get(i)).VMlist.size();j++){
                
            }
        }*/
        for(;i<PMArray.length;i++){
            //System.out.println("in addvma "+tmp[i]);
            if(PMArray[i].resCap >= capy){
                //if(!((PMstruct)PMlist.get(i)).onState){
                    //System.err.println("changing state of pm "+((PMstruct)PMlist.get(i)).PM_NO);
                    PMArray[i].onState=true;
                    //System.out.println("state now "+((PMstruct)PMlist.get(i)).onState);
                    //System.out.println("state now next state "+((PMstruct)PMlist.get(i+1)).onState);
                    //System.err.println(((PMstruct)PMlist.get(i)).onState);
                //}
                VMstruct temp = new VMstruct();
                temp.VM_ID = VM_ID;
                temp.cap = capy;
                PMArray[i].VMlist.add(temp);
                PMArray[i].resCap=
                        PMArray[i].resCap-capy;
                PMArray[i].VMCount++;
                //System.out.println("VM has been added in pm no "+ 
                  //      ((PMstruct)PMlist.get(i)).PM_NO);
                //System.out.println("the residual cap of pm is "+ 
                  //      ((PMstruct)PMlist.get(i)).resCap);
                break;
            }
        }
        if(i==PMArray.length){
            System.out.println("sorry no enough space");
        }
        }
        
    }
    protected void addVMA(PMstruct[] tmp,int PMNO,String VM_ID, int capy){       
                VMstruct temp = new VMstruct();
                temp.VM_ID = VM_ID;
                temp.cap = capy;
                tmp[PMNO].VMlist.add(temp);
                tmp[PMNO].resCap=
                        tmp[PMNO].resCap-capy;
                tmp[PMNO].VMCount++;
    }
    boolean checkName(String VMID){
        for(int i=0;i<PMArray.length;i++){
            if(PMArray[i].onState){
                for(int j=0;j<PMArray[i].VMCount;j++){
                if(((VMstruct)PMArray[i].VMlist.get(j)).VM_ID.equals(VMID))
                return false;
                }
            }
        }
        return true;
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
    
    void deleteVM(PMstruct[] tmp,int PMNo,int VMNo){
        int freed = ((VMstruct)tmp[PMNo].VMlist.get(VMNo)).cap;
        tmp[PMNo].VMlist.remove(VMNo);
        tmp[PMNo].VMCount--;
        
        tmp[PMNo].resCap = tmp[PMNo].resCap + freed;
        if(tmp[PMNo].VMCount==0){
            tmp[PMNo].onState=false;
        }
    }
    void deleteVM(int PMNo,int VMNo){
        int freed = ((VMstruct)PMArray[PMNo].VMlist.get(VMNo)).cap;
        PMArray[PMNo].VMlist.remove(VMNo);
        PMArray[PMNo].VMCount--;
        
        PMArray[PMNo].resCap = PMArray[PMNo].resCap + freed;
        if(PMArray[PMNo].VMCount==0){
            PMArray[PMNo].onState=false;
        }
    }
    
    int getPMCountA(){
        return PMArray.length;
    }
    String getPMIDA(int i){
        return PMArray[i].PM_NO;
    }
    
    boolean getOnStatusA(int i){
        
        return PMArray[i].onState;
        
    }
    
    int getResCapA(int i){
        return PMArray[i].resCap;
    }
    
    String getPMNoA(int i){
        return PMArray[i].PM_NO;
    }
    
    
    /*int getPMCount(){
        return PMlist.size();
    }
    String getPMID(int i){
        return "PM"+((PMstruct)PMlist.get(i)).PM_NO;
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
    }*/
    int getVMCount(int i){
        return PMArray[i].VMCount;
    }
    
    String getVMID(int i,int j){
        return  ((VMstruct)PMArray[i].VMlist.get(j)).VM_ID;
    }
    int getVMCap(int i,int j){
        return ((VMstruct)PMArray[i].VMlist.get(j)).cap;
    }
    
    PMstruct[] copy(){
        PMstruct[] tmp = new PMstruct[pmCount];
        for(int i=0;i<pmCount;i++){
            tmp[i]=new PMstruct();
            tmp[i].PM_NO=PMArray[i].PM_NO;
            tmp[i].resCap=PMArray[i].resCap;
            tmp[i].VMCount=PMArray[i].VMCount;
            tmp[i].onState=PMArray[i].onState;
            for(int j=0;j<PMArray[i].VMCount;j++){
                VMstruct temp = new VMstruct();
                temp.VM_ID = ((VMstruct)PMArray[i].VMlist.get(j)).VM_ID;
                temp.cap = ((VMstruct)PMArray[i].VMlist.get(j)).cap;
                tmp[i].VMlist.add(temp);
                
            }
        }
        return tmp;
    }
    
    boolean consolidate(){
        PMstruct[] tmp=copy();
        System.out.println(tmp);
        System.out.println(PMArray);
        
        sort(tmp);
        if(tryMoving(tmp)){
            System.out.println("here");
            sort(PMArray);
            tryMoving(PMArray);
            order();
            return true;
        }
        //PMArray=tmp;
        return false;
    }
    void order(){
        for(int i=0;i<pmCount;i++){
            for(int j=0;j<pmCount;j++){
                PMstruct tmp=PMArray[i];
                System.out.println(PMArray[i].PM_NO);
                System.out.println("PM "+(j+1));
                if(PMArray[i].PM_NO.equals("PM "+(j+1))){
                    PMArray[i]=PMArray[j];
                    PMArray[j]=tmp;
                }
            }
        }
    }
    boolean tryMoving(PMstruct[] temp){
        
        for(int i=0;i<temp.length;i++){
            if(temp[i].onState){
                //System.out.println("here");
            for(int j=0;j<temp[i].VMCount;j++){
                for(int k=temp.length-1;k>=0&&k!=i;k--){
                    if(((VMstruct)temp[i].VMlist.get(j)).cap<temp[k].resCap){
                        addVMA(temp,k,((VMstruct)temp[i].VMlist.get(j)).VM_ID,
                                ((VMstruct)temp[i].VMlist.get(j)).cap);
                        deleteVM(temp,i, j);
                        if(temp[i].VMCount==0){
                            return true;
                        }
                        
                    }
                }
            }
        }
        }
        return false;
    }
    
    PMstruct[] sort(PMstruct[] temp){
        for(int out=1;out<temp.length;out++){
            
            int key=temp[out].resCap;
            PMstruct ko=temp[out];
            int i=out-1;
            while(i>=0 && temp[i].resCap<key){
                temp[i+1]=temp[i];
                i--;
                
                temp[i+1]=ko;
            }        
        }
        for(int i=0;i<temp.length;i++){
            //System.out.println(temp[i].resCap+" ");
        }
        //System.out.println("after sorting");
        
        return temp;
    }
}

