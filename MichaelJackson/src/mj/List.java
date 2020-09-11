package mj;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class List extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel list;
	private ArrayList<JPanel> listOfItems;
		
	public List() {		
		listOfItems = new ArrayList<>();
		list = new JPanel();
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
		
		setBackground(new Color(255, 255, 200));
		add(list);
	}
	
	public void addItem(JPanel item) {
		listOfItems.add(item);
		list.add(item);
		list.revalidate();
	}
}