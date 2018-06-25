/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.awt.image.BufferedImage;

/**
 *
 * @author patkhai
 */
public class Explosion extends Sprites {
    protected int delay, now;

    public Explosion(BufferedImage img, int x, int y, int sprite, int totalSprites) {
        super(img, x, y, sprite, totalSprites, "explosion");
//        renderExplosion();
        delay = 2;
        now = 0;
    }
    //explosion delay and how long it will take to disappear
    public void renderExplosion(){
            render(game.g2, game);
            now++;
            if(now>delay){
                now=0;
                sprite++;
            }
    }
    
    public boolean finish(){
        return sprite >= totalSprites;
    }
    
}
