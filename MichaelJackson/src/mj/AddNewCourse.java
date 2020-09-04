package mj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddNewCourse extends JPanel {
	private JTextArea txtDesc;
	private JTextField txtTrainer;
	private JTextField txtDate;
	private JTextField txtCourseID;
    
    AddNewCourse() {
    	        
    	JPanel addNewCourse = new JPanel();
        JPanel frontPanel =  new JPanel();
        JPanel NavPanel = new JPanel();
     
       
        //Add New User panel //        
        addNewCourse.setPreferredSize(new Dimension(1920, 1080));
        addNewCourse.setBackground( SystemColor.controlHighlight);
        //getContentPane().setLayout(null);
        addNewCourse.setLayout(null);      
        //getContentPane().add(addNewCourse);
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBounds(216, 127, 1071, 834);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        addNewCourse.add(frontPanel);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.GRAY);
        separator_1.setBackground(Color.GRAY);
        separator_1.setBounds(157, 273, 757, 2);
        frontPanel.add(separator_1);
        
        JLabel lblName = new JLabel("Training Course Name");
        lblName.setFont(new Font("Serif", Font.PLAIN, 30));
        lblName.setBounds(157, 144, 291, 47);
        frontPanel.add(lblName);
        
        JTextField txtName = new JTextField(); 
        txtName.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtName.setBounds(157, 215, 757, 47);
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
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setForeground(Color.GRAY);
        separator_2.setBackground(Color.GRAY);
        separator_2.setBounds(157, 467, 757, 8);
        frontPanel.add(separator_2);
        
        JLabel lblDesc = new JLabel("Description\r\n");
        lblDesc.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDesc.setBounds(157, 306, 153, 27);
        frontPanel.add(lblDesc);
        
        txtDesc = new JTextArea();
        txtDesc.setText("Enter short description\r\n");
        txtDesc.setForeground(Color.GRAY);
        txtDesc.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDesc.setBorder(null);
        txtDesc.setBounds(157, 356, 757, 110);
      
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
        frontPanel.add(txtDesc);
        
        JLabel lblTrainer = new JLabel("Trainer");
        lblTrainer.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTrainer.setBounds(157, 500, 100, 27);
        frontPanel.add(lblTrainer);
        
        txtTrainer = new JTextField();
        txtTrainer.setText("Enter trainer ID for this training course(e.g. TRN12345)");
        txtTrainer.setForeground(Color.GRAY);
        txtTrainer.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtTrainer.setBorder(null);
        txtTrainer.setBounds(157, 541, 757, 47);
        txtTrainer.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if( txtTrainer.getText().trim().equals("Enter trainer ID for this training course(e.g. TRN12345)"))
        			 txtTrainer.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if( txtTrainer.getText().trim().equals("")) 
        			 txtTrainer.setText("Enter trainer ID for this training course(e.g. TRN12345)");
        	}
        });
        frontPanel.add(txtTrainer);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setForeground(Color.GRAY);
        separator_3.setBackground(Color.GRAY);
        separator_3.setBounds(157, 599, 757, 2);
        frontPanel.add(separator_3);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDate.setBounds(157, 640, 100, 27);
        frontPanel.add(lblDate);
        
        txtDate = new JTextField();
        txtDate.setText("Enter training date");
        txtDate.setForeground(Color.GRAY);
        txtDate.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDate.setBorder(null);
        txtDate.setBounds(157, 682, 757, 47);
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
        separator_4.setBounds(157, 740, 757, 2);
        frontPanel.add(separator_4);
        
        JButton addButton = new JButton("Add");
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        addButton.setBackground(new Color(106, 90, 205));
        addButton.setBounds(764, 772, 150, 35);
        frontPanel.add(addButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        cancelButton.setBackground(new Color(106, 90, 205));
        cancelButton.setBounds(594, 772, 150, 35);
        frontPanel.add(cancelButton);
        
        JLabel lblCourseID = new JLabel("Training Course ID");
        lblCourseID.setFont(new Font("Serif", Font.PLAIN, 30));
        lblCourseID.setBounds(157, 11, 291, 45);
        frontPanel.add(lblCourseID);
        
        txtCourseID = new JTextField();
        txtCourseID.setText("Enter training course ID(e.g. ABC-1234)");
        txtCourseID.setForeground(Color.GRAY);
        txtCourseID.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtCourseID.setBorder(null);
        txtCourseID.setBounds(157, 67, 757, 47);
        txtCourseID.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(txtCourseID.getText().trim().equals("Enter training course ID(e.g. ABC-1234)")) 
        	         txtCourseID.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(txtCourseID.getText().trim().equals("")) 
        	           txtCourseID.setText("Enter training course ID(e.g. ABC-1234)");
        	}
        });
        frontPanel.add(txtCourseID);
        
        JSeparator separator_3_1 = new JSeparator();
        separator_3_1.setForeground(Color.GRAY);
        separator_3_1.setBackground(Color.GRAY);
        separator_3_1.setBounds(157, 125, 757, 2);
        frontPanel.add(separator_3_1);
        
        JLabel lblNewLabel = new JLabel("Add New Training Course");
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        lblNewLabel.setBounds(222, 51, 493, 46);
        addNewCourse.add(lblNewLabel);
        setSize(1920,1080);
        add(addNewCourse);
    
  
        //Navigation Bar
        //NavPanel.setBackground(new Color(54, 33, 89));
        //NavPanel.setBounds(0, 0, 311, 1041);
        //getContentPane().add(NavPanel);
       
        ////end of Add New User panel////
        
    }

  
}