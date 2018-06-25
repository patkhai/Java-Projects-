package P_R_Tank;

import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author patkhai and reo
 */


public class KeyManager {
    int [] tank1, tank2;
    Game game = Game.getInstance();
    
    public void process(ArrayList<Tank> tanks, ArrayList<Sprites> w1, ArrayList<Breakablewall> w2){
        move(tanks);
        collisionTanks(tanks, w1, w2);
    }

    public void pressed(KeyEvent e, ArrayList<Tank> tanks) {
        if(e.getKeyCode() == KeyEvent.VK_A)
            tanks.get(0).keys[0] = true;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            tanks.get(1).keys[0] = true;
        if(e.getKeyCode() == KeyEvent.VK_S)
            tanks.get(0).keys[1] = true;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            tanks.get(1).keys[1] = true;
        if(e.getKeyCode() == KeyEvent.VK_D)
            tanks.get(0).keys[2] = true;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            tanks.get(1).keys[2] = true;
        if(e.getKeyCode() == KeyEvent.VK_W)
            tanks.get(0).keys[3] = true;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            tanks.get(1).keys[3] = true;
    }

    public void released(KeyEvent e, ArrayList<Tank> tanks){
        if(e.getKeyCode() == KeyEvent.VK_A)
            tanks.get(0).keys[0] = false;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            tanks.get(1).keys[0] = false;
        if(e.getKeyCode() == KeyEvent.VK_S)
            tanks.get(0).keys[1] = false;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            tanks.get(1).keys[1] = false;
        if(e.getKeyCode() == KeyEvent.VK_D)
            tanks.get(0).keys[2] = false;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            tanks.get(1).keys[2] = false;
        if(e.getKeyCode() == KeyEvent.VK_W)
            tanks.get(0).keys[3] = false;
        if(e.getKeyCode() == KeyEvent.VK_UP)
            tanks.get(1).keys[3] = false;
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            tanks.get(0).fire();
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            tanks.get(1).fire();

    }

    public void move(ArrayList<Tank> tanks){
        tank1 = new int[2];
        tank2 = new int[2];
        tank1[0] = tanks.get(0).getX();
        tank1[1] = tanks.get(0).getY();
        tank2[0] = tanks.get(1).getX();
        tank2[1] = tanks.get(1).getY();
        tanks.get(0).move();
        tanks.get(1).move();
    }
    

   public void collisionTanks(ArrayList<Tank> tanks, ArrayList<Sprites> w1, ArrayList<Breakablewall> w2){
        //this will check the collision between the two tanks if they bump into each other
        Rectangle boxt1 = new Rectangle(tanks.get(0).getX(), tanks.get(0).getY(),55,55);
        Rectangle boxt2 = new Rectangle(tanks.get(1).getX(), tanks.get(1).getY(),55,55);
        if(boxt1.intersects(boxt2)) {
            tanks.get(0).setX(tank1[0]);
            tanks.get(0).setY(tank1[1]);
            tanks.get(1).setX(tank2[0]);
            tanks.get(1).setY(tank2[1]);
        }
        //to see the collison with sprites so unbreakblewall
        for(int i = 0; i < w1.size(); i++){
            Rectangle sprites = new Rectangle(w1.get(i).getX(), w1.get(i).getY(),w1.get(i).getImg().getWidth()/2,w1.get(i).getImg().getHeight()/2);
            if(boxt1.intersects(sprites)){
                tanks.get(0).setX(tank1[0]);
                tanks.get(0).setY(tank1[1]);
            }
            if(boxt2.intersects(sprites)){
                tanks.get(1).setX(tank2[0]);
                tanks.get(1).setY(tank2[1]);
            }
        }
        //this will check the collison with breakwall 
        for(int i = 0; i < w2.size(); i++){
            Rectangle walls = new Rectangle(w2.get(i).getX(), w2.get(i).getY(),w1.get(i).getImg().getWidth()/1 ,w1.get(i).getImg().getHeight()/1);
                   
            if(boxt1.intersects(walls) && game.walls2.get(i).visible){
                tanks.get(0).setX(tank1[0]);
                tanks.get(0).setY(tank1[1]);
            }
            if(boxt2.intersects(walls) && game.walls2.get(i).visible){
                tanks.get(1).setX(tank2[0]);
                tanks.get(1).setY(tank2[1]);
            }
        }
        tanks.get(0).checkCollision(tanks.get(1));
        if(game.running) {
            game.scoreP1++;
            game.stoprunning();
        }
        tanks.get(1).checkCollision(tanks.get(0));
        if(game.running) {
            game.scoreP2++;
            game.stoprunning();
        }  
    }
}