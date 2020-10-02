package modeltraining;

import model.JDBCexecute;

public class TrainingCourseMaterial {
	
	// For database
	private JDBCexecute database;
	
	
	/**************
	 * Constructor
	 * init JDBC
	 *************/
	public TrainingCourseMaterial() {
		
		database = new JDBCexecute();
	}
	
	
	/********************************
	 * Add new material into course
	 * 
	 * @param materialID
	 * @param courseID
	 * @param materialTitle
	 * @param MaterialDesc
	 * 
	 * @return boolean
	 *******************************/
	public boolean addNewMaterial(String materialID, String courseID, String materialTitle, String MaterialDesc) {
		
		// Query
		String query = ("INSERT INTO COURSE_MATERIAL " +
				"VALUES ('" 	+
				materialID 		+ "', '" +
				courseID 		+ "', '" + 
				materialTitle 	+ "', '" +
				MaterialDesc 	+ "');" );

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("addNewMaterial Success");
			return true;
		} else {
			System.out.println("addNewMaterial Fail");
		}
		
		return false;
	}
	
	/******************************************
	 * Change the title or description of material
	 * 
	 * @param materialID
	 * @param newDetails
	 * @param choice
	 * choice 1: MATERIAL_TITLE
	 * choice 2: MATERIAL_DESC
	 * 
	 * @return boolean
	 *****************************************/
	public boolean setMaterialDetails(String materialID, String newDetails, int choice) {
		
		
		// Query
		String query = "";
		if (choice == 1) {
			query = ( "UPDATE COURSE_MATERIAL " 
					+ "SET MATERIAL_TITLE = '" + newDetails + "' "
					+ "WHERE MATERIAL_ID = '"+ materialID +"';");
		} else
		if (choice == 2) {
			query = ( "UPDATE COURSE_MATERIAL " 
					+ "SET MATERIAL_DESC = '" + newDetails + "' "
					+ "WHERE MATERIAL_ID = '"+ materialID +"';");
		} else {
			System.out.println("Invalid Choice\n"
					+ "setMaterialDetails Fail");
			return false;
		}

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("setMaterialDetails Success");
			return true;
		} else {
			System.out.println("setMaterialDetails Fail");
		}

		return false;
	}
	
	/**
	 * Delete material
	 * @param materialID
	 * @return boolean
	 */
	public boolean deleteMaterial(String materialID) {
		
		// Query
		String query = ("DELETE FROM COURSE_MATERIAL" + 
				"WHERE MATERIAL_ID = '" + materialID + "';" );

		// Execute Query 
		if(database.executeUpdate(query)) {
			System.out.println("deleteMaterial Success");
			return true;
		} else {
			System.out.println("deleteMaterial Fail");
		}
		
		return false;
	}
	
	
	
	/**********************
	 * Getter
	 * @param materialID
	 * @return courseID
	 * @throws Exception 
	 *********************/
	public String getMaterialCourseID(String materialID) throws Exception {
		
		// Query
		String courseID = "Fail to Obtain Result";
		String query = ("SELECT COURSE_ID FROM COURSE_MATERIAL " +
				"WHERE MATERIAL_ID = '" + materialID + "';" );
		String column = "COURSE_ID";

		// Execute Query
		courseID = database.executeQuery(query, column);
		System.out.println("getMaterialCourseID executed");

		// Extract result
		System.out.println("getMaterialCourseID result: \n"
				+ "Material_ID: " + materialID + "\n"
				+ "Course_ID: " + courseID ); 
		
		return courseID;
	}
	
	/**********************
	 * Getter
	 * @param materialID
	 * @return materialTitle
	 * @throws Exception 
	 *********************/
	public String getMaterialTitle(String materialID) throws Exception {
		
		// Query
		String materialTitle = "Fail to Obtain Result";
		String column = "MATERIAL_TITLE";
		String query = ("SELECT MATERIAL_TITLE FROM COURSE_MATERIAL " +
				"WHERE MATERIAL_ID = '" + materialID + "';" );

		// Execute Query
		materialTitle = database.executeQuery(query, column);
		System.out.println("getMaterialTitle executed");

		// Display result
		System.out.println("getMaterialCourseID result: \n"
				+ "Material_ID: " + materialID + "\n"
				+ "MATERIAL_TITLE: " + materialTitle ); 
		
		return materialID;
	}
	
	/**********************
	 * Getter
	 * @param materialID
	 * @return materialDesc
	 * @throws Exception 
	 *********************/
	public String getMaterialDescription(String materialID) throws Exception {
		

		// Query
		String materialDesc = "Fail to Obtain Result";
		String column = "MATERIAL_DESC";
		String query = ("SELECT MATERIAL_DESC FROM COURSE_MATERIAL " +
				"WHERE MATERIAL_ID = '" + materialID + "';" );
		System.out.println(query);

		// Execute Query
		materialDesc = database.executeQuery(query, column);
		System.out.println("getMaterialDescription executed");

		// Extract result
		System.out.println("getMaterialCourseID result: \n"
				+ "Material_ID: " + materialID + "\n"
				+ "MATERIAL_DESC: " + materialDesc ); 

		
		return materialDesc;
	}

}
