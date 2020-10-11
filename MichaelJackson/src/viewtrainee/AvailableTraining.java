package viewtrainee;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import view.JButtonID;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvailableTraining extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton trainingButton;
	private JButton enrollButton;
	private JTextPane textPane;
	private JButtonID trainerProfileButton;
	
	private boolean extend = false;
	private int extendedHeight = 275;
	private int retractedHeight = 70;
	
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	Font heading3 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public AvailableTraining(
			String courseID, String courseName, String courseDesc, 
			String trainerID, String trainerName) {
		
		setPreferredSize(new Dimension(800, retractedHeight));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		trainingButton = new JButton(courseName);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.setFont(heading2);
		trainingButton.setBounds(0, 0, 700, 70);
		add(trainingButton);
		
		enrollButton = new JButton("Enroll");
		enrollButton.setBackground(new Color(205,133,63));
		enrollButton.setFont(heading3);
		enrollButton.setBounds(700, 0, 100, 70);
		add(enrollButton);
		
		textPane = new JTextPane();
		textPane.setFont(heading3);
		textPane.setBackground(new Color(244, 164, 96));
		textPane.setBounds(90, 80, 620, 125);
		textPane.setEditable(false);
		add(textPane);
		textPane.setText(courseDesc);
		
		trainerProfileButton = new JButtonID(trainerName, trainerID);
		trainerProfileButton.setBackground(new Color(205,133,63));
		trainerProfileButton.setFont(heading3);
		trainerProfileButton.setBounds(510, 215, 200, 50);
		add(trainerProfileButton);
		
		JButton background = new JButton();
		background.setEnabled(false);
		background.setBounds(0, 0, 800, retractedHeight);
		add(background);
		
		trainingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!extend) { // not extended
					showMenu();
					extend = true; // become extended
				}
				else { // extended
					hideMenu();
					extend = false; // become not extended
				}
			}
		});	

	}
	
	private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                setPreferredSize(new Dimension(800, extendedHeight));
                
                getParent().revalidate();
                getParent().repaint();
            }
        }).start();
    }

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                setPreferredSize(new Dimension(800, retractedHeight));
                
                getParent().revalidate();
                getParent().repaint();
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
    
    public JButton getTrainingButton() {
    	return trainingButton;
    }
    
    public JButton getEnrollButton() {
    	return enrollButton;
    }
    
    public JButtonID getTrainerProfileButton() {
    	return trainerProfileButton;
    }
}
