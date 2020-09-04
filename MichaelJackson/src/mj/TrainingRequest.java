package mj;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class TrainingRequest extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);
	/**
	 * 
	 */
	public TrainingRequest(String name) {
		
		setPreferredSize(new Dimension(600, 60));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		//////////// one single request ////////////
		// will create an individual class later
		JButton acceptButton = new JButton("Accept");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		acceptButton.setBounds(390, 15, 90, 30);
		add(acceptButton);
		
		JButton rejectButton = new JButton("Reject");
		rejectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rejectButton.setBounds(490, 15, 90, 30);
		add(rejectButton);
		
		JButton profileButton = new JButton(name);
		profileButton.setFont(f1);
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileButton.setBorder(null);
		profileButton.setBackground(SystemColor.menu);
		profileButton.setFocusPainted(false);
		profileButton.setBounds(0, 0, 380, 60);
		add(profileButton);
		
		//////////// end of one single request ////////////

	}
}