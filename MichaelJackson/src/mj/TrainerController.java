package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class TrainerController {
	private TrainerUI trainerUI;
	
	private TrainingMaterialDetails tempTrainingMaterialDetails;
	private TrainingRequestList tempRequestList;
	private TrainingTraineeList tempTraineeList;
	
	public TrainerController(TrainerUI trainerUI) {
		this.trainerUI = trainerUI;
		setManageTrainingCourseListener();
        setTrainingProgressListener();
	}
	
	public void setManageTrainingCourseListener() {
		List temp = trainerUI.getTrainingList();
		// will change
		// items here are Training
		JPanel tempTraining = temp.getItem(0);
		tempTrainingMaterialDetails = ((Training) tempTraining).getTrainingMaterialDetails();
		tempRequestList = ((Training) tempTraining).getTrainingRequestList();
		tempTraineeList = ((Training) tempTraining).getTrainingTraineeList();
		((Training) tempTraining).getUpdateButton().addActionListener(updateButtonListener);
		((Training) tempTraining).getRequestButton().addActionListener(requestButtonListener);
		((Training) tempTraining).getTraineeListButton().addActionListener(traineeListButtonListener);
	}
	
	public void setTrainingProgressListener() {
		
	}
	
	ActionListener updateButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			trainerUI.getPanelBody().removeAll();
			trainerUI.getPanelBody().add(tempTrainingMaterialDetails);
			trainerUI.getPanelBody().repaint();
			trainerUI.getPanelBody().revalidate();
		}
	};
	
	ActionListener requestButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			trainerUI.getPanelBody().removeAll();
			trainerUI.getPanelBody().add(tempRequestList);
			trainerUI.getPanelBody().repaint();
			trainerUI.getPanelBody().revalidate();
		}
	};
	
	ActionListener traineeListButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			trainerUI.getPanelBody().removeAll();
			trainerUI.getPanelBody().add(tempTraineeList);
			trainerUI.getPanelBody().repaint();
			trainerUI.getPanelBody().revalidate();
		}
	};
}
