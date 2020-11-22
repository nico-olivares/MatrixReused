package matrixRain;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Rain extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Drop[] drops;
	private char target;
	public static int targetCounter = 0;

	
	//Creates an array of drops(strings). 
    Rain(char tar) {
    	this.setBackground(Color.black);
    	target = tar;
        drops = new Drop[Config.SCREEN_WIDTH / Config.FONT_SIZE];	//Creates as
        									//many drops as space in the row.
        
        
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Drop(i * Config.FONT_SIZE, target);	//Fills the array with
            							//drops from the Drop class. The given
            							//x is the i times the font size
            
            
        }
    }

   
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        //g.fillRect(0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        //g.setColor(Color.BLACK);
        Font font = new Font("Monospaced", Font.PLAIN, Config.FONT_SIZE);
        g2.setFont(font);

        for (int i = 0; i < drops.length; i++) {
            if (drops[i].isOffScreen()) {	//starts a new string when the current
            								//one goes off screen
                drops[i] = new Drop(i * Config.FONT_SIZE, target);
            }
            drops[i].draw(g2);
            
            
        }

        try {
            Thread.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        repaint();
    }

}