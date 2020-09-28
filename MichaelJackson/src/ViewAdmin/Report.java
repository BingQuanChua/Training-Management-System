package ViewAdmin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Report extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel list = new JPanel();
	
	public Report() {
		
		setBackground(new Color(255, 255, 200));	
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
		
		addTraining(new ManageAllReport("Python Advance Training Course",list));
		addTraining(new ManageAllReport("Software Engineering with Java",list));
		addTraining(new ManageAllReport("Introduction to OOPDS",list));
		add(list);
	}
			
	private void addTraining(ManageAllReport t) {
		list.add(t);
	}
}
