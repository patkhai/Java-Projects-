/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author patkhai and reo
 */

public class Tile {
    protected boolean passby, visible;
    private int x, y;
    private BufferedImage img;
    
    public Tile(BufferedImage img, int x, int y){
        this.x = x;
        this.y = y;
        this.img =img;
        visible = true;
    }
    
    public void render(Graphics g, ImageObserver obsv) {
        g.drawImage(img, x, y, obsv);
    }
    
    //Getters and Setters
    public BufferedImage getImg(){
        return img;
    }
    
    public boolean getpass(){
        return passby;
    }
    
    public void setPassby(boolean value){
        passby = value;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    
    
}
