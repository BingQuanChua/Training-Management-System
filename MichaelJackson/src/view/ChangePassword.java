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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class ChangePassword extends JPanel{

		private JButton saveButton;
		private JButton cancelButton;
		private JTextField txtCurrentPass;
		private JTextField txtNewPass;
		private JTextField txtConfirmPass;
		private int dialogButton_1;
		private int dialogButton_2;
		/**
		 * Create the panel.
		 */
		
		public ChangePassword() {

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
			JLabel lblNewLabel = new JLabel("Current Password");
			lblNewLabel.setFont(new Font("Serif", Font.BOLD, 30));
			lblNewLabel.setBounds(200, 139, 300, 28);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("New Password");
			lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 30));
			lblNewLabel_1.setBounds(200, 280, 300, 28);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Confirm Password");
			lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 30));
			lblNewLabel_2.setBounds(200, 420, 300, 28);
			panel.add(lblNewLabel_2);
			
			//Content
			txtCurrentPass = new JTextField();
			txtCurrentPass.setText("Enter current password");
			txtCurrentPass.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		if(txtCurrentPass.getText().trim().equals("Enter current password")) 
	        			txtCurrentPass.setText("");
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		 if(txtCurrentPass.getText().trim().equals("")) 
	        			 txtCurrentPass.setText("Enter current password");
	        	}
	        }); 
			txtCurrentPass.setForeground(Color.GRAY);
			txtCurrentPass.setFont(new Font("Serif", Font.PLAIN, 20));
			txtCurrentPass.setBounds(200, 189, 500, 28);
			txtCurrentPass.setEditable(true);
			txtCurrentPass.setBorder(null);
			panel.add(txtCurrentPass);
			
			txtNewPass = new JTextField();
			txtNewPass.setText("Enter new password");
			txtNewPass.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		if(txtNewPass.getText().trim().equals("Enter new password")) 
	        			txtNewPass.setText("");
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		 if(txtNewPass.getText().trim().equals("")) 
	        			 txtNewPass.setText("Enter new password");
	        	}
	        }); 
			txtNewPass.setForeground(Color.GRAY);
			txtNewPass.setFont(new Font("Serif", Font.PLAIN, 20));
			txtNewPass.setBounds(200, 330, 500, 28);
			txtNewPass.setEditable(true);
			txtNewPass.setBorder(null);
			panel.add(txtNewPass);
			
			txtConfirmPass = new JTextField();
			txtConfirmPass.setText("Enter your new password again");
			txtConfirmPass.addFocusListener(new FocusAdapter() {
	        	@Override
	        	public void focusGained(FocusEvent e) {
	        		if(txtConfirmPass.getText().trim().equals("Enter your new password again")) 
	        			txtConfirmPass.setText("");
	        	}
	        	@Override
	        	public void focusLost(FocusEvent e) {
	        		 if(txtConfirmPass.getText().trim().equals("")) 
	        			 txtConfirmPass.setText("Enter your new password again");
	        	}
	        }); 
			txtConfirmPass.setForeground(Color.GRAY);
			txtConfirmPass.setFont(new Font("Serif", Font.PLAIN, 20));
			txtConfirmPass.setBounds(200, 470, 500, 28);
			txtConfirmPass.setEditable(true);
			txtConfirmPass.setBorder(null);
			panel.add(txtConfirmPass);
			
			///Separator
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(200, 360, 500, 5);
			panel.add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBounds(200, 500, 500, 5);
			panel.add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(200, 218, 500, 5);
			panel.add(separator_3);
			
			JLabel lblPersonalInfo = new JLabel("Password");
			lblPersonalInfo.setForeground(Color.BLACK);
			lblPersonalInfo.setFont(new Font("Serif", Font.PLAIN, 40));
			lblPersonalInfo.setBounds(15, 0, 221, 52);
			panel.add(lblPersonalInfo);
			
			saveButton = new JButton("Save");
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialogButton_1 = JOptionPane.showConfirmDialog (null, "Are you sure want to save the changes?","WARNING",JOptionPane.YES_NO_OPTION);
	    			if(dialogButton_1 == JOptionPane.YES_OPTION) {
	    				dialogButton_2 = JOptionPane.showConfirmDialog (null, "Password has been changed successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
	    			}
	        	}
				});
			
			saveButton.setForeground(Color.WHITE);
			saveButton.setFont(new Font("Serif", Font.PLAIN, 20));
			saveButton.setBackground(new Color(205, 133, 63));
			saveButton.setBounds(550, 562, 150, 35);
			panel.add(saveButton);
			
			JSeparator separator_3_1 = new JSeparator();
			separator_3_1.setForeground(Color.GRAY);
			separator_3_1.setBackground(Color.GRAY);
			separator_3_1.setBounds(0, 61, 1000, 2);
			panel.add(separator_3_1);
			
		}

		public JButton getConfirmButton() {
			return saveButton;
		}
		
		public JTextField getTxtOldPass() {
			return txtCurrentPass;
		}
		
		public JTextField getTxtNewPass() {
			return txtNewPass;
		}
		
		public JTextField gettxtConfirmPass() {
			return txtConfirmPass;
		}
	}

