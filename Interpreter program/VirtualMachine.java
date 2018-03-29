package interpreter;

import java.util.Stack;
import interpreter.ByteCode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
     public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dump = false; 
        while(isRunning) {   
            ByteCode code = program.getCode(pc); 
            code.execute(this); 
            //will see if dump is on after reading the dumpcode
            if(dump && !(code instanceof DumpCode)){
               System.out.println(code.toString());
                //after then it will print and dump
                runStack.dump(); 
            }
            pc++;
        }
    }
   
    /*We will be using vm to call all the functions from the rts so that we 
     can use it on other class and a way to maintain functions private
    */
     
    public int peek() {
        return runStack.peek();
    }

    public int pop() {
        return runStack.pop();
    }

    public int push(int i) {
        return runStack.push(i);
    }

    public void newFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public int store(int offset) {
        return runStack.store(offset);
    }

    public int load(int offset) {
        return runStack.load(offset);
    }

    public void pushReturnAddress() {
        returnAddrs.push(pc);
    }

    public int popReturnAddress() {
        return returnAddrs.pop();
    }

    public void setPC(int addrs) {
       pc = addrs;
    }

    public int getPC() {
        return pc;
    }

    public void setDump(boolean dumping) {
        dump = dumping;
    }

    public void isRunning() {
        isRunning = false;
    }
    
    public int getOffset(){
        return runStack.getOffset();
    }  
}