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

/*act as a superclass for false | goto | call code*/
public interface Superclass {
    public abstract String getLabel(); 
    public abstract void setAddrs(int n);
    public abstract int getAddrs();
}
