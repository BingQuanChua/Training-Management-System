package comm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JLabel userLabel;
	private JLabel passwordLabel;
	
	public Login() {

		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBounds(273, 164, 97, 25);
		add(loginButton);
		
		userIDField = new JTextField();
		userIDField.setBounds(102, 92, 268, 25);
		add(userIDField);
		userIDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 126, 268, 25);
		add(passwordField);
		
		JLabel titleLabel = new JLabel("MJ Training Management System");
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setBounds(80, 13, 211, 57);
		add(titleLabel);
		
		userLabel = new JLabel("EmployeeID\r\n");
		userLabel.setBounds(15, 94, 75, 21);
		add(userLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(15, 128, 75, 21);
		add(passwordLabel);
		
	}

}
