package login;

import model.JDBCinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mj.UserLogin;

public class Login extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private String userID;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private LoginView view;
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
			
		view = new LoginView();
		view.getLoginButton().addActionListener(loginListener); 
		view.setBackground(new Color(233, 150, 122));
		view.setForeground(new Color(238, 130, 238));
		
		JPanel container = new JPanel(new GridBagLayout());
		container.setBackground(new Color(233, 150, 122));
		container.setForeground(new Color(238, 130, 238));
		container.add(view);

	    setContentPane(container);
		setBackground(Color.WHITE);
		setSize(1200, 800);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	ActionListener loginListener = new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				userID = view.getUserIDField().getText(); 
				System.out.println(userID);
				SQLconnector(userID, view.getPasswordField().getPassword());
			}
			
	};

	
	private void SQLconnector(String username, char[] password) {
		
			//changing the password from char array to String
			String pass = new String(password);
		
		try {
		
			String query = "SELECT * FROM USER WHERE USER_ID = '"+username+"' AND USER_PASS = '"+pass+"'";
			rs = st.executeQuery(query);
			
			//result.next == true .
			
			if(rs.next())
			{
								
				if(rs.getString("USER_TYPE").equals("admin")) {
				
					choice = 1;
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
				new UserLogin(choice, userID);
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid user");
			}
		} catch(Exception e) {
			System.out.println(e);
		}	
	}
}
