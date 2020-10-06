package modeltraining;

import java.util.ArrayList;

import model.JDBCexecute;

public class AllTrainingCourse {
	
	private JDBCexecute database;
	
	public AllTrainingCourse(){
	
		database = new JDBCexecute();
	}
	
	public void getAllTrainingCourseID(ArrayList<String> IDList) {
		
		String column = "COURSE_ID";
		String query = ("SELECT COURSE_ID FROM TRAINING_COURSE; " );
		
		database.executeMultiRowQuery(query, column, IDList);
	}
	
	
	public String getTrainingCourseDetails(String courseID, int choice) throws Exception {
		
		String courseDetails = "Fail To Obtain Result";
		String query = "";
		String column = "";

		// Query
		switch(choice) 
		{
			case 1:	
				query = ("SELECT USER_ID FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "USER_ID";
				break;
			case 2: 
				query = ("SELECT COURSE_NAME FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "COURSE_NAME";
				break;
			case 3: 
				query = ("SELECT COURSE_DESC FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "COURSE_DESC";
				break;
			case 4: 
				query = ("SELECT COURSE_DATE FROM TRAINING_COURSE WHERE COURSE_ID = '"+ courseID +"';");
				column = "COURSE_DATE";
				break;
			default:
				System.out.println("Invalid choice");
				return courseDetails;
		}

		
		// Execute Query
		courseDetails = database.executeQuery(query, column);
		System.out.println("getTrainingCourseDetails Result \n"
				+ "CourseID: " + courseID + "\n" 
				+ column + ": " + courseDetails);

		return courseDetails;
	}

}
