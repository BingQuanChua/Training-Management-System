package mj;
import viewadmin.AddNewCourse;
import viewadmin.AdminUI;
import viewadmin.ManageUser;
import viewadmin.AllTraineeList;
import viewadmin.AllTrainerList;
import modeluser.AdminModel;
import view.ListPanel;

import java.sql.SQLException;
import javax.swing.JOptionPane;



public class UserManagementController {
	private AdminUI adminUI;
	private AdminModel adminModel;
	private AdminController adminController;
	private String userType = "";
	private String trainerChar = "";
	private String traineeChar = "";
	private String userID;
	private String userPass;
	
	public UserManagementController(AdminUI adminUI, AdminModel adminModel, AdminController adminController) {
		this.adminUI = adminUI;
		this.adminModel = adminModel;
		this.adminController = adminController;
	}	
	
	public void addNewUser() throws Exception {
	    userID = adminUI.getAddNewUser().getUserIDField().getText().toLowerCase();
	    userPass = adminUI.getAddNewUser().getPasswordField().getText();
		int response = JOptionPane.showConfirmDialog (null, "Are you sure want to register this new account?","WARNING",JOptionPane.YES_NO_OPTION);
		if (response == 0) {
			
			if(validateEmpty() && validateCheckBox() ) {
				
				if(adminUI.getAddNewUser().getTrainerBox().getState() == true) {
					
					trainerChar = userID.substring(0,3);
					
					if(validateTrainer(trainerChar) && validateID(userID)) {	
						userType = "trainer";
						boolean success = adminModel.addNewUser(userID, userPass, userType);
						
						if(success) {
						ManageUser newTrainer = new ManageUser(adminModel.getUserName(userID,2),userID);
					
						if(adminModel.getUserName(userID,2) == null) 
							newTrainer = new ManageUser("TrainerName",userID);
					
							adminUI.getAllTrainerList().getTrainerList().addItem(newTrainer);
							ListPanel trainerPanel = adminUI.getAllTrainerList().getTrainerList();
							for (int i = 0; i < trainerPanel.getListOfPanel().size(); i++) {
								ManageUser temp = (ManageUser) trainerPanel.getListOfPanel().get(i);
								temp.getNumberLabel().setText((i+1)+".");
								trainerPanel.getContainerPanel().add(temp);
							}
							adminController.addDeleteTrainerListener((ManageUser) trainerPanel.getItem(trainerPanel.getListOfPanel().size()-1));
							JOptionPane.showConfirmDialog (null, "Account has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
							adminUI.home();
						}
						else {
							JOptionPane.showConfirmDialog (null, "Error! Invalid Input.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showConfirmDialog (null, "Error! Wrong format of user ID for trainer. Example of correct format: trn00001","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(adminUI.getAddNewUser().getTraineeBox().getState() == true) {
				
					traineeChar = userID.substring(0,3);
					
					if(validateTrainee(traineeChar) && validateID(userID)) {
						
						userType = "trainee";
						boolean success = adminModel.addNewUser(userID, userPass, userType);
						System.out.println(success);
						if(success) {
						ManageUser newTrainee = new ManageUser(adminModel.getUserName(userID,1),userID);
						
						if(adminModel.getUserName(userID,1) == null) 
							newTrainee = new ManageUser("TraineeName",userID);
					
						adminUI.getAllTraineeList().getTraineeList().addItem(newTrainee);
						ListPanel traineePanel = adminUI.getAllTraineeList().getTraineeList();
						for (int i = 0; i < traineePanel.getListOfPanel().size(); i++) {
							ManageUser temp = (ManageUser) traineePanel.getListOfPanel().get(i);
							temp.getNumberLabel().setText((i+1)+".");
							traineePanel.getContainerPanel().add(temp);
						}
						
						adminController.addDeleteTraineeListener((ManageUser) traineePanel.getItem(traineePanel.getListOfPanel().size()-1));
						JOptionPane.showConfirmDialog (null, "Account has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
						adminUI.home();
						}
						else {
							JOptionPane.showConfirmDialog (null, "Error! Invalid Input.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
					
					}
					else {
						JOptionPane.showConfirmDialog (null, "Error! Wrong format of user ID for trainee. Example of correct format: tre00001","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else {
				JOptionPane.showConfirmDialog (null, "Error! No empty field or checkbox allowed.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private boolean validateEmpty() {
		if(adminUI.getAddNewUser().getUserIDField().getText().contains("Enter userID") || adminUI.getAddNewUser().getPasswordField().getText().contains("Enter password")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean validateCheckBox() {
		if(adminUI.getAddNewUser().getTrainerBox().getState() == false && adminUI.getAddNewUser().getTraineeBox().getState() == false) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean validateTrainer(String user) {
		if(user.equals("tnr"))
			return true;
		else
			return false;
	}
	
	private boolean validateTrainee(String user) {
		if(user.equals("tne"))
			return true;
		else
			return false;
	}
	
	private boolean validateID(String user) {
		if (user.length() != 8) {
			return false;
		}
		for (int i = 3; i < user.length(); i++) {
			if(!Character.isDigit(user.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
