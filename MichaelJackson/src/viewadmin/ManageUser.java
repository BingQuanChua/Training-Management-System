package viewadmin;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManageUser extends JPanel {
	/**
	 * Manage all users in the system
	 */
	private static final long serialVersionUID = 1L;
	Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

	public ManageUser(String name, int number) {

		setPreferredSize(new Dimension(1070, 60));
		setBackground(Color.WHITE);
		setLayout(null);

		JButton deleteButton = new JButton("X");
		deleteButton.setFont(new Font("SansSerif", Font.PLAIN, 25));
		deleteButton.setBackground(new Color(205,133,63));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setBorder(null);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteButton.setBounds(639, 2, 52, 53);
		add(deleteButton);

		JButton profileButton = new JButton(name);
		profileButton.setForeground(Color.BLACK);
		profileButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		profileButton.setBorder(null);
		profileButton.setBackground(Color.WHITE);
		profileButton.setFocusPainted(false);
		profileButton.setBounds(75, 1, 450, 58);
		add(profileButton);
		
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(f1);
		label.setBounds(12, 6, 56, 50);
		add(label);
		label.setText(number+".");
		
		JButton background = new JButton();
		background.setForeground(Color.BLACK);
		background.setEnabled(false);
		background.setBounds(0, 0, 800, 60);
		add(background);

		//////////// end of one single request ////////////

	}
}