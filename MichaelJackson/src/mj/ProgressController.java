package mj;

import modeltraining.TrainingProgress; 
import viewtrainee.*;

public class ProgressController {
	
	TraineeUI traineeUI;
	String traineeID;
	String traineeName;
	TrainingProgress progressModel;
	
	
	ProgressController(TraineeUI traineeUI, String traineeID){
		
		this.traineeUI = traineeUI;
		this.traineeID = traineeID;
		progressModel = new TrainingProgress(); 
		setTraineeProgress(0);
		
	}
	
	public void setTraineeProgress(int i) {
		
		EnrolledTraining tempET = (EnrolledTraining)traineeUI.getEnrolledTrainingList().getItem(i); 
		EnrolledTrainingDetails tempETD = (EnrolledTrainingDetails)tempET.getTrainingDetails();
		String courseID = tempETD.getCourseID();
		int progress = progressModel.calculateProgress(traineeID, courseID);
		tempETD.getIndividualProgress().setIndividualProgress(traineeName, traineeID, progress); //each trainee has one progress only in every course
		 
	}
	
}
