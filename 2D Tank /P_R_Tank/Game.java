/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P_R_Tank;

import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author patkhai and reo
 */

public class Game extends JPanel implements Runnable{
    private Thread thread;
    private BufferedImage bg, view1, view2;
    private Background backg;
    protected int Game_width, Game_height, scoreP1 = 0, scoreP2 = 0, gameover;
    Boolean running = false;
    BufferedImage miniMap, end;
    Point mapsize;
    Graphics2D g2;
    protected ArrayList<Breakablewall> walls2;
    protected ArrayList<Tank> tanks;
    protected ArrayList<Sprites> sp; //only for unbreakable wall and power
    //class variables, creating statics
    private static final Game game = new Game();
    public static HashMap<String, BufferedImage> sprites;
    private static Map maplvl;
    //keyManager 
    private KeyManager keyManager;
    protected KeyControl key;
    //sound
    public static final Sound sound = new Sound();
    //font
    private Font score = new Font("SanSerif", Font.BOLD, 35);
    private Font winner = new Font("SanSerif", Font.BOLD, 45);
    //init all classes 
    private void initGame(){
        //for keylistener buttons
        setFocusable(true);
        //sprites images and loading them
        sprites = new HashMap<String, BufferedImage>();
        ImageLoader();
        tanks = new ArrayList<Tank>();
        sp = new ArrayList<Sprites>();
        //breakable wall
        walls2 = new ArrayList<>();
        //level for the map, assigning tiles and read the number with txt
        maplvl = new Map("/res/map.txt");
        maplvl.loadfiles();
        //map split and mini map
        mapsize = new Point(maplvl.Map_width * 32, maplvl.Map_height * 32);
        //background init
        backg = new Background(mapsize.x, mapsize.y);
        backg.init(sprites.get("Background"));  
        //keyListener
        keyManager = new KeyManager();
        key = new KeyControl();
        addKeyListener(key);
    }
    
    //getting all the image path 
    public void ImageLoader(){
        sprites.put("Background", loadImages("/res/Background.bmp"));    
        sprites.put("Wall1", loadImages("/res/wall1.gif"));
        sprites.put("wall2", loadImages("/res/Wall2.gif"));
        sprites.put("Tank1", loadImages("/res/TankImage.png"));
        sprites.put("Tank2", loadImages("/res/TankImage2.png"));
        sprites.put("power", loadImages("/res/Pickup.gif"));
        sprites.put("bullet", loadImages("/res/bullet.png"));
        sprites.put("explosion", loadImages("/res/explosion.png"));
    }

