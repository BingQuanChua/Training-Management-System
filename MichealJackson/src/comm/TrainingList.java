package comm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class TrainingList extends JPanel {

	/**
	 * This panel holds a list of training objects
	 */

	private JPanel list;
	private ArrayList<Training> trainingList;
	Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);
		
	public TrainingList() {
		// setPreferredSize(new Dimension(850, 400));	
		
		/* Was trying to create a label here
		 * 
		 * setLayout(new BorderLayout()); JPanel titlePanel = new JPanel();
		 * add(titlePanel, BorderLayout.NORTH); JLabel titleLabel = new
		 * JLabel("List of Training Requests"); titleLabel.setFont(heading1);
		 * titlePanel.add(titleLabel);
		 */
		JLabel titleLabel = new JLabel();
		titleLabel.setBackground(new java.awt.Color(155, 156, 237));
		titleLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		titleLabel.setText("    Manage Training Course");
		titleLabel.setOpaque(true);
		
		
		trainingList = new ArrayList<>();
		list = new JPanel();
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
		
		
		addTraining(new Training("Python Advance Training Course"));
		addTraining(new Training("Software Engineering with Java"));
		addTraining(new Training("Introduction to OOPDS"));
		
		setBackground(new Color(255, 255, 200));
		add(list);
	}
	
	private void addTraining(Training t) {
		trainingList.add(t);
		list.add(t);
		list.revalidate();
	}
}