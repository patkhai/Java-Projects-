package Bricks;


import java.awt.Graphics;

/**
 *
 * @author fujishimareo
 */
public abstract class Entity {
    
    protected float x, y; //for caluculation 
    protected int width, height; // to set the size of image of items
    
    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    // public abstract void tick();
    
    public abstract void draw(Graphics g);
    
    public float getX(){
        return x;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public float getY(){
        return y;
    }
    
    public void setY(float y){
        this.y = y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
}