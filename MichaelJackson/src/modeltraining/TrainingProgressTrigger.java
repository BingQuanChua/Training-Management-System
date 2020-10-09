package modeltraining;

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
	public void addMaterialTrigger(String courseID, String materialID) {
		
		String column = "USER_ID";
		String query = "";
		
		
	}

	public void deleteMaterialTrigger() {

	}
	
	public void enrollCourseTrigger() {
		
	}
	
	

}
