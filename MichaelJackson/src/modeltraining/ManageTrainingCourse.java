package modeltraining;

import model.JDBCexecute;


public class ManageTrainingCourse {

	private JDBCexecute database;
	
	public ManageTrainingCourse(){
	
		database = new JDBCexecute();
	}
	
	/**
	 *  training_course table
	 * +-------------+--------------+------+-----+---------+-------+
	 * | Field       | Type         | Null | Key | Default | Extra |
	 * +-------------+--------------+------+-----+---------+-------+
	 * | COURSE_ID   | char(8)      | NO   | PRI | NULL    |       |
	 * | USER_ID     | char(8)      | NO   | MUL | NULL    |       |
	 * | COURSE_NAME | varchar(50)  | YES  |     | NULL    |       |
	 * | COURSE_DESC | varchar(200) | YES  |     | NULL    |       |
	 * | COURSE_DATE | date         | YES  |     | NULL    |       |
	 * +-------------+--------------+------+-----+---------+-------+
	 */
	
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
				courseDate 		+ "', " +
				"''" + ");" );

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
			case 5:
				query = ( "UPDATE TRAINING_COURSE " 
						+ "SET FEEDBACK_LINK = '" + newDetails + "' "
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
		String query = ("DELETE FROM TRAINING_COURSE " + 
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
	
	/**
	 * training_course table
	 * +-------------+--------------+------+-----+---------+-------+
	 * | Field       | Type         | Null | Key | Default | Extra |
	 * +-------------+--------------+------+-----+---------+-------+
	 * | COURSE_ID   | char(8)      | NO   | PRI | NULL    |       |
	 * | USER_ID     | char(8)      | NO   | MUL | NULL    |       |
	 * | COURSE_NAME | varchar(50)  | YES  |     | NULL    |       |
	 * | COURSE_DESC | varchar(200) | YES  |     | NULL    |       |
	 * | COURSE_DATE | date         | YES  |     | NULL    |       |
	 * +-------------+--------------+------+-----+---------+-------+
	 */
	
	/**********************
	 * Getter
	 * @param courseID
	 * @return trainerID (userID)
	 * @throws Exception 
	 *********************/
	public String getTrainerID(String courseID) throws Exception {
		
		// Query
		String trainerID = "Fail to Obtain Result";
		String query = ("SELECT USER_ID FROM TRAINING_COURSE " +
				"WHERE COURSE_ID = '" + courseID + "';" );
		String column = "USER_ID";
		
		// Execute Query
		courseID = database.executeQuery(query, column);
		System.out.println("getTrainerID executed");

		// Extract result
		System.out.println("getTrainerID result: \n"
				+ "Training_ID: " + courseID + "\n"
				+ "Trainer_ID: " + trainerID ); 
			
		return trainerID;
	}
	
	/**********************
	 * Getter
	 * @param courseID
	 * @return courseName
	 * @throws Exception 
	 *********************/
	public String getCourseName(String courseID) throws Exception {
		
		// Query
		String courseName = "Fail to Obtain Result";
		String query = ("SELECT COURSE_NAME FROM TRAINING_COURSE " +
				"WHERE COURSE_ID = '" + courseID + "';" );
		String column = "COURSE_NAME";
		
		// Execute Query
		courseID = database.executeQuery(query, column);
		System.out.println("getCourseName executed");

		// Extract result
		System.out.println("getCourseName result: \n"
				+ "Training_ID: " + courseID + "\n"
				+ "Course_Name: " + courseName ); 
			
		return courseName;
	}
	
	/**********************
	 * Getter
	 * @param courseID
	 * @return courseName
	 * @throws Exception 
	 *********************/
	public String getCourseDescription(String courseID) throws Exception {
		
		// Query
		String courseDesc = "Fail to Obtain Result";
		String query = ("SELECT COURSE_DESC FROM TRAINING_COURSE " +
				"WHERE COURSE_ID = '" + courseID + "';" );
		String column = "COURSE_DESC";
		
		// Execute Query
		courseID = database.executeQuery(query, column);
		System.out.println("getCourseDescription executed");

		// Extract result
		System.out.println("getCourseDescription result: \n"
				+ "Training_ID: " + courseID + "\n"
				+ "Course_Desc: " + courseDesc ); 
			
		return courseDesc;
	}
	
	/**********************
	 * Getter
	 * @param courseID
	 * @return courseName
	 * @throws Exception 
	 *********************/
	public String getCourseDate(String courseID) throws Exception {
		
		// Query
		String courseDate = "Fail to Obtain Result";
		String query = ("SELECT COURSE_DATE FROM TRAINING_COURSE " +
				"WHERE COURSE_ID = '" + courseID + "';" );
		String column = "COURSE_DATE";
		
		// Execute Query
		courseID = database.executeQuery(query, column);
		System.out.println("getCourseDate executed");

		// Extract result
		System.out.println("getCourseDate result: \n"
				+ "Training_ID: " + courseID + "\n"
				+ "Course_Date: " + courseDate ); 
			
		return courseDate;
	}
	
}
