package comm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

;

public class Training extends JPanel {

	/**
	 * This panel holds a single training panel.
	 */
	
	private boolean extend = false;
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	
	public Training(String trainingName) {
		
		setPreferredSize(new Dimension(600, 60));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		JButton trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(new Color(255, 165, 0));
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trainingButton.setBounds(0, 0, 600, 60);
		add(trainingButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(492, 65, 75, 87);
		add(editButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(244, 164, 96));
		textPane.setBounds(60, 65, 425, 90);
		add(textPane);
		textPane.setText("Description for " + trainingName + ".");
		
		JButton feedbackButton = new JButton("Feedback");
		feedbackButton.setBounds(60, 265, 510, 30);
		add(feedbackButton);
		
		JButton requestButton = new JButton("Training Requests");
		requestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		requestButton.setBounds(60, 195, 510, 30);
		add(requestButton);
		
		JButton traineeListButton = new JButton("List of Trainees");
		traineeListButton.setBounds(60, 230, 510, 30);
		add(traineeListButton);
		
		JButton updateButton = new JButton("Update Material");
		updateButton.setBounds(60, 160, 510, 30);
		add(updateButton);
		
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
                setPreferredSize(new Dimension(600, 310));
                
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
                setPreferredSize(new Dimension(600, 60));
                
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
}
