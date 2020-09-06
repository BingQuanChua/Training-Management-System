package mj;

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
	
	
	private JButton trainingButton;
	private JButton editButton;
	private JTextPane textPane;
	private JButton feedbackButton;
	private JButton requestButton;
	private JButton traineeListButton;
	private JButton updateButton;
	
	private boolean extend = false;
	
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	Font heading3 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	
	public Training(String trainingName) {
		
		setPreferredSize(new Dimension(800, 70));
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(new Color(255, 165, 0));
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trainingButton.setBounds(0, 0, 800, 70);
		add(trainingButton);
		
		textPane = new JTextPane();
		textPane.setFont(heading3);
		textPane.setBackground(new Color(244, 164, 96));
		textPane.setBounds(50, 75, 620, 100);
		add(textPane);
		textPane.setText("Description for " + trainingName + ".");
		
		editButton = new JButton("Edit");
		editButton.setFont(heading3);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editButton.setBounds(675, 75, 75, 100);
		add(editButton);
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setFont(heading3);
		feedbackButton.setBounds(50, 345, 700, 50);
		add(feedbackButton);
		
		requestButton = new JButton("Training Requests");
		requestButton.setFont(heading3);
		requestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 
			}
		});
		requestButton.setBounds(50, 235, 700, 50);
		add(requestButton);
		
		traineeListButton = new JButton("List of Trainees");
		traineeListButton.setFont(heading3);
		traineeListButton.setBounds(50, 290, 700, 50);
		add(traineeListButton);
		
		updateButton = new JButton("Update Material");
		updateButton.setFont(heading3);
		updateButton.setBounds(50, 180, 700, 50);
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
                setPreferredSize(new Dimension(800, 405));
                
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
                setPreferredSize(new Dimension(800, 70));
                
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
