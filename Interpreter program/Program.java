package interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import interpreter.ByteCode.*;


public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> addrslabel;
    private String label;
    private int addrs;
    
    public Program() {
        program = new ArrayList<ByteCode>();
        addrslabel = new HashMap<String, Integer>(); 
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    
    public void resolveAddrs(Program program) {
        for (int i=0; i < this.program.size(); i++) {            
            if (this.program.get(i) instanceof Superclass){
                addrs = addrslabel.get(((Superclass) this.program.get(i)).getLabel());
                ((Superclass) this.program.get(i)).setAddrs(addrs);
            }          
        }
    }
    
    public void add(ByteCode code) { 
        if (code instanceof LabelCode){
            label = ((LabelCode)code).getLabel();
            addrslabel.put(label, program.size()-1);
        }
        program.add(code); 
    } 
    
    }
