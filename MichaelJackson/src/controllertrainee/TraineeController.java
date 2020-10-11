package controllertrainee;

import java.util.ArrayList;

import modeltraining.TrainingCourseSearch;
import modeluser.TraineeModel;
import viewtrainee.TraineeUI;

public class TraineeController {
	
	private TraineeUI traineeUI;
	private TraineeModel traineeModel;
	private TrainingCourseSearch courseModel;
	
	private String traineeID;
	private ArrayList <String> availableCourseList;
	private ArrayList <String> enrolledCourseList;
	
	private AvailableCourseController availableCourseControl;
	private EnrolledCourseController enrolledCourseControl;
	
	public TraineeController(TraineeUI traineeUI, TraineeModel traineeModel){
		
		System.out.println("\n\n********************\n"
						 + "TraineeController\n\n");
		
		this.traineeUI = traineeUI;
		this.traineeModel = traineeModel;
		this.traineeID = traineeModel.getTraineeID();
		courseModel = new TrainingCourseSearch();
		
		System.out.println("\n\nsetEnrolledTrainingCourse\n");
		setEnrolledTrainingCourse(enrolledCourseList, courseModel, this.traineeModel, this.traineeUI);
		
		System.out.println("\n\nSetAvailableTrainingCourse\n");
		setAvailableTrainingCourse(availableCourseList, courseModel, this.traineeUI, this.enrolledCourseControl);
		
		System.out.println("\n\nTraineeController\n"
						 + "*********************\n");
	}
	
	
	public void setAvailableTrainingCourse(ArrayList<String> availableCourseList,
			  							   TrainingCourseSearch courseModel,
			  							   TraineeUI traineeUI,
			  							   EnrolledCourseController enrolledCourseControl) {
		
		availableCourseControl = 
				new AvailableCourseController(availableCourseList,
											  courseModel,
											  traineeUI,
											  enrolledCourseControl);
		
	}
	
	
	public void setEnrolledTrainingCourse(ArrayList<String> enrolledCourseList,
			 							  TrainingCourseSearch courseModel,
			 							  TraineeModel traineeModel,
			 							  TraineeUI traineeUI) {
		
		enrolledCourseControl = 
				new EnrolledCourseController(enrolledCourseList,
											 courseModel,
											 traineeModel,
											 traineeUI);
		
	}
	
}
