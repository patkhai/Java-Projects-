package Bricks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 *  @author fujishimareo
 */

public abstract class Tile extends Entity{
    protected boolean visible;
    
    public Tile(float x, float y, int width, int height, boolean visible){
        super(x, y, width, height);
        this.visible = visible;
    }

    public abstract void collisionWithBall(Ball ball);
    public abstract void checkVisible();

    //Getters and Setters
    public boolean getVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
}