package comm;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class ManageTrainingCourse extends JPanel {

	/**
	 * This panel holds a single training panel.
	 */

	private boolean extend = false;
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

	public ManageTrainingCourse(String trainingName) {

		setPreferredSize(new Dimension(600, 60));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);

		JButton trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(new Color(255, 165, 0));
		trainingButton.setBounds(0, 0, 600, 60);
		add(trainingButton);

		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				removeAll();
				add(new EditCourse());
				revalidate();
			}
		});
	
		
	}
}
