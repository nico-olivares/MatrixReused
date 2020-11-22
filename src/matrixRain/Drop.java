package matrixRain;

import java.awt.*;
import java.util.Random;

public class Drop {

    private Random rng = new Random();
    private int velocity, length, x, y;
    private char target;
    private char[][] text;
 

    
    //Defines a vertical string with an x, y, velocity, and text
    Drop(int x, char tar) {
        this.x = x;			//x is passed
        target = tar;
        length = getRandomInteger(5, 30);
        text = createContent(length, target);	//createContent creates a char[][] with
        								//random letters
        velocity = getRandomInteger(1, 5);	//the timer speed is set, velocity is
        									//how far each vertical jump is
        this.y = (-1) * length * Config.FONT_SIZE;	//sets the y right above the
        										//visible screen
    }

    //Creates an array[][] of characters given the passed length
    protected char[][] createContent(int length, char tar) {
    	//System.out.println("The target letter is " + tar);
        char[][] result = new char[length][1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = getRandomCharacter();	//this method will give 
            										//a random char
            if (result[i][0] == tar) {
            	Rain.targetCounter++;
            	//System.out.println("The target counter is " + Rain.targetCounter);
            	
            }
        }
        if (Rain.targetCounter > Config.TOTAL_LETTERS + 19) {
        	Main.resetPanel();
        }
        return result;
    }

    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();
        for (int i = 0; i < length; i++) {
        	//Changes the letters within the string every now and then
        	if (Controls.isOriginal) {
        		if (getRandomInteger(0, length) == i)
        		text[i][0] = getRandomCharacter();
        	}
            if (i == length - 1)
                //g2.setColor(new Color(253, 104, 25));
            	g2.setColor(Color.white);
            else
                //g2.setColor(new Color(66, 198, 255));
            	g2.setColor(Color.green);
            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }
        y += velocity;
    }

    //generates a random lowercase char
    public char getRandomCharacter() {
    	if (Controls.isOriginal ) {
    		return (char) (rng.nextInt(100) + 900);
    	} else {
    		return (char) (rng.nextInt(26) + 'a');
    	}
    }

    //random int generator with a range
    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    //lets you know when the string leaves the screen
    public boolean isOffScreen() {
        return (y > Config.SCREEN_HEIGHT);
    }

    
}