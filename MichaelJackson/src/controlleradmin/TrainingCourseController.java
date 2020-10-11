package controlleradmin;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modeltraining.ManageTrainingCourse;
import modeltraining.TrainingCourseSearch;
import modeluser.AdminModel;
import view.ListPanel;
import viewadmin.AddNewCourse;
import viewadmin.AllTrainingList;
import viewadmin.EditCourse;
import viewadmin.ManageTraining;

public class TrainingCourseController {
	private AllTrainingList allTrainingList;
	private AddNewCourse addNewCourse;
	private EditCourse editCourse;
	private AdminModel adminModel;
	private ManageTrainingCourse trainingCourseModel;
	private TrainingCourseSearch courseSearch;
	
	public TrainingCourseController(AllTrainingList allTrainingList, AddNewCourse addNewCourse, EditCourse editCourse, AdminModel adminModel) {
		this.allTrainingList = allTrainingList;
		this.addNewCourse = addNewCourse;
		this.editCourse = editCourse;
		this.adminModel = adminModel;
		
		trainingCourseModel = new ManageTrainingCourse();
		courseSearch = new TrainingCourseSearch();
	}
	
	public void showTrainingList() {
		ArrayList <String> allTrainingCourseList = new ArrayList<>();
		courseSearch.getAllTrainingCourseID(allTrainingCourseList);
		try {
			for(int i = 0;  i < allTrainingCourseList.size(); i++) {
				ManageTraining tempTraining = new ManageTraining(
						courseSearch.getTrainingCourseDetails(allTrainingCourseList.get(i), 2), 
						allTrainingCourseList.get(i));
				
				allTrainingList.getTrainingList().addItem(tempTraining);
			}
		} catch (Exception e) {
			System.out.println("showTrainingList Fail");
		}
	}
	
