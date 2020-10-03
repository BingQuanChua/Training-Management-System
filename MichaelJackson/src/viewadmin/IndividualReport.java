package viewadmin;
import javax.swing.*;

import view.IndividualProgress;

import java.awt.*;
import java.awt.event.*;

public class IndividualReport extends JPanel{
	/**
	 * Report of one training
	 */
	private JPanel list = new JPanel();
	
	// need to pass something in...
	public IndividualReport(String trainingName) {
		setBackground( new Color(255, 255, 200));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 1080));
	    panel.setBackground( new Color(255, 255, 200));
	    panel.setLayout(null);
	    
	    JLabel trainingLabel = new JLabel(trainingName);
		trainingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trainingLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
		trainingLabel.setBounds(0, 0, 1000, 80);
		panel.add(trainingLabel);
		
		JLabel lblTrainingCourseDescription = new JLabel();
		lblTrainingCourseDescription.setForeground(Color.BLACK);
		lblTrainingCourseDescription.setText("Training Course Description\r\n");
		lblTrainingCourseDescription.setOpaque(true);
		lblTrainingCourseDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainingCourseDescription.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTrainingCourseDescription.setBackground(new Color(255, 222, 173));
		lblTrainingCourseDescription.setBounds(107, 85, 800, 70);
		panel.add(lblTrainingCourseDescription);
	    
		JTextArea txtDesc = new JTextArea();
		txtDesc.setText("Description");
		txtDesc.setEditable(false);
		txtDesc.setLineWrap(true);
		txtDesc.setBackground(Color.WHITE);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportView(txtDesc);
		scrollPane_2.setBounds(107, 155, 800, 100);
		panel.add(scrollPane_2);
		
		
		JLabel lblFeedback = new JLabel();
		lblFeedback.setForeground(Color.BLACK);
		lblFeedback.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setBackground(new Color(255, 222, 173));
		lblFeedback.setText("Feedback");
		lblFeedback.setOpaque(true);
		lblFeedback.setBounds(107, 310, 800, 70);
		panel.add(lblFeedback);
		add(panel);
		
		JTextArea txtFeedback = new JTextArea();
		txtFeedback.setBackground(Color.WHITE);
		txtFeedback.setLineWrap(true);
		txtFeedback.setEditable(false);
		txtFeedback.setText("1. This training course is awesome!!!!!!!!"
				+ "\n2.Looking forward to the next training!!!"
				+ "\n3.Best training course ever!!!");
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(txtFeedback);
		scrollPane_1.setBounds(107, 380, 800, 200);
		panel.add(scrollPane_1);
		
		JLabel lblProgress = new JLabel();
		lblProgress.setForeground(Color.BLACK);
		lblProgress.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgress.setText("Progress");
		lblProgress.setOpaque(true);
		lblProgress.setBackground(new Color(255, 222, 173));
		lblProgress.setBounds(107, 630, 800, 70);
		panel.add(lblProgress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 700, 800, 335);
		panel.add(scrollPane);
		
		list = new JPanel();
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
		scrollPane.setViewportView(list);
		
		addProgress(new IndividualProgress("Jim Helpert", 50));
		addProgress(new IndividualProgress("Michael Scott", 30));
		addProgress(new IndividualProgress("Dwight Schrute", 70));
		addProgress(new IndividualProgress("Pam Beesly", 60));
		addProgress(new IndividualProgress("Kevin Malone", 90));
		addProgress(new IndividualProgress("Creed Bratton", 20));
		addProgress(new IndividualProgress("Andy Bernard", 10));
		addProgress(new IndividualProgress("Toby Flenderson", 100));
		panel.add(scrollPane);

	}
	
	private void addProgress(IndividualProgress p) {
		list.add(p);
	}
}
