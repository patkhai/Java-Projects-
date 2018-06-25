/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author patkhai and reo
 */

//this will layered the bg img as panel and positing tiles
public class Background extends JPanel{
    private final int bwidth;
    private final int bheight;
    private BufferedImage bgPanel;
    
    public Background(int width, int height){
        this.bwidth = width;
        this.bheight = height;
    }
    
    public void init(BufferedImage path){
        bgPanel = path;
    }
    
    public void render(Graphics g){
         int TileWidth = bgPanel.getWidth(this);
         int TileHeight = bgPanel.getHeight(this);
        int  x = bwidth / TileWidth;
        int  y = bheight / TileHeight;
         for (int i = -1; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
               g.drawImage(bgPanel, j * TileWidth, i * TileHeight, TileWidth, TileHeight, this);
            }
        }
          
    }
}
