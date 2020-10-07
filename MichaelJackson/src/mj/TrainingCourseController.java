package mj;

import java.util.ArrayList; 

import modeltraining.ManageTrainingCourse;
import modeltraining.TrainingCourseSearch;
import view.ListPanel;
import viewadmin.AddNewCourse;
import viewadmin.AllTrainingList;
import viewadmin.EditCourse;
import viewadmin.ManageTraining;

public class TrainingCourseController {
	private AllTrainingList allTrainingList;
	private AddNewCourse addNewCourse;
	private EditCourse editCourse;
	private ManageTrainingCourse trainingCourseModel;
	private TrainingCourseSearch courseSearch;
	
	public TrainingCourseController(AllTrainingList allTrainingList, AddNewCourse addNewCourse, EditCourse editCourse) {
		this.allTrainingList = allTrainingList;
		this.addNewCourse = addNewCourse;
		this.editCourse = editCourse;
		
		trainingCourseModel = new ManageTrainingCourse();
		courseSearch = new TrainingCourseSearch();
	}
	
	public void showTrainingList() {
		ArrayList <String> availableTrainingCourseList = new ArrayList<>();
		courseSearch.getAllTrainingCourseID(availableTrainingCourseList);
		try {
			for(int i = 0;  i< availableTrainingCourseList.size(); i++) {
				ManageTraining tempTraining = new ManageTraining(
						courseSearch.getTrainingCourseDetails(availableTrainingCourseList.get(i), 2), 
						availableTrainingCourseList.get(i));
				
				allTrainingList.getTrainingList().addItem(tempTraining);
			}
		} catch (Exception e) {
			System.out.println("showTrainingList Fail");
		}
	}
	
	public boolean addNewCourse() {
		String courseID = addNewCourse.getTxtCourseID().getText();
		String trainerID = addNewCourse.getTxtTrainer().getText();
		String courseName = addNewCourse.getTxtName().getText();
		String courseDesc = addNewCourse.getTxtDesc().getText();
		String courseDate = addNewCourse.getTxtDate().getText();
		
		// validate courseID and trainerID format
		if (idValidator(courseID, "crs") && idValidator(trainerID, "tnr")) {
			boolean success = trainingCourseModel.addNewTrainingCourse(courseID, trainerID, courseName, courseDesc, courseDate);
			if (success) {
				ManageTraining newTraining = new ManageTraining(courseName, courseID);
				allTrainingList.getTrainingList().addItem(newTraining);
				return true;
			}
		}
		else {
			// if one or both are wrong
			System.out.println("Invalid input while adding new course");
		}
		return false;
	}
	
	public void getTrainingDetails(String courseID) {
		try {
			editCourse.getTrainingName().setText(courseSearch.getTrainingCourseDetails(courseID, 2));
			editCourse.getTrainingDesc().setText(courseSearch.getTrainingCourseDetails(courseID, 3));
			editCourse.getTrainerID().setText(courseSearch.getTrainingCourseDetails(courseID, 1));
			editCourse.getTrainingDate().setText(courseSearch.getTrainingCourseDetails(courseID, 4));
		
		} catch (Exception e) {
			System.out.println("getTrainingDetails Fail");
		}
	}
	
	public boolean setCourseDetails(String courseID) {
		String courseName = editCourse.getTrainingName().getText();
		String courseDesc = editCourse.getTrainingDesc().getText();
		String trainerID = editCourse.getTrainerID().getText();
		String courseDate = editCourse.getTrainingDate().getText();

		// validate trainerID format
		if (idValidator(trainerID, "tnr")) {
			try {
				trainingCourseModel.setTrainingCourseDetails(courseName, courseID, 2);
				trainingCourseModel.setTrainingCourseDetails(courseDesc, courseID, 3);
				trainingCourseModel.setTrainingCourseDetails(trainerID, courseID, 1);
				trainingCourseModel.setTrainingCourseDetails(courseDate, courseID, 4);
			} catch (Exception e) {
				System.out.println("setCourseDetails Fail");
			}
			
			// in cases course name is changed
			ListPanel p = allTrainingList.getTrainingList();
			for (int i = 0; i < p.getListOfPanel().size(); i++) {
				if ((((ManageTraining) p.getItem(i)).getCourseID()).equals(courseID)) {
					((ManageTraining) p.getItem(i)).getTrainingButton().setText(courseName);
				}
			}
			return true;
			
		}
		else {
			// if one or both are wrong
			System.out.println("Invalid input while adding new course");
		}
		return false;
	}
	
	public void deleteTrainingCourse(String courseID) {
		boolean success = trainingCourseModel.deleteTrainingCourse(courseID);
	}
	
	/*
	 * ID header type
	 * 
	 * adm :admin
	 * tnr :trainer
	 * tne :trainee
	 * 
	 * crs :training course
	 * mtr :training material
	 * 
	 * rpt :report
	 */
	
	public static boolean idValidator(String id, String type) {
		// checks length
		if (id.length() != 8) {
			return false;
		}
		// checks valid id header
		if (id.substring(0,3).equals(type) == false) {
			return false;
		}
		// checks digits after header
		for (int i = 3; i < id.length(); i++) {
			if(!Character.isDigit(id.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
