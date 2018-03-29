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


 /*Return from the current function; 
 <funcname> is used as a comment to 
 indicate the current function
 */
public class ReturnCode extends ByteCode{
    private String returnarg;
    private int returnaddrs;
    
    public void init(ArrayList<String> args) {
       if(args.size()>0){
            returnarg = args.get(0);
        }else{
            returnarg = "";
        }
    }
   
    public void execute(VirtualMachine vm) {
        vm.setPC(vm.popReturnAddress()); 
        vm.popFrame(); 
        returnaddrs = vm.peek();
    }

    public String toString(){
        String top;
        int i = returnarg.indexOf("<");
        if(i<0){
          top = returnarg;
        }else{
          top = returnarg.substring(0,i);
        }
        return "\nRETURN " + returnarg + "    exit " + top + " " + returnaddrs; }
}
