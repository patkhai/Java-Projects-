
package Bricks;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author patkhai
 */
public class ImageLoader {
    
    public static BufferedImage loadImage(String path){
        try{
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Can't read Image file");
        System.exit(1);
        
        }
        return null;
    }
}