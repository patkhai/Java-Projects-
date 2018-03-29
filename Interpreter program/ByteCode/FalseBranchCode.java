/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import java.util.ArrayList;
import interpreter.VirtualMachine;
/**
 *
 * @author patkhai
 */

/* pop the top of the stack; if it is false(0) 
then it will branch to <label> else execute the next bytecode*/

public class FalseBranchCode extends ByteCode implements Superclass {
    private String falseargs;
    private int gotoaddrs;

    public void init(ArrayList<String> args) {
        falseargs = args.get(0);  
    }
    
    public void execute(VirtualMachine vm) {
        if(vm.pop() == 0) {
            vm.setPC(gotoaddrs);
        }
    }
    
    public String toString(){
        return "\nFALSEBRANCH " + falseargs ; }
    
    public int getAddrs(){
        return gotoaddrs;
    }
    
    public void setAddrs(int n){
        gotoaddrs = n;
    }
    
    public String getLabel(){
        return falseargs;
    }
}
    

