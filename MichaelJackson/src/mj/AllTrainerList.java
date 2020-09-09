package mj;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AllTrainerList extends JPanel {

	/**
	 * Showing a list of all trainers
	 */
	public AllTrainerList() {
		
		JPanel btmPanel = new JPanel();
		btmPanel.setForeground(Color.WHITE);
		btmPanel.setPreferredSize(new Dimension(1500, 800));
		btmPanel.setBounds(277, 121, 1300, 800);
		btmPanel.setBackground( Color.WHITE);
             
		setBackground(new Color(255, 255, 224));
		setPreferredSize(new Dimension(1600, 1080));
		setLayout(null);
		btmPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(99, 5, 881, 423);
		topPanel.setPreferredSize(new Dimension(500, 300));
		topPanel.setForeground(SystemColor.desktop);
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(null);
		        
		ManageUser r1 = new ManageUser("Bryan Cranston");
		r1.setLocation(0, 0);
		r1.setSize(877, 60);
		topPanel.add(r1);
		        
		ManageUser r2 = new ManageUser("Edwin White");
		r2.setBounds(0, 71, 877, 60);
		topPanel.add(r2);
		
		ManageUser r3 = new ManageUser("Keanu Reeves");
		r3.setBounds(0, 142, 877, 60);
		topPanel.add(r3);
		
		ManageUser r4 = new ManageUser("Rami Malek");
		r4.setBounds(0, 217, 877, 60);
		topPanel.add(r4);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 80, 1244, 17);
        separator_1.setForeground(Color.LIGHT_GRAY);
        separator_1.setBackground(Color.LIGHT_GRAY);
        btmPanel.add(separator_1);
        
        JLabel lblNumber = new JLabel("No.");
        lblNumber.setBounds(68, 31, 46, 38);
        lblNumber.setForeground(Color.DARK_GRAY);
        lblNumber.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblNumber);
        
        JLabel lblTraineeName = new JLabel("Trainer Name");
        lblTraineeName.setBounds(431, 31, 257, 38);
        lblTraineeName.setForeground(Color.DARK_GRAY);
        lblTraineeName.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblTraineeName);
        
        JLabel lblAction = new JLabel("Action\r\n");
        lblAction.setBounds(949, 31, 104, 38);
        lblAction.setForeground(Color.DARK_GRAY);
        lblAction.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblAction);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setForeground(Color.LIGHT_GRAY);
        separator_2.setBackground(Color.LIGHT_GRAY);
        separator_2.setBounds(31, 735, 1240, 10);
        btmPanel.add(separator_2);
        
        JScrollPane scrollPane = new JScrollPane(topPanel);
		scrollPane.setBounds(326, 127, 945, 556);
		scrollPane.setBorder(null);
		btmPanel.add(scrollPane);
		add(btmPanel);
		
		JLabel lblListOfTrainers = new JLabel("List of Trainers");
		lblListOfTrainers.setForeground(Color.DARK_GRAY);
		lblListOfTrainers.setFont(new Font("SansSerif", Font.PLAIN, 40));
		lblListOfTrainers.setBounds(277, 48, 280, 73);
		add(lblListOfTrainers);
		
						

	}
}
