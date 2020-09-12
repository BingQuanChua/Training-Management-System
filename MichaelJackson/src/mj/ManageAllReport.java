 package mj;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ManageAllReport extends JPanel {

	/**
	 * Managing all training report 
	 */
	private static final long serialVersionUID = 1L;

	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);
	/**
	 * 
	 */
	public ManageAllReport(String name,JPanel list) {

		setPreferredSize(new Dimension(800, 70));
		setBackground(UIManager.getColor("Button.background"));
		
		//////////// one single request ////////////
		// will create an individual class later
		
		
		JButton trainingButton = new JButton(name);
		trainingButton.setForeground(Color.BLACK);
		trainingButton.setBounds(0, 0, 800, 70);
		trainingButton.setPreferredSize(new Dimension(800, 70));
		trainingButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				list.removeAll();
				list.add(new IndividualReport());
		        list.repaint();
				list.revalidate();
		
			}
			
		});

		setLayout(null);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.setFocusPainted(false);
		add(trainingButton);
		
		

	}
}