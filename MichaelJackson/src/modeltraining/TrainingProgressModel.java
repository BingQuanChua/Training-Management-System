package modeltraining;

import java.util.ArrayList;

import model.JDBCexecute;

public class TrainingProgressModel {
	
	// For database
	private JDBCexecute database;


	/**************
	 * Constructor
	 * init JDBC
	 *************/
	public TrainingProgressModel() {

		database = new JDBCexecute();
	}
	
	public boolean getMaterialIsDone(String traineeID, String materialID) throws Exception {
		
		String result = "Fail to Obtain Result";
		String column = "MATERIAL_IS_DONE";
		String query = ("SELECT MATERIAL_IS_DONE FROM PROGRESS " + 
						"WHERE USER_ID = '" + traineeID + "' "+ 
						"AND MATERIAL_ID = '" + materialID +"';" );
		
		result = database.executeQuery(query, column);
		
		if (result.equals("true") || result.toLowerCase().equals("true") ){
			return true;
		} else 
		if (result.equals("false") || result.toLowerCase().equals("false")) {
			return false;
		} 
		
		return false;
	}
	
	public boolean setMaterialIsDone(String traineeID, String materialID) {
		
		boolean materialIsDone = false;
		String query = ("UPDATE PROGRESS " + 
					    "SET MATERIAL_IS_DONE =" + " 'true' " +
					    "WHERE USER_ID = '" + traineeID + "' " + 
					    "AND MATERIAL_ID = '"+materialID+"';" );
		
		materialIsDone = database.executeUpdate(query);
		
		return materialIsDone;
	}
	
	public int calculateProgress(String traineeID, String courseID) {
		
		
		ArrayList<String> materialIDList = new ArrayList<>();
		String column = "MATERIAL_ID";
		String query = ("SELECT MATERIAL_ID FROM COURSE_MATERIAL " + 
						"WHERE COURSE_ID = '" + courseID +"';" );
		
		database.executeMultiRowQuery(query, column, materialIDList);
		
		int progress = 0;
		double total = materialIDList.size();
		double temp = 0;
		
		try {
			for(int i = 0; i<total ; i++) {
				if(getMaterialIsDone(traineeID, materialIDList.get(i))) {
					temp++;
					System.out.println("temp++ " + temp);
				} 
				
				progress = (int)((temp / total) * 100);
			}
		} catch (Exception e) {
			System.out.println("CalculateProgress Fail");			
		}
		
		
		return progress;
	}
}
