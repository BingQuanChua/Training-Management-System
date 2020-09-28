package view;

import javax.swing.JPanel; 

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;

public class Icon extends JPanel {

	/**
	 * Create the panel.
	 */
	public Icon() {
		setLayout(new BorderLayout());
		setBackground(new Color(255, 255, 200));
		setPreferredSize(new Dimension(320, 320));
		
		JLabel iconLabel = new JLabel("");
		try {
			File iconPath = new File("src/images/icon.png");
			Image originalIcon = ImageIO.read(iconPath);
        	Image icon = originalIcon.getScaledInstance(320, 320, Image.SCALE_DEFAULT);
        	iconLabel.setIcon(new ImageIcon(icon));
        }
        catch (Exception ex) {
        	System.out.println("Icon Image not found");
        }
		iconLabel.setVerticalAlignment(JLabel.CENTER);
		iconLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// setLayout(null);	
		// iconLabel.setBounds(700, 280, 320, 320);
		add(iconLabel, BorderLayout.CENTER);

	}
}
