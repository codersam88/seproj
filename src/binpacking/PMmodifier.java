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
    private static PMstruct[] PMArray;
    private LinkedList VMlist;
    private VMstruct[] VMArray;
    int VM_num=0;

    
    void initPMsA(){
        PMArray=new PMstruct[pmCount];
        for(int i = 0;i<pmCount;i++){
            PMArray[i]= new PMstruct();
            PMArray[i].PM_NO="PM "+(i+1);
            PMArray[i].resCap=100;
        }
    }
    
    void changeState(int i){
        PMArray[i].onState=true;
        PMArray[i].resCap=100;
    }
    protected int addVMA(String VM_ID, int capy){
        if(checkName(VM_ID)){
            capy=(int)Math.ceil(capy);
        int i=0;
        for(;i<PMArray.length;i++){
            if(PMArray[i].onState){
              if(PMArray[i].resCap >= capy){
                PMArray[i].onState=true;
                     VMstruct temp = new VMstruct();
                temp.VM_ID = VM_ID;
                temp.cap = capy;
                PMArray[i].VMlist.add(temp);
                PMArray[i].resCap=
                        PMArray[i].resCap-capy;
                PMArray[i].VMCount++;
                break;  
            }
        }
        }
        
        if(i==PMArray.length){
           int ret=addInOff(VM_ID,  capy);
           return ret;
        }
        return 0;
        }
        else{
            return 1;//for no enough space
        }
        
    }
        int addInOff(String VM_ID, int capy){
           int i=0;
        for(;i<PMArray.length;i++){
            if(PMArray[i].resCap >= capy){
                PMArray[i].onState=true;
                     VMstruct temp = new VMstruct();
                temp.VM_ID = VM_ID;
                temp.cap = capy;
                PMArray[i].VMlist.add(temp);
                PMArray[i].resCap=
                        PMArray[i].resCap-capy;
                PMArray[i].VMCount++;
                break;
            }
        }
        if(i==PMArray.length){
            System.out.println("sorry no enough space");
            return 2;//for no enough capacity
        }
        return 0;
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
        sort(tmp);
        int i=0;
        for(;tryMoving(tmp);i++){
            sort(tmp);
            
        }
        updatePA(tmp);
        order();
        if(i>0){
            return true;
        }
        return false;
    }
    void updatePA(PMstruct[] tmp){
        for(int i=0;i<pmCount;i++){
            PMArray[i]=tmp[i];
        }
    }
    void order(){
        for(int i=0;i<pmCount;i++){
            for(int j=0;j<pmCount;j++){
                PMstruct tmp=PMArray[i];
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
            for(int j=0;j<temp[i].VMCount;j++){
                for(int k=temp.length-1;k>=0&&k!=i;k--){
                    System.out.println("at this "+temp[k].PM_NO);
                    if(((VMstruct)temp[i].VMlist.get(j)).cap<=temp[k].resCap){
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
            int last=temp.length-1;
            if(temp[i].onState&&temp[i].resCap==100&&i<last){
                PMstruct tp=temp[i];
                temp[i]=temp[last];
                temp[last]=tp;
                last--;
            }
         }
         
        return temp;
    }
    void switchOFFPM(int i){
        
        PMstruct[] tmp=copy();
        if(tmp[i].resCap==100){
            tmp[i].onState=false;
            updatePA(tmp);
            return;
        }
        for(int j=0;j<tmp[i].VMCount;j++){
            for(int k=0;k<pmCount;k++){
                
                if(!(tmp[k].PM_NO.equals("PM "+(i+1)))){
                    if(tmp[k].onState){
                            if(((VMstruct)tmp[i].VMlist.get(j)).cap
                            <=tmp[k].resCap){
                            addVMA(tmp, k, ((VMstruct)tmp[i].VMlist.get(j)).VM_ID, 
                                    ((VMstruct)tmp[i].VMlist.get(j)).cap);
                            deleteVM(tmp, i, j);
                            if(!tmp[i].onState){
                                updatePA(tmp);
                                order();
                            }
                        }
                        
                    }
                }
            }
        }
    }
}

