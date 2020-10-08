package controlleradmin;

import java.util.ArrayList;

import modeltraining.TrainingCourseSearch;
import modeltraining.TrainingProgressModel;
import modeluser.AdminModel;
import viewadmin.AdminUI;
import viewadmin.ReportTraining;
import viewadmin.Report;

public class ReportController {
	
	private AdminUI adminUI;
	private AdminModel adminModel;
	private TrainingCourseSearch courseSearch;
	private TrainingProgressModel progressModel;
	
	ArrayList <String> allCourseList;
	
	ReportController(AdminUI adminUI, AdminModel adminModel) {
		
		this.adminUI = adminUI;
		this.adminModel = adminModel;
		courseSearch = new TrainingCourseSearch();
		progressModel = new TrainingProgressModel();
		
		setAllTrainingReport();
		
	}
	
	public void setAllTrainingReport() {
		
		allCourseList = new ArrayList<>();
		courseSearch.getAllTrainingCourseID(allCourseList);
		
		for(int i = 0;  i< allCourseList.size(); i++) {
			addTrainingReport(i);
		}
		
	}
	
	
	public void addTrainingReport(int i){
		
		try {		
			
			ArrayList <String> enrolledTraineeList = new ArrayList<>();
			String courseID, courseName, courseDesc;

			courseID = allCourseList.get(i);
			courseName = courseSearch.getTrainingCourseDetails(courseID, 2);
			courseDesc = courseSearch.getTrainingCourseDetails(courseID, 3);

			// set all training in report
			adminUI.addReport(courseID, courseName, courseDesc);
			System.out.println("\n\n" +adminUI.getReportList().getListOfPanel().size()+ "\n\n");
			
			// set all trainee progress
			enrolledTraineeList.clear();
			courseSearch.getEnrolledTraineeID(courseID, enrolledTraineeList);

			for(int j = 0; j < enrolledTraineeList.size(); j++) {
					
				String traineeID = enrolledTraineeList.get(j);
				
				((ReportTraining)((Report) adminUI
						.getReportList()
						.getItem(i))
							.getReportTraining())
								.addProgress(
									traineeID, 
									adminModel.getUserProfile(traineeID, 1), 
									progressModel.calculateProgress(traineeID, courseID)); 				
			}
					
		} catch (Exception e) {
			System.out.println("\naddTrainingReport Fail\n");
		}
	}

}
