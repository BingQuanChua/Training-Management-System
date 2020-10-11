package viewtrainee;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.JButtonID;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class EnrolledTraining extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButtonID enrolledTrainingButton;
	private EnrolledTrainingDetails trainingDetails;
	private String courseID;
	private Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	
	public EnrolledTraining(
			String courseID, String courseName, String courseDesc,
			String trainerID, String trainerName, 
			String traineeID, String traineeName) {
		
		this.courseID = courseID;
		
		setPreferredSize(new Dimension(800, 70));
		setLayout(null);
		
		enrolledTrainingButton = new JButtonID(courseName, courseID);
		enrolledTrainingButton.setFont(heading2);
		enrolledTrainingButton.setBackground(Color.LIGHT_GRAY);
		enrolledTrainingButton.setBounds(0, 0, 800, 70);
		add(enrolledTrainingButton);
		
		trainingDetails = new EnrolledTrainingDetails(
				courseID, courseName, courseDesc, 
				trainerID, trainerName, 
				traineeID, traineeName);
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public JButton getEnrolledTrainingButton() {
		return enrolledTrainingButton;
	}
	
	public EnrolledTrainingDetails getTrainingDetails() {
		return trainingDetails;
	}

}
