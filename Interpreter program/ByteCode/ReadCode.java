/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import java.util.ArrayList;
import interpreter.VirtualMachine;
import java.io.*;
/**
 *
 * @author patkhai
 */

/*Read an integer; prompt the user for input & 
put the value just read on top of the stack*/
public class ReadCode  extends ByteCode{

    public void init(ArrayList<String> args) {}
      
    public void execute(VirtualMachine vm) {
        try{
          System.out.print("\nUser Input (only Integer): ");
          BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          String line = in.readLine();
          int n = Integer.parseInt(line);
          vm.push(n);
        }catch(IOException e){}        
    }

     public String toString(){
            return "READ"; }
     
   }
    

