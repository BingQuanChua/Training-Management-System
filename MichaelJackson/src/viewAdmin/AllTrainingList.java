package viewAdmin;

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

public class AllTrainingList extends JPanel {
	
	public AdminUI adminUI;
	/**
	 * Showing a list of all training
	 */
	public AllTrainingList(AdminUI adminUI) {
		this.adminUI = adminUI;
		setBackground(new Color(255, 255, 200));
		setPreferredSize(new Dimension(1000, 1080));	
		
		JPanel list = new JPanel();
		GridBagLayout gbl_list = new GridBagLayout();
		gbl_list.columnWidths = new int[]{610, 0};
		gbl_list.rowHeights = new int[]{60, 0};
		gbl_list.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_list.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		list.setLayout(gbl_list);
		
		JButton btnAdd = new JButton("+ Add New Training Course");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(new Color(240,240,240));
		btnAdd.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnAdd.setPreferredSize(new Dimension(800, 70));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				list.removeAll();
				list.add(new AddNewCourse(adminUI));
		        list.repaint();
				list.revalidate();
		
			}
			
		});
		GridBagConstraints gbc_r0 = new GridBagConstraints();
		gbc_r0.anchor = GridBagConstraints.CENTER;
		gbc_r0.insets = new Insets(0, 0,5, 0);
		gbc_r0.gridx = 0;
		gbc_r0.gridy = 0;
		
		list.add(btnAdd, gbc_r0);
		
		ManageTraining r1 = new ManageTraining("Python Advance Training Course",list,adminUI);
		GridBagConstraints gbc_r1 = new GridBagConstraints();
		gbc_r1.anchor = GridBagConstraints.CENTER;
		gbc_r1.insets = new Insets(0, 0, 5, 0);
		gbc_r1.gridx = 0;
		gbc_r1.gridy = 1;
		list.add(r1, gbc_r1);
		
		ManageTraining r2 = new ManageTraining("Software Engineering with Java",list,adminUI);
		GridBagConstraints gbc_r2 = new GridBagConstraints();	
		gbc_r2.anchor = GridBagConstraints.NORTHWEST;
		gbc_r2.insets = new Insets(0, 0, 5, 0);
		gbc_r2.gridx = 0;
		gbc_r2.gridy = 2;
		list.add(r2, gbc_r2);
		
		ManageTraining r3 = new ManageTraining("Introduction to OOPDS",list,adminUI);
		GridBagConstraints gbc_r3 = new GridBagConstraints();
		gbc_r3.anchor = GridBagConstraints.NORTHWEST;
		gbc_r3.gridx = 0;
		gbc_r3.gridy = 3;
		list.add(r3, gbc_r3);
		
		add(list);

	}
}
