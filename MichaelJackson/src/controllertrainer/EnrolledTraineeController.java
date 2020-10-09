package controllertrainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modeltraining.TrainingProgressTrigger;
import modeltraining.TrainingRegistration;
import modeluser.TraineeModel;
import view.ListPanel;
import viewadmin.ManageUser;
import viewtrainer.TrainingMaterial;
import viewtrainer.TrainingTraineeList;

public class EnrolledTraineeController {
	private String courseID;
	private TrainingTraineeList traineeList;
	private TrainingRegistration trainingRegistrationModel;
	private TrainingProgressTrigger progressTableTrigger;
	
	public EnrolledTraineeController(String courseID, TrainingTraineeList traineeList) {
		this.courseID = courseID;
		this.traineeList = traineeList;
		trainingRegistrationModel = new TrainingRegistration();
		progressTableTrigger = new TrainingProgressTrigger();
		
		setEnrolledTraineeList();
	}
	
	private void setEnrolledTraineeList() {
		
		ArrayList<String> enrolledTraineeIDList = new ArrayList<>();
		
		trainingRegistrationModel.getEnrolledTraineeID(courseID, enrolledTraineeIDList);
		
		try {
			for(int i = 0;  i < enrolledTraineeIDList.size(); i++) {
				
				String traineeID = enrolledTraineeIDList.get(i);
				TraineeModel traineeModel = new TraineeModel(traineeID);
				String traineeName = traineeModel.getTraineeProfile(1);
				
				ManageUser temp;
				
				if(traineeName == null) 
					temp = new ManageUser("TraineeName", traineeID);				
				else 
					temp = new ManageUser(traineeName, traineeID);	
				
				addDeleteTraineeListener(temp);
				traineeList.getTraineeList().addItem(temp);
			}
		} catch (Exception e) {
			System.out.println("showTrainingList Fail");
		}
	}
	
	private void addDeleteTraineeListener(ManageUser mu) {
		mu.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to remove this trainee?", "Remove trainee", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					// remove from enroll
					String traineeID = mu.getUserID();
					trainingRegistrationModel.deleteEnroll(traineeID, courseID);
					
					// remove from progress
					progressTableTrigger.deleteTraineeTrigger(courseID, traineeID);
					
					// remove from view
					ListPanel p = traineeList.getTraineeList();
					p.getListOfPanel().remove(mu);
					p.getContainerPanel().removeAll();
					for (int i = 0; i < p.getListOfPanel().size(); i++) {
						ManageUser temp = (ManageUser) p.getListOfPanel().get(i);
						temp.getNumberLabel().setText((i+1)+".");
						p.getContainerPanel().add(temp);
					}
					p.getContainerPanel().repaint();
					p.getContainerPanel().revalidate();
				}
			}
		});
	}
}
