package mj;

import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

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
		userIDField = new JTextField("");
		passwordField = new JPasswordField("passwordField");
		JButton loginButton = new JButton("loginButton");
		
		loginButton.setBounds(273, 164, 97, 25);
		getContentPane().add(loginButton);
		
//		userIDField = new JTextField();
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
		
		userLabel = new JLabel("UserID");
		userLabel.setBounds(15, 94, 75, 21);
		getContentPane().add(userLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(15, 128, 75, 21);
		getContentPane().add(passwordLabel);
		
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setSize(1920, 1080);       
		setResizable(true);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLconnector(userIDField.getText(), passwordField.getPassword());
				dispose();
				
			
			}
		});
		
	}
public  void SQLconnector(String username, char[] password) {
		
		
		String pass = new String(password);
		AdminUI adminUI = new AdminUI();
		TrainerUI trainerUI = new TrainerUI();
		TraineeUI traineeUI = new TraineeUI();
	
		
//		System.out.println(pass);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/training_management_system","root","");
		Statement state =connection.createStatement();
		String query = "select * from user_login_data where user_email = '"+username+"' and user_password = '"+pass+"'";
		ResultSet result = state.executeQuery(query);
		if(result.next())
		{
			//JOptionPane.showMessageDialog(null, "'"+result.getString("user_Full_name")+"' Logged In");
			if(result.getInt("user_role") == 1) {
				adminUI.setVisible(true);
			}
			if(result.getInt("user_role") == 2) {
				trainerUI.setVisible(true);
			}
			if(result.getInt("user_role") == 3) {
				traineeUI.setVisible(true);
			}
		

		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Options");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	public static void main(String[] args) {
		new Login();
	}

}
