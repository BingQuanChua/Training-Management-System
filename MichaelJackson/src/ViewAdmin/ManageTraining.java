package ViewAdmin;

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

public class ManageTraining extends JPanel {

	/**
	 * Manage all training courses
	 */
	private static final long serialVersionUID = 1L;

	Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);
	/**
	 * 
	 */
	public ManageTraining(String name,JPanel list) {

		setPreferredSize(new Dimension(800, 70));
		setBackground(UIManager.getColor("Button.background"));
		
		//////////// one single request ////////////
		// will create an individual class later
		
		
		JButton trainingButton = new JButton(name);
		trainingButton.setBounds(0, 0, 736, 70);
		trainingButton.setPreferredSize(new Dimension(800, 70));
		trainingButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				list.removeAll();
				list.add(new EditCourse());
		        list.repaint();
				list.revalidate();
		
			}
			
		});
		
		JButton deleteButton = new JButton("X");
		deleteButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		deleteButton.setBackground(new Color(205,133,63));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setBorder(null);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteButton.setBounds(735, 0, 65, 70);
		add(deleteButton);
		setLayout(null);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.setFocusPainted(false);
		add(trainingButton);


	}
}