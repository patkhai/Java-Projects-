/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * @author patkhai and reo
 */

public class Tank extends Sprites{
    
    protected int vx, vy, initsprite;
    private int angle;
    //setting a degree  for each rotation
    private final int r = 6;
    //movement of the tank with keys assigned
    boolean[] keys = new boolean[4];
    //bullet to show
    boolean show = true, powerup = false;
    //life display and score
    int life = 6;
    protected ArrayList<Bullet> bullets;
    public ArrayList<Explosion> explosions;
    

    //using sprites
    public Tank(BufferedImage img, int vx, int vy, int sprite, int totalSprites) {
        super(img, vx, vy, sprite, totalSprites, "tank");
        explosions = new ArrayList<>();
        bullets = new ArrayList<>();
        angle = r * sprite;
        this.vx = vx;
        this.vy = vy;
        this.initsprite = sprite;
        for(int i = 0; i<= 3; i++)
            keys[i] = false;
    }

    //assinging the tokens to the keys so taht its easier to know which one is which
    public void move() {
        if(keys[0]) rotateLeft();
        if(keys[1]) moveBackwards();
        if(keys[2]) rotateRight();
        if(keys[3]) moveForwards();
        
    }

    private void rotateLeft() {
        sprite++;
        if(sprite > 59) sprite = 0;
        angle = r * sprite;
    }

    private void rotateRight() {
        sprite--;
        if(sprite < 0) sprite = 59;
        angle = r * sprite;
    }

    private void moveBackwards() {
        x -= (speed * Math.cos(Math.toRadians(angle)));
        y += (speed * Math.sin(Math.toRadians(angle)));
    }

    private void moveForwards() {
       x += (speed * Math.cos(Math.toRadians(angle)));
       y -= (speed * Math.sin(Math.toRadians(angle)));   
    }
//will be use for collision when the tank and the wall
    public Rectangle returnBounds(){
        return new Rectangle(x,y,54,54);
    }
    
    public void fire(){
        bullets.add(new Bullet(game.loadImages().get("bullet"), x + getImg().getWidth()/2, y + getImg().getHeight()/2, angle));
        if(powerup)
          bullets.add(new Bullet(game.loadImages().get("bullet"), x + getImg().getWidth()/4 , y + getImg().getHeight()/4 , angle));
    }
    
    //to check the bullets and tanks
    public void checkCollision(Tank t1){
        Rectangle t = returnBounds();
        Rectangle t1Rec = t1.returnBounds();
        
        //check collision with power agaisnt tank
        for(int i = 0; i < game.sp.size(); i++){
            if(game.sp.get(i).type.equals("power")) {
                Rectangle powers = game.sp.get(i).getBounds();
                if (t.intersects(powers)) {
                    powerup = true;
                    game.sp.remove(i);
                }
            }
        }
        //this will check bullets and the tanks
        for(int i = 0; i < bullets.size(); i++){
            boolean remove = false;
            Rectangle r1 = new Rectangle(bullets.get(i).getX(),bullets.get(i).getY(), bullets.get(i).getImg().getWidth(),bullets.get(i).getImg().getHeight());
            //bullets and player
            if(r1.intersects(t1Rec)) {
                explosions.add(new Explosion(game.loadImages().get("explosion"),(int)r1.getX()-16,(int)r1.getY()-16,0,6));
                game.sound.playClip("/res/Explosion_small.wav");
                remove = true;
                t1.life -= 1;
                if(t1.life == 0){
                    game.sound.playClip("/res/Explosion_large.wav");
                    game.running = true;
                }  
            }
            //to see if the bullet and breakable works 
            for(int j = 0; j < game.walls2.size(); j++){
                Rectangle w2 = new Rectangle(game.walls2.get(j).getX(),game.walls2.get(j).getY(), game.walls2.get(j).getImg().getWidth(), game.walls2.get(j).getImg().getHeight());
                if(r1.intersects(w2) && game.walls2.get(j).visible){
                    explosions.add(new Explosion(game.loadImages().get("explosion"),game.walls2.get(j).getX(),game.walls2.get(j).getY(), 0, 6));
                    game.sound.playClip("/res/Explosion_small.wav");
                    game.walls2.get(j).visible = false;
                    remove = true;
                }
            }
            
            //check bullets and unbreakableWall
            for(int j = 0; j < game.sp.size(); j++){
                if(game.sp.get(i).type.equals("wall")) {
                    Rectangle w2 = new Rectangle(game.sp.get(j).getX(), game.sp.get(j).getY(), game.sp.get(j).getImg().getWidth(), game.sp.get(j).getImg().getHeight());
                    if (r1.intersects(w2)) {
                        game.sound.playClip("/res/Explosion_small.wav");
                        remove = true;
                    }
                }
            }
            if(remove) bullets.remove(i);
        }           
    }
    
    public ArrayList getBullets(){
        return bullets;
    }
}