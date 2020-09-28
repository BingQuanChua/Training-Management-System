package ViewTrainee;

import javax.swing.JButton;
import javax.swing.JPanel;

import View.SubMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnrolledTraining extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JButton enrolledTrainingButton;
	private EnrolledTrainingDetails trainingDetails;
	private SubMenu training;
	
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	
	public EnrolledTraining(String trainingName) {
		
		setPreferredSize(new Dimension(800, 70));
		setLayout(null);
		
		trainingDetails = new EnrolledTrainingDetails(trainingName);
		training = new SubMenu(trainingName, trainingDetails);
		
		enrolledTrainingButton = new JButton(trainingName);
		enrolledTrainingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
			}
		});
		enrolledTrainingButton.setFont(heading2);
		enrolledTrainingButton.setBackground(Color.LIGHT_GRAY);
		enrolledTrainingButton.setBounds(0, 0, 800, 70);
		add(enrolledTrainingButton);
	}

}
