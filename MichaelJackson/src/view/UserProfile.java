package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import viewadmin.AdminUI;

public class UserProfile extends JPanel {
	
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblPersonalInfo;
	private JButton editButton;
	private JButton cancelButton;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtPosition;
	private JTextField txtContact;
	private JTextField txtEmail;
	private JTextArea txtDesc;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	
	public UserProfile() {
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1000,1000));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1000, 1000));
		add(panel);
		panel.setLayout(null);
		
		
		//Header
		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_1.setBounds(200, 100, 300, 28);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_2.setBounds(200, 200, 300, 28);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Position");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_3.setBounds(200, 300, 300, 28);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_4.setBounds(200, 400, 300, 28);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_5.setBounds(200, 500, 300, 28);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("About me");
		lblNewLabel_6.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_6.setBounds(200, 600, 300, 28);
		panel.add(lblNewLabel_6);
		
	
		//Content
		txtName = new JTextField();
		txtName.setForeground(Color.GRAY);
		txtName.setFont(new Font("Serif", Font.PLAIN, 20));
		txtName.setBounds(200, 150, 500, 28);
		txtName.setEditable(false);
		txtName.setBorder(null);
		panel.add(txtName);
		
		txtGender = new JTextField();
		txtGender.setForeground(Color.GRAY);
		txtGender.setFont(new Font("Serif", Font.PLAIN, 20));
		txtGender.setBounds(200, 250, 500, 28);
		txtGender.setEditable(false);
		txtGender.setBorder(null);
		panel.add(txtGender);
		
		txtPosition = new JTextField();
		txtPosition.setForeground(Color.GRAY);
		txtPosition.setFont(new Font("Serif", Font.PLAIN, 20));
		txtPosition.setBounds(200, 350, 500, 28);
		txtPosition.setEditable(false);
		txtPosition.setBorder(null);
		panel.add(txtPosition);
		
		txtContact = new JTextField();
		txtContact.setForeground(Color.GRAY);
		txtContact.setFont(new Font("Serif", Font.PLAIN, 20));
		txtContact.setBounds(200, 450, 500, 28);
		txtContact.setEditable(false);
		txtContact.setBorder(null);
		panel.add(txtContact);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setFont(new Font("Serif", Font.PLAIN, 20));
		txtEmail.setBounds(200, 550, 500, 28);
		txtEmail.setEditable(false);
		txtEmail.setBorder(null);
		panel.add(txtEmail);
		
		txtDesc = new JTextArea();
		txtDesc.setForeground(Color.GRAY);
		txtDesc.setFont(new Font("Serif", Font.PLAIN, 20));
		txtDesc.setBounds(200, 650, 700, 28);
		txtDesc.setEditable(false);
		txtDesc.setLineWrap(true);	
		txtDesc.setBorder(null);
		scrollPane = new JScrollPane(txtDesc);
		scrollPane.setBounds(200, 650, 500, 130);
		panel.add(scrollPane);
		
		///Separator
		separator_1 = new JSeparator();
		separator_1.setBounds(200, 180, 500, 5);
		panel.add(separator_1);
				
		separator_2 = new JSeparator();
		separator_2.setBounds(200, 280, 500, 5);
		panel.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(200, 380, 500, 5);
		panel.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setBounds(200, 480, 500, 5);
		panel.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(200, 580, 500, 5);
		panel.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setBounds(200, 796, 500, 5);
		panel.add(separator_6);
		
		lblPersonalInfo = new JLabel("Personal Info");
		lblPersonalInfo.setForeground(Color.BLACK);
		lblPersonalInfo.setFont(new Font("Serif", Font.PLAIN, 40));
		lblPersonalInfo.setBounds(15, 0, 221, 52);
		panel.add(lblPersonalInfo);
		
	    separator_7 = new JSeparator();
		separator_7.setForeground(Color.GRAY);
		separator_7.setBackground(Color.GRAY);
		separator_7.setBounds(0, 60, 1000, 2);
		panel.add(separator_7);
		
		/*
		cancelButton = new JButton("Back");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Serif", Font.PLAIN, 20));
		cancelButton.setBackground(new Color(205, 133, 63));
		cancelButton.setBounds(366, 852, 150, 35);
		cancelButton.setVisible(false);
		panel.add(cancelButton);
		*/
		
		editButton = new JButton("Edit");
		editButton.setForeground(Color.WHITE);
		editButton.setFont(new Font("Serif", Font.PLAIN, 20));
		editButton.setBackground(new Color(205, 133, 63));
		editButton.setBounds(550, 852, 150, 35);
		panel.add(editButton);
		
	;}

	public JButton getEditButton() {
		return editButton;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}
	
	public JTextField getTxtGender() {
		return txtGender;
	}
	
	public JTextField getTxtPosition() {
		return txtPosition;
	}
	
	public JTextField getTxtContact() {
		return txtContact;
	}
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}
	
	public JTextArea getTxtDesc() {
		return txtDesc;
	}
}
