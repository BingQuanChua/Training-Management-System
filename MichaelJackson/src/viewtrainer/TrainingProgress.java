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

public class TrainingProgress extends JPanel {

	/**
	 * This panel holds all the individual training progresses of a single training.
	 */
	
	private JPanel list;
	private ArrayList<IndividualProgress> progressList;
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
		progressList = new ArrayList<>();
		
		trainingButton = new JButton(trainingName);
		trainingButton.setFont(heading2);
		trainingButton.setBackground(Color.LIGHT_GRAY);
		trainingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trainingButton.setBounds(0, 0, 800, 70);
		add(trainingButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 70, 800, 360);
		add(scrollPane);
		
		list = new JPanel();
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
		scrollPane.setViewportView(list);
	
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
		progressList.add(p);
		list.add(p);
		list.revalidate();
	}
	
	public String getCourseID() {
		return trainingID;
	}
}
