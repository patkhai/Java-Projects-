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

/*write the value on top of the stack for output 
 and leave the value on top of the stack*/
public class WriteCode extends ByteCode{
    private int toppeek;
    public void init(ArrayList<String> args) { 
    }

    public void execute(VirtualMachine vm) {
       toppeek = vm.peek();
    }
       
    public String toString() {
       return "\nWRITE " + "\n" + toppeek  ;}
     }
    

