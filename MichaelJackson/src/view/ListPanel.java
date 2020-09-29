package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JOptionPane;
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
			addNewTrainingMaterial(item);
		}
		if (item instanceof TrainingRequest) {
			// accept and reject
		}
		if (item instanceof AvailableTraining) {
			// enroll
		}
	}

	// getting an item from the container
	public JPanel getItem(int i) {
		return listOfItems.get(i);
	}	
	
	private void addNewTrainingMaterial(JPanel p) {
		((TrainingMaterial) p).getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this material?", "Delete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfItems.remove(p);
					container.removeAll();
					for (JPanel existingItem : listOfItems) {
						container.add(existingItem);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
	}
	
	private void acceptRejectTrainer(JPanel p) {
		
	}
}
