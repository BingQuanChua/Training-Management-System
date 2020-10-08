package viewadmin;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;

public class ManageTraining extends JPanel {
	
	public AdminUI adminUI;
	/**
	 * Manage all training courses
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton trainingButton;
	private JButton deleteButton;
	private String courseID;
	
	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);

	public ManageTraining(String name, String courseID) {
		this.courseID = courseID;
		
		setPreferredSize(new Dimension(800, 70));
		setBackground(UIManager.getColor("Button.background"));
		
		trainingButton = new JButton(name);
		trainingButton.setBounds(0, 0, 736, 70);
		trainingButton.setPreferredSize(new Dimension(800, 70));
		trainingButton.setFont(new Font("SansSerif", Font.PLAIN, 20));

		deleteButton = new JButton("X");
		deleteButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		deleteButton.setBackground(new Color(205,133,63));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setBorder(null);
		deleteButton.setBounds(735, 0, 65, 70);
		add(deleteButton);
		
		setLayout(null);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.setFocusPainted(false);
		add(trainingButton);
		
	}
	
	public String getCourseID() {
		return courseID;
	}
	
	public JButton getTrainingButton() {
		return trainingButton;
	}
	
	public JButton getDeleteButton() {
		return deleteButton;
	}
}