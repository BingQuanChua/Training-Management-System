package controllertrainer;

import java.util.ArrayList;

import modeltraining.TrainingCourseSearch;
import modeltraining.TrainingProgressModel;
import modeluser.TrainerModel;
import viewtrainer.TrainerUI;
import viewtrainer.Training;
import viewtrainer.TrainingProgress;

public class TrainingProgressController {
	
	private TrainerUI trainerUI;
	private TrainerModel trainerModel;
	private TrainingCourseSearch courseSearch;
	private TrainingProgressModel progressModel;
	
	public TrainingProgressController(TrainerUI trainerUI, 
									  TrainingCourseSearch courseSearch,
									  TrainerModel trainerModel) {
		
		this.trainerUI = trainerUI;
		this.trainerModel = trainerModel;
		this.courseSearch = courseSearch;
		progressModel = new TrainingProgressModel();
		
		setTrainingProgress();
	}
	
	public void setTrainingProgress() {
		
		ArrayList <String> assignedCourseList = new ArrayList<>();
		ArrayList <String> enrolledTraineeList = new ArrayList<>();
		courseSearch.getAssignedTrainingCourseID(trainerModel.getTrainerID(), assignedCourseList);
		try {
			for(int i = 0;  i< assignedCourseList.size(); i++) {			
				
				String courseID = assignedCourseList.get(i);
				String courseName = courseSearch.getTrainingCourseDetails(courseID, 2);
				
				// set all assigned training
				trainerUI.addTrainingProgress(courseID, courseName);
				
				// set all trainee progress
				enrolledTraineeList.clear();
				courseSearch.getEnrolledTraineeID(courseID, enrolledTraineeList);
				
				for(int j = 0; j < enrolledTraineeList.size(); j++) {
					
					String traineeID = enrolledTraineeList.get(j);
					((TrainingProgress) trainerUI
							.getTrainingProgressList()
							.getItem(i))
								.addProgress(
										traineeID, 
										trainerModel.getUserProfile(traineeID, 1), 
										progressModel.calculateProgress(traineeID, courseID));
				}
				
				// setting listeners to the buttons
					
			}
		} catch (Exception e) {
			System.out.println("setTrainingProgress Fail");
		}
	}
	
	
}
