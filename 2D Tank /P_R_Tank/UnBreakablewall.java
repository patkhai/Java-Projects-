/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.awt.image.BufferedImage;

/**
 *
 * @author patkhai and reo
 */

public class UnBreakablewall extends Tile{
    
    public UnBreakablewall(BufferedImage img, int x, int y) {
        super(img, x, y);
        setPassby(false);
        visible = true;
    }
    
    
}
