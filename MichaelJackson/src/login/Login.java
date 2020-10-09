package login;

import model.JDBCinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mj.UserLogin;

public class Login extends JFrame {

	
	/**
	 * Create the panel.
	 */
	
	private JTextField userIDField;
	private  JPasswordField passwordField;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JPanel panel;
	private JPanel iconPanel;
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private String userID;
	private  JButton loginButton;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private UserLogin userLogin;
	public static int choice = 0;
	
	public Login() {
		
		super("MJ Training Management System");
		
		try {
			con = DriverManager.getConnection(url, serverName, serverPassword);
			st = con.createStatement();
			System.out.println("USER LOGIN: Connected to Database\n");
		} catch (SQLException e) {
			System.out.println("USER LOGIN: Fail to Connect Database\n");
		}
		
		getContentPane().setBackground(new Color(233, 150, 122));
		getContentPane().setForeground(new Color(238, 130, 238));
		
		passwordField = new JPasswordField("passwordField");
		getContentPane().setLayout(null);
	
		panel = new JPanel();
		panel.setBackground(new Color(255, 218, 185));
		panel.setLocation(327, 263);
		panel.setSize(609, 337);
		panel.setBorder(new TitledBorder("Login"));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		loginButton = new JButton("Login");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.black);
		loginButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		loginButton.setBounds(431, 245, 112, 45);
		loginButton.setFocusable(false);
		panel.add(loginButton);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Serif", Font.PLAIN, 20));
		passwordField.setBounds(221, 165, 322, 34);
		panel.add(passwordField);
		
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
		
		userIDField = new JTextField();
		userIDField.setForeground(Color.GRAY);
		userIDField.setFont(new Font("Serif", Font.PLAIN, 20));
		userIDField.setBounds(221, 100, 322, 34);
		userIDField.setEditable(true);  
		userIDField.setColumns(10);
		panel.add(userIDField);

		loginButton.addActionListener(loginListener); 
		
		iconPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		iconPanel.setLocation(327, 135);
		iconPanel.setSize(609, 130);
		iconPanel.setBackground(new Color(233, 150, 122));
		
		
		try {
			File logo = new File("src/images/logo.PNG");
			Image originalIcon = ImageIO.read(logo);
			Image resizedIcon = originalIcon.getScaledInstance(500, 120, Image.SCALE_DEFAULT);
			ImageIcon icon = new ImageIcon(resizedIcon);
				iconPanel.add(new JLabel(icon));
			
			} catch(Exception ex) {
			System.out.println(ex);
		}
		
		getContentPane().add(iconPanel);
	        
		setBackground(Color.WHITE);
		setSize(1200, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	ActionListener loginListener = new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				userID = userIDField.getText();
				System.out.println(userID);
				SQLconnector(userID, passwordField.getPassword());

			}
	};

	
	private void SQLconnector(String username, char[] password) {
		
			//changing the password from char array to String
			String pass = new String(password);
		
		try {
		
			String query = "select * from user where USER_ID = '"+username+"' and USER_PASS = '"+pass+"'";
			rs = st.executeQuery(query);
			
			//result.next == true .
			
			if(rs.next())
			{
								
				if(rs.getString("USER_TYPE").equals("admin")) {
				
					choice = 1;
					System.out.println(choice);
					dispose();
				}
				else if(rs.getString("USER_TYPE").equals( "trainer")) {
					
					choice = 2;
					dispose();
				}
				else if(rs.getString("USER_TYPE").equals( "trainee")) {
					
					choice = 3;
					dispose();
				}
				userLogin = new UserLogin(choice, userID);
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid User");
			}
		} catch(Exception e) {
			System.out.println(e);
		}	
	}
}
