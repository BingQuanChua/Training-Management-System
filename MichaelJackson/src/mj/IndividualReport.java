package mj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IndividualReport extends JPanel{
	/**
	 * Report of one training
	 */
	JPanel list = new JPanel();
	private boolean extend = false;
	
	public IndividualReport() {
	setLayout(new BorderLayout(0, 0));
	setSize(1000,1080);
	JPanel panel = new JPanel();
	panel.setPreferredSize(new Dimension(1000, 1080));
    panel.setBackground( new Color(255, 255, 224));
    panel.setLayout(null);
    
	JTextArea txtDesc = new JTextArea();
	txtDesc.setText("Description");
	txtDesc.setEditable(false);
	txtDesc.setLineWrap(true);
	txtDesc.setBackground(new Color(230, 230, 250));
	txtDesc.setBounds(146, 87, 761, 100);
	JScrollPane scrollPane_2 = new JScrollPane();
	scrollPane_2.setViewportView(txtDesc);
	scrollPane_2.setBounds(146, 87, 761, 100);
	panel.add(scrollPane_2);
	
	
	JLabel lblFeedback = new JLabel();
	lblFeedback.setFont(new Font("Dialog", Font.PLAIN, 20));
	lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
	lblFeedback.setBackground(new Color(147, 112, 219));
	lblFeedback.setText("Feedback");
	lblFeedback.setOpaque(true);
	lblFeedback.setBounds(107, 187, 800, 70);
	
	panel.add(lblFeedback);
	add(panel);
	
	JTextArea txtFeedback = new JTextArea();

	txtFeedback.setBackground(new Color(230, 230, 250));
	txtFeedback.setBounds(146, 255, 761, 200);
	txtFeedback.setLineWrap(true);
	txtFeedback.setEditable(false);
	txtFeedback.setText("1. This training course is awesome!!!!!!!!"
			+ "\n2.Looking forward to the next training!!!"
			+ "\n3.Best training course ever!!!");
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setViewportView(txtFeedback);
	scrollPane_1.setBounds(146, 255, 761, 200);
	panel.add(scrollPane_1);
	
	JLabel lblProgress = new JLabel();
	lblProgress.setFont(new Font("Dialog", Font.PLAIN, 20));
	lblProgress.setHorizontalAlignment(SwingConstants.CENTER);
	lblProgress.setText("Progress");
	lblProgress.setOpaque(true);
	lblProgress.setBackground(new Color(147, 112, 219));
	lblProgress.setBounds(107, 454, 800, 70);
	panel.add(lblProgress);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(146, 524, 761, 335);
	panel.add(scrollPane);
	
	list = new JPanel();
	list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
	scrollPane.setViewportView(list);
	
	JLabel lblTrainingCourseDescription = new JLabel();
	lblTrainingCourseDescription.setText("Training Course Description\r\n");
	lblTrainingCourseDescription.setOpaque(true);
	lblTrainingCourseDescription.setHorizontalAlignment(SwingConstants.CENTER);
	lblTrainingCourseDescription.setFont(new Font("Dialog", Font.PLAIN, 20));
	lblTrainingCourseDescription.setBackground(new Color(147, 112, 219));
	lblTrainingCourseDescription.setBounds(107, 16, 800, 70);
	panel.add(lblTrainingCourseDescription);
	
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
