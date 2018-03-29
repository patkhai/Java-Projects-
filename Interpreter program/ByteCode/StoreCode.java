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

/*will store value into the offset n from the start
 of the frame; <id> is used as a comment, 
 it's the variable name where the data is stored. */
public class StoreCode extends ByteCode { 
    private String name;
    private int offset, value;

    public void init(ArrayList<String> args) {
       offset = Integer.parseInt(args.get(0));
        name = args.get(1);
    }
      
    public void execute(VirtualMachine vm) {
         value = vm.peek();
         vm.store(offset);
    }
    
    public String toString(){
        return "\nSTORE " + offset + "" + name + "  " + name + "=" + value; }   
}