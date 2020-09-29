package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import viewadmin.ManageUser;
import viewtrainee.AvailableTraining;
import viewtrainer.TrainingMaterial;
import viewtrainer.TrainingRequest;

public class ListPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	private ArrayList<JPanel> listOfItems;
		
	public ListPanel() {		
		listOfItems = new ArrayList<>();
		container = new JPanel();
		container.setLayout(new javax.swing.BoxLayout(container, javax.swing.BoxLayout.Y_AXIS));
		
		setBackground(new Color(255, 255, 200));
		add(container);
	}
	
	// adding a new JPanel to the container
	public void addItem(JPanel item) {
		listOfItems.add(item);
		container.add(item);
		
		if (item instanceof ManageUser) {
			
		}
		if (item instanceof TrainingMaterial) {
			// item.getDeleteButton().addActioncontainerener(...)
		}
		if (item instanceof TrainingRequest) {
			
		}
		if (item instanceof AvailableTraining) {
			
		}
	}
	
	// for clearing the JPanel only, listOfItems is untouched
	public void clearAll() {
		removeAll();
		repaint();
		revalidate();
	}
	
	// getting an item from the container
	public JPanel getItem(int i) {
		return listOfItems.get(i);
	}
	
	public JPanel getContainer() {
		return container;
	}
	
}