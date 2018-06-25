/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author patkhai and reo
 */
public class Map {
     int Map_width, Map_height;
     BufferedReader level;
     String file;
   
    
    public Map (String path){
        String line;
        try {
            file = path;
            level = new BufferedReader(new InputStreamReader(getClass().getResource(file).openStream()));
            line = level.readLine();
            Map_width = line.length();
            Map_height = 0;
            while(line != null) {
                Map_height++;
                line = level.readLine();
            }
            level.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    //load the files from the txt and read the line and the numbers
    public void loadfiles(){
       Game game = Game.getInstance();
        String line;
        try {
            level = new BufferedReader(new InputStreamReader(Game.class.getResource(file).openStream()));
            line = level.readLine();
            Map_width = line.length();
            Map_height=0;
            while(line!=null){
                for(int i = 0, n = line.length() ; i < n ; i++) {
                    char c = line.charAt(i);

                    if(c=='1'){
                        game.addSprites(game.loadImages().get("Wall1"), i * 32, Map_height * 32, 0, 1, "wall"); //*32 = size of each img
                    }

                    if(c=='2'){
                        game.addBrWall(game.loadImages().get("wall2"), i * 32, Map_height * 32); //*32 = size of each img
                    }

                    if(c=='3'){
                        game.addTanks1(game.loadImages().get("Tank1"), i * 32, Map_height * 32); //*32 = size of each img
                    }
                    if(c=='4'){
                        game.addTanks2(game.loadImages().get("Tank2"), i * 32, Map_height * 32); //*32 = size of each img
                    }

                   if(c=='5'){
                        game.addSprites(game.loadImages().get("power"), i * 32, Map_height * 32, 0, 1, "power");
                    }
                }
                Map_height++;
                line = level.readLine();
            }
            level.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
}
