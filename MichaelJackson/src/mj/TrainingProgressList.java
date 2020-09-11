package mj;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TrainingProgressList extends JPanel {

	/**
	 * This panel holds a list of TrainingProgress s
	 * 
	 * TrainingProgressList : list of progress bars of all the trainings
	 * 			|
	 * Training Progress : progress bars of one single training
	 * 			|
	 * Individual Progress : one single progress bar
	 */
	
	private JPanel list;
	private ArrayList<TrainingProgress> trainingProgressList;
	
	public TrainingProgressList() {
		
		
		trainingProgressList = new ArrayList<>();
		list = new JPanel();
		list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));
		
		addTrainingProgress(new TrainingProgress("Python Advance Training Course"));
		addTrainingProgress(new TrainingProgress("Software Engineering with Java"));
		addTrainingProgress(new TrainingProgress("Introduction to OOPDS"));
		
		setBackground(new Color(255, 255, 200));
		add(list);
	}
	
	private void addTrainingProgress(TrainingProgress tp) {
		trainingProgressList.add(tp);
		list.add(tp);
		list.revalidate();
	}

}
