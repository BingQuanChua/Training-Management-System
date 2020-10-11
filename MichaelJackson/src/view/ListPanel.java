package view;

import java.awt.Color;

import javax.swing.JPanel;

import java.util.ArrayList;

import viewadmin.ManageUser;

public class ListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	private ArrayList<JPanel> listOfPanel;
		
	public ListPanel() {		
		listOfPanel = new ArrayList<>();
		container = new JPanel();
		container.setLayout(new javax.swing.BoxLayout(container, javax.swing.BoxLayout.Y_AXIS));
		
		setBackground(new Color(255, 255, 200));
		add(container);
	}
	
	// adding a new JPanel to the container
	public void addItem(JPanel item) {
		listOfPanel.add(item);
		container.add(item);
		
		if (item instanceof ManageUser) {
			((ManageUser) item).getNumberLabel().setText(listOfPanel.size()+".");
		}
		
		container.repaint();
		container.revalidate();
	}

	// getting an item from the container
	public JPanel getItem(int i) {
		return listOfPanel.get(i);
	}	
	
	public JPanel getContainerPanel() {
		return container;
	}
	
	public ArrayList<JPanel> getListOfPanel() {
		return listOfPanel;
	}
}
