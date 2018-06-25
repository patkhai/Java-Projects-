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
public class Breakablewall extends Tile{
    private int timer = 1000;
    
    public Breakablewall(BufferedImage img, int x, int y){
        super(img, x, y);
        setPassby(false);
        visible = true;
    }
    //this will make sure that if the wall breaks if will spawn in 5 secs
    
    public void render(Graphics g, ImageObserver obsv){
        if(!visible) {
            this.timer--;
            if(this.timer < 0){
                this.timer = 1000;
                this.visible = true;
            }
        }else {
            super.render(g, obsv);
        }
    }
    
}
