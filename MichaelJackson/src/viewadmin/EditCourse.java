package viewadmin;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class EditCourse extends JPanel{
	/**
	 * Showing page for editing training course
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtName;
	private JTextArea txtDesc;
	private JTextField txtTrainer;
	private JTextField txtDate;
	private JButton editButton;
	private JButton cancelButton;
    
    public EditCourse() {
        
        JPanel frontPanel =  new JPanel();
        JPanel NavPanel = new JPanel();    
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBounds(384, 120, 1071, 834);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.GRAY);
        separator_1.setBackground(Color.GRAY);
        separator_1.setBounds(157, 256, 757, 2);
        frontPanel.add(separator_1);
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Serif", Font.PLAIN, 30));
        lblName.setBounds(157, 160, 100, 27);
        frontPanel.add(lblName);
        
        txtName = new JTextField(); 
        txtName.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtName.setBounds(157, 211, 757, 47);
        frontPanel.add(txtName);
        txtName.setText("Enter training course name");
        txtName.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(txtName.getText().trim().equals("Enter training course name")) 
        	         txtName.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(txtName.getText().trim().equals("")) 
        	           txtName.setText("Enter training course name");
        	}
        });
        txtName.setForeground(Color.GRAY);
        txtName.setBorder(null);
        txtName.setEditable(false);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setForeground(Color.GRAY);
        separator_2.setBackground(Color.GRAY);
        separator_2.setBounds(157, 463, 757, 8);
        frontPanel.add(separator_2);
        
        JLabel lblDesc = new JLabel("Description\r\n");
        lblDesc.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDesc.setBounds(157, 302, 153, 27);
        frontPanel.add(lblDesc);
        
        txtDesc = new JTextArea();
        txtDesc.setText("Enter short description\r\n");
        txtDesc.setForeground(Color.GRAY);
        txtDesc.setLineWrap(true);
        txtDesc.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDesc.setBorder(null);
        txtDesc.setEditable(false);
        txtDesc.setBounds(157, 279, 757, 110);
      
        txtDesc.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if( txtDesc.getText().trim().equals("Enter short description")) 
        			 txtDesc.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if( txtDesc.getText().trim().equals("")) 
        			 txtDesc.setText("Enter short description");
        	}
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setBounds(157, 352, 757, 110);
    	scrollPane.setViewportView(txtDesc);
        frontPanel.add(scrollPane);
        
        JLabel lblTrainer = new JLabel("Trainer");
        lblTrainer.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTrainer.setBounds(157, 499, 100, 27);
        frontPanel.add(lblTrainer);
        
        txtTrainer = new JTextField();
        txtTrainer.setText("Enter trainer ID for this training course\r\n");
        txtTrainer.setForeground(Color.GRAY);
        txtTrainer.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtTrainer.setBorder(null);
        txtTrainer.setEditable(false);
        txtTrainer.setBounds(157, 537, 757, 47);
        txtTrainer.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if( txtTrainer.getText().trim().equals("Enter trainer ID for this training course")) 
        			 txtTrainer.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if( txtTrainer.getText().trim().equals("")) 
        			 txtTrainer.setText("Enter trainer ID for this training course");
        	}
        });
        frontPanel.add(txtTrainer);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setForeground(Color.GRAY);
        separator_3.setBackground(Color.GRAY);
        separator_3.setBounds(157, 594, 757, 2);
        frontPanel.add(separator_3);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDate.setBounds(157, 636, 100, 27);
        frontPanel.add(lblDate);
        
        txtDate = new JTextField();
        txtDate.setText("Enter training date");
        txtDate.setForeground(Color.GRAY);
        txtDate.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDate.setBorder(null);
        txtDate.setBounds(157, 678, 757, 47);
        txtDate.setEditable(false);
        txtDate.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if( txtDate.getText().trim().equals("Enter training date")) 
        			 txtDate.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if( txtDate.getText().trim().equals("")) 
        			 txtDate.setText("Enter training date");
        	}
        });
        frontPanel.add(txtDate);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setForeground(Color.GRAY);
        separator_4.setBackground(Color.GRAY);
        separator_4.setBounds(157, 736, 757, 2);
        frontPanel.add(separator_4);
        
        editButton = new JButton("Edit\r\n");
        editButton.setForeground(Color.WHITE);
        editButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        editButton.setBackground(new Color(205,133,63));
        editButton.setBounds(770, 819, 150, 35);
        frontPanel.add(editButton);
        
        cancelButton = new JButton("Cancel");
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        cancelButton.setBackground(new Color(205,133,63));
        cancelButton.setBounds(595, 819, 150, 35);
        frontPanel.add(cancelButton);
        
        JLabel lblEditTrainingCourse = new JLabel("Edit Training Course Info");
        lblEditTrainingCourse.setForeground(Color.BLACK);
        lblEditTrainingCourse.setFont(new Font("Serif", Font.PLAIN, 40));
        lblEditTrainingCourse.setBounds(15, 0, 532, 73);
        frontPanel.add(lblEditTrainingCourse);
        frontPanel.setPreferredSize(new Dimension(1000, 1000));
        add(frontPanel);
        
        JSeparator separator_5 = new JSeparator();
        separator_5.setForeground(Color.GRAY);
        separator_5.setBackground(Color.GRAY);
        separator_5.setBounds(0, 72, 1000, 2);
        frontPanel.add(separator_5);
        setPreferredSize(new Dimension(1000, 1000));
        setBackground(new Color (255,255,200));

        ////end of Edit User panel////
    }
   
    public JButton getEditButton() {
    	return editButton;
    }
    
    public JButton getCancelButton() {
    	return cancelButton;
    }
    
    public JTextField getTrainingName() {
    	return txtName;
    }
    
    public JTextField getTrainerID() {
    	return txtTrainer;
    }
    
    public JTextField getTrainingDate() {
    	return txtDate;
    }
    
    public JTextArea getTrainingDesc() {
    	return txtDesc;
    }

}