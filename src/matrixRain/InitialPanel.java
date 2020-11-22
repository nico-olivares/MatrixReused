package matrixRain;

import java.awt.Color;

import javax.swing.JPanel;

public class InitialPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panel;
	
	
	InitialPanel() {
		panel = new JPanel();
		panel.setBackground(Color.black);
	}
	
	
	public JPanel replacePanel(JPanel newPanel) {
		panel = newPanel;
		return panel;
	}
	
	
	
	

}
