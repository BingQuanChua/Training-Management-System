package viewadmin;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class AddNewCourse extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AdminUI adminUI;
	
	private JTextField txtCourseID;
	private JTextField txtName;
	private JTextArea txtDesc;
	private JTextField txtTrainer;
	private JTextField txtDate;
	
	private JButton addButton;
	private JButton cancelButton;
    
    public AddNewCourse() {
    	
    	setBackground(new Color(255, 255, 200));        
    	JPanel addNewCourse = new JPanel();
        JPanel frontPanel =  new JPanel();
        JPanel NavPanel = new JPanel();
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBounds(378, 138, 1071, 834);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.GRAY);
        separator_1.setBackground(Color.GRAY);
        separator_1.setBounds(103, 371, 757, 2);
        frontPanel.add(separator_1);
        
        JLabel lblName = new JLabel("Training Course Name");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Serif", Font.PLAIN, 30));
        lblName.setBounds(103, 242, 291, 47);
        frontPanel.add(lblName);
        
        txtName = new JTextField(); 
        txtName.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtName.setBounds(103, 313, 757, 47);
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
        separator_2.setBounds(103, 565, 757, 8);
        frontPanel.add(separator_2);
        
        JLabel lblDesc = new JLabel("Description\r\n");
        lblDesc.setForeground(Color.BLACK);
        lblDesc.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDesc.setBounds(103, 404, 153, 27);
        frontPanel.add(lblDesc);
        
        txtDesc = new JTextArea();
        txtDesc.setText("Enter short description\r\n");
        txtDesc.setForeground(Color.GRAY);
        txtDesc.setLineWrap(true);
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
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setBounds(103, 454, 757, 110);
    	scrollPane.setViewportView(txtDesc);
        frontPanel.add(scrollPane);
        
        JLabel lblTrainer = new JLabel("Trainer");
        lblTrainer.setForeground(Color.BLACK);
        lblTrainer.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTrainer.setBounds(103, 598, 100, 27);
        frontPanel.add(lblTrainer);
        
        txtTrainer = new JTextField();
        txtTrainer.setText("Enter trainer ID for this training course (e.g. tnr12345)");
        txtTrainer.setForeground(Color.GRAY);
        txtTrainer.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtTrainer.setBorder(null);
        txtTrainer.setBounds(103, 639, 757, 47);
        txtTrainer.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if( txtTrainer.getText().trim().equals("Enter trainer ID for this training course (e.g. tnr12345)"))
        			 txtTrainer.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if( txtTrainer.getText().trim().equals("")) 
        			 txtTrainer.setText("Enter trainer ID for this training course (e.g. tnr12345)");
        	}
        });
        frontPanel.add(txtTrainer);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setForeground(Color.GRAY);
        separator_3.setBackground(Color.GRAY);
        separator_3.setBounds(103, 697, 757, 2);
        frontPanel.add(separator_3);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setForeground(Color.BLACK);
        lblDate.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDate.setBounds(103, 738, 100, 27);
        frontPanel.add(lblDate);
        
        txtDate = new JTextField();
        txtDate.setText("Enter training date (format: YYYY-MM-DD)");
        txtDate.setForeground(Color.GRAY);
        txtDate.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDate.setBorder(null);
        txtDate.setBounds(103, 780, 757, 47);
        txtDate.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if( txtDate.getText().trim().equals("Enter training date (format: YYYY-MM-DD)")) 
        			 txtDate.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if( txtDate.getText().trim().equals("")) 
        			 txtDate.setText("Enter training date (format: YYYY-MM-DD)");
        	}
        });
        frontPanel.add(txtDate);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setForeground(Color.GRAY);
        separator_4.setBackground(Color.GRAY);
        separator_4.setBounds(103, 838, 757, 2);
        frontPanel.add(separator_4);
        
        addButton = new JButton("Add");
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Serif", Font.PLAIN, 20));
        addButton.setBackground(new Color(205,133,63));
        addButton.setBounds(710, 900, 150, 35);
        frontPanel.add(addButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Serif", Font.PLAIN, 20));
        cancelButton.setBackground(new Color(205,133,63));
        cancelButton.setBounds(529, 900, 150, 35);
        frontPanel.add(cancelButton);
        
        JLabel lblCourseID = new JLabel("Training Course ID");
        lblCourseID.setForeground(Color.BLACK);
        lblCourseID.setFont(new Font("Serif", Font.PLAIN, 30));
        lblCourseID.setBounds(103, 109, 291, 45);
        frontPanel.add(lblCourseID);
        
        txtCourseID = new JTextField();
        txtCourseID.setText("Enter training course ID (e.g. crs12345)");
        txtCourseID.setForeground(Color.GRAY);
        txtCourseID.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtCourseID.setBorder(null);
        txtCourseID.setBounds(103, 165, 757, 47);
        txtCourseID.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(txtCourseID.getText().trim().equals("Enter training course ID (e.g. crs12345)")) 
        	         txtCourseID.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(txtCourseID.getText().trim().equals("")) 
        	           txtCourseID.setText("Enter training course ID (e.g. crs12345)");
        	}
        });
        frontPanel.add(txtCourseID);
        
        JSeparator separator_3_1 = new JSeparator();
        separator_3_1.setForeground(Color.GRAY);
        separator_3_1.setBackground(Color.GRAY);
        separator_3_1.setBounds(103, 223, 757, 2);
        frontPanel.add(separator_3_1);
        frontPanel.setPreferredSize(new Dimension(1000, 1000));
        setPreferredSize(new Dimension(1000, 1000));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        add(frontPanel);
        
        JLabel lblNewLabel = new JLabel("Add New Training Course");
        frontPanel.add(lblNewLabel);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        lblNewLabel.setBounds(15, 0, 505, 73);
        
        JSeparator separator_3_2 = new JSeparator();
        separator_3_2.setForeground(Color.GRAY);
        separator_3_2.setBackground(Color.GRAY);
        separator_3_2.setBounds(0, 71, 1000, 2);
        frontPanel.add(separator_3_2);
 
        //Navigation Bar
        //NavPanel.setBackground(new Color(54, 33, 89));
        //NavPanel.setBounds(0, 0, 311, 1041);
        //getContentPane().add(NavPanel);
       
        ////end of Add New User panel////
        
    }
    	
	
	public JTextField getTxtCourseID() {
		return txtCourseID;
	}
	
	public JTextField getTxtName() {
		return txtName;
	}
	
	public JTextArea getTxtDesc() {
		return txtDesc;
	}
	
	public JTextField getTxtTrainer() {
		return txtTrainer;
	}
	
	public JTextField getTxtDate() {
		return txtDate;
	}
		
    public JButton getAddButton() {
    	return addButton;
    }
    
    public JButton getCancelButton() {
    	return cancelButton;
    }
}