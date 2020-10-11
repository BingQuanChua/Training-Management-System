package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class UserProfile extends JPanel {
	
	/**
	 * User profile panel
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtPosition;
	private JTextField txtContact;
	private JTextField txtEmail;
	private JTextArea txtDesc;
	private JButton editButton;
	// private JButton cancelButton;
	
	/**
	 * Create the panel.
	 */
	
	public UserProfile() {
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1000,1000));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1000, 1000));
		add(panel);
		panel.setLayout(null);
		
		
		//Header
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_1.setBounds(200, 100, 300, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_2.setBounds(200, 200, 300, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Position");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_3.setBounds(200, 300, 300, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_4.setBounds(200, 400, 300, 28);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel_5.setBounds(200, 500, 300, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("About me");
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
		JScrollPane scrollPane = new JScrollPane(txtDesc);
		scrollPane.setBounds(200, 650, 500, 130);
		panel.add(scrollPane);
		
		///Separator
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(200, 180, 500, 5);
		panel.add(separator_1);
				
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(200, 280, 500, 5);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(200, 380, 500, 5);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(200, 480, 500, 5);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(200, 580, 500, 5);
		panel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(200, 796, 500, 5);
		panel.add(separator_6);
		
		JLabel lblPersonalInfo = new JLabel("Personal Info");
		lblPersonalInfo.setForeground(Color.BLACK);
		lblPersonalInfo.setFont(new Font("Serif", Font.PLAIN, 40));
		lblPersonalInfo.setBounds(15, 0, 221, 52);
		panel.add(lblPersonalInfo);
		
		JSeparator separator_7 = new JSeparator();
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
	
	public JButton getEditButton() {
		return editButton;
	}
}
