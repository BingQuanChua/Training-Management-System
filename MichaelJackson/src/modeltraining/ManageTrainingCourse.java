package modeltraining;

import model.JDBCexecute;


public class ManageTrainingCourse {

	private JDBCexecute database;
	
	public ManageTrainingCourse(){
	
		database = new JDBCexecute();
	}
	
	
	/********************************
	 * Add new training course
	 * 
	 * @param courseID
	 * @param trainerID
	 * @param courseName
	 * @param courseDesc
	 * @param courseDate
	 * 
	 * @return boolean
	 *******************************/
	public boolean addNewTrainingCourse(String courseID, String trainerID, String courseName, String courseDesc, String courseDate) {
		
		// Query
		String query = ("INSERT INTO TRAINING_COURSE " +
				"VALUES ('" 	+
				courseID 		+ "', '" +
				trainerID 		+ "', '" + 
				courseName	 	+ "', '" +
				courseDesc	 	+ "', '" +
				courseDate 		+ "');" );

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("addNewTrainingCourse Success");
			return true;
		} else {
			System.out.println("addNewTrainingCourse Fail");
		}
		
		return false;
	}
	
	/********************************
	 * Change training course details
	 * 
	 * @param newDetails
	 * @param courseID
	 * @param choice
	 * 	1: trainerID
	 *  2: courseName
	 *  3: courseDesc
	 *  4: courseDate
	 * 
	 * @return boolean
	 *******************************/
	public boolean setTrainingCourseDetails(String newDetails, String courseID, int choice) {
		
		// Query
		String query = "Fail";
		switch(choice) {
			case 1:
				query = ( "UPDATE TRAINING_COURSE " 
						+ "SET USER_ID = '" + newDetails + "' "
						+ "WHERE COURSE_ID = '"+ courseID +"';");
				break;
			case 2:
				query = ( "UPDATE TRAINING_COURSE " 
						+ "SET COURSE_NAME = '" + newDetails + "' "
						+ "WHERE COURSE_ID = '"+ courseID +"';");
				break;
			case 3:
				query = ( "UPDATE TRAINING_COURSE " 
						+ "SET COURSE_DESC = '" + newDetails + "' "
						+ "WHERE COURSE_ID = '"+ courseID +"';");
				break;
			case 4:
				query = ( "UPDATE TRAINING_COURSE " 
						+ "SET COURSE_DATE = '" + newDetails + "' "
						+ "WHERE COURSE_ID = '"+ courseID +"';");
				break;
			default:
				System.out.println("Invalid Choice\n"
						+ "setTrainingCourseDetails Fail");
				return false;
		}

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("setTrainingCourseDetails Success");
			return true;
		} else {
			System.out.println("setTrainingCourseDetails Fail");
		}

		return false;
	}
	
	/**
	 * Delete existing training course
	 * @param courseID
	 * @return boolean
	 */
	public boolean deleteTrainingCourse(String courseID) {
		
		// Query
		String query = ("DELETE FROM TRAINING_COURSE" + 
						"WHERE COURSE_ID = '" + courseID + "';" );

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("deleteTrainingCourse Success");
			return true;
		} else {
			System.out.println("deleteTrainingCourse Fail");
		}
		
		return false;
	}
	
}
