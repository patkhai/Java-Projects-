/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
/**
 *
 * @author patkhai
 */

import java.util.ArrayList;
import interpreter.VirtualMachine;

/* this will pop top 2 levels of the stack and perform 
indicated operation + - / * == != <= > < >= | &
*/
public class BopCode extends ByteCode {
    private String operator;
    
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }
    
    public void execute(VirtualMachine vm) {
        int topValue = vm.pop();  
        int secondValue = vm.pop();
 
        switch(operator) { 
          //Arithmetic op 
         case "-":
                vm.push(secondValue-topValue);
                break;
                
         case "+":
                vm.push(secondValue+topValue);
                break;
                
         case "*":
                vm.push(secondValue*topValue);
                break;  
                
         case "/":
                vm.push(secondValue/topValue);
                break;
         //Logical op      
         case "<=":
                if(secondValue <= topValue) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
          
         case "!=":
                if(secondValue != topValue) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
         case "==":
                if(secondValue == topValue) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            
         case ">":
                if(secondValue > topValue) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
            
         case "<":
                if(secondValue < topValue) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
                
         case ">=":
                if(secondValue >= topValue) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
                
         case "&":
                if(secondValue > 0  &&  topValue > 0) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;    
                
         case "|":
                if(secondValue > 0 ||  topValue > 0) {
                    vm.push(1);
                } else {
                    vm.push(0);
                }
                break;
        }
    }
    
       public String toString(){
        return "\nBOP " + operator ; }
}


                
        
    
    

