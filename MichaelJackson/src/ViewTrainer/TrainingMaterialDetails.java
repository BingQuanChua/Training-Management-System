	package ViewTrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import View.ListPanel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

public class TrainingMaterialDetails extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton addNewMaterialButton;
	private ListPanel trainingMaterialList;
	
	Font heading1 = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	Font heading3 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	Font heading4 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public TrainingMaterialDetails(String trainingName) {
		setBackground(new Color(255, 255, 200));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 200));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 0};
		gridBagLayout.rowHeights = new int[]{1, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		
		// creating an upper panel which does not resize
		////// start of upperPanel creation //////
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setBackground(new Color(255, 255, 200));
		upperPanel.setPreferredSize(new Dimension(1000, 440));
		
		JLabel trainingLabel = new JLabel(trainingName);
		trainingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trainingLabel.setFont(heading1);
		trainingLabel.setBounds(0, 0, 1000, 80);
		upperPanel.add(trainingLabel);
		
		JLabel label1 = new JLabel("Training Course Description");
		label1.setFont(heading2);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(100, 85, 800, 50);
		upperPanel.add(label1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(heading3);
		textArea.setBounds(100, 135, 800, 125);
		textArea.setText("Description for " + trainingName + ".");
		textArea.setEditable(false);
		upperPanel.add(textArea);
		
		JLabel label2 = new JLabel("Training Course Materials");
		label2.setFont(heading2);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(100, 310, 800, 50);
		upperPanel.add(label2);
		
		addNewMaterialButton = new JButton("+ Add New Material");
		addNewMaterialButton.setFont(heading3);
		addNewMaterialButton.setBounds(100, 360, 800, 80);
		
		upperPanel.add(addNewMaterialButton);
		////// end of upperPanel creation //////
		
		// creating a list of materials
		trainingMaterialList = new ListPanel(); 
		trainingMaterialList.setBackground(new Color(255,255,200));
		trainingMaterialList.addItem(new TrainingMaterial()); 
		////// end of list creation //////
			
		// adding both panels into this panel
		GridBagConstraints gbc_upperPanel = new GridBagConstraints();
		gbc_upperPanel.anchor = GridBagConstraints.CENTER;
		gbc_upperPanel.fill = GridBagConstraints.NORTH;
		gbc_upperPanel.gridx = 0;
		gbc_upperPanel.gridy = 0;
		panel.add(upperPanel, gbc_upperPanel);
		GridBagConstraints gbc_trainingMaterialList = new GridBagConstraints();
		gbc_trainingMaterialList.anchor = GridBagConstraints.CENTER;
		gbc_trainingMaterialList.fill = GridBagConstraints.NORTH;
		gbc_trainingMaterialList.gridx = 0;
		gbc_trainingMaterialList.gridy = 1;
		panel.add(trainingMaterialList, gbc_trainingMaterialList);
		
		add(panel);
	}
	
	public JButton getAddNewMaterialButton() {
		return addNewMaterialButton;
	}
	
	public ListPanel getTrainingMaterialList() {
		return trainingMaterialList;
	}
}
