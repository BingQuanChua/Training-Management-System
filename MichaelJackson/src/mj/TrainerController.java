package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import modeluser.TrainerModel;
import view.ListPanel;
import viewtrainer.TrainerUI;
import viewtrainer.Training;
import viewtrainer.TrainingMaterial;
import viewtrainer.TrainingMaterialDetails;
import viewtrainer.TrainingRequestList;
import viewtrainer.TrainingTraineeList;

public class TrainerController {
	private TrainerUI trainerUI;
	private TrainerModel trainerModel;
	
	private TrainingMaterialDetails tempTrainingMaterialDetails;
	private TrainingRequestList tempRequestList;
	private TrainingTraineeList tempTraineeList;

	
	public TrainerController(TrainerUI trainerUI, TrainerModel trainerModel) {
		this.trainerUI = trainerUI;
		this.trainerModel = trainerModel;
		setManageTrainingCourseListener();
        setTrainingProgressListener();
	}
	
	private void setManageTrainingCourseListener() {
		// looping from database, getting data
//		while () {
//
//			System.out.println();
//		}
		
		
		
		
		
		
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
