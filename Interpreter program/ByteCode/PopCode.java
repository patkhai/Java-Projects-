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

/*Popping the top numlevels of runtime stack*/
public class PopCode extends ByteCode {
    private int popargs, POP,toppop;
    
    public void init(ArrayList<String> args) {
        popargs = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {
       toppop = vm.getOffset();
       POP = popargs;    
       if(popargs > toppop) {
           POP = toppop;
       }
        for(int i = 0; i < POP; i++) {
            vm.pop();
        }
    }

    public String toString(){
            return "\nPOP " + popargs; }  
}  

