package viewadmin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import view.ListPanel;

public class AllTrainingList extends JPanel {
	/**
	 * Showing a list of all training
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton addNewTrainingButton;
	private ListPanel trainingList; 
	
	public AllTrainingList() {
		
		setBackground(new Color(255, 255, 200));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 200));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1, 0};
		gridBagLayout.rowHeights = new int[]{1, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setBackground(new Color(255, 255, 200));
		upperPanel.setPreferredSize(new Dimension(800, 70));
		
		addNewTrainingButton = new JButton("+ Add New Training Course");
		addNewTrainingButton.setForeground(Color.BLACK);
		addNewTrainingButton.setBackground(new Color(240,240,240));
		addNewTrainingButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		addNewTrainingButton.setBounds(0, 0, 800, 70);
		upperPanel.add(addNewTrainingButton);
//		addNewTraningButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				removeAll();
//				add(new AddNewCourse(adminUI));
//		        repaint();
//				revalidate();
//			}	
//		});
		
		trainingList = new ListPanel();
		trainingList.addItem(new ManageTraining("Python Advance Training Course"));
		trainingList.addItem(new ManageTraining("Software Engineering with Java"));
		trainingList.addItem(new ManageTraining("Python Advance Training Course"));
		
		GridBagConstraints gbc_upperButton = new GridBagConstraints();
		gbc_upperButton.anchor = GridBagConstraints.CENTER;
		gbc_upperButton.fill = GridBagConstraints.NORTH;
		gbc_upperButton.gridx = 0;
		gbc_upperButton.gridy = 0;
		panel.add(upperPanel, gbc_upperButton);
		GridBagConstraints gbc_trainingList = new GridBagConstraints();
		gbc_trainingList.anchor = GridBagConstraints.CENTER;
		gbc_trainingList.fill = GridBagConstraints.NORTH;
		gbc_trainingList.gridx = 0;
		gbc_trainingList.gridy = 1;
		panel.add(trainingList, gbc_trainingList);
		
		add(panel);
	}
	
	public JButton getAddNewTrainingButton() {
		return addNewTrainingButton;
	}
	
	public ListPanel getTrainingList() {
		return trainingList;
	}
}
