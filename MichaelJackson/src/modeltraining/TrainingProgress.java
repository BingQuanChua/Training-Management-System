package modeltraining;

import model.JDBCexecute;

public class TrainingProgress {
	
	// For database
	private JDBCexecute database;


	/**************
	 * Constructor
	 * init JDBC
	 *************/
	public TrainingProgress() {

		database = new JDBCexecute();
	}
	
	public String getTraineeProgres(String traineeID, String materialID) {
		
		return "";
	}
	
	public boolean updateTraineeProgress(String traineeID, String materialID) {
		
		String query = "UPDATE PROGRESS " + 
					   "SET MATERIAL_IS_DONE =" + " 'true' " +
					   "WHERE USER_ID = '" + traineeID + "' " + 
					   "AND MATERIAL_ID = '"+materialID+"';";
		
		return false;
	}
}
