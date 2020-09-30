package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.IndividualProgress;
import viewtrainee.EnrolledTraining;
import viewtrainee.EnrolledTrainingDetails;
import viewtrainee.TraineeUI;

public class TraineeController {
	private TraineeUI traineeUI;
	
	private EnrolledTrainingDetails tempEnrolledTrainingDetails;
	private IndividualProgress tempProgressBar;
	
	TraineeController(TraineeUI traineeUI){
		this.traineeUI = traineeUI;
		setAvailableTrainingCourseListener();
		setEnrolledTrainingCourseListener();
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
		// tempProgress
		//eedbackButton
		//tempMaterialList
	
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

}
