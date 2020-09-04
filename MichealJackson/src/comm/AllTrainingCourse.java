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

public class AllTrainingCourse extends JPanel {

	/**
	 * This panel holds a list of training objects
	 */

	private JPanel list;
	private ArrayList<ManageTrainingCourse> allTrainingCourse;
	Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);

	public AllTrainingCourse() {
	
		JLabel titleLabel = new JLabel();
		titleLabel.setBackground(new java.awt.Color(155, 156, 237));
		titleLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		titleLabel.setText("    Manage Training Course");
		titleLabel.setOpaque(true);

		allTrainingCourse = new ArrayList<>();
		list = new JPanel();
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));

		addTraining(new ManageTrainingCourse("Python Advance Training Course"));
		addTraining(new ManageTrainingCourse("Software Engineering with Java"));
		addTraining(new ManageTrainingCourse("Introduction to OOPDS"));

		setBackground(new Color(255, 255, 200));
		list.setSize(1920,1080);
		setSize(1920,1080);
		add(list);
	}

	private void addTraining(ManageTrainingCourse t) {
		allTrainingCourse.add(t);
		list.add(t);
	}
}