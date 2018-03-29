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

/* Used prior to calling a function */
public class ArgsCode extends ByteCode {
    private int numargs;
    
    public void init(ArrayList<String> args){
        numargs = Integer.parseInt(args.get(0));
    }
    
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(numargs);
    
    }
    
    public String toString(){
        return "\nARGS " + numargs ; }
    }
   

