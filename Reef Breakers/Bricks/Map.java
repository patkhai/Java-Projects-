
package Bricks;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author patkhai
 */
public class Map {
     private int Map_width, Map_height;
     private BufferedReader level;
     private String currentStage;

     private Block[][] block;
     private int blockNum = 0;
     private int blockNumInTheStage = 0; // to calculate the score
     private int enemyNum = 0;
     private boolean blockCheck = false; // for the score
     private boolean life = false; // for healing block ditection

   
    
    public Map(String stage){
        String line;
        currentStage = stage;
        try {
            //read file
            level = new BufferedReader(new InputStreamReader(getClass().getResource(stage).openStream()));
            // get line from file
            line = level.readLine();
            // get width
            Map_width = line.length();
            // get height
            Map_height = 0;
            while(line != null) {
                Map_height++;
                line = level.readLine();
            }
            // close file
            level.close();
            // set block array
            block = new Block[Map_height][Map_width];
            //read file again 
            level = new BufferedReader(new InputStreamReader(Game.class.getResource(stage).openStream()));
            // get line from file
            line = level.readLine();

            int height = 0;
            while(line!=null){
                int blockCount =0;
                // initialize block based on the infomation from file
                for(int i = 0, n = Map_width ; i < n ; i++) {
                    char c = line.charAt(i);
                    if(c=='0'){
                        block[height][i] = new Block(i*25, height*20, 25, 20, true, 0);
                    }
                    if(c=='1'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 1);
                        blockNum++;
                    }
                    if(c=='2'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 2);
                        blockNum++;
                    }
                    if(c=='3'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 3);
                        blockNum++;
                    }
                    if(c=='4'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 4);
                        blockNum++;
                    }
                    if(c=='5'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 5);
                        blockNum++;
                    }
                    if(c=='6'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 6);
                        blockNum++;
                    }
                    if(c=='u'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 10);
                        blockNum++;
                    }
                    if(c=='p'){
                      blockCount++;
                        block[height][i] = new PowerUp(blockCount*50-25, height*20, 50, 20, true, 20);
                    }
                    if(c=='e'){
                      blockCount++;
                        block[height][i] = new Enemy(blockCount*50-25, height*20, 50, 40, true, 30);
                        enemyNum++;
                    }
                    if(c=='h'){
                      blockCount++;
                        block[height][i] = new Block(blockCount*50-25, height*20, 50, 20, true, 40);
                    }
                    if(c=='n'){
                      blockCount++;
                    }
                }
                height++;
                line = level.readLine();
            }
            level.close();
            blockNumInTheStage = blockNum;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //load the files from the txt and read the line and the numbers
    public void draw(Graphics g){
      for(int i=0; i < Map_height; i++){
        for(int j=0; j < Map_width; j++){
          try{
            if(block[i][j] != null)
              block[i][j].draw(g);
          } catch (Exception e) {
            System.out.println("Block[i][j] = " + i + " " + j );
          }  
        }
      }
    }

    public void collisionWithBall(Ball ball){
      for(int i=0; i < Map_height; i++){
        for(int j=0; j < Map_width; j++){
          try{
            if(block[i][j] != null){
              block[i][j].collisionWithBall(ball);
            
            }
          } catch (Exception e) {
            System.out.println("Block[i][j] = " + i + " " + j );
          }  
        }
      }
    }

    public void checkVisible() {
      for(int i=0; i < Map_height; i++){
        for(int j=0; j < Map_width; j++){
          try{
            if(block[i][j] != null){
              if(block[i][j].getBlockNum() != 0 && block[i][j].getHealth() <= 0){
                // if block is enemy 
                if(block[i][j].getBlockNum() == 30 && block[i][j].getVisible())
                {
                  enemyNum--;
                  Sound.playClip("/res/Sound_bigleg.wav");
                }
                // if block is nomal blocks
                if(block[i][j].getDisapier() && !block[i][j].getVisible() && block[i][j].getBlockNum() != 30 && block[i][j].getBlockNum() != 20 && block[i][j].getBlockNum() != 40)
                {
                  blockNum--; 
                  blockCheck = true;
                  block[i][j].setDisapier(false);
                }
                block[i][j].checkVisible();
                // if block is power up block 
                if(block[i][j].getDisapier() && !block[i][j].getVisible() && block[i][j].getBlockNum() == 40){
                  life = true;
                  block[i][j].setDisapier(false);
                  Sound.playClip("/res/Sound_block.wav");
                }
              }
            }
          } catch (Exception e) {
            System.out.println("Block[i][j] = " + i + " " + j );
          }  
        }
      }

    }

    // GETTER SETTER
    public Block[][] getBlock(){
      return block;
    }

    public int getBlockNum(){
      return blockNum;
    }

    public int getEnemyNum(){
      return enemyNum;
    }

    public int getBlockNumInTheStage(){
      return blockNumInTheStage;
    }

    public boolean getBlockCheck(){
      return blockCheck;
    }

    public void setBlockCheck(boolean bc){
      this.blockCheck = bc;
    }

    public boolean getLife(){
      return life;
    }

    public void setLife(boolean life){
      this.life = life;
    }

    public String getCurrentStage(){
      return currentStage;
    }
}