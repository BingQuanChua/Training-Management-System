package controllertrainee;

import java.util.ArrayList;

import modeltraining.TrainingCourseSearch;
import viewtrainee.TraineeUI;

public class AvailableCourseController {
	
	ArrayList<String> availableCourseList;
	TrainingCourseSearch courseModel;
	TraineeUI traineeUI;
	
	public AvailableCourseController(ArrayList<String> availableCourseList,
								  	TrainingCourseSearch courseModel,
								  	TraineeUI traineeUI) {
		
		this.availableCourseList = availableCourseList;
		this.courseModel = courseModel;
		this.traineeUI = traineeUI;
		
		setAvailableTrainingCourse();
		addAvailableTrainingCourseListener();
		
	}
	
	public void setAvailableTrainingCourse() {

		availableCourseList = new ArrayList<>();		
		String courseID; String courseName; String courseDesc;
		String trainerID; String trainerName;

		try {
			// set Available Course
			courseModel.getAllTrainingCourseID(availableCourseList);
			for(int i = 0;  i< availableCourseList.size(); i++) {

				courseID = availableCourseList.get(i);
				trainerID = courseModel.getTrainingCourseDetails(courseID, 1);
				courseName = courseModel.getTrainingCourseDetails(courseID, 2);
				courseDesc = courseModel.getTrainingCourseDetails(courseID, 3);
				trainerName = courseModel.getTrainingCourseDetails(trainerID, 5);
				traineeUI.addAvailableTraining(courseID, courseName, courseDesc, 
						trainerID, trainerName);

				// add listener
				addAvailableTrainingCourseListener();

			}
		} catch (Exception e) {
			System.out.println("setAvailableTrainingCourse Fail");
		}
	}
	
	private void addAvailableTrainingCourseListener() {
		
	}

}
