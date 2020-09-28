package ViewTrainee;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnrolledTrainingMaterial extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField titleField;
	private JTextArea txtrDescription;
	private JButton doneButton;
	
	private String title;
	private String description;
	private boolean isDone = false;
	
	Font heading4 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public EnrolledTrainingMaterial() {
		setPreferredSize(new Dimension(800, 115));
		setLayout(null);
		
		titleField = new JTextField();
		titleField.setFont(heading4);
		titleField.setText("Title");
		titleField.setBounds(5, 5, 635, 30);
		add(titleField);
		titleField.setColumns(100);
		titleField.setEditable(false);
		
		txtrDescription = new JTextArea();
		txtrDescription.setFont(heading4);
		txtrDescription.setText("Description");
		txtrDescription.setBounds(5, 35, 635, 75);
		JScrollPane scrollPane = new JScrollPane(txtrDescription);
		scrollPane.setSize(635, 75);
		scrollPane.setLocation(5, 35);
		add(scrollPane);
		txtrDescription.setEditable(false);
		txtrDescription.setLineWrap(true);
		
		doneButton = new JButton("Mark As Done");
		doneButton.setFont(heading4);
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "This button can only be clicked once. Are you sure about that?", "Complete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					doneButton.setEnabled(false);
					// update progress bar
				}
				
			}
		});
		doneButton.setBounds(645, 30, 150, 55);
		add(doneButton);
		
		JButton background = new JButton();
		background.setEnabled(false);
		background.setBounds(0, 0, 800, 115);
		add(background);
	}

}
