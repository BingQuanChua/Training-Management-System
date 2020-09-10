package mj;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EditCourse extends JPanel{
	/**
	 * Showing page for editing training course
	 */
	private JTextArea txtDesc;
	private JTextField txtTrainer;
	private JTextField txtDate;
    
    EditCourse() {
        
    	JPanel editCourse = new JPanel();
        JPanel frontPanel =  new JPanel();
        JPanel NavPanel = new JPanel();
     
       
        //Add New User panel //        
        editCourse.setPreferredSize(new Dimension(1600, 1080));
        editCourse.setBackground( new Color(255, 255, 224));
        editCourse.setLayout(null);      
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBounds(384, 120, 1071, 834);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        editCourse.add(frontPanel);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setForeground(Color.GRAY);
        separator_1.setBackground(Color.GRAY);
        separator_1.setBounds(157, 196, 757, 2);
        frontPanel.add(separator_1);
        
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Serif", Font.PLAIN, 30));
        lblName.setBounds(157, 87, 100, 27);
        frontPanel.add(lblName);
        
        JTextField txtName = new JTextField(); 
        txtName.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtName.setBounds(157, 138, 757, 47);
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
        separator_2.setBounds(157, 390, 757, 8);
        frontPanel.add(separator_2);
        
        JLabel lblDesc = new JLabel("Description\r\n");
        lblDesc.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDesc.setBounds(157, 229, 153, 27);
        frontPanel.add(lblDesc);
        
        txtDesc = new JTextArea();
        txtDesc.setText("Enter short description\r\n");
        txtDesc.setForeground(Color.GRAY);
        txtDesc.setLineWrap(true);
        txtDesc.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDesc.setBorder(null);
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
        scrollPane.setBounds(157, 279, 757, 110);
    	scrollPane.setViewportView(txtDesc);
        frontPanel.add(scrollPane);
        
        JLabel lblTrainer = new JLabel("Trainer");
        lblTrainer.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTrainer.setBounds(157, 426, 100, 27);
        frontPanel.add(lblTrainer);
        
        txtTrainer = new JTextField();
        txtTrainer.setText("Enter trainer ID for this training course\r\n");
        txtTrainer.setForeground(Color.GRAY);
        txtTrainer.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtTrainer.setBorder(null);
        txtTrainer.setBounds(157, 464, 757, 47);
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
        separator_3.setBounds(157, 521, 757, 2);
        frontPanel.add(separator_3);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDate.setBounds(157, 563, 100, 27);
        frontPanel.add(lblDate);
        
        txtDate = new JTextField();
        txtDate.setText("Enter training date");
        txtDate.setForeground(Color.GRAY);
        txtDate.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtDate.setBorder(null);
        txtDate.setBounds(157, 605, 757, 47);
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
        setLayout(new BorderLayout(0, 0));
        frontPanel.add(txtDate);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setForeground(Color.GRAY);
        separator_4.setBackground(Color.GRAY);
        separator_4.setBounds(157, 663, 757, 2);
        frontPanel.add(separator_4);
        
        JButton editButton = new JButton("Edit\r\n");
        editButton.setForeground(Color.WHITE);
        editButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        editButton.setBackground(new Color(106, 90, 205));
        editButton.setBounds(770, 746, 150, 35);
        frontPanel.add(editButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		removeAll();
				add(new AllTrainingList());
		        repaint();
				revalidate();
        	}
        });
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        cancelButton.setBackground(new Color(106, 90, 205));
        cancelButton.setBounds(595, 746, 150, 35);
        frontPanel.add(cancelButton);
        add(editCourse);
        
        JLabel lblEditTrainingCourse = new JLabel("Edit Training Course Info");
        lblEditTrainingCourse.setForeground(Color.DARK_GRAY);
        lblEditTrainingCourse.setFont(new Font("SansSerif", Font.PLAIN, 40));
        lblEditTrainingCourse.setBounds(384, 46, 532, 73);
        editCourse.add(lblEditTrainingCourse);
        setSize(1600,1080);
       
       
        ////end of Add New User panel////
    }

}