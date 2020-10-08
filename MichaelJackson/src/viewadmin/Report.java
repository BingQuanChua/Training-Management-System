 package viewadmin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Report extends JPanel {

	/**
	 * Managing all training report 
	 */
	private static final long serialVersionUID = 1L;
	private JButton trainingButton;
	private ReportTraining reportTraining; // individual report for each report
	
	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);
	
	public Report(String courseID, String courseName, String courseDesc) {

		setPreferredSize(new Dimension(800, 70));
		setBackground(UIManager.getColor("Button.background"));
		
		trainingButton = new JButton(courseName);
		trainingButton.setForeground(Color.BLACK);
		trainingButton.setBounds(0, 0, 800, 70);
		trainingButton.setPreferredSize(new Dimension(800, 70));
		trainingButton.setFont(new Font("SansSerif", Font.PLAIN, 20));

		setLayout(null);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.setFocusPainted(false);
		add(trainingButton);
				
		reportTraining = new ReportTraining(courseID, courseName, courseDesc);
	}
	
	public JButton getTrainingButton() {
		return trainingButton;
	}
	
	public ReportTraining getReportTraining() {
		
		System.out.println("\n\ngetReportTraining\n\n");
		
		return reportTraining;
	}
	
}