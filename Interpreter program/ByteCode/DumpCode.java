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

/*print out bytecode to the screeen*/ 
public class DumpCode extends ByteCode {
    private String dump;

    public void init(ArrayList<String> args) {
        dump = args.get(0);
    }
    
    public void execute(VirtualMachine vm) {
         if (dump.equals("ON")){
            vm.setDump(true);
        }else{
            vm.setDump(false);
         
        }
     }
    
}