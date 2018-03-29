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

/*target for branches (false,goto,call)*/
public class LabelCode extends ByteCode{
    private String labelargs;
    
   public void init(ArrayList<String> args) {
        labelargs = args.get(0);
    }

   public void execute(VirtualMachine vm) { }
    
   public String toString(){
       return "\nLABEL " + " " + labelargs; }

   public String getLabel(){
       return labelargs;
   }
   
   public void setAddrs(){
       
   }

}
