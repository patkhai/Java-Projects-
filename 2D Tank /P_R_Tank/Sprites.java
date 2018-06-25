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

public class Sprites {
    Game game;
    BufferedImage img;
    BufferedImage[] splitImg = new BufferedImage[60];
    int speed = 6;
     String type;
    boolean visible = true;    
    protected int x, y, sprite = 0, totalSprites;
    
    //will get all the imgs from this set of sprites
    public Sprites(BufferedImage img, int initX, int initY, int sprite, int totalSprites, String type){
        this.totalSprites = totalSprites;
        this.sprite = sprite;
        this.type = type;
        init(img, initX, initY);
    }

    private void init(BufferedImage img, int initX, int initY) {
        game = Game.getInstance();
        x = initX; y = initY;
        this.img = img;
        int width = img.getWidth()/totalSprites;
        int height = img.getHeight();
        for(int i =0; i<=totalSprites-1; i++)
            splitImg[i] = img.getSubimage(i * width, 0, width, height);
    }

    public void render(Graphics g, ImageObserver obs){
        g.drawImage(splitImg[sprite], x, y, obs);
    }

    public BufferedImage getImg(){
        return splitImg[sprite];
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
      
    public Rectangle getBounds(){
        return new Rectangle(x,y,img.getWidth(),img.getHeight());
    }
    
    public String getType(){
        return type;
    }
    
    
}
