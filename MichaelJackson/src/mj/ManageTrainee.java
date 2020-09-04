package mj;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

public class ManageTrainee extends JPanel {

	private static final long serialVersionUID = 1L;

	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);

	public ManageTrainee(String name) {

		setPreferredSize(new Dimension(839, 60));
		setBackground(Color.WHITE);
		setLayout(null);

		JButton deleteButton = new JButton("X");
		deleteButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		deleteButton.setBackground(Color.DARK_GRAY);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setBorder(null);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteButton.setBounds(642, 0, 52, 53);
		add(deleteButton);

		JButton profileButton = new JButton(name);
		profileButton.setForeground(Color.DARK_GRAY);
		profileButton.setFont(f1);
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileButton.setBorder(null);
		profileButton.setBackground(Color.WHITE);
		profileButton.setFocusPainted(false);
		profileButton.setBounds(0, 0, 380, 60);
		add(profileButton);

		//////////// end of one single request ////////////

	}
}