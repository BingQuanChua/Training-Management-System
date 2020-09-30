package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.ListPanel;
import viewtrainer.TrainerUI;
import viewtrainer.Training;
import viewtrainer.TrainingMaterial;
import viewtrainer.TrainingMaterialDetails;
import viewtrainer.TrainingRequestList;
import viewtrainer.TrainingTraineeList;

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
	
	private void setManageTrainingCourseListener() {
		// will change, suppose to loop data from database
		// items here are Training
		Training tempTraining = (Training) trainerUI.getTrainingList().getItem(0);
		tempTrainingMaterialDetails = tempTraining.getTrainingMaterialDetails();
		tempRequestList = tempTraining.getTrainingRequestList();
		tempTraineeList = tempTraining.getTrainingTraineeList();
		tempTraining.getUpdateButton().addActionListener(updateButtonListener);
		tempTrainingMaterialDetails.getAddNewMaterialButton().addActionListener(addNewTrainingMaterialButtonListener);
		tempTraining.getRequestButton().addActionListener(requestButtonListener);
		tempTraining.getTraineeListButton().addActionListener(traineeListButtonListener);
	}
	
	private void setTrainingProgressListener() {
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
