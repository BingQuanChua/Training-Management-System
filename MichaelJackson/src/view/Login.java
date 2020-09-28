package view;

import mj.*;
import viewAdmin.AdminUI;
import viewTrainee.TraineeUI;
import viewTrainer.TrainerUI;

import java.sql.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Font;

public class Login extends JFrame {

	/**
	 * Create the panel.
	 */
	
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JPanel panel;
	private JPanel iconPanel;
	
	public Login() {
		super("MJ Training Management System");
		getContentPane().setBackground(new Color(233, 150, 122));
		getContentPane().setForeground(new Color(238, 130, 238));
		passwordField = new JPasswordField("passwordField");
		getContentPane().setLayout(null);
	
		panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setLocation(386, 263);
		panel.setSize(609, 337);
		panel.setBorder(new TitledBorder("Login"));
		getContentPane().add(panel);
		panel.setLayout(null);
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(205, 133, 63));
		loginButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		loginButton.setBounds(431, 245, 112, 45);
		loginButton.setFocusable(false);
		panel.add(loginButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(Color.GRAY);
		passwordField_1.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordField_1.setBounds(221, 165, 322, 34);
		panel.add(passwordField_1);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(Color.DARK_GRAY);
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		passwordLabel.setBounds(56, 160, 121, 32);
		panel.add(passwordLabel);
		

		userLabel = new JLabel("UserID:");
		userLabel.setForeground(Color.DARK_GRAY);
		userLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		userLabel.setBounds(56, 99, 121, 25);
		panel.add(userLabel);
		userIDField = new JTextField("");
		userIDField.setForeground(Color.GRAY);
		userIDField.setFont(new Font("Serif", Font.PLAIN, 20));
		userIDField.setBounds(221, 100, 322, 34);
		panel.add(userIDField);
		userIDField.setColumns(10);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SQLconnector(userIDField.getText(), passwordField.getPassword());
				dispose();
				
			
			}
		});
		
		iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		iconPanel.setLocation(386, 124);
		iconPanel.setSize(605, 130);
		iconPanel.setBackground(new Color(233, 150, 122));

		try {
			Image originalIcon = ImageIO.read(getClass().getResource("images/logo.PNG"));
			Image resizedIcon = originalIcon.getScaledInstance(500, 120, Image.SCALE_DEFAULT);
			ImageIcon icon = new ImageIcon(resizedIcon);
				iconPanel.add(new JLabel(icon));
			} catch(Exception ex) {
			System.out.println(ex);
		}	
		
		getContentPane().add(iconPanel);
	        
		setBackground(Color.WHITE);
		setSize(1400, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setResizable(true);
		setVisible(true);
		//getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
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

	/*
	public static void main(String[] args) {
		new Login();
	}/**/

}