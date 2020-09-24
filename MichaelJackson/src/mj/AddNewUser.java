package mj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddNewUser extends JPanel {
    
	public AdminUI adminUI;
	private int dialogButton_1;
	private int dialogButton_2; 
	
    AddNewUser(AdminUI adminUI) {
    	this.adminUI = adminUI;
    	setBackground(new Color(255, 255, 200));
    	
    	
    	
        JPanel frontPanel = new JPanel();
        JSeparator separator_1 = new JSeparator();
        JSeparator separator_2 = new JSeparator();
        JTextField userIDField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JCheckBox trainerBox = new JCheckBox("New Trainer", true);
        JCheckBox traineeBox = new JCheckBox("New Trainee", true);
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dialogButton_1 = JOptionPane.showConfirmDialog (null, "Are you sure want to register this new account?","WARNING",JOptionPane.YES_NO_OPTION);
    			if(dialogButton_1 == JOptionPane.YES_OPTION) {
    				dialogButton_2 = JOptionPane.showConfirmDialog (null, "Account has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    				adminUI.home();
    			}
        	}
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		adminUI.home();
        	}
        });
        JLabel lblUserID = new JLabel("UserID");
        JLabel lblPassword = new JLabel("Password\r\n");
        JPanel NavPanel = new JPanel();
        Font heading1 = new Font(Font.SERIF, Font.PLAIN, 40);
        Font f1 = new Font(Font.SERIF, Font.PLAIN, 20);
       
        //Add New User panel //        
           
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        
        JLabel lblUserInfo = new JLabel("User Info");
        lblUserInfo.setForeground(Color.BLACK);
        lblUserInfo.setFont(new Font("Serif", Font.PLAIN, 40));
        lblUserInfo.setBounds(15, 0, 159, 52);
        frontPanel.add(lblUserInfo);
    
        
        //Separator//       
        separator_1.setBackground(Color.GRAY);
        separator_1.setForeground(Color.GRAY);
        separator_1.setBounds(227, 320, 600, 2);
        frontPanel.add(separator_1);
               
        separator_2.setForeground(Color.GRAY);
        separator_2.setBackground(Color.GRAY);
        separator_2.setBounds(227, 517, 600, 2);
        frontPanel.add(separator_2);
        
        //TextField// 
        userIDField.setText("Enter userID");
        userIDField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(userIDField.getText().trim().equals("Enter userID")) 
        	         userIDField.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(userIDField.getText().trim().equals("")) 
        	           userIDField.setText("Enter userID");
        	}
        }); 
        userIDField.setBounds(227, 229, 600, 80);
        userIDField.setForeground(Color.GRAY);
        userIDField.setFont(f1);
        userIDField.setBorder(null);
             
        passwordField.setText("Enter password\r\n");
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		  if(passwordField.getText().trim().equals("Enter password"))
        		         passwordField.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(passwordField.getText().trim().equals(""))
                    passwordField.setText("Enter password");
        	}
        });
        passwordField.setBounds(227, 429, 600, 80); 
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(f1);
        passwordField.setBorder(null);
         
        frontPanel.add(userIDField);
        frontPanel.add(passwordField);
        
        //button  
        trainerBox.setHorizontalAlignment(SwingConstants.CENTER);
        trainerBox.setBounds(227, 569, 300, 46);
        frontPanel.add(trainerBox);
        trainerBox.setForeground(Color.BLACK);
        trainerBox.setBackground(new Color(106, 90, 205));
        trainerBox.setFont(f1);
        
        traineeBox.setHorizontalAlignment(SwingConstants.CENTER);
        traineeBox.setBounds(529, 569, 300, 46);
        frontPanel.add(traineeBox);
        traineeBox.setBackground(new Color(106, 90, 205));
        traineeBox.setForeground(Color.BLACK);
        traineeBox.setFont(f1);
            
        addButton.setBackground(new Color(205,133,63));
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(677, 746, 150, 35);
        frontPanel.add(addButton);
        addButton.setFont(new Font("Serif", Font.PLAIN, 20));
             
        cancelButton.setBackground(new Color(205,133,63));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(502, 746, 150, 35);
        frontPanel.add(cancelButton);
        cancelButton.setFont(new Font("Serif", Font.PLAIN, 20));
         
        lblUserID.setForeground(Color.BLACK);
        lblUserID.setFont(new Font("Serif", Font.BOLD, 30));
        lblUserID.setBounds(227, 183, 103, 35);
        frontPanel.add(lblUserID);
         
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Serif", Font.BOLD, 30));
        lblPassword.setBounds(227, 383, 150, 35);
        frontPanel.add(lblPassword);
        frontPanel.setPreferredSize(new Dimension(1000, 1000));
        setPreferredSize(new Dimension(1000, 1000));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        add(frontPanel);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setForeground(Color.GRAY);
        separator_3.setBackground(Color.GRAY);
        separator_3.setBounds(0, 60, 1000, 2);
        frontPanel.add(separator_3);
        setBackground(new Color (255,255,200));
       
        ////end of Add New User panel///
    }
}