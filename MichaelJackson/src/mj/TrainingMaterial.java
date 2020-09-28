package mj;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TrainingMaterial extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField titleField;
	private JTextArea txtrDescription;
	private JButton editButton;
	private JButton deleteButton;
	
	private String title;
	private String description;
	private boolean isEditing = false;
	
	Font heading4 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public TrainingMaterial() {
		
		setPreferredSize(new Dimension(800, 115));
		setLayout(null);
		
		titleField = new JTextField();
		titleField.setText("Title");
		titleField.setFont(heading4);
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
		
		editButton = new JButton("Edit");
		editButton.setFont(heading4);;
		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!isEditing) {
					titleField.setEditable(true);
					txtrDescription.setEditable(true);
					editButton.setText("Save");
					isEditing = true;
				}
				else {
					titleField.setEditable(false);
					txtrDescription.setEditable(false);
					editButton.setText("Edit");
					isEditing = false;
				}
			}
		});
		editButton.setBounds(645, 30, 100, 55);
		add(editButton);
		
		deleteButton = new JButton("X");
		deleteButton.setFont(heading4);
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this material?", "Delete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 1) {
					
				}
			}
		});
		deleteButton.setBounds(745, 30, 50, 55);
		add(deleteButton);
		
		JButton background = new JButton();
		background.setEnabled(false);
		background.setBounds(0, 0, 800, 115);
		add(background);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public JButton getDeleteButton() {
		return deleteButton;
	}

}
