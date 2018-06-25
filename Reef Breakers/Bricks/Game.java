package Bricks;

import java.util.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author patkhai and reo
 */

public class Game extends JPanel implements ActionListener, KeyListener
{
	private boolean play = true;
	private int score = 0;
	private int life = 5;
	private boolean revive = true;
	
	private Timer timer;
	private int delay = 8;
	
	// private MapGenerator map;
	private ImageFolder iF;

	// Objects
	private Ball ball;
	private Player player;
	// private Block block;
	private Map map;
    private String stage1 = "/res/stage1.txt";
    private String stage2 = "/res/Stage2.txt";
	
	public Game()
	{		
		iF = new ImageFolder();
		iF.init();
		// objects
		ball = new Ball(450, 340, 20, 20, true);
		player = new Player(310, 550, 100, 30);
		// block = new Block(30, 30, 50, 20, true, 1);
		map = new Map(stage1);     
		// map = new MapGenerator(4, 12);
		addKeyListener(player);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
                timer=new Timer(delay,this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{    		
		//backGround image
		g.drawImage(ImageFolder.backGround1, 0, 0, 800, 600, null);

		// drawing map
		map.draw(g);

		// the ball
		ball.draw(g);

		// the player
		player.draw(g);
		
		// the scores 		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString("SCORE : "+ score, 650,30);
		g.drawString("LIFE : "+ life, 650,60);
	
		// when you won the game
		if(map.getEnemyNum() <= 0)
		{
			 addKeyListener(this);
			 play = false;

             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 30));
             g.drawString("You Won", 260,300);
             
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 20));  
             if(map.getCurrentStage() == stage1)         
             	g.drawString("Press (SPACE) to go to next Stage or (ENTER) to Restart ", 230,350);  
             if(map.getCurrentStage() == stage2)         
             	g.drawString("Congratulation!!", 230,350); 
		}
		
		// when you lose the game
		if(life <= 0)
        {
        	addKeyListener(this);
			 play = false;
                 Sound.playClip("/res/Sound_lost.wav");
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 30));
             g.drawString("Game Over, Scores: "+ score, 190,300);
             
             g.setColor(Color.RED);
             g.setFont(new Font("serif",Font.BOLD, 20));           
             g.drawString("Press (Enter) to Restart", 230,350);        
        }
		g.dispose();
	}	
	
	public void actionPerformed(ActionEvent e) 
	{
		timer.start();
		if(play)
		{	
			//ball update
			ball.update();
			//when you drop the ball
			if(ball.getY()>600 && revive)
			{
				life--;
				revive = false;
				ball = new Ball(450, 340, 20, 20 , true);
			}
			revive = true;
			// ball collision with player
			ball.collisionWithPlayer((int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight());
			// ball collision with walls
			map.collisionWithBall(ball);

			// when ball fits power up block, the ball power increase
			if(ball.getDiviable()){
				ball.setDiviable(false);
				ball.setPower(ball.getPower()*2);
				ball.setAngleSpeed(ball.getAngleSpeed() + 10);
			}

			// check if blocks are visible
			map.checkVisible();	

			// counting score
			if(map.getBlockCheck()){
				score = 10*(map.getBlockNumInTheStage()-map.getBlockNum());
				map.setBlockCheck(false);
			}

			// healing block
			if(map.getLife()){
				life++;
				map.setLife(false);
			}
			
			repaint();		
		}
	}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    	// when you lose => reset and restart
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
	    {        
	    	System.out.println("Enter pressed");
	    	play = true;
	    	life = 10;
	    	score = 0;
	    	ball = new Ball(450, 340, 20, 20 , true);
	    	player = new Player(310, 550, 100, 30);
			map = new Map(stage1);
			addKeyListener(player);
			removeKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			timer.restart();
	    } 
	    // when you clear the first stage
	    if (e.getKeyCode() == KeyEvent.VK_SPACE)
	    {        
//	    	System.out.println("SPACE pressed");
	    	play = true;
	    	ball = new Ball(450, 340, 20, 20, true);
	    	player = new Player(310, 550, 100, 30);
	    	map = new Map(stage2);
	    	addKeyListener(player);
			removeKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			timer.restart();
	    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}