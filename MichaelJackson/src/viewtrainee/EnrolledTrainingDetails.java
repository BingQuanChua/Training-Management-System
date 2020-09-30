package viewtrainee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import view.IndividualProgress;
import view.ListPanel;

public class EnrolledTrainingDetails extends JPanel {

	/**
	 * This panel holds the details of one single training course
	 */
	private static final long serialVersionUID = 1L;

	private ListPanel trainingMaterialList;
	private IndividualProgress individualProgress;
	private JButton trainerProfileButton;
	private JButton feedbackButton;
	
	private int numberOfCompletedMaterial = 0;
	private String feedbackLink = "";
	
	Font heading1 = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	Font heading3 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	Font heading4 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public EnrolledTrainingDetails(String trainingName) {
		setBackground(new Color(255, 255, 200));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 200));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 0};
		gridBagLayout.rowHeights = new int[]{1, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		
		// creating an upper panel which does not resize
		////// start of upperPanel creation //////
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setBackground(new Color(255, 255, 200));
		upperPanel.setPreferredSize(new Dimension(1000, 500));
		
		JLabel trainingLabel = new JLabel(trainingName);
		trainingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trainingLabel.setFont(heading1);
		trainingLabel.setBounds(0, 0, 1000, 80);
		upperPanel.add(trainingLabel);
		
		JLabel label1 = new JLabel("Training Course Details");
		label1.setFont(heading2);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(100, 85, 800, 50);
		upperPanel.add(label1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(heading3);
		textArea.setBounds(100, 135, 800, 125);
		textArea.setText("Description for " + trainingName + ".");
		textArea.setEditable(false);
		upperPanel.add(textArea);
		
		individualProgress = new IndividualProgress("Trainee", 0);
		individualProgress.setBounds(115, 270, 770, 70);
		upperPanel.add(individualProgress);
		
		trainerProfileButton = new JButton("Trainer");
		trainerProfileButton.setFont(heading3);
		trainerProfileButton.setBounds(115, 350, 380, 50);
		upperPanel.add(trainerProfileButton);
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setFont(heading3);
		feedbackButton.setBounds(505, 350, 380, 50);
		feedbackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Please use this link to do the feedback: \n" + feedbackLink);				
			}
		});
		upperPanel.add(feedbackButton);
		feedbackButton.setVisible(false);
		
		JLabel label2 = new JLabel("Training Course Materials");
		label2.setFont(heading2);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(100, 450, 800, 50);
		upperPanel.add(label2);
		////// end of upperPanel creation //////
		
		// creating a list of assigned materials
		////// dummy list creation //////
		trainingMaterialList = new ListPanel();
		trainingMaterialList.setBackground(new Color(255, 255, 200));
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		trainingMaterialList.addItem(new EnrolledTrainingMaterial());
		////// end of list creation //////
		
		// adding both panels into this panel
		GridBagConstraints gbc_upperPanel = new GridBagConstraints();
		gbc_upperPanel.anchor = GridBagConstraints.CENTER;
		gbc_upperPanel.fill = GridBagConstraints.NORTH;
		gbc_upperPanel.gridx = 0;
		gbc_upperPanel.gridy = 0;
		panel.add(upperPanel, gbc_upperPanel);
		GridBagConstraints gbc_trainingMaterialList = new GridBagConstraints();
		gbc_trainingMaterialList.anchor = GridBagConstraints.CENTER;
		gbc_trainingMaterialList.fill = GridBagConstraints.NORTH;
		gbc_trainingMaterialList.gridx = 0;
		gbc_trainingMaterialList.gridy = 1;
		panel.add(trainingMaterialList, gbc_trainingMaterialList);
		
		add(panel);
	}
	
	public ListPanel getTrainingMaterialList() {
		return trainingMaterialList;
	}
	
	public IndividualProgress getIndividualProgress() {
		return individualProgress;
	}
	
	public JButton getTrainerProfileButton() {
		return trainerProfileButton;
	}
	
	public JButton getFeedbackButton() {
		return feedbackButton;
	}
	
	public String getFeedbackLink() {
		return feedbackLink;
	}
	
	public void setFeedbackLink(String feedbackLink) {
		this.feedbackLink = feedbackLink;
	}
	
	public int getNumberOfCompletedMaterial() {
		return numberOfCompletedMaterial;
	}
	
	public void setNumberOfCompletedMaterial(int numberOfCompletedMaterial) {
		this.numberOfCompletedMaterial = numberOfCompletedMaterial;
	}
	
	// this attribute increases
	public void increaseNumberOfCompletedMaterial() {
		numberOfCompletedMaterial++;
	}
}
