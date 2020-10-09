package modeltraining;

import java.util.ArrayList;

import model.JDBCexecute;

public class TrainingProgressTrigger {
	
	// For database
	private JDBCexecute database;


	/**************
	 * Constructor
	 * init JDBC
	 *************/
	public TrainingProgressTrigger() {

		database = new JDBCexecute();
	}
	
	
   /**
	*  SELECT ALL TRAINEE_ID FROM ENROLL (WHERE ENROLL.COURSE_ID == COURSE_MATERIAL.COURSE_ID )
	*  
	*  FOR(TAINEE_ID)
	*  BEGIN
	*     INSERT INTO PROGRESS VALUES	 
	*        TRAINEE_ID 
	*        COURSE_MATERIAL.MATERIAL_ID
	*        ENROLL.MATERIAL_IS_DONE = 'false'
	*  END
	*/
	public void addMaterialTrigger(String courseID, String newMaterialID) {
		
		String column = "USER_ID";
		String query = ("SELECT USER_ID FROM ENROLL " + 
						"WHERE COURSE_ID = '" +courseID + "';  " );
		ArrayList<String> traineeList = new ArrayList<>();
		database.executeMultiRowQuery(query, column, traineeList);

		for(int i = 0; i < traineeList.size(); i++) {
			
			query = "INSERT INTO PROGRESS VALUES ('" +
					traineeList.get(i) +"','" +
					newMaterialID + 
					"','false');";
			database.executeUpdate(query);
			
		}
	}

	public void deleteMaterialTrigger(String deletedMaterialID) {
		
		String query = ("DELETE FROM PROGRESS WHERE MATERIAL_ID = '" +
				deletedMaterialID + "';" );
		database.executeUpdate(query);

	}
	
	   /**
		*  SELECT ALL MATERIAL_ID FROM COURSE_MATERIAL 
		*     WHERE COURSE_MATERIAL.COURSE_ID = ENROLL.COURSE_ID
		*  
		*  FOR(MATERIAL_ID)
		*  BEGIN
		*     INSERT INTO PROGRESS VALUES	 
		*        TRAINEE_ID 
		*        MATERIAL_ID
		*        ENROLL.MATERIAL_IS_DONE = 'false'
		*  END
		*/
	public void enrollCourseTrigger(String courseID, String traineeID) {
		
		String column = "MATERIAL_ID";
		String query = ("SELECT MATERIAL_ID FROM COURSE_MATERIAL " + 
						"WHERE COURSE_ID = '" + courseID + "';  " );
		ArrayList<String> materialList = new ArrayList<>();
		database.executeMultiRowQuery(query, column, materialList);
		
		for(int i = 0; i < materialList.size(); i++) {

			query = "INSERT INTO PROGRESS VALUES ('" +
					 traineeID +"','" +
					 materialList.get(i) + 
					"','false');";
			database.executeUpdate(query);
		}
	}
	
	public void deleteTraineeTrigger(String courseID, String traineeID) {

		String column = "MATERIAL_ID";
		String query = ("SELECT MATERIAL_ID FROM COURSE_MATERIAL " + 
						"WHERE COURSE_ID = '" + courseID + "';  " );
		ArrayList<String> materialList = new ArrayList<>();
		database.executeMultiRowQuery(query, column, materialList);
		
		for(int i = 0; i < materialList.size() ; i++) {
			
			query = ("DELETE FROM PROGRESS " + 
					 "WHERE USER_ID = '" + traineeID + 
					 "MATERIAL_ID = " + materialList.get(i) + "';" );
			database.executeUpdate(query);
		}
	}
	
	

}