    //Images will load through using this
    public BufferedImage loadImages(String name){
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't read img file");
            System.exit(1);
        }
        return img;
    }
    
    //to know when key is pressed and released
    public class KeyControl extends KeyAdapter {
        
        public void keyPressed(KeyEvent e) {
            keyManager.pressed(e,tanks);
        }
        
        public void keyReleased(KeyEvent e) {
            keyManager.released(e, tanks);
        }

    }
    
    //adding breakable wall for AllayList
    public void addBrWall(BufferedImage img, int x, int y){
        walls2.add(new Breakablewall(img, x, y));
    }
    
    //adding Tank for AllayList
    public void addTanks1(BufferedImage img, int x, int y){
        tanks.add(new Tank(img, x, y, 0, 60));
    }
    public void addTanks2(BufferedImage img, int x, int y){
        tanks.add(new Tank(img, x, y, 30, 60));
    }

    //intitializing the Sprites class object and adding it to ArrayList
    //now the sprites object have a image, location and Key of the image
    public void addSprites(BufferedImage img, int x, int y, int sprite, int total, String type){
        sp.add(new Sprites(img, x, y,sprite,total,type));
    }
    
    /*rendering all the minimap sizes according to the windowsize and 
       and also drawing all the tanks, health, etc 
    */
    @Override
    public void paint(Graphics g){
        if(bg == null) {
            bg = (BufferedImage) createImage(mapsize.x, mapsize.y);
            g2 = bg.createGraphics();
              miniMap = bg; 
        }
        render();
        Dimension windowSize = getSize();
        int p1x = tanks.get(0).getX() - windowSize.width / 4 > 0 ? tanks.get(0).getX() - windowSize.width / 4 : 0;
        int p1y = tanks.get(0).getY() - windowSize.height / 2 > 0 ? tanks.get(0).getY() - windowSize.height / 2 : 0;
          
        if (p1x > mapsize.x - windowSize.width / 2) {
            p1x = mapsize.x - windowSize.width / 2;
        }
        if (p1y > mapsize.y - windowSize.height) {
            p1y = mapsize.y - windowSize.height;
        }
        
        int p2x = tanks.get(1).getX() - windowSize.width / 4 > 0 ? tanks.get(1).getX() - windowSize.width / 4 : 0;
        int p2y = tanks.get(1).getY() - windowSize.height / 2 > 0 ? tanks.get(1).getY() - windowSize.height / 2 : 0;

        if (p2x > mapsize.x - windowSize.width / 2) {
            p2x = mapsize.x - windowSize.width / 2;
        }
        if (p2y > mapsize.y - windowSize.height) {
            p2y = mapsize.y - windowSize.height;
        }
        
        // draw split screen views offscreen & get some help from PROFESSOR
        view1 = bg.getSubimage(p1x, p1y, windowSize.width / 2, windowSize.height);
        view2 = bg.getSubimage(p2x, p2y, windowSize.width / 2, windowSize.height);
        // draw eventual onscreen image offscreen
        g.drawImage(view1, 0, 0, this);
        g.drawImage(view2, windowSize.width / 2, 0, this);
        g.drawRect(windowSize.width / 2 - 1, 0, 1, windowSize.height);
        g.drawImage(miniMap, windowSize.width / 2 - 104 ,378, 200, 200, this);
        //for the live menu for score and health
        if(scoreP1 == 2){
            g.setColor(Color.orange);
            g.setFont(winner);
            game.stoprunning();
            g.drawString("Player 1 WIN" + gameover, p1x + 30 , p1y - 70);
        }else if (scoreP2 == 2){
            g.setColor(Color.red);
            g.setFont(winner);
            game.stoprunning();
            g.drawString("Player 2 WIN" + gameover, p2x + 200 , p2y - 90);
        }
        g.setFont(score);
        g.setColor(Color.WHITE); 
        g.drawString("Life: " + tanks.get(0).life,32, getHeight() - 60);
        g.drawString("Life: " + tanks.get(1).life, getWidth() - 150, getHeight() - 60);
        g.drawString("Score: " + scoreP1, 32, getHeight() - 120);
        g.drawString("Score: " + scoreP2, getWidth() - 150, getHeight() - 120);
        g.dispose();
         
    }   
    //drawing every image
    private void render(){
        //drawing background
        backg.render(g2);
        keyManager.process(tanks, sp, walls2);
        ArrayList<Bullet> b;
        //drawing wall1
        for(int i=0; i<sp.size();i++) {
            sp.get(i).render(g2, this);
        }
        //drawing wall2
        for(int i=0; i<walls2.size(); i++){
            walls2.get(i).render(g2, this);
        }
        //drawing tank and shoowing the bullet out of the tank
         for(int i = 0; i < tanks.size(); i++){
//        System.out.println(tanks.get(0));
           b = tanks.get(i).getBullets();
            for (Bullet bu : b) {
                if(bu.visible) {
                    bu.draw(g2, this);
                    bu.update();
                }
            }
            if(tanks.get(i).show)
            tanks.get(i).render(g2, this);
         }
         //drawing explosion
         for(int i = 0; i < tanks.size(); i++){
            for (int j = 0; j < tanks.get(i).explosions.size();j++){
                Explosion exp = tanks.get(i).explosions.get(j);
                if(!exp.finish()) {
                    exp.renderExplosion();
                } else {
                    tanks.get(i).explosions.remove(exp);
                }
            }
        }
    }
    
    
    @Override
    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            repaint();
            try {
                thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }

        }
    }
    
    //used in the map
    public HashMap<String, BufferedImage> loadImages() {
        return sprites;
    }
     
    public static Game getInstance() {
        return game;
    }
    public void setDimensions(int width, int height) {
        this.Game_width = width;
        this.Game_height = height;
    }
    
     public void start() {
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }
    
   //to stop the thread safely and properly
    public void stoprunning(){
        running = false;
        removeKeyListener(key);
        game.initGame();
    }
    
    public static void main(String argv[]) {
        final Game game = Game.getInstance();
        JFrame j = new JFrame("Tank Wars");
        j.addWindowListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                game.requestFocusInWindow();
            }
        });
        j.getContentPane().add("Center", game);
        j.pack();
        j.setSize(new Dimension(800, 600));
        j.setLocationRelativeTo(null); // game opens in the middle of the screen
        game.setDimensions(800, 600);
        game.initGame();
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.sound.playLoop("/res/lost_woods.wav");
        game.start();
    }
        
    }
    

