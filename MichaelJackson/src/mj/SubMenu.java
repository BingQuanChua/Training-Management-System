package mj;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public SubMenu(String title, JPanel panel) {
		
		JLabel titleLabel = new JLabel("    " + title);
		titleLabel.setBackground(new java.awt.Color(155, 156, 237));
		titleLabel.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
		titleLabel.setOpaque(true);
		
		//JPanel panel = new JPanel(); // this line is for testing purposes :D
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addGap(12)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
					.addGap(93))
		);
		setLayout(layout);
		setBackground(new Color(255, 255, 200));
	}
}
