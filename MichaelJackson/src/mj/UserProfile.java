package mj;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class UserProfile extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserProfile() {
		setBackground(Color.WHITE);
		setLayout(null);
		setPreferredSize(new Dimension(800,800));
	
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 800, 800);
		add(panel);
		panel.setLayout(null);
		
		
		//Header
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(50, 100, 300, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(50, 200, 300, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Position");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_2.setBounds(50, 300, 300, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_3.setBounds(50, 400, 300, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4.setBounds(50, 500, 300, 28);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("About me");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_5.setBounds(50, 600, 300, 28);
		panel.add(lblNewLabel_5);
		
		
	
		//Content
		JLabel lblNewLabel_6 = new JLabel("Liew Kuan Yung");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(50, 150, 700, 28);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Male\r\n");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(50, 250, 700, 28);

		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cleaner");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(50, 350, 700, 28);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("012-3456789");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(50, 450, 700, 28);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("kuanyung@tms.com");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(50, 550, 700, 28);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("I'm am cool");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(50, 650, 700, 28);
		panel.add(lblNewLabel_11);
		
		
		
		///Separator
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 180, 300, 5);
		panel.add(separator);
				
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 280, 300, 5);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(50, 380, 300, 5);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(50, 480, 300, 5);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(50, 580, 300, 5);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(50, 680, 300, 5);
		panel.add(separator_5);

	}
}
