
package Bricks;

/**
 *
 * @author patkhai
 */


import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj=new JFrame();
		Game game = new Game();
		obj.setBounds(150, 100, 800, 600);
		obj.setTitle("Bricks Game");		
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
		obj.add(game); 
                Sound.playLoop("/res/lost_woods.wav");
        obj.setVisible(true);
     
		
	}

}
