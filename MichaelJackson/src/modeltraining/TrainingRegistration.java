package modeltraining;

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
				"pending"	 	+ "');");

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("addNewEnroll Success");
			return true;
		} else {
			System.out.println("addNewEnroll Fail");
		}
		
		return false;
	}
	
	/********************************
	 * Accept request
	 * 
	 * @param userID
	 * @param courseID
	 *  
	 * @return boolean
	 *******************************/
	public boolean acceptRequest(String userID, String courseID) {
		
		// Query
		String query = ("UPDATE ENROLL " +
				"SET TRAINING_STATUS = 'approved' WHERE " +
				"USER_ID = '" + userID + "' AND " +
				"COURSE_ID = '" + courseID + "';");

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("acceptRequest Success");
			return true;
		} else {
			System.out.println("acceptRequest Fail");
		}
		
		return false;
	}
	
	/********************************
	 * Reject request
	 * 
	 * @param userID
	 * @param courseID
	 *  
	 * @return boolean
	 *******************************/
	public boolean rejectRequest(String userID, String courseID) {
		
		// Query
		String query = ("UPDATE ENROLL " +
				"SET TRAINING_STATUS = 'rejected' WHERE " +
				"USER_ID = '" + userID + "' AND " +
				"COURSE_ID = '" + courseID + "';");

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("rejectRequest Success");
			return true;
		} else {
			System.out.println("rejectRequest Fail");
		}
		
		return false;
	}
}
