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

/*transfer control to the indicated function*/
public class CallCode extends ByteCode implements Superclass {
    private String var, top;
    private int gotoaddrs, value;
    
    public void init(ArrayList<String> args) {
        var = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress();
        vm.setPC(gotoaddrs); 
        //value = vm.peek();
    }

    public String toString(){    
            int i = var.indexOf("<");
            if(i<0){
                top = var;
            }else{
                top = var.substring(0,i);
            }
            return "\nCALL " + var + "   " + top + "(" + value + ")"; }
    
    public int getAddrs(){
        return gotoaddrs;
    }
    
    public void setAddrs(int n){
        gotoaddrs = n;
    }
    
    public String getLabel(){
        return var;
    }   
}
