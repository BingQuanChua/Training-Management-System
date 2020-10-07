package modeltraining;

import java.util.ArrayList;

import model.JDBCexecute;

public class TrainingCourseSearch {
	
	private JDBCexecute database;
	
	public TrainingCourseSearch(){
	
		database = new JDBCexecute();
	}
	
	public void getAllTrainingCourseID(ArrayList<String> list) {
		
		String column = "COURSE_ID";
		String query = ("SELECT COURSE_ID FROM TRAINING_COURSE; " );
		
		database.executeMultiRowQuery(query, column, list);
	}
	
	/**
	 * @param courseID
	 * @param choice
	 * 1: USER_ID // traienrID
	 * 2: COURSE_NAME
	 * 3: COURSE_DESC
	 * 4: COURSE_DATE
	 * 5: TRAINER_NAME //courseID used as trainerID
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getTrainingCourseDetails(String courseID, int choice) throws Exception {
		
		String courseDetails = "Fail To Obtain Result";
		String query = "";
		String column = "";

		// Query
		switch(choice) 
		{
			case 1:	
				query = ("SELECT USER_ID FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "USER_ID";
				break;
			case 2: 
				query = ("SELECT COURSE_NAME FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "COURSE_NAME";
				break;
			case 3: 
				query = ("SELECT COURSE_DESC FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "COURSE_DESC";
				break;
			case 4: 
				query = ("SELECT COURSE_DATE FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "COURSE_DATE";
				break;
			case 5:
				query = ("SELECT USER_NAME FROM USER WHERE USER_ID = '"+ courseID +"';"); //the courseID is userID
				column = "USER_NAME";
				break;
			default:
				System.out.println("Invalid choice");
				return courseDetails;
		}

		// Execute Query
		courseDetails = database.executeQuery(query, column);
		return courseDetails;
	}
	
	
	
	// Trainee
	public void getAvailableTrainingCourseID(ArrayList<String> list) {
		
		String column = "COURSE_ID";
		String query = ("SELECT COURSE_ID FROM TRAINING_COURSE; " );
		
		database.executeMultiRowQuery(query, column, list);
		
	}
	
	// Trainee
	public void getEnrolledTrainingCourseID(String traineeID, ArrayList<String> list) {

		String status = "approved";
		String column = "COURSE_ID";
		String query = ("SELECT COURSE_ID FROM ENROLL " + 
				"WHERE USER_ID = '" + traineeID + "' " +
				"AND TRAINING_STATUS = '"+ status + "' ;" );

		database.executeMultiRowQuery(query, column, list);
	}
	
	
	// Course material
	public void getAllCourseMaterial(String courseID, ArrayList<String> list ) {
		
		String column = "MATERIAL_ID";
		String query = ("SELECT MATERIAL_ID FROM COURSE_MATERIAL " + 
						"WHERE COURSE_ID = '" + courseID + "'; " );
		
		database.executeMultiRowQuery(query, column, list);
	}
	
	/**
	 * Course material
	 * 
	 * @param materialID
	 * @param choice
	 * 1: COURSE_ID
	 * 2: MATERIAL_TITLE
	 * 3: MATERIAL_DESC
	 * 
	 * @return materialDetails
	 * @throws Exception
	 */
	public String getCourseMaterialDetails(String materialID, int choice) throws Exception {
		
		String materialDetails = "Fail To Obtain Result";
		String query = "";
		String column = "";

		// Query
		switch(choice) 
		{
			case 1:	
				query = ("SELECT COURSE_ID FROM COURSE_MATERIAL WHERE MATERIAL_ID = '"+ materialID +"';");
				column = "COURSE_ID";
				break;
			case 2: 
				query = ("SELECT MATERIAL_TITLE FROM COURSE_MATERIAL WHERE MATERIAL_ID = '"+ materialID +"';");
				column = "MATERIAL_TITLE";
				break;
			case 3: 
				query = ("SELECT MATERIAL_DESC FROM COURSE_MATERIAL WHERE MATERIAL_ID = '"+ materialID +"';");
				column = "MATERIAL_DESC";
				break;
			default:
				System.out.println("Invalid choice");
				return materialDetails;
		}

		// Execute Query
		materialDetails = database.executeQuery(query, column);
		return materialDetails;
	}

}
