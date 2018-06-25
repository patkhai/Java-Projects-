package Bricks;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author fujishimareo
 */
public class Ball extends Entity{
    
    public static final int DEFAULT_POWER = 10;
    public static final float DEFAULT_SPEED = 1.5f;
    public static final int DEFAULT_XDIR = -1;
    public static final int DEFAULT_YDIR = -2;
    public static final int DEFAULT_BALL_WIDTH = 64;
    public static final int DEFAULT_BALL_HEIGHT = 64;
    public static final int MAX_YDIR = 64;
    
    protected int power;
    protected float speed;
    private int angle = 0;
    private int angleSpeed = 5;
    private double gravity = 0.03;

    protected float ballXdir;
    protected float ballYdir;

    private boolean visible;
    protected boolean diviable;
    private boolean life = true;

    
    public Ball(float x, float y, int width, int height, boolean visible) {
        super(x, y, width, height);
        power = DEFAULT_POWER;
        speed =  DEFAULT_SPEED;
        ballXdir = DEFAULT_XDIR;
        ballYdir = DEFAULT_YDIR;
        this.visible = visible;
        this.diviable = false;
    }

    @Override
    public void draw(Graphics g) {
      if(visible){
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);    
        rotation.rotate(Math.toRadians(angle), ImageFolder.star.getWidth() / 2, ImageFolder.star.getHeight() / 2);
          
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(ImageFolder.star, rotation, null);
      }
    }

    public void update(){
      if(visible){
        angle += angleSpeed;
        x += ballXdir;
        y += ballYdir;
        ballYdir += gravity;
      }

      // collision between ball and walls
      if(x < 25){
        ballXdir = -ballXdir;
        x = 26;
      }
      if(y < 20){
        ballYdir = -ballYdir;
        y = 21;
      }
      if(x > 750){
        ballXdir = -ballXdir;
        x = 749;
      } 
      if(y > 600){
        life = false;
      }

    }

    public void collisionWithPlayer(int playerX, int playerY, int playerWidth, int playerHeight){
      if(new Rectangle(playerX, playerY, playerWidth/3, 1).intersects(new Rectangle((int)x, (int)y, width, height)))
      {
        ballYdir += 0.5;
        // check max ballYdir
        if(ballYdir  > (float)7.5)
          ballYdir=(float)4.5;
        ballYdir = -ballYdir;
        ballXdir = -2;
        ballXdir -= 0.1;
      }
      else if(new Rectangle(playerX + playerWidth/3, playerY, playerWidth/3, 1).intersects(new Rectangle((int)x, (int)y, width, height)))
      {
        ballYdir += 0.7;
        // check max ballYdir
        if(ballYdir  > (float)7.5)
          ballYdir=(float)4.5;
        ballYdir = -ballYdir;
      }
      else if(new Rectangle(playerX + 2 * playerWidth/3, playerY, playerWidth/3, 1).intersects(new Rectangle((int)x, (int)y, width, height)))
      {
        ballYdir += 0.5;
        // check max ballYdir
        if(ballYdir  > (float)7.5)
          ballYdir=(float)4.5;
        ballYdir = -ballYdir;
        ballXdir = 2;
        ballXdir += 0.1;
      }
      
    }
    
    //GETTERS SETTERS
    
    public int getPower(){
        return power;
    }
    
    public void setPower(int power){
        this.power = power;
    }
    
    public float getSpeed(){
        return speed;
    }
    
    public void setSpeed(float speed){
        this.speed = speed;
    }
    
    public float getBallXdir(){
        return ballXdir;
    }
    
    public void setBallXdir(float ballXdir){
        this.ballXdir = ballXdir;
    }
    
    public float getBallYdir(){
        return ballYdir;
    }
    
    public void setBallYdir(float ballYdir){
        this.ballYdir = ballYdir;
    }

    public void setVisible(boolean visible){
      this.visible = visible;
    }

    public boolean getVisible(){
      return this.visible;
    }

    public void setDiviable(boolean diviable){
      this.diviable = diviable;
    }

    public boolean getDiviable(){
      return diviable;
    }

    public void setAngleSpeed(int as){
      this.angleSpeed = as;
    }

    public int getAngleSpeed(){
      return angleSpeed;
    }
    
}