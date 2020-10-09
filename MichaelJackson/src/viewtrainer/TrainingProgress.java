package viewtrainer;

import javax.swing.JPanel;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

import view.IndividualProgress;
import view.ListPanel;

public class TrainingProgress extends JPanel {

	/**
	 * This panel holds all the individual training progresses of a single training.
	 */
	
	private ListPanel progressList;
	private JButton trainingButton;
	
	private boolean extend = false;
	private int extendedHeight = 430;
	private int retractedHeight = 70;
	private String trainingID;
	
	Font heading2 = new Font(Font.SANS_SERIF, Font.PLAIN, 22);
	
	public TrainingProgress(String trainingID, String trainingName) {
		
		setPreferredSize(new Dimension(800, retractedHeight));
		setLayout(null);
		
		this.trainingID = trainingID;
		
		trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trainingButton.setBounds(0, 0, 800, 70);
		add(trainingButton);
		
		progressList = new ListPanel();
		progressList.setBackground(new Color(230, 230, 250));
		
		JScrollPane scrollPane = new JScrollPane(progressList);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 70, 800, 360);
		add(scrollPane);
			
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
	
	public void addProgress(String traineeID, String traineeName, int progress) {
		IndividualProgress p = new IndividualProgress(traineeName, traineeID, progress);
		progressList.addItem(p);
	}
	
	public String getCourseID() {
		return trainingID;
	}
}
