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

//stopping the execution
public class HaltCode extends ByteCode{
    
    public void init(ArrayList<String> args) { 
    }
    
    public void execute(VirtualMachine vm) {
      //terminating the program now
        vm.isRunning();
    }
 
    public String toString(){
        return "\nHalt "; }
    
}
