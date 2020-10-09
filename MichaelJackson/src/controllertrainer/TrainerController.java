package controllertrainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modeltraining.ManageTrainingCourse;
import modeltraining.TrainingCourseSearch;
import modeluser.TrainerModel;
import view.ListPanel;
import view.SubMenu;
import viewtrainer.TrainerUI;
import viewtrainer.Training;
import viewtrainer.TrainingMaterial;
import viewtrainer.TrainingMaterialDetails;
import viewtrainer.TrainingRequestList;
import viewtrainer.TrainingTraineeList;

public class TrainerController {
	
	// View
	private TrainerUI trainerUI;
	private TrainerModel trainerModel;
	
	// Controller
	private TraineeProgressController progressController;
	private TrainingCourseMaterialController trainingCourseMaterialController;
	
	// Model
	private ManageTrainingCourse trainingCourseModel;
	private TrainingCourseSearch courseSearch;
	
	// Variables
	private String feedbackLink = "";
	
	// Constructor
	public TrainerController(TrainerUI trainerUI, TrainerModel trainerModel) {
		
		this.trainerUI = trainerUI;
		this.trainerModel = trainerModel;
		courseSearch = new TrainingCourseSearch();

		System.out.println("\n\n********************\n"
				 		 + "Trainer Controller\n\n");
		
		System.out.println("\n\nsetManageTrainingCourse\n");
		setManageTrainingCourse();
		
		System.out.println("\n\nsetTrainingProgress\n");
        setTrainingProgress(trainerUI, courseSearch, trainerModel);
        
        System.out.println("\n\nTrainer Controller\n"
				 		 + "*********************\n");
	}
	
	// Allow trainer to manage
	// 1: Assigned training course
	// 2: material
	// 3: trainee
	private void setManageTrainingCourse() {
		
		ArrayList <String> assignedTrainingCourseList = new ArrayList<>();
		courseSearch.getAssignedTrainingCourseID(trainerModel.getTrainerID(), assignedTrainingCourseList);
		try {
			for(int i = 0;  i< assignedTrainingCourseList.size(); i++) {			
				
				String tempCourseID = assignedTrainingCourseList.get(i);
				Training tempTraining = new Training(courseSearch.getTrainingCourseDetails(tempCourseID, 2), tempCourseID);
				
				// setting individual description in Training
				String tempCourseDesc = courseSearch.getTrainingCourseDetails(tempCourseID, 3);
				tempTraining.getTextArea().setText(tempCourseDesc);
				
				// setting listeners to the buttons
				addTrainingButtonListener(tempTraining, tempCourseID);
				
				// add Training
				trainerUI.getTrainingList().addItem(tempTraining);
				
			}
		} catch (Exception e) {
			System.out.println("setEnrolledTrainingCourse Fail");
		}
	}
	
	// Allow trainer to view trainee progress and profile
	private void setTrainingProgress(TrainerUI trainerUI, 
									 TrainingCourseSearch courseSearch,
									 TrainerModel trainerModel) {
		
		progressController = new TraineeProgressController(trainerUI,
															courseSearch,
															trainerModel);
		
		
	}
	
	// Add listener to manage training
	private void addTrainingButtonListener(Training training, String courseID) {
		
		trainingCourseMaterialController = new TrainingCourseMaterialController();
		trainingCourseModel = new ManageTrainingCourse();
		try {
			
			String courseName = courseSearch.getTrainingCourseDetails(courseID, 2);
			String courseDesc = courseSearch.getTrainingCourseDetails(courseID, 3);
			
			
			TrainingMaterialDetails trainingMaterialDetails = new TrainingMaterialDetails(courseName, courseID);
			
			training.getUpdateButton().addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					
					// set description
					trainingMaterialDetails.getTextArea().setText(courseDesc);
					
					trainerUI.getPanelBody().removeAll();
					trainerUI.getPanelBody().add(new SubMenu("Manage Training Course", trainingMaterialDetails));
					trainerUI.getPanelBody().repaint();
					trainerUI.getPanelBody().revalidate();
				}
			});
			
			// set listener to add new material button
			trainingMaterialDetails.getAddNewMaterialButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					trainingCourseMaterialController.addNewMaterial(courseID, trainingMaterialDetails.getTrainingMaterialList());
				}
			});
			trainingCourseMaterialController.showMaterial(courseID, trainingMaterialDetails.getTrainingMaterialList());
			
			
			TrainingTraineeList traineeList = new TrainingTraineeList(courseID);
			EnrolledTraineeController enrolledTraineeController = new EnrolledTraineeController(courseID, traineeList);
			training.getTraineeListButton().addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					trainerUI.getPanelBody().removeAll();
					trainerUI.getPanelBody().add(new SubMenu("Manage Training Course", traineeList));
					trainerUI.getPanelBody().repaint();
					trainerUI.getPanelBody().revalidate();
				}
			});
			
			training.getFeedbackButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String newLink = "";
					try {
						feedbackLink = courseSearch.getTrainingCourseDetails(courseID, 6);
						
						if (feedbackLink.length() == 0) {
							newLink = JOptionPane.showInputDialog("Enter Google Form link");
						}
						else {
							int response = JOptionPane.showConfirmDialog (null, "You have entered a link previously.\nExisting Google Form link:\n" + feedbackLink + "\n\nDo you want to overwrite it?","WARNING",JOptionPane.YES_NO_OPTION);
							if (response == 0) {
								newLink = JOptionPane.showInputDialog("Existing Google Form link:\n" + feedbackLink + "\n\nEnter new Google Form link");
							}
						}
												
					} catch (Exception e1) {
						System.out.println("Feedback link unable to get");
					}
					if (newLink.length() != 0) {
						trainingCourseModel.setTrainingCourseDetails(newLink, courseID, 5);
					}
				}
			});
			
		} catch (Exception e1) {

			System.out.println("addTrainingButtonListener Fail");
		}
	}
}
