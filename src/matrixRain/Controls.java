package matrixRain;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Controls extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panel;
	private JButton original, go, stop;
	private JComboBox<String> letterBox, quantityBox;
	public static boolean isOriginal = false;
	private final String[] letters = new String[] {"a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z"};
	private final String[] quantity = new String[] {"25", "50", "75", "100"};
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unused")
		Controls cont = new Controls();
		
	}

	
	public JPanel getPanel() {
		panel = new JPanel();
		quantityBox = new JComboBox<String>(quantity);
		quantityBox.setSelectedIndex(3);
		quantityBox.addActionListener(this);
		panel.add(quantityBox);
		letterBox = new JComboBox<String>(letters);
		letterBox.addActionListener(this);
		panel.add(letterBox);
		original = new JButton("Original");
		original.addActionListener(this);
		panel.add(original);
		go = new JButton("Go");
		go.addActionListener(this);
		panel.add(go);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		panel.add(stop);
		panel.setBackground(Color.gray);
		return panel;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("The button was pushed");
		
		if(e.getSource() == quantityBox) {
			Config.TOTAL_LETTERS = (quantityBox.getSelectedIndex() + 1) * 25;
			//System.out.println("The quantity is " + Config.TOTAL_LETTERS);
		}
		
		if (e.getSource() == original) {
			isOriginal = true;
			Main.updatePanel('0');
		}
		
		if (e.getSource() == go) {
			isOriginal = false;
			Main.updatePanel(letterBox.getSelectedItem().toString().charAt(0));
		}
		
		if (e.getSource() == stop) {
			Main.resetPanel();
			
		}
	}
	
	
	
	
}
