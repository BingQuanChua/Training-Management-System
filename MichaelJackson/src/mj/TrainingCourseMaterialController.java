package mj;

import java.util.ArrayList;

import modeltraining.ManageTrainingCourse;
import modeltraining.TrainingCourseSearch;
import view.ListPanel;
import viewadmin.ManageTraining;
import viewtrainer.Training;

public class TrainingCourseMaterialController {
	private String courseID;
	private Training training;
	private ListPanel trainingList;
	private ManageTrainingCourse trainingCourseModel;
	private TrainingCourseSearch courseSearch;
	
	public TrainingCourseMaterialController() {
		
		trainingCourseModel = new ManageTrainingCourse();
		courseSearch = new TrainingCourseSearch();
	}
	
	public void addNewMaterial(ListPanel materialList) {
		
	}
}
