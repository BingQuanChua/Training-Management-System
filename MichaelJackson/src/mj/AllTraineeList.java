package mj;

import javax.swing.*;
import java.awt.*;

public class AllTraineeList extends JPanel {

	/**
	 * Showing a list of all trainees
	 */
	public AllTraineeList() {
		
		JPanel btmPanel = new JPanel();
		btmPanel.setForeground(Color.WHITE);
		btmPanel.setPreferredSize(new Dimension(1000, 1000));
		btmPanel.setBackground( Color.WHITE);
             
		setBackground(new Color(255, 255, 200));
		setPreferredSize(new Dimension(1000, 1000));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btmPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(99, 5, 881, 423);
		topPanel.setPreferredSize(new Dimension(500, 300));
		topPanel.setForeground(SystemColor.desktop);
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(null);
		        
		ManageUser r1 = new ManageUser("Bryan Cranston",1);
		r1.setLocation(0, 0);
		r1.setSize(800, 60);
		topPanel.add(r1);
		        
		ManageUser r2 = new ManageUser("Edwin White",2);
		r2.setBounds(0, 60, 800, 60);
		topPanel.add(r2);
		
		ManageUser r3 = new ManageUser("Keanu Reeves",3);
		r3.setBounds(0, 115, 800, 60);
		topPanel.add(r3);
		
		ManageUser r4 = new ManageUser("Rami Malek",4);
		r4.setBounds(0, 171, 800, 60);
		topPanel.add(r4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 143, 1244, 17);
        separator_1.setForeground(Color.LIGHT_GRAY);
        separator_1.setBackground(Color.LIGHT_GRAY);
        btmPanel.add(separator_1);
        
        JLabel lblNumber = new JLabel("No.");
        lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblNumber.setBounds(100, 85, 75, 50);
        lblNumber.setForeground(Color.DARK_GRAY);
        lblNumber.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblNumber);
        
        JLabel lblTraineeName = new JLabel("Trainee Name");
        lblTraineeName.setHorizontalAlignment(SwingConstants.CENTER);
        lblTraineeName.setBounds(175, 85, 450, 50);
        lblTraineeName.setForeground(Color.DARK_GRAY);
        lblTraineeName.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblTraineeName);
        
        JLabel lblAction = new JLabel("Action\r\n");
        lblAction.setHorizontalAlignment(SwingConstants.CENTER);
        lblAction.setBounds(625, 85, 275, 50);
        lblAction.setForeground(Color.DARK_GRAY);
        lblAction.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblAction);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setForeground(Color.LIGHT_GRAY);
        separator_2.setBackground(Color.LIGHT_GRAY);
        separator_2.setBounds(15, 931, 970, 17);
        btmPanel.add(separator_2);
        
        JScrollPane scrollPane = new JScrollPane(topPanel);
		scrollPane.setBounds(107, 188, 945, 556);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		btmPanel.add(scrollPane);
		add(btmPanel);
		
		JLabel lblListOfTrainees = new JLabel("List of Trainees");
		lblListOfTrainees.setLocation(15, 0);
		lblListOfTrainees.setSize(331, 50);
		lblListOfTrainees.setForeground(Color.DARK_GRAY);
		lblListOfTrainees.setFont(new Font("Serif", Font.PLAIN, 40));
		btmPanel.add(lblListOfTrainees);
		
						

	}
}
