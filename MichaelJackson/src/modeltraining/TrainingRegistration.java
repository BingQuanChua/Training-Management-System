package modeltraining;

import java.util.ArrayList;

import model.JDBCexecute;

public class TrainingRegistration {
		
	private JDBCexecute database;
		
	public TrainingRegistration(){
	
		database = new JDBCexecute();
	}
	
	/**
	 *  enroll table
	 * +-----------------+-------------+------+-----+---------+-------+
	 * | Field           | Type        | Null | Key | Default | Extra |
	 * +-----------------+-------------+------+-----+---------+-------+
	 * | USER_ID         | char(8)     | NO   | PRI | NULL    |       |
	 * | COURSE_ID       | char(8)     | NO   | PRI | NULL    |       |
	 * | TRAINING_STATUS | varchar(10) | YES  |     | NULL    |       |
	 * +-----------------+-------------+------+-----+---------+-------+
	 */
	
	/********************************
	 * Add new enroll
	 * 
	 * @param userID
	 * @param courseID
	 *  
	 * @return boolean
	 *******************************/
	public boolean addNewEnroll(String userID, String courseID) {
		
		// Query
		String query = ("INSERT INTO ENROLL " +
				"VALUES ('" 	+
				userID 			+ "', '" +
				courseID 		+ "', '" + 
				"approved"	 	+ "');"); // pending

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("addNewEnroll Success");
			return true;
		} else {
			System.out.println("addNewEnroll Fail");
		}
		
		return false;
	}
	
	public boolean deleteEnroll(String userID, String courseID) {
	
		// Query
		String query = ("DELETE FROM ENROLL WHERE " +
				"USER_ID = '" + userID	+ "' AND " +
				"COURSE_ID = '" + courseID + "';"); 
	
		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("deleteEnroll Success");
			return true;
		} else {
			System.out.println("deleteEnroll Fail");
		}
		
		return false;
	}
	
	public void getEnrolledTraineeID(String courseID, ArrayList<String> list) {

		String status = "approved";
		String column = "USER_ID";
		String query = ("SELECT USER_ID FROM ENROLL " + 
				"WHERE COURSE_ID = '" + courseID + "' " +
				"AND TRAINING_STATUS = '"+ status + "' ;" );

		database.executeMultiRowQuery(query, column, list);
	}
}
	
