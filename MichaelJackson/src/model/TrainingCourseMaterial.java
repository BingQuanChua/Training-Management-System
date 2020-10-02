package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainingCourseMaterial {
	
	// For database
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	/**************
	 * Constructor
	 * init JDBC
	 *************/
	public TrainingCourseMaterial(){
		
		try {
			con = DriverManager.getConnection(url, serverName, serverPassword);
			st = con.createStatement();
			System.out.println("COURSE MATERIAL: Connected to Database\n");
		} catch (SQLException e) {
			System.out.println("COURSE MATERIAL: Fail to Connect Database\n");
		}	
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
		
		try {
			// Query
			String query = ("INSERT INTO COURSE_MATERIAL " +
							"VALUES ('" 	+
							materialID 		+ "', '" +
							courseID 		+ "', '" + 
							materialTitle 	+ "', '" +
							MaterialDesc 	+ "');" );
			
			System.out.println(query);
						
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("addNewMaterial Success");
			return true;
				
		} catch (SQLException e) {
			System.out.println("addNewMaterial SQL Fail");
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
		
		String query = "";
		try {
			// Query
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
				System.out.println("Invalid Choice");
				throw new Exception();
			}
			
			System.out.println(query);
						
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("setMaterialDetails Success");
			return true;
				
		} catch (SQLException e) {
			System.out.println("setMaterialDetails SQL Fail");
		} catch (Exception e) {
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
		
		try {
			// Query
			String query = ("DELETE FROM COURSE_MATERIAL" + 
						  	"WHERE MATERIAL_ID = '" + materialID + "';" );
			
			System.out.println(query);
						
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("deleteMaterial Success");
			return true;
				
		} catch (SQLException e) {
			System.out.println("deleteMaterial SQL Fail");
		} catch (Exception e) {
			System.out.println("deleteMaterial Fail");
		}
		
		
		return false;
	}
	
	
	
	/**********************
	 * Getter
	 * @param materialID
	 * @return courseID
	 *********************/
	public String getMaterialCourseID(String materialID) {
		
		String courseID = "";
		
		try {
			// Query
			String query = ("SELECT COURSE_ID FROM COURSE_MATERIAL " +
							"WHERE MATERIAL_ID = '" + materialID + "';" );
			System.out.println(query);
						
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getMaterialCourseID query execute successful");

			// Extract result
			courseID = rs.getString("COURSE_ID");
			System.out.println("getMaterialCourseID result: \n"
								+ "Material_ID: " + materialID + "\n"
								+ "Course_ID: " + courseID ); 

		} catch (SQLException e) {
			System.out.println("getMaterialCourseID SQL Fail");
		}
		
		return courseID;
	}
	
	/**********************
	 * Getter
	 * @param materialID
	 * @return materialTitle
	 *********************/
	public String getMaterialTitle(String materialID) {
		
		String materialTitle = "";
		
		try {
			// Query
			String query = ("SELECT MATERIAL_TITLE FROM COURSE_MATERIAL " +
							"WHERE MATERIAL_ID = '" + materialID + "';" );
			System.out.println(query);
						
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getMaterialTitle query execute successful");

			// Extract result
			materialTitle = rs.getString("MATERIAL_TITLE");
			System.out.println("getMaterialCourseID result: \n"
								+ "Material_ID: " + materialID + "\n"
								+ "MATERIAL_TITLE: " + materialTitle ); 

		} catch (SQLException e) {
			System.out.println("getMaterialTitle SQL Fail");
		}
		
		return materialID;
	}
	
	/**********************
	 * Getter
	 * @param materialID
	 * @return materialDesc
	 *********************/
	public String getMaterialDescription(String materialID) {
		
		String materialDesc = "";
		
		try {
			// Query
			String query = ("SELECT MATERIAL_DESC FROM COURSE_MATERIAL " +
							"WHERE MATERIAL_ID = '" + materialID + "';" );
			System.out.println(query);
						
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			System.out.println("getMaterialDescription query execute successful");

			// Extract result
			materialDesc = rs.getString("MATERIAL_DESC");
			System.out.println("getMaterialCourseID result: \n"
								+ "Material_ID: " + materialID + "\n"
								+ "MATERIAL_DESC: " + materialDesc ); 

		} catch (SQLException e) {
			System.out.println("getMaterialDescription SQL Fail");
		}
		
		return materialDesc;
	}

}
