package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IndividualProgress extends JPanel {

	/**
	 * This panel holds a progress bar for an individual trainee in a single training
	 */
	private JButtonID nameButton;
	private JProgressBar progressBar;
	private String traineeName;
	private String traineeID;
	private int progress;
	private Font f2 = new Font(Font.DIALOG, Font.PLAIN, 18);
	
	public IndividualProgress(String traineeName, String traineeID, int progress) {
		
		this.traineeName = traineeName;
		this.traineeID = traineeID;
		this.progress = progress;
		
		setBackground(new Color(230, 230, 250));
		setPreferredSize(new Dimension(743, 70));
		setLayout(null);
		
		nameButton = new JButtonID(traineeName, traineeID);
		nameButton.setFont(f2);
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nameButton.setBorder(null);
		nameButton.setBackground(new Color(205,133,63));
		nameButton.setFocusPainted(false);
		nameButton.setBounds(0, 0, 230, 70);
		add(nameButton);
		
		progressBar = new JProgressBar(0, 100);
		progressBar.setBackground(new Color(230, 230, 250));
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setBounds(235, 10, 493, 50);
		progressBar.setValue(progress); // set progress 0-100
		progressBar.setStringPainted(true);
		add(progressBar);
	}
	
	public String getName() {
		return traineeName;
	}
	
	public void setName(String name) {
		this.traineeName = name;
		nameButton.setText(name);
	}
	
	public String getTraineeID() {
		return traineeID;
	}
	
	public void setTraineeID(String traineeID) {
		this.traineeID = traineeID;
		nameButton.setUserID(traineeID);
	}
	
	public int getProgress() {
		return progress;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
		progressBar.setValue(progress);
	}
	
	public JButton getNameButton() {
		return nameButton;
	}
	
	public void setIndividualProgress(String userName, String traineeID, int progress) {
		//individualProgress
		setName(userName);
		setTraineeID(traineeID);
		setProgress(progress);
	}

	
}
