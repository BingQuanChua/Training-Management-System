package mj;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeltraining.TraineeTrainingCourseModel;
import modeltraining.TrainingProgress;
import modeluser.TraineeModel;
import view.IndividualProgress;
import view.ListPanel;
import viewtrainee.EnrolledTraining;
import viewtrainee.EnrolledTrainingDetails;
import viewtrainee.EnrolledTrainingMaterial;
import viewtrainee.TraineeUI;

public class TraineeController {
	
	private TraineeUI traineeUI;
	private TraineeModel traineeModel;
	private TraineeTrainingCourseModel courseModel;
	private TrainingProgress progressModel;
	
	private EnrolledTrainingDetails tempEnrolledTrainingDetails;
	private IndividualProgress tempProgressBar;
	private ListPanel tempTrainingMaterialList;
	
	private String traineeID;
	
	TraineeController(TraineeUI traineeUI, TraineeModel traineeModel){
		
		System.out.println("\n\n####################\n"
						+ "TraineeController\n"
						+ "####################\n");
		
		this.traineeUI = traineeUI;
		this.traineeModel = traineeModel;
		this.traineeID = traineeModel.getTraineeID();
		courseModel = new TraineeTrainingCourseModel();
		progressModel = new TrainingProgress();
		setAvailableTrainingCourse();
		setEnrolledTrainingCourse();
		setAvailableTrainingCourseListener();
		setEnrolledTrainingCourseListener();
		
		System.out.println("\n\n####################\n"
						+ "TraineeController End\n"
						+ "####################\n");
	}

	
	public void setAvailableTrainingCourse() {
		
		ArrayList <String> availableTrainingCourseList = new ArrayList<>();
		courseModel.getAllTrainingCourseID(availableTrainingCourseList);
		
		String courseID; String courseName; String courseDesc;
		String trainerID; String trainerName;
		
		try {
			for(int i = 0;  i< availableTrainingCourseList.size(); i++) {
				
				courseID = availableTrainingCourseList.get(i);
				trainerID = courseModel.getTrainingCourseDetails(courseID, 1);
				courseName = courseModel.getTrainingCourseDetails(courseID, 2);
				courseDesc = courseModel.getTrainingCourseDetails(courseID, 3);
				trainerName = courseModel.getTrainingCourseDetails(trainerID, 5);
				traineeUI.addAvailableTraining(courseID, courseName, courseDesc, 
											   trainerID, trainerName);
				
			}
		} catch (Exception e) {
			System.out.println("setAvailableTrainingCourse Fail");
		}
	}
	
	
	public void setEnrolledTrainingCourse() {
		
		ArrayList <String> enrolledTrainingCourseList = new ArrayList<>();
		courseModel.getEnrolledTrainingCourseID(traineeModel.getTraineeID(), enrolledTrainingCourseList);
		
		String courseID; String courseName; String courseDesc;
		String trainerID; String trainerName;
		
		try {
			for(int i = 0;  i< enrolledTrainingCourseList.size(); i++) {
				
				// set enrolled course
				courseID = enrolledTrainingCourseList.get(i);
				trainerID = courseModel.getTrainingCourseDetails(courseID, 1);
				courseName = courseModel.getTrainingCourseDetails(courseID, 2);
				courseDesc = courseModel.getTrainingCourseDetails(courseID, 3);
				trainerName = courseModel.getTrainingCourseDetails(trainerID, 5);
				traineeUI.addEnrolledTraining(courseID, courseName, courseDesc,
											  trainerID, trainerName, 
											  traineeModel.getTraineeProfile(1));
				
				// Set progress
				((EnrolledTraining)traineeUI.getEnrolledTrainingList()
						  .getItem(i))  //return EnrolledTraining
						  .getTrainingDetails()  // return EnrolledTrainingDetail
						  .getIndividualProgress()
				 		  .setIndividualProgress(
				 				  traineeModel.getTraineeProfile(1), 
				 				  traineeID, 
				 				  progressModel.calculateProgress(traineeID, courseID));
			}
		} catch (Exception e) {
			System.out.println("setEnrolledTrainingCourse Fail");
		}
	}
	
	
	private void setAvailableTrainingCourseListener() {
		
	}
	
	private void setEnrolledTrainingCourseListener() {
		// setListener to each of the EnrolledTraining
		// will change, need to loop here
		EnrolledTraining temp = (EnrolledTraining) traineeUI.getEnrolledTrainingList().getItem(0);
		temp.getEnrolledTrainingButton().addActionListener(trainingButtonListener);
		tempEnrolledTrainingDetails = temp.getTrainingDetails();
		// description text area update
		// trainee profile button listener
		// trainer profile button listener
		tempProgressBar = tempEnrolledTrainingDetails.getIndividualProgress();
		
		
		/*
		tempTrainingMaterialList = tempEnrolledTrainingDetails.getTrainingMaterialList();
		for (JPanel material : tempTrainingMaterialList.getListOfPanel()) {
			// add listener to each mark as done button on each training material
			addMarkAsDoneListener((EnrolledTrainingMaterial) material);
		}/**/
		// tempProgress
		// feedbackButton
		// tempMaterialList
	
	}
	
	ActionListener trainingButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			traineeUI.getPanelBody().removeAll();
			traineeUI.getPanelBody().add(tempEnrolledTrainingDetails);
			traineeUI.getPanelBody().repaint();
			traineeUI.getPanelBody().revalidate();
		}
	};
	
	/*
	private void addMarkAsDoneListener(EnrolledTrainingMaterial m) {
		m.getDoneButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "This button can only be clicked once. Are you sure about that?", "Complete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					m.getDoneButton().setEnabled(false);
					tempEnrolledTrainingDetails.increaseNumberOfCompletedMaterial(); // increase by 1
					int progress = (tempEnrolledTrainingDetails.getNumberOfCompletedMaterial()*100 / tempTrainingMaterialList.getListOfPanel().size());
					tempProgressBar.setProgress(progress);
					
					if(tempProgressBar.getProgress() == 100) {
						tempEnrolledTrainingDetails.getFeedbackButton().setVisible(true);
					}
				}
			}
		});
	}
	*/
}
