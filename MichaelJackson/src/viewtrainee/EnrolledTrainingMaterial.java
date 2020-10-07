package viewtrainee;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.JButtonID;

public class EnrolledTrainingMaterial extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField titleField;
	private JTextArea txtrDescription;
	private JButtonID doneButton;
	
	private String materialID;
	private String courseID;
	private boolean isDone = false;
	
	Font heading4 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public EnrolledTrainingMaterial(
			String courseID, String traineeID,
			String materialID, String materialTitle, String materialDesc ) {
		
		this.courseID = courseID;
		this.materialID = materialID;
		setPreferredSize(new Dimension(800, 115));
		setLayout(null);
		
		titleField = new JTextField();
		titleField.setFont(heading4);
		titleField.setText(materialTitle);
		titleField.setBounds(5, 5, 635, 30);
		add(titleField);
		titleField.setColumns(100);
		titleField.setEditable(false);
		
		txtrDescription = new JTextArea();
		txtrDescription.setFont(heading4);
		txtrDescription.setText(materialDesc);
		txtrDescription.setBounds(5, 35, 635, 75);
		JScrollPane scrollPane = new JScrollPane(txtrDescription);
		scrollPane.setSize(635, 75);
		scrollPane.setLocation(5, 35);
		add(scrollPane);
		txtrDescription.setEditable(false);
		txtrDescription.setLineWrap(true);
		
		doneButton = new JButtonID("Mark As Done", traineeID, materialID);
		doneButton.setFont(heading4);
		doneButton.setBounds(645, 30, 150, 55);
		add(doneButton);
		
		JButton background = new JButton();
		background.setEnabled(false);
		background.setBounds(0, 0, 800, 115);
		add(background);
	}
	
	public JButton getDoneButton() {
		return doneButton;
	}

	public boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public String getMaterialID() {
		return materialID;
	}

}
