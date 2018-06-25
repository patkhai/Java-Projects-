

package Bricks;

import java.awt.image.BufferedImage;

/**
 *
 * @author patkhai
 */

//initialize every images and sounds
public class ImageFolder {
     
    protected static BufferedImage star, shell, block1, block2, block3, block4, block5, block6, block7;
    protected static BufferedImage Block_solid, wall, powerUp, heal;
    protected static BufferedImage backGround1;
    protected static BufferedImage enemy;
    
    public static void init(){
    	// the ball
       	star = ImageLoader.loadImage("/res/Pip.gif");
       	// the player
	    shell = ImageLoader.loadImage("/res/try.gif");
	    // blocks
	    block1 = ImageLoader.loadImage("/res/Block1.gif");
	    block2 = ImageLoader.loadImage("/res/Block2.gif");
	    block3 = ImageLoader.loadImage("/res/Block3.gif");
	    block4 = ImageLoader.loadImage("/res/Block4.gif");
	    block5 = ImageLoader.loadImage("/res/Block5.gif");
	    block6 = ImageLoader.loadImage("/res/Block6.gif");
	    block7 = ImageLoader.loadImage("/res/Block7.gif");
	    powerUp = ImageLoader.loadImage("/res/Block_split.gif");
	    heal = ImageLoader.loadImage("/res/Block_life.gif");
	    // unbreakable walls
	    Block_solid = ImageLoader.loadImage("/res/Block_solid.gif");
	    wall = ImageLoader.loadImage("/res/Wall.gif");
	    // the enemy
	    enemy = ImageLoader.loadImage("/res/enemy.gif");
	    // the background
	    backGround1 = ImageLoader.loadImage("/res/Background1.bmp");
    }
 
}