package model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCexecute {
	
	// For database
	private String url = JDBCinfo.getURL();
	private String serverName = JDBCinfo.getServerName();
	private String serverPassword = JDBCinfo.getServerPassword();
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	/******************
	 * Constructor
	 * initialize JDBC
	 *****************/
	public JDBCexecute(){
		
		try {
			con = DriverManager.getConnection(url, serverName, serverPassword);
			st = con.createStatement();
			System.out.println("JDBCquery: Connected to Database\n");
		} catch (SQLException e) {
			System.out.println("??? JDBCquery: Fail to Connect Database ???\n");
		}	
	}
	
	/**
	 * Database: SET, INSERT, DELETE
	 * 
	 * @param query
	 * @return boolean
	 */
	public boolean executeUpdate(String query) {
		
		try {
			// Query
			System.out.println(query);
						
			// Execute Query 
			st.executeUpdate(query);			
			System.out.println("executeUpdate Success");
			return true;
				
		} catch (SQLException e) {
			System.out.println("??? executeUpdate Fail ???");
		}
		
		return false;
	}
	
	/**
	 * Database: SELECT
	 * 
	 * @param query
	 * @param column
	 * @return result
	 * @throws Exception
	 */
	public String executeQuery(String query, String column) throws Exception {
		
		String result = "Fail To Obtain Result";
		
		try {
			// Query
			System.out.println(query);
			
			// Execute Query
			rs = st.executeQuery(query);
			rs.next();
			
			// Extract result
			result = rs.getString(column);
			
			System.out.println("Result: " + result);
			System.out.println("executeQuery Successful");
			
		} catch (SQLException e) {
			System.out.println("??? executeQuery Fail ???");
		}
		
		return result;
	}
	
	/**
	 * Close Database 
	 * (After log out)
	 */
	public void closeDatabase() {
		
		try {
			// Close statement
			st.close();
		} catch (SQLException e) {
			System.out.println("Database fail to closed"); 
			e.printStackTrace();
		}
		System.out.println("Database closed");
	}
}
