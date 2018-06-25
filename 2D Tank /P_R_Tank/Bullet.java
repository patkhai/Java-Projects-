/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author patkhai
 */
public class Bullet{
    int angle,x,y;
    BufferedImage bullet;
    boolean visible;
    public Bullet(BufferedImage img, int x, int y, int angle) {
        this.x = x;
        bullet = img;
        this.y= y;
        this.angle = angle;
        visible = true;
    }

    public void draw(Graphics g, ImageObserver obs){
        g.drawImage(bullet, x, y, obs);
    }
    public void update(){
        x += Math.cos(Math.toRadians(angle)) * 7;
        y -= Math.sin(Math.toRadians(angle)) * 7;
    }

    public void collision(){
        Rectangle r1 = new Rectangle(x,y,bullet.getWidth(),bullet.getHeight());
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public BufferedImage getImg(){
        return bullet;
    }
}
