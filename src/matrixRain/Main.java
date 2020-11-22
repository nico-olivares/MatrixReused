package matrixRain;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main {

	private static JFrame frame;
	public static JPanel rainPanel = new JPanel();
	private static Rain newRain;
	
    public static void main(String[] args) {
    	@SuppressWarnings("unused")
        Main main = new Main();
    }
    
    Main() {
    	setUp();
    }
    
    private void setUp() {
    	frame = new JFrame("Matrix Rain " + Config.TOTAL_LETTERS);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT+30);
        frame.setResizable(false);
        frame.setBackground(Color.black);
        frame.setLayout(new BorderLayout(1,1));
        
        
        //frame.add(new Rain(), BorderLayout.CENTER);
        rainPanel.setBackground(Color.black);
        frame.add(rainPanel, BorderLayout.CENTER);
        
        Controls cont = new Controls();
        frame.add(cont.getPanel(), BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    
    public static void updatePanel(char tar) {
    	newRain = new Rain(tar);
    	frame.remove(rainPanel);
    	frame.add(newRain, BorderLayout.CENTER);
    	frame.setVisible(true);
    }
    
    public static void resetPanel() {
    	frame.remove(newRain);
    	frame.setVisible(false);
    	rainPanel.setBackground(Color.black);
    	frame.add(rainPanel, BorderLayout.CENTER);
    	
    	frame.setVisible(true);
    	//System.out.println("The component in the 0 position is " + 
    	//frame.getComponent(1));
    
    }

}