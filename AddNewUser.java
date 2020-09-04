import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.sql.*;

public class AddNewUser extends JFrame {
    
    AddNewUser() {
    	
        super("MJ Traning Management System");
        
    	JPanel addNewUserPanel = new JPanel();
        JPanel frontPanel = new JPanel();
        JSeparator separator_1 = new JSeparator();
        JSeparator separator_2 = new JSeparator();
        JTextField userIDField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JCheckBox trainerBox = new JCheckBox("New Trainer", true);
        JCheckBox traineeBox = new JCheckBox("New Trainee", true);
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
        JLabel lblUserID = new JLabel("UserID");
        JLabel lblPassword = new JLabel("Password\r\n");
        JLabel title = new JLabel("Add New User");
        JPanel NavPanel = new JPanel();
        Font heading1 = new Font(Font.SERIF, Font.PLAIN, 40);
        Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);
       
        //Add New User panel //        
        addNewUserPanel.setBounds(310, 0, 1594, 1041);
        addNewUserPanel.setBackground( SystemColor.controlHighlight);
        getContentPane().setLayout(null);
        addNewUserPanel.setLayout(null);      
        getContentPane().add(addNewUserPanel);
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBounds(216, 127, 1071, 834);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        addNewUserPanel.add(frontPanel);
        
        //Separator//       
        separator_1.setBackground(Color.GRAY);
        separator_1.setForeground(Color.GRAY);
        separator_1.setBounds(230, 243, 600, 2);
        frontPanel.add(separator_1);
               
        separator_2.setForeground(Color.GRAY);
        separator_2.setBackground(Color.GRAY);
        separator_2.setBounds(230, 440, 600, 2);
        frontPanel.add(separator_2);
        
        //TextField// 
        userIDField.setText("Enter UserID");
        userIDField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(userIDField.getText().trim().equals("Enter UserID")) 
        	         userIDField.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(userIDField.getText().trim().equals("")) 
        	           userIDField.setText("Enter UserID");
        	}
        }); 
        userIDField.setBounds(230, 152, 600, 80);
        userIDField.setForeground(Color.GRAY);
        userIDField.setFont(f1);
        userIDField.setBorder(null);
             
        passwordField.setText("Enter Password\r\n");
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		  if(passwordField.getText().trim().equals("Enter Password"))
        		         passwordField.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(passwordField.getText().trim().equals(""))
                    passwordField.setText("Enter Password");
        	}
        });
        passwordField.setBounds(230, 352, 600, 80); 
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(f1);
        passwordField.setBorder(null);
         
        frontPanel.add(userIDField);
        frontPanel.add(passwordField);
        
        //button  
        trainerBox.setHorizontalAlignment(SwingConstants.CENTER);
        trainerBox.setBounds(230, 492, 300, 46);
        frontPanel.add(trainerBox);
        trainerBox.setForeground(Color.WHITE);
        trainerBox.setBackground(new Color(106, 90, 205));
        trainerBox.setFont(f1);
        
        traineeBox.setHorizontalAlignment(SwingConstants.CENTER);
        traineeBox.setBounds(532, 492, 300, 46);
        frontPanel.add(traineeBox);
        traineeBox.setBackground(new Color(106, 90, 205));
        traineeBox.setForeground(Color.WHITE);
        traineeBox.setFont(f1);
            
        addButton.setBackground(new Color(106, 90, 205));
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(680, 669, 150, 35);
        frontPanel.add(addButton);
        addButton.setFont(f1);
             
        cancelButton.setBackground(new Color(106, 90, 205));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(517, 669, 150, 35);
        frontPanel.add(cancelButton);
        cancelButton.setFont(f1);
         
        lblUserID.setForeground(Color.DARK_GRAY);
        lblUserID.setFont(new Font("Serif", Font.BOLD, 20));
        lblUserID.setBounds(230, 106, 65, 35);
        frontPanel.add(lblUserID);
         
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Serif", Font.BOLD, 20));
        lblPassword.setBounds(230, 306, 103, 35);
        frontPanel.add(lblPassword);
         
        title.setBounds(216, 33, 358, 83);
        addNewUserPanel.add(title);
        title.setForeground(Color.DARK_GRAY);
        title.setFont(heading1);
       
        //Navigation Bar
        NavPanel.setBackground(new Color(54, 33, 89));
        NavPanel.setBounds(0, 0, 311, 1041);
        getContentPane().add(NavPanel);
       
        ////end of Add New User panel////
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        new AddNewUser();
    }
}