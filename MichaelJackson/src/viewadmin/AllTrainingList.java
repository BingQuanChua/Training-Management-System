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
	public ListPanel trainingList; 
	public AdminUI adminUI;
	/**
	 * Showing a list of all training
	 */
	public AllTrainingList(AdminUI adminUI) {
		trainingList = new ListPanel();
		this.adminUI = adminUI;
		setBackground(new Color(255, 255, 200));
		setPreferredSize(new Dimension(1000, 1080));	
		
		JButton btnAdd = new JButton("+ Add New Training Course");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(new Color(240,240,240));
		btnAdd.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnAdd.setPreferredSize(new Dimension(300, 45));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new AddNewCourse(adminUI));
		        repaint();
				revalidate();
			}	
		});
		GridBagConstraints gbc_r0 = new GridBagConstraints();
		gbc_r0.anchor = GridBagConstraints.CENTER;
		gbc_r0.gridx = 0;
		gbc_r0.gridy = 2;
		add(btnAdd, gbc_r0);
		
		trainingList.addItem(new ManageTraining("Python Advance Training Course",this,adminUI));
		trainingList.addItem(new ManageTraining("Software Engineering with Java",this,adminUI));
		trainingList.addItem(new ManageTraining("Python Advance Training Course",this,adminUI));
		add(trainingList);
	}
}
