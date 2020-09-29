package viewtrainer;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import view.ListPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TrainingRequestList extends JPanel {

	/**
	 * Create the panel.
	 */
	private ListPanel requestList;
	
	public TrainingRequestList() {
		setBackground(new Color(255, 255, 200));
		setPreferredSize(new Dimension(1000, 800));
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1000, 800));	
		
		JLabel label1 = new JLabel("No.");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Serif", Font.PLAIN, 30));
		label1.setBounds(100, 85, 75, 50);
		panel.add(label1);
		
		JLabel label2 = new JLabel("Trainee Name");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Serif", Font.PLAIN, 30));
		label2.setBounds(175, 85, 450, 50);
		panel.add(label2);
		
		JLabel label3 = new JLabel("Action");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Serif", Font.PLAIN, 30));
		label3.setBounds(625, 85, 275, 50);
		panel.add(label3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(100, 140, 820, 10);
        separator_1.setForeground(Color.LIGHT_GRAY);
        separator_1.setBackground(Color.LIGHT_GRAY);
        panel.add(separator_1);
        
        requestList = new ListPanel();
		requestList.setBackground(Color.WHITE);
		// dummy data input //
		requestList.addItem(new TrainingRequest("Norman Reedus", 1));
		requestList.addItem(new TrainingRequest("Keanu Reeves", 2));
		requestList.addItem(new TrainingRequest("Michael Jackson", 3));
		// end of dummy data //
		
		JScrollPane scrollPane = new JScrollPane(requestList);
		scrollPane.setBounds(100, 150, 820, 550);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(100, 710, 820, 10);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.LIGHT_GRAY);
        panel.add(separator_2);
		
        JLabel title = new JLabel("Training Request");
		title.setFont(new Font("Serif", Font.PLAIN, 40));
		title.setBounds(100, 25, 299, 47);
		panel.add(title);
		
		add(panel);
	}
}
