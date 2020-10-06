package mj;
import viewadmin.AddNewCourse;
import viewadmin.AdminUI;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import modeluser.AdminModel;

public class UserManagementController {
	private AdminUI adminUI;
	private AdminModel adminModel;
	private String userType = "";
	private String trainerChar = "";
	private String traineeChar = "";
	
	public UserManagementController(AdminUI adminUI, AdminModel adminModel) {
		this.adminUI = adminUI;
		this.adminModel = adminModel;
	}	
	
	public void addNewUser() {
		if(adminUI.getAddNewUser().getTrainerBox().getState() == true) {
			
			trainerChar = adminUI.getAddNewUser().getUserIDField().getText().toLowerCase().substring(0,3);
			if(validateTrainer(trainerChar)) {
			userType = "trainer";
			}
			else {
				JOptionPane.showConfirmDialog (null, "Error! ","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if(adminUI.getAddNewUser().getTraineeBox().getState() == true) {
		
			traineeChar = adminUI.getAddNewUser().getUserIDField().getText().toLowerCase().substring(0,3);
			if(validateTrainee(traineeChar)) {
			userType = "trainee";
			}
			else {
				JOptionPane.showConfirmDialog (null, "Error! ","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			
			}
		}
		
		int response = JOptionPane.showConfirmDialog (null, "Are you sure want to register this new account?","WARNING",JOptionPane.YES_NO_OPTION);
		if (response == 0) {
			if(validateEmpty() && validateCheckBox()) {
				adminModel.addNewUser(adminUI.getAddNewUser().getUserIDField().getText().toLowerCase(), adminUI.getAddNewUser().getPasswordField().getText(), userType);
				JOptionPane.showConfirmDialog (null, "Account has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				adminUI.home();
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
		if(user.equals("trn"))
			return true;
		else
			return false;
	}
	
	private boolean validateTrainee(String user) {
		if(user.equals("tre"))
			return true;
		else
			return false;
	}
}
