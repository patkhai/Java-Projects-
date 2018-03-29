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

/* Initializes a variable to the value 
after loading a value on top of the rs
 */
public class LitCode extends ByteCode {  
    private int value;
    private String name,output;

    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        if(args.size()>1){
            name = args.get(1);
        }else{
            name = "";
        }
    } 

    public void execute(VirtualMachine vm) {    
        if(name.equals("")){
            vm.push(value);
        }else{
            vm.push(0);
        }
    }
    
    public String toString(){
        output = "\nLIT " + value + "" + name;
        if(!name.equals("")){
            output = output + " int " + name;
        }
        return output; }
    }
    
