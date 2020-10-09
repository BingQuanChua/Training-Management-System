package controllertrainee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeltraining.TrainingCourseSearch;
import modeltraining.TrainingProgressTrigger;
import modeltraining.TrainingRegistration;
import view.ListPanel;
import viewtrainee.AvailableTraining;
import viewtrainee.TraineeUI;

public class AvailableCourseController {
	
	private ArrayList<String> availableCourseList;
	private TrainingCourseSearch courseModel;
	private TraineeUI traineeUI;
	EnrolledCourseController enrolledCourseControl;
	private TrainingRegistration trainingRegistrationModel;
	private TrainingProgressTrigger progressTableTrigger;
	
	
	public AvailableCourseController(ArrayList<String> availableCourseList,
								  	TrainingCourseSearch courseModel,
								  	TraineeUI traineeUI,
								  	EnrolledCourseController enrolledCourseControl) {
		
		this.availableCourseList = availableCourseList;
		this.courseModel = courseModel;
		this.traineeUI = traineeUI;
		this.enrolledCourseControl = enrolledCourseControl;
		
		trainingRegistrationModel = new TrainingRegistration();
		progressTableTrigger = new TrainingProgressTrigger();
		
		setAvailableTrainingCourse();
		
	}
	
	public void setAvailableTrainingCourse() {

		availableCourseList = new ArrayList<>();		
		String courseID; String courseName; String courseDesc;
		String trainerID; String trainerName;

		try {
			// set Available Course
			courseModel.getAvailableTrainingCourseID(traineeUI.getTraineeID(), availableCourseList);
			for(int i = 0;  i < availableCourseList.size(); i++) {

				courseID = availableCourseList.get(i);
				trainerID = courseModel.getTrainingCourseDetails(courseID, 1);
				courseName = courseModel.getTrainingCourseDetails(courseID, 2);
				courseDesc = courseModel.getTrainingCourseDetails(courseID, 3);
				trainerName = courseModel.getTrainingCourseDetails(trainerID, 5);
				traineeUI.addAvailableTraining(courseID, courseName, courseDesc, 
						trainerID, trainerName);

				// add listener
				addAvailableTrainingCourseListener((AvailableTraining)traineeUI.getAvailableTrainingList().getItem(i), courseID);

			}
		} catch (Exception e) {
			System.out.println("setAvailableTrainingCourse Fail");
		}
	}
	
	private void addAvailableTrainingCourseListener(AvailableTraining at, String courseID) {
		// at.getTrainerProfileButton() // add listener for trainer profile
		
		at.getEnrollButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Confirm enrollment?", "Enroll Training Course", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					// add to database (training is enrolled)
					trainingRegistrationModel.addNewEnroll(traineeUI.getTraineeID(), courseID);
					progressTableTrigger.enrollCourseTrigger(courseID, traineeUI.getTraineeID());
					
					// remove from view (enrolled)
					ListPanel p = traineeUI.getAvailableTrainingList();
					p.getListOfPanel().remove(at);
					p.getContainerPanel().removeAll();
					for (JPanel temp : p.getListOfPanel()) {
						p.getContainerPanel().add(temp);
					}
					p.getContainerPanel().repaint();
					p.getContainerPanel().revalidate();
					
					// add to enrolled training list
					enrolledCourseControl.addNewEnrolledTrainingCourse(courseID);
				
					JOptionPane.showConfirmDialog (null, "You have enrolled to this training course.","Enroll Successfully",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
	}

}
