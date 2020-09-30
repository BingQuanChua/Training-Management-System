package viewtrainee;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.SubMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnrolledTraining extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton enrolledTrainingButton;
	private EnrolledTrainingDetails trainingDetails;
	
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	
	public EnrolledTraining(String trainingName) {
		
		setPreferredSize(new Dimension(800, 70));
		setLayout(null);
		
		trainingDetails = new EnrolledTrainingDetails(trainingName);
		
		enrolledTrainingButton = new JButton(trainingName);
		enrolledTrainingButton.setFont(heading2);
		enrolledTrainingButton.setBackground(Color.LIGHT_GRAY);
		enrolledTrainingButton.setBounds(0, 0, 800, 70);
		add(enrolledTrainingButton);
	}
	
	public JButton getEnrolledTrainingButton() {
		return enrolledTrainingButton;
	}
	
	public EnrolledTrainingDetails getTrainingDetails() {
		return trainingDetails;
	}

}
