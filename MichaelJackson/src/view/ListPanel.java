package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import viewadmin.ManageTraining;
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
			addDeleteUserListener((ManageUser) item);
		}
		if (item instanceof ManageTraining) {
			addDeleteTrainingListener((ManageTraining) item);
		}
		if (item instanceof TrainingMaterial) {
			addDeleteMaterialListener((TrainingMaterial) item);
		}
		if (item instanceof TrainingRequest) {
			addAcceptRejectTraineeListener((TrainingRequest) item);
		}
		if (item instanceof AvailableTraining) {
			addEnrollTrainingListener((AvailableTraining) item);
		}
	}

	// getting an item from the container
	public JPanel getItem(int i) {
		return listOfPanel.get(i);
	}	
	
	private void addDeleteUserListener(ManageUser p) {
		p.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to remove this user?", "Remove user", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfPanel.remove(p);
					container.removeAll();
					for (int i = 0; i < listOfPanel.size(); i++) {
						ManageUser temp = (ManageUser) listOfPanel.get(i);
						temp.getNumberLabel().setText((i+1)+".");
						container.add(temp);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
	}
	
	private void addDeleteTrainingListener(ManageTraining p) {
		p.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this training course?", "Delete Training Course", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfPanel.remove(p);
					container.removeAll();
					for (JPanel temp : listOfPanel) {
						container.add(temp);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
	}
	
	private void addDeleteMaterialListener(TrainingMaterial p) {
		p.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this material?", "Delete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfPanel.remove(p);
					container.removeAll();
					for (JPanel temp : listOfPanel) {
						container.add(temp);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
	}
	
	private void addAcceptRejectTraineeListener(TrainingRequest p) {
		p.getAcceptButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to accept this trainee?", "Accept Trainee", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfPanel.remove(p);
					container.removeAll();
					for (int i = 0; i < listOfPanel.size(); i++) {
						TrainingRequest temp = (TrainingRequest) listOfPanel.get(i);
						temp.getNumberLabel().setText((i+1)+".");
						container.add(temp);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
		p.getRejectButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to reject this trainee?", "Reject Trainee", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfPanel.remove(p);
					container.removeAll();
					for (int i = 0; i < listOfPanel.size(); i++) {
						TrainingRequest temp = (TrainingRequest) listOfPanel.get(i);
						temp.getNumberLabel().setText((i+1)+".");
						container.add(temp);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
	}
	
	private void addEnrollTrainingListener(AvailableTraining p) {
		p.getEnrollButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Confirm enrollment?", "Enroll Training Course", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					listOfPanel.remove(p);
					container.removeAll();
					for (JPanel temp : listOfPanel) {
						container.add(temp);
					}
					container.repaint();
					container.revalidate();
				}
			}
		});
	}
}
