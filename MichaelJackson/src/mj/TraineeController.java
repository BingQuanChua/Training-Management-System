package mj;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeltraining.TrainingCourseGetterModel;
import modeluser.TraineeModel;
import view.IndividualProgress;
import view.ListPanel;
import viewtrainee.EnrolledTraining;
import viewtrainee.EnrolledTrainingDetails;
import viewtrainee.EnrolledTrainingMaterial;
import viewtrainee.TraineeUI;

public class TraineeController {
	
	private TraineeUI traineeUI;
	private TraineeModel traineeModel;
	private TrainingCourseGetterModel trainingCourseGetterModel;
	
	private EnrolledTrainingDetails tempEnrolledTrainingDetails;
	private IndividualProgress tempProgressBar;
	private ListPanel tempTrainingMaterialList;
	
	TraineeController(TraineeUI traineeUI, TraineeModel traineeModel){
		this.traineeUI = traineeUI;
		this.traineeModel = traineeModel;
		trainingCourseGetterModel = new TrainingCourseGetterModel();
		setAvailableTrainingCourse();
		setEnrolledTrainingCourse();
		setAvailableTrainingCourseListener();
		setEnrolledTrainingCourseListener();
	}

	
	
	public void setAvailableTrainingCourse() {
		
		ArrayList <String> availableTrainingCourseList = new ArrayList<>();
		trainingCourseGetterModel.getAllTrainingCourseID(availableTrainingCourseList);
		try {
			for(int i = 0;  i< availableTrainingCourseList.size(); i++) {

				traineeUI.addAvailableTraining(
						trainingCourseGetterModel.getTrainingCourseDetails(availableTrainingCourseList.get(i), 2), 
						availableTrainingCourseList.get(i));
			}
		} catch (Exception e) {
			System.out.println("setAvailableTrainingCourse Fail");
		}
		
	}
	
	public void setEnrolledTrainingCourse() {
		
		ArrayList <String> enrolledTrainingCourseList = new ArrayList<>();
		trainingCourseGetterModel.getEnrolledTrainingCourseID(traineeModel.getTraineeID(), enrolledTrainingCourseList);
		try {
			for(int i = 0;  i< enrolledTrainingCourseList.size(); i++) {
				
				traineeUI.addEnrolledTraining(
						trainingCourseGetterModel.getTrainingCourseDetails(enrolledTrainingCourseList.get(i), 2), 
						enrolledTrainingCourseList.get(i));
			}
		} catch (Exception e) {
			System.out.println("setEnrolledTrainingCourse Fail");
		}
	}
	
	
	private void setAvailableTrainingCourseListener() {
		
	}
	
	private void setEnrolledTrainingCourseListener() {
		// setListener to each of the EnrolledTraining
		// will change, need to loop here
		EnrolledTraining temp = (EnrolledTraining) traineeUI.getEnrolledTrainingList().getItem(0);
		temp.getEnrolledTrainingButton().addActionListener(trainingButtonListener);
		tempEnrolledTrainingDetails = temp.getTrainingDetails();
		// description text area update
		// trainee profile button listener
		// trainer profile button listener
		tempProgressBar = tempEnrolledTrainingDetails.getIndividualProgress();
		
		
		/*
		tempTrainingMaterialList = tempEnrolledTrainingDetails.getTrainingMaterialList();
		for (JPanel material : tempTrainingMaterialList.getListOfPanel()) {
			// add listener to each mark as done button on each training material
			addMarkAsDoneListener((EnrolledTrainingMaterial) material);
		}/**/
		// tempProgress
		// feedbackButton
		// tempMaterialList
	
	}
	
	ActionListener trainingButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			traineeUI.getPanelBody().removeAll();
			traineeUI.getPanelBody().add(tempEnrolledTrainingDetails);
			traineeUI.getPanelBody().repaint();
			traineeUI.getPanelBody().revalidate();
		}
	};
	
	/*
	private void addMarkAsDoneListener(EnrolledTrainingMaterial m) {
		m.getDoneButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "This button can only be clicked once. Are you sure about that?", "Complete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					m.getDoneButton().setEnabled(false);
					tempEnrolledTrainingDetails.increaseNumberOfCompletedMaterial(); // increase by 1
					int progress = (tempEnrolledTrainingDetails.getNumberOfCompletedMaterial()*100 / tempTrainingMaterialList.getListOfPanel().size());
					tempProgressBar.setProgress(progress);
					
					if(tempProgressBar.getProgress() == 100) {
						tempEnrolledTrainingDetails.getFeedbackButton().setVisible(true);
					}
				}
			}
		});
	}
	*/
}
