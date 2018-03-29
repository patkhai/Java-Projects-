package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interpreter.ByteCode.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;
    private String line, codeString, codeClass;
    private StringTokenizer token;
    private ArrayList<String> byteArgs;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));     
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    
    
    // this will get instance of each bytecode and add it to Program
    public Program loadCodes() throws IOException { 
        //initializing program class to load byteCodes from a file
        program = new Program(); 
        //Create an array list that stores the arguments of a bytecode
        byteArgs = new ArrayList<String>();
        // Setting line to be the first line of the byteCode File
        line = byteSource.readLine();
        while(line != null) { 
            //setting up a string tokenizer to go through the line
            token = new StringTokenizer(line);
            //empties the arraylist of argruments if there were args
            byteArgs.clear(); 
            //getting the  first token from the line 
            codeString = token.nextToken(); 
            //calling from codetable
            codeClass = CodeTable.getClassName(codeString); 
            //this will chekc if there are args linked with the bytecode
            while(token.hasMoreTokens()) {
                // this will add the next token (byteargs) to the arraylist   
                byteArgs.add(token.nextToken());
                }
            
            try {
                
                //gettin the class for the bytecode and will build a new instance 
                ByteCode bytecode = (ByteCode)(Class.forName("interpreter.ByteCode." + codeClass).newInstance());
                // fucntion will pass the arraylist of arguments to the bytecode obj
                bytecode.init(byteArgs); 
                //System.out.println("error might be here"); <- just testing it out to sse where the error
                program.add(bytecode); //and then will add bytecode obj to a program 
                //Syste.out.println("test here too"); <- just testing it out to sse where the error
                line = byteSource.readLine(); //read the next line 
            }
            
            //if instance of byteCode class cannot be created, print error but will continue processing
            catch(Exception e) { 
                System.out.print("Error occured" +e);
            }
        }
        //this will resolve specific bytecode instances
        program.resolveAddrs(program); 
        return program;
    }
}