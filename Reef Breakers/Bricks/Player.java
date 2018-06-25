package Bricks;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

/**
 *
 * @author fujishimareo
 */
public class Player extends Entity implements KeyListener{
    
    public final int DEFAULT_PLAYERXDIR = 100;
    private int playerXDir;


    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
        this.playerXDir = DEFAULT_PLAYERXDIR;

    }

    private void moveRight(){
      x += playerXDir;
    }

    private void moveLeft(){
      x -= playerXDir;
    }

    @Override
    public void draw(Graphics g) {
      g.drawImage(ImageFolder.shell, (int)x, (int)y, width, height, null);
    }

    @Override
  public void keyPressed(KeyEvent e) 
  {
    // keep increasing playerXDir
    playerXDir += 3.6 ;
    if (e.getKeyCode() == KeyEvent.VK_RIGHT){        
      if(x > 675){
        x = 670;
      }
      else{
        moveRight();
      }
    }
    
    if (e.getKeyCode() == KeyEvent.VK_LEFT){          
      if(x <= 25){
        x = 30;
      }
      else{
        moveLeft();
      }
    }    
  }



    @Override
  public void keyReleased(KeyEvent e) {
      if(x > 675){
        x = 670;
      }
      if(x <= 25){
        x = 30;
      }
    playerXDir = DEFAULT_PLAYERXDIR;

  }
    @Override
  public void keyTyped(KeyEvent e) {
      if(x > 675){
        x = 670;
      }
      if(x <= 25){
        x = 30;
      }
  }
}