package Bricks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
/**
 *
 * @author fujishimareo
 */
public class  PowerUp extends Block{

    

    public PowerUp(float x, float y, int width, int height, boolean visible, int blockNum){
        super(x, y, width, height, visible, blockNum);
    }

    @Override
    public void draw(Graphics g) {
        if(blockNum == 20 && visible == true)
            g.drawImage(ImageFolder.powerUp, (int)x, (int)y, width, height, null);
    }

    @Override
    public void collisionWithBall(Ball ball) {
        if(visible && new Rectangle((int)ball.getX(), (int)ball.getY(), ball.getWidth(), ball.getHeight()).intersects(new Rectangle((int)x, (int)y, width, height)))
        {
            if(blockNum != 10){
                health -= 10;
                if(health <= 0){
                    ball.setDiviable(true);
                }
                Sound.playClip("/res/Sound_block.wav");
            }
            ball.setBallYdir(-ball.getBallYdir());
            ball.setBallXdir(-ball.getBallXdir());
        }

    }

    @Override
    public void checkVisible() {
        if(health <= 0){
            this.setVisible(false);
        }
    }

    // GETTER SETTER

    
}