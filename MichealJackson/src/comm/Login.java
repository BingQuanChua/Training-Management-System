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

public class Login extends JFrame {

	/**
	 * Create the panel.
	 */
	
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JLabel userLabel;
	private JLabel passwordLabel;
	
	public Login() {
		super("MJ Training Management System");
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBounds(273, 164, 97, 25);
		getContentPane().add(loginButton);
		
		userIDField = new JTextField();
		userIDField.setBounds(102, 92, 268, 25);
		getContentPane().add(userIDField);
		userIDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 126, 268, 25);
		getContentPane().add(passwordField);
		
		JLabel titleLabel = new JLabel("MJ Training Management System");
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setBounds(80, 13, 211, 57);
		getContentPane().add(titleLabel);
		
		userLabel = new JLabel("EmployeeID\r\n");
		userLabel.setBounds(15, 94, 75, 21);
		getContentPane().add(userLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(15, 128, 75, 21);
		getContentPane().add(passwordLabel);
		
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1920, 1080);
		setResizable(true);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
