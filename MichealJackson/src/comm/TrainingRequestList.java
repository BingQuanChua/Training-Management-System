package comm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class TrainingRequestList extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrainingRequestList() {
		setBackground(UIManager.getColor("Button.darkShadow"));
		setPreferredSize(new Dimension(850, 400));	
		
		JPanel list = new JPanel();
		GridBagLayout gbl_list = new GridBagLayout();
		gbl_list.columnWidths = new int[]{610, 0};
		gbl_list.rowHeights = new int[]{60, 0};
		gbl_list.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_list.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		list.setLayout(gbl_list);
		
		TrainingRequest r1 = new TrainingRequest("Keanu Reeves");
		GridBagConstraints gbc_r1 = new GridBagConstraints();
		gbc_r1.anchor = GridBagConstraints.NORTHWEST;
		gbc_r1.insets = new Insets(0, 0, 5, 0);
		gbc_r1.gridx = 0;
		gbc_r1.gridy = 0;
		list.add(r1, gbc_r1);
		
		TrainingRequest r2 = new TrainingRequest("Bryan Cranston");
		GridBagConstraints gbc_r2 = new GridBagConstraints();
		gbc_r2.anchor = GridBagConstraints.NORTHWEST;
		gbc_r2.insets = new Insets(0, 0, 5, 0);
		gbc_r2.gridx = 0;
		gbc_r2.gridy = 1;
		list.add(r2, gbc_r2);
		
		TrainingRequest r3 = new TrainingRequest("Rami Malek");
		GridBagConstraints gbc_r3 = new GridBagConstraints();
		gbc_r3.anchor = GridBagConstraints.NORTHWEST;
		gbc_r3.gridx = 0;
		gbc_r3.gridy = 2;
		list.add(r3, gbc_r3);
		
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		

	}
}
