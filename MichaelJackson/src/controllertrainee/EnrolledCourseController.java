package controllertrainee;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeltraining.TrainingCourseSearch;
import modeltraining.TrainingProgress;
import modeluser.TraineeModel;
import view.JButtonID;
import viewtrainee.EnrolledTraining;
import viewtrainee.EnrolledTrainingDetails;
import viewtrainee.EnrolledTrainingMaterial;
import viewtrainee.TraineeUI;

public class EnrolledCourseController {
	
	private TrainingProgress progressModel;
	private ArrayList<String> enrolledCourseList;
	private TrainingCourseSearch courseModel;
	private TraineeModel traineeModel;
	private TraineeUI traineeUI; 
	private String traineeID;
	
	EnrolledCourseController(ArrayList<String> enrolledCourseList,
							 TrainingCourseSearch courseModel,
							 TraineeModel traineeModel,
							 TraineeUI traineeUI ){
		
		this.enrolledCourseList = enrolledCourseList;
		this.courseModel = courseModel;
		this.traineeModel = traineeModel;
		this.traineeUI = traineeUI;
		progressModel = new TrainingProgress();
		traineeID = traineeModel.getTraineeID();
		
		setEnrolledTrainingCourse();
		
	}
	

	public void setEnrolledTrainingCourse() {

		enrolledCourseList = new ArrayList<>();
		ArrayList <String> courseMaterialList = new ArrayList<>();
		String courseID; String courseName; String courseDesc;
		String trainerID; String trainerName;
		String materialID; String materialTitle; String materialDesc;

		try {
			courseModel.getEnrolledTrainingCourseID(traineeModel.getTraineeID(), enrolledCourseList);
			for(int i = 0;  i< enrolledCourseList.size(); i++) {

				// set enrolled course
				courseID = enrolledCourseList.get(i);
				System.out.println("\nLOOP: " + courseID + "\n");
				trainerID = courseModel.getTrainingCourseDetails(courseID, 1);
				courseName = courseModel.getTrainingCourseDetails(courseID, 2);
				courseDesc = courseModel.getTrainingCourseDetails(courseID, 3);
				trainerName = courseModel.getTrainingCourseDetails(trainerID, 5);
				traineeUI.addEnrolledTraining(courseID, courseName, courseDesc,
						trainerID, trainerName, 
						traineeModel.getTraineeProfile(1));

				// add listener
				addEnrolledTrainingCourseListener(i);

				// Set progress
				((EnrolledTraining)traineeUI.getEnrolledTrainingList()
						.getItem(i))  //return EnrolledTraining
				.getTrainingDetails()  // return EnrolledTrainingDetail
				.getIndividualProgress()
				.setIndividualProgress(
						traineeModel.getTraineeProfile(1), 
						traineeID, 
						progressModel.calculateProgress(traineeID, courseID));

				// set material
				courseMaterialList.clear();
				courseModel.getAllCourseMaterial(courseID, courseMaterialList);
				for(int j = 0; j < courseMaterialList.size(); j++) {
					materialID = courseMaterialList.get(j);
					materialTitle = courseModel.getCourseMaterialDetails(materialID, 2);
					materialDesc = courseModel.getCourseMaterialDetails(materialID, 3);
					((EnrolledTraining)traineeUI.getEnrolledTrainingList()
							.getItem(i))  //return EnrolledTraining
					.getTrainingDetails()  // return EnrolledTrainingDetail
					.addCourseMaterial(courseID, trainerName, 
							materialID, materialTitle, materialDesc);

					// Mark as done
					if(progressModel.getMaterialIsDone(traineeID, materialID).equals("true")) {
						// disable button
						System.out.println("### closeMarkAsDone ### " + materialID);
						closeMarkAsDoneListener(i, j);
					} else {
						// add listener
						System.out.println("### addMarkAsDone ### " + materialID);
						addMarkAsDoneListener(i, j);
					}
				}

			}
		} catch (Exception e) {
			System.out.println("setEnrolledTrainingCourse Fail");
		}
	}
	
	public void addNewEnrolledTrainingCourse(String courseID) {
		
	}


	private void addEnrolledTrainingCourseListener(int i) {

		EnrolledTrainingDetails tempETD;

		((EnrolledTraining)traineeUI
				.getEnrolledTrainingList().getItem(i))
				.getEnrolledTrainingButton()
				.addActionListener(trainingButtonListener);

		tempETD = ((EnrolledTraining)traineeUI
				.getEnrolledTrainingList()
				.getItem(i))
				.getTrainingDetails();
	}

	ActionListener trainingButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			JButtonID tempJButton = (JButtonID) e.getSource(); 
			traineeUI.getPanelBody().removeAll();
			traineeUI.getPanelBody().add(getEnrolledTrainingDetails(tempJButton.getUserID()));
			traineeUI.getPanelBody().repaint();
			traineeUI.getPanelBody().revalidate();
		}
	};



	private void closeMarkAsDoneListener(int i, int j) {

		((EnrolledTrainingMaterial)((EnrolledTraining)traineeUI
				.getEnrolledTrainingList()
				.getItem(i))  //return EnrolledTraining
					.getTrainingDetails()  // return EnrolledTrainingDetail
					.getTrainingMaterialList()
					.getItem(j))
						.getDoneButton()
						.setEnabled(false);
	}


	private void addMarkAsDoneListener(int i, int j) {

		EnrolledTrainingMaterial tempETM;

		tempETM = ((EnrolledTrainingMaterial)((EnrolledTraining)traineeUI
						.getEnrolledTrainingList()
						.getItem(i))  //return EnrolledTraining
							.getTrainingDetails()  // return EnrolledTrainingDetail
							.getTrainingMaterialList()
							.getItem(j));

		tempETM.getDoneButton()
			   .addActionListener(markAsDoneListener);
	}

	ActionListener markAsDoneListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int input = JOptionPane.showConfirmDialog(null, "This button can only be clicked once. Are you sure about that?", "Complete Material", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
			// 0 = yes, 1 = no, 2 = cancel
			if (input == 0) {
				JButtonID tempButton = (JButtonID) e.getSource();
				tempButton.setEnabled(false);
				progressModel.setMaterialIsDone(traineeID, tempButton.getMaterialID());
				resetProgress(tempButton.getMaterialID());
			}
		}
	};

	public void resetProgress(String materialID) {
		String courseID;
		try {
			courseID = courseModel.getCourseMaterialDetails(materialID, 1);
			int index = enrolledCourseList.indexOf(courseID);
			((EnrolledTraining)traineeUI.getEnrolledTrainingList()
					.getItem(index))  //return EnrolledTraining
					.getTrainingDetails()  // return EnrolledTrainingDetail
					.getIndividualProgress()
					.setIndividualProgress(
							traineeModel.getTraineeProfile(1), 
							traineeID, 
							progressModel.calculateProgress(traineeID, courseID));
			
		} catch (Exception e) {
			System.out.println("resetProgress Fail");
		}
	}

	public JPanel getEnrolledTrainingDetails(String courseID) {

		try {
			int index = enrolledCourseList.indexOf(courseID);
			return
					((EnrolledTraining)traineeUI.getEnrolledTrainingList()
							.getItem(index))  //return EnrolledTraining
					.getTrainingDetails();  // return EnrolledTrainingDetail

		} catch (Exception e) {
			System.out.println("resetProgress Fail");
		}

		return null;
	}

}
