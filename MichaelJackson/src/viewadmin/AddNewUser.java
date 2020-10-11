package viewadmin;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class AddNewUser extends JPanel {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField userIDField;
	private JTextField passwordField;
	private ButtonGroup group;
	private JButton addButton;
	private JButton cancelButton;
	private JCheckBox trainerBox;
	private JCheckBox traineeBox;
	
    public AddNewUser() {
    	
    	setBackground(new Color(255, 255, 200));
    	
        JPanel frontPanel = new JPanel();
        JSeparator separator_1 = new JSeparator();
        JSeparator separator_2 = new JSeparator();
        userIDField = new JTextField(20);
        passwordField = new JTextField(20);
        group = new ButtonGroup();
        trainerBox = new JCheckBox("New Trainer", false);
        traineeBox = new JCheckBox("New Trainee", false);
        group.add(trainerBox);
        group.add(traineeBox);
        
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        JLabel lblUserID = new JLabel("UserID");
        JLabel lblPassword = new JLabel("Password\r\n");
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
        userIDField.setText("[Auto-generate] Please select user type");
        userIDField.setEditable(false);
        userIDField.setBounds(227, 229, 600, 80);
        userIDField.setForeground(Color.GRAY);
        userIDField.setFont(f1);
        userIDField.setBorder(null);
             
        passwordField.setText("Enter password");
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
        
        //checkbox
        trainerBox.setBounds(227, 569, 300, 46);
        frontPanel.add(trainerBox);
//        trainerBox.setBackground(new Color(205,133,63));
//        trainerBox.setForeground(Color.WHITE);
        trainerBox.setFont(new Font("Serif", Font.BOLD, 25));
        
        traineeBox.setBounds(529, 569, 300, 46);
        frontPanel.add(traineeBox);
//       traineeBox.setBackground(new Color(205,133,63));
//       traineeBox.setForeground(Color.WHITE);
        traineeBox.setFont(new Font("Serif", Font.BOLD, 25));
            
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
    
    public JTextField getUserIDField() {
    	return userIDField;
    }
    
    public JTextField getPasswordField() {
    	return passwordField;
    }
    
    public ButtonGroup getCBG() {
    	return group;
    }
    
    public JCheckBox getTrainerBox() {
    	return trainerBox;
    }
    
    public JCheckBox getTraineeBox() {
    	return traineeBox;
    }
    public JButton getAddButton() {
    	return addButton;
    }
    
    public JButton getCancelButton() {
    	return cancelButton;
    }
    

}