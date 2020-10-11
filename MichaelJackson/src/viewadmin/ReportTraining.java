package viewadmin;
import javax.swing.*;

import view.IndividualProgress;

import java.awt.*;

public class ReportTraining extends JPanel{
	/**
	 * Report of one training
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel list = new JPanel();
	private JTextArea txtFeedback;
	
	// need to pass something in...
	public ReportTraining(String courseID, String courseName, String courseDesc) {
		setBackground( new Color(255, 255, 200));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 1080));
	    panel.setBackground( new Color(255, 255, 200));
	    panel.setLayout(null);
	    
	    JLabel trainingLabel = new JLabel(courseName);
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
		txtDesc.setText(courseDesc);
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
		
		txtFeedback = new JTextArea();
		txtFeedback.setBackground(Color.WHITE);
		txtFeedback.setLineWrap(true);
		txtFeedback.setEditable(false);
		txtFeedback.setText("Feedback Link: " );
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
		
		panel.add(scrollPane);

	}
	
	// Feedback update
	public void setFeedbackLink(String feedback) {
		txtFeedback.setText("Feedback Link:\n" + feedback );
	}
	
	
	// Progress Update
	public void addProgress(String traineeID, String traineeName, int progress) {
		
		list.add(new IndividualProgress(traineeName, traineeID, progress));
	}
}
