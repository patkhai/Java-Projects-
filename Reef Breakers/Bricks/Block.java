package Bricks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
/**
 *
 * @author fujishimareo
 */
public class Block extends Tile{
    //width = 50 height = 20

    //blockNum 10 = unBreakable

    protected int blockNum;
    protected double health;
    private boolean disapier = false;
    
    public Block(float x, float y, int width, int height, boolean visible, int blockNum){
        super(x, y, width, height, visible);
        this.blockNum = blockNum;
        // health = 10 * blockNum;
        if(blockNum == 20 || blockNum == 30 || blockNum == 40){ //if block are special block
            health = 10;
        }else{ 
            // to set different health to different coloer
            health = 5 + 5 * blockNum;
        }
    }

    @Override
    public void draw(Graphics g) {
        if(blockNum == 1 && visible == true)
            g.drawImage(ImageFolder.block1, (int)x, (int)y, width, height, null); //pink 1 hits
        if(blockNum == 2 && visible == true)
            g.drawImage(ImageFolder.block2, (int)x, (int)y, width, height, null); //yellow 2 hits
        if(blockNum == 3 && visible == true)
            g.drawImage(ImageFolder.block3, (int)x, (int)y, width, height, null); //red 2 hitss
        if(blockNum == 4 && visible == true)
            g.drawImage(ImageFolder.block4, (int)x, (int)y, width, height, null); //green 3 hits
        if(blockNum == 5 && visible == true)
            g.drawImage(ImageFolder.block5, (int)x, (int)y, width, height, null); //blue 3 hitss
        if(blockNum == 6 && visible == true)
            g.drawImage(ImageFolder.block6, (int)x, (int)y, width, height, null); //dark blue 4 hits
        //unbreakable wall
        if(blockNum == 10 && visible == true)
            g.drawImage(ImageFolder.Block_solid, (int)x, (int)y, width, height, null);
        if(blockNum == 0 && visible == true)
            g.drawImage(ImageFolder.wall, (int)x, (int)y, width, height, null); // walls
        // healing
        if(blockNum == 40 && visible == true)
            g.drawImage(ImageFolder.heal, (int)x, (int)y, width, height, null);
    }

    @Override
    public void collisionWithBall(Ball ball) {
        if(visible && new Rectangle((int)ball.getX(), (int)ball.getY(), ball.getWidth(), ball.getHeight()).intersects(new Rectangle((int)x, (int)y, width, height)))
        {
            if(blockNum != 10) 
                health -= ball.getPower();
            Sound.playClip("/res/Sound_click.wav");
            float collideX = -ball.getBallXdir();
            float collideY = -ball.getBallYdir();
            ball.setBallYdir(collideY);
            ball.setBallXdir(collideX);  
            // System.out.println("collide!!!!!!!");
        }

    }

    @Override
    public void checkVisible() {
        if(health <= 0 && visible == true){
            this.setVisible(false);
            disapier = true;
        }
    }

    // GETTER SETTER
    public double getHealth(){
        return health;
    }

    public int getBlockNum(){
        return blockNum;
    }

    public boolean getDisapier(){
        return disapier;
    }
    
    public void setDisapier(boolean aha){
        disapier = aha;
    }
}