	public boolean addNewCourse() {
		String courseID = addNewCourse.getTxtCourseID().getText();
		String trainerID = (String) addNewCourse.getTrainerIDComboBox().getSelectedItem();
		String courseName = addNewCourse.getTxtName().getText();
		String courseDesc = addNewCourse.getTxtDesc().getText();
		String courseDate = addNewCourse.getTxtDate().getText();
		String errorMessage = "Error!";
		
		// validate if courseName is empty
		if (courseName.equals("Enter training course name")) {
			errorMessage += "\nCourse name cannot be left empty!";
		}
		
		// validate if courseDesc is empty
		if (courseDesc.equals("Enter short description")) {
			errorMessage += "\nCourse description cannot be left empty!";
		}
		
		// validate if courseDesc is empty
		if (trainerID.equals("--please select a trainer--")) {
			errorMessage += "\nTrainer ID selection cannot be left empty!";
		}
		else {
			trainerID = trainerID.substring(0,8);
			System.out.println(trainerID);
		}
		
		// validate if courseDate is empty
		if (courseDate.equals("Enter training date (format: YYYY-MM-DD)")) {
			errorMessage += "\nCourse date cannot be left empty!";
		}
		
		if (errorMessage.length() > 6) {
			JOptionPane.showConfirmDialog (null, errorMessage,"ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		/*
		 * If all the fields are not empty
		 */
		
		// validate courseID and trainerID format
		if (idValidator(courseID, "crs") && idValidator(trainerID, "tnr")) {
			
			if (dateValidator(courseDate)) {
				boolean success = trainingCourseModel.addNewTrainingCourse(courseID, trainerID, courseName, courseDesc, courseDate);
				if (success) {
					ManageTraining newTraining = new ManageTraining(courseName, courseID);
					allTrainingList.getTrainingList().addItem(newTraining);
					return true;
				}
			}
			else {
				// courseDate is wrong
				JOptionPane.showConfirmDialog (null, "Error! Wrong date format! \nDate format: YYYY-MM-DD","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				System.out.println("Invalid input while adding new course");
			}
				
		}
		else {
			// I bet only trainerID is wrong
			JOptionPane.showConfirmDialog (null, "Error! Trainer does not exist! Please check the list of trainers","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			System.out.println("Invalid input while adding new course");
		}
		return false;
	}
	
	public void getTrainingDetails(String courseID) {
		try {
			editCourse.getTrainingName().setText(courseSearch.getTrainingCourseDetails(courseID, 2));
			editCourse.getTrainingDesc().setText(courseSearch.getTrainingCourseDetails(courseID, 3));
			editCourse.getTrainingDate().setText(courseSearch.getTrainingCourseDetails(courseID, 4));
			
			ArrayList<String> allTrainerID = new ArrayList<>();
			adminModel.getAllTrainerID(allTrainerID);
			editCourse.getTrainerIDComboBox().removeAllItems();
			editCourse.getTrainerIDComboBox().addItem("--please select a trainer--");
			for (int i = 0; i < allTrainerID.size(); i++) {
				try {
					String trainerID = allTrainerID.get(i);
					String name;
					name = adminModel.getUserProfile(trainerID, 1);
					editCourse.getTrainerIDComboBox().addItem(trainerID + " - " + name);
				} catch (Exception e1) {
					System.out.println("getTrainingDetails: get trainer details failed");
				}	
			}
			
			String trainerID = courseSearch.getTrainingCourseDetails(courseID, 1);
			for (int i = 0; i < allTrainerID.size(); i++) {
				if (allTrainerID.get(i).equals(trainerID)) {
					editCourse.getTrainerIDComboBox().setSelectedIndex(i+1);
				}
			}
		
		} catch (Exception e) {
			System.out.println("getTrainingDetails Fail");
		}
	}
	
	public boolean setCourseDetails(String courseID) {
		String courseName = editCourse.getTrainingName().getText();
		String courseDesc = editCourse.getTrainingDesc().getText();
		String trainerID = ((String) editCourse.getTrainerIDComboBox().getSelectedItem());
		String courseDate = editCourse.getTrainingDate().getText();
		String errorMessage = "Error!";
		// validate if courseName is empty
		if (courseName.equals("Enter training course name")) {
			errorMessage += "\nCourse name cannot be left empty!";
		}
				
		// validate if courseDesc is empty
		if (courseDesc.equals("Enter short description")) {
			errorMessage += "\nCourse description cannot be left empty!";
		}
				
		// validate if courseDesc is empty
		if (trainerID.equals("--please select a trainer--")) {
			errorMessage += "\nTrainer ID selection cannot be left empty!";
		}
		else {
			trainerID = trainerID.substring(0,8);
			System.out.println(trainerID);
		}
		
		// validate if courseDate is empty
		if (courseDate.equals("Enter training date (format: YYYY-MM-DD)")) {
			errorMessage += "\nCourse date cannot be left empty!";
		}
		
		if (errorMessage.length() > 6) {
			JOptionPane.showConfirmDialog (null, errorMessage,"ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			return false;
		}
				
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
	
	public String getLatestTrainingCourseID() {
		try {
			String lastID = courseSearch.getLastCourseID();
			int id = Integer.parseInt(lastID.substring(3, 8))+1;
			String newID = String.format("crs%05d", id);
			
			return newID;
			
		} catch (Exception e) {
			System.out.println("setLatestTrainingCourseID failed");
		}
		return "ERROR";
		
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
	
	public static boolean dateValidator(String date) {
		// checks length YYYY-MM-DD
		if (date.length() != 10) {
			return false;
		}
		// checks character
		if (date.charAt(4) != '-' || date.charAt(7) != '-') {
			return false;
		}
		// checks number
		for (int i = 0; i < 10; i++) {
			if (i == 4 || i == 7) {
				continue;
			}
			if (!Character.isDigit(date.charAt(i))) {
				return false;
			}
		}
		
		return true;
		
	}
}
