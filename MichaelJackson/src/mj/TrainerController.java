package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.ListPanel;
import viewTrainer.TrainerUI;
import viewTrainer.Training;
import viewTrainer.TrainingMaterial;
import viewTrainer.TrainingMaterialDetails;
import viewTrainer.TrainingRequestList;
import viewTrainer.TrainingTraineeList;

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
		ListPanel temp = trainerUI.getTrainingList();
		// will change, suppose to loop data from database
		// items here are Training
		JPanel tempTraining = temp.getItem(0);
		tempTrainingMaterialDetails = ((Training) tempTraining).getTrainingMaterialDetails();
		tempRequestList = ((Training) tempTraining).getTrainingRequestList();
		tempTraineeList = ((Training) tempTraining).getTrainingTraineeList();
		((Training) tempTraining).getUpdateButton().addActionListener(updateButtonListener);
		tempTrainingMaterialDetails.getAddNewMaterialButton().addActionListener(addNewTrainingMaterialButtonListener);
		((Training) tempTraining).getRequestButton().addActionListener(requestButtonListener);
		((Training) tempTraining).getTraineeListButton().addActionListener(traineeListButtonListener);
	}
	
	public void setTrainingProgressListener() {
		// should allow trainer to view trainee profile
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
	
	ActionListener addNewTrainingMaterialButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			tempTrainingMaterialDetails.getTrainingMaterialList().addItem(new TrainingMaterial());
			tempTrainingMaterialDetails.getTrainingMaterialList().repaint();
			tempTrainingMaterialDetails.getTrainingMaterialList().revalidate();
		}
	};
}
