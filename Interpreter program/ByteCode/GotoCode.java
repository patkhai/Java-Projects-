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

/* jump to the memeory addrs of the Label where pc point to */
public class GotoCode extends ByteCode implements Superclass{
   private String gotoargs;
   private int gotoaddrs;
   
   public void init(ArrayList<String> args) {
         gotoargs = args.get(0);
    }
    
   public void execute(VirtualMachine vm) {
        vm.setPC(gotoaddrs);  
    }
  
   public String toString(){
        return "\nGOTO " + gotoargs; }
    
   public void setAddrs(int addrs){
        gotoaddrs = addrs;
    }
   
   public String getLabel(){
       return gotoargs;
   }
   
   public int getAddrs(){
        return gotoaddrs;
    }
}
