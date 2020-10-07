package viewadmin;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.UserProfile;

public class ManageUser extends JPanel {
	/**
	 * Manage all users in the system
	 */
	private static final long serialVersionUID = 1L;
	private JLabel numberLabel;
	private JButton profileButton;
	private JButton deleteButton;
	private UserProfile userProfile;
	private String userID;
	
	Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	

	public ManageUser(String name,String userID) {
		this.userID = userID;
		userProfile = new UserProfile();
		setPreferredSize(new Dimension(1070, 60));
		setBackground(Color.WHITE);
		setLayout(null);
		
		numberLabel = new JLabel();
		numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberLabel.setFont(f1);
		numberLabel.setBounds(12, 6, 56, 50);
		add(numberLabel);
		
		deleteButton = new JButton("X");
		deleteButton.setFont(new Font("SansSerif", Font.PLAIN, 25));
		deleteButton.setBackground(new Color(205,133,63));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setBorder(null);
		deleteButton.setBounds(639, 2, 52, 56);
		add(deleteButton);
		
		profileButton = new JButton(name);
		profileButton.setForeground(Color.BLACK);
		profileButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		profileButton.setBorder(null);
		profileButton.setBackground(Color.WHITE);
		profileButton.setFocusPainted(false);
		profileButton.setBounds(75, 1, 450, 58);
		add(profileButton);
		
		JButton background = new JButton();
		background.setForeground(Color.BLACK);
		background.setEnabled(false);
		background.setBounds(0, 0, 800, 60);
		add(background);

		//////////// end of one single request ////////////

	}
	
	public JLabel getNumberLabel() {
		return numberLabel;
	}
	
	public JButton getProfileButton() {
		return profileButton;
	}
	
	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	public String getUserID() {
		return userID;
	}
}