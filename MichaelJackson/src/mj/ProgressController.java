package mj;

import modeltraining.TrainingProgressModel; 
import viewtrainee.*;

public class ProgressController {
	
	TraineeUI traineeUI;
	String traineeID;
	String traineeName;
	TrainingProgressModel progressModel;
	
	
	ProgressController(TraineeUI traineeUI, String traineeID){
		
		this.traineeUI = traineeUI;
		this.traineeID = traineeID;
		progressModel = new TrainingProgressModel(); 
		setTraineeProgress();
	}
	
	public void setTraineeProgress() {
		
		for(int i = 0; i < traineeUI.getEnrolledTrainingList().getListOfPanel().size(); i++ ) {
			EnrolledTraining tempET = (EnrolledTraining)traineeUI.getEnrolledTrainingList().getItem(i); 
			EnrolledTrainingDetails tempETD = (EnrolledTrainingDetails)tempET.getTrainingDetails();
			String courseID = tempETD.getCourseID();
			int progress = progressModel.calculateProgress(traineeID, courseID);
			tempETD.getIndividualProgress().setIndividualProgress(traineeName, traineeID, progress); //each trainee has one progress only in every course
		}
	}
	
}
