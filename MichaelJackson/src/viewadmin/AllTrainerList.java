package viewadmin;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class AllTrainerList extends JPanel {

	/**
	 * Showing a list of all trainers
	 */

private ListPanel trainerList;
public AdminUI adminUI;
	
	public AllTrainerList(AdminUI adminUI) {
		this.adminUI = adminUI;
		setBackground(new Color(255, 255, 200));
		setPreferredSize(new Dimension(1000, 1000));

		
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
		r2.setBounds(0, 58, 800, 60);
		topPanel.add(r2);
		
		ManageUser r3 = new ManageUser("Keanu Reeves",3);
		r3.setBounds(0, 116, 800, 60);
		topPanel.add(r3);
		
		ManageUser r4 = new ManageUser("Rami Malek",4);
		r4.setBounds(0, 174, 800, 60);
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
        
        JLabel lblTrainerName = new JLabel("Trainer Name");
        lblTrainerName.setHorizontalAlignment(SwingConstants.CENTER);
        lblTrainerName.setBounds(175, 85, 450, 50);
        lblTrainerName.setForeground(Color.DARK_GRAY);
        lblTrainerName.setFont(new Font("Serif", Font.PLAIN, 30));
        btmPanel.add(lblTrainerName);
        
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
		scrollPane.setBounds(100, 187, 945, 556);
		scrollPane.setBorder(null);
		btmPanel.add(scrollPane);
		add(btmPanel);

        trainerList = new ListPanel();
        trainerList.setBackground(Color.WHITE);
        // dummy data input //
        trainerList.addItem(new ManageUser("Yong Sheng Kai", this));
		trainerList.addItem(new ManageUser("Kong Yee Ling", this));
		trainerList.addItem(new ManageUser("Wong Keng Hao", this));
		trainerList.addItem(new ManageUser("Wong Wen Yao", this));
		trainerList.addItem(new ManageUser("Hee Wai Bing", this));
		// end of dummy data //
		
		JScrollPane scrollPane = new JScrollPane(trainerList);
		scrollPane.setBounds(100, 150, 820, 550);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(100, 710, 820, 10);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.LIGHT_GRAY);
        panel.add(separator_2);
		
        JLabel title = new JLabel("List of Trainers");
		title.setFont(new Font("Serif", Font.PLAIN, 40));
		title.setBounds(100, 25, 299, 47);
		panel.add(title);

		
		JLabel lblListOfTrainers = new JLabel("List of Trainers");
		lblListOfTrainers.setLocation(15, 0);
		lblListOfTrainers.setSize(280, 50);
		lblListOfTrainers.setForeground(Color.DARK_GRAY);
		lblListOfTrainers.setFont(new Font("Serif", Font.PLAIN, 40));
		btmPanel.add(lblListOfTrainers);
		
						

	}
}
