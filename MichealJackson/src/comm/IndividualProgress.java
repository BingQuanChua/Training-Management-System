package comm;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IndividualProgress extends JPanel {

	/**
	 * This panel holds a progress bar for an individual trainee in a single training
	 */
	private JProgressBar progressBar;
	Font f2 = new Font(Font.DIALOG, Font.PLAIN, 15);
	
	public IndividualProgress(String name, int progress) {
		
		setPreferredSize(new Dimension(550, 60));
		setLayout(null);
		
		JButton nameButton = new JButton(name);
		nameButton.setFont(f2);
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nameButton.setBorder(null);
		nameButton.setBackground(SystemColor.menu);
		nameButton.setFocusPainted(false);
		nameButton.setBounds(0, 0, 150, 60);
		add(nameButton);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setBounds(150, 10, 400, 40);
		progressBar.setValue(progress); // set progress 0-100
		progressBar.setStringPainted(true);
		add(progressBar);

	}
	
	public void setProgress(int p) {
		progressBar.setValue(p);
	}

}
