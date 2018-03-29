package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;
    private Stack<Integer> framePointer2;
    
    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<Integer>();
        framePointer = new Stack<Integer>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

public void dump() {
       //making a copy of fp so that original is not modified
       framePointer2 = (Stack<Integer>) framePointer.clone();
       //kepping the fp order
       int [] frameIndex= new int[framePointer.size()]; 
       //copy stack into array keeping order the firest fp the first element in the array
       for(int i = framePointer.size() - 1; i >= 0; i--){ 
            frameIndex[i]=framePointer2.pop();    
       }
       //this will print the rts based on the frameindex if rts is not empty
       if(!runTimeStack.isEmpty()){
           //set the boundaries to print the different frames of the runStack
           int last;
           for(int i = 0; i < framePointer.size(); i++){
               //get first and second fp
               int first = frameIndex[i];
               //get the next element if there is another fpIndex
               if(i<framePointer.size() - 1){ 
                    last = frameIndex[i + 1];
               }else{
                   //if there is only one fp,last is size of rts
                   last = runTimeStack.size(); 
               }
               if(first == last){
                   System.out.print("[ ]");
               }else{
                    //print first the first runStack element
                    System.out.print("["+ runTimeStack.get(first));
                    //Print the stack from the first inclusive to last exclusive fp boundary
                    for(int j = first + 1; j < last; j++){
                        System.out.print(","+runTimeStack.get(j));
                    }
                    System.out.print("]");
                }
           }
       }else{
           //if the rs is empty
           System.out.println("[ ]" ); 
            
       }            
   } 

    //peek the top item on rs
    public int peek() {
        return runTimeStack.get(runTimeStack.size()-1);
    }
    //pop the top item on rs
    public int pop() {
         return runTimeStack.remove(runTimeStack.size()-1);
    }
    //push the top item item on rs
    public int push(int i) {
        runTimeStack.add(i);
        return i;     
    }
    //peek the top frame offset
    public int peekFramePointer(){
        return framePointer.peek();
    }
    //start new frame
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }
    //pop the top frame after return and push the return value
    public void popFrame() {
        int top = peek();
        int index = framePointer.pop(); 
        while(runTimeStack.size()-1 >= index) {
            if(!runTimeStack.isEmpty()) {
                pop();
            }
        }
        push(top);
    }
    //store the stack value into variable
    public int store(int offset) {
        runTimeStack.set(framePointer.peek() + offset, pop()); 
        return offset;
    }
    //load variables onto rs
    public int load(int offset) {
        int var = runTimeStack.get(framePointer.peek() + offset); 
        runTimeStack.add(var); 
        return offset;
    }
    //get offset value
    public int getOffset() {
        return runTimeStack.size() - framePointer.peek() - 1;
    }
 
}