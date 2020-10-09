package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
public class LoginView extends JPanel {
	
	/**
	 * Create the Login panel
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	public LoginView() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(600, 550));
		
		JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		iconPanel.setBounds(0, 0, 600, 200);
		iconPanel.setBackground(new Color(233, 150, 122));
		panel.add(iconPanel);
		
		try {
			File logo = new File("src/images/logo.PNG");
			Image originalIcon = ImageIO.read(logo);
			Image resizedIcon = originalIcon.getScaledInstance(600, 194, Image.SCALE_DEFAULT);
			ImageIcon icon = new ImageIcon(resizedIcon);
				iconPanel.add(new JLabel(icon));
			
			} catch(Exception ex) {
			System.out.println(ex);
		}
		
		JLabel userLabel = new JLabel("UserID:");
		userLabel.setForeground(Color.DARK_GRAY);
		userLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		userLabel.setBounds(50, 295, 150, 40);
		panel.add(userLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		passwordLabel.setBounds(50, 385, 150, 40);
		panel.add(passwordLabel);
		
		userIDField = new JTextField();
		userIDField.setForeground(Color.GRAY);
		userIDField.setFont(new Font("Serif", Font.PLAIN, 25));
		userIDField.setBounds(200, 295, 335, 40);
		userIDField.setEditable(true);  
		userIDField.setColumns(10);
		panel.add(userIDField);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Serif", Font.PLAIN, 25));
		passwordField.setBounds(200, 385, 335, 40);
		userIDField.setEditable(true);  
		userIDField.setColumns(20);
		panel.add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(415, 450, 120, 45);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		loginButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		loginButton.setFocusable(false);
		panel.add(loginButton);
		
		add(panel);
		
		JPanel boxPanel = new JPanel();
		boxPanel.setBackground(new Color(255, 218, 185));
		boxPanel.setLocation(0, 200); // 327, 263
		boxPanel.setSize(600, 350);
		boxPanel.setBorder(new TitledBorder("Login"));
		boxPanel.setLayout(null);
		panel.add(boxPanel);
		
	}
	
	public JTextField getUserIDField() {
		return userIDField;
	}
	
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}
	 
}
