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

/* push the value in the slot which is offset n from the start
of the frame onto the top of the stack
*/
public class LoadCode extends ByteCode{
    private int value;
    private String name;

    public void init(ArrayList<String> args) {
      value = Integer.parseInt(args.get(0));
        name = args.get(1);
    
    }
   
    public void execute(VirtualMachine vm) {
        vm.load(value); 
    }
    
    public String toString() {
        return "\nLOAD " + value + " " + name; }

}



