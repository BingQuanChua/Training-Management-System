package controlleradmin;

import viewadmin.AdminUI;
import viewadmin.ManageUser;

import modeluser.AdminModel;

import view.ListPanel;

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
				if (validatePassword(userPass)) {
				if(adminUI.getAddNewUser().getTrainerBox().isSelected() == true) {
					
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
							adminController.addProfileListener((ManageUser) trainerPanel.getItem(trainerPanel.getListOfPanel().size()-1));
							JOptionPane.showConfirmDialog (null, "Account has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
							adminUI.home();
						}
						else {
							JOptionPane.showConfirmDialog (null, "Error! Invalid Input.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showConfirmDialog (null, "Error! Wrong format of user ID for trainer. Example of correct format: tnr00001","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(adminUI.getAddNewUser().getTraineeBox().isSelected() == true) {
				
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
						adminController.addProfileListener((ManageUser) traineePanel.getItem(traineePanel.getListOfPanel().size()-1));
						JOptionPane.showConfirmDialog (null, "Account has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
						adminUI.home();
						}
						else {
							JOptionPane.showConfirmDialog (null, "Error! Invalid Input.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						}
					
					}
					
					else {
						JOptionPane.showConfirmDialog (null, "Error! Wrong format of user ID for trainee. Example of correct format: tne00001","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
					}
				}
				}
				else {
					JOptionPane.showConfirmDialog (null, "Error! Wrong password format. The password should consists of a minimum length of 10 with at least one uppercase alphabetic character, one number and one symbol.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
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
		if(adminUI.getAddNewUser().getTrainerBox().isSelected() == false && adminUI.getAddNewUser().getTraineeBox().isSelected() == false) {
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
	
	public static boolean validatePassword(String password) {
		
		boolean containsLowerCase = false;
		boolean containsUpperCase = false;
		boolean containsNumber = false;
		boolean containsSymbol = false;

		String symbol = "!@#$%^&*()_+{}|:<>?-=[];,./~`";

		if(password.length() < 10) {
			System.out.println("Password must be at least 10 characters");
			return false; // invalid
		}
		for(int i = 0; i < password.length(); i++) {
			boolean flag = true; // contains illegal characters

			if(Character.isDigit(password.charAt(i))) {
				containsNumber = true;
				flag = false;
			}
			else {
				if(Character.isLowerCase(password.charAt(i))) {
					containsLowerCase = true;
					flag = false;
				}
				else {
					if(Character.isUpperCase(password.charAt(i))) {
						containsUpperCase = true;
						flag = false;
					}
					else {
						for(int j = 0; j < symbol.length(); j++) {
							if(password.charAt(i) == symbol.charAt(j)) {
								containsSymbol = true;
								flag = false;
							}
						}
					}
				}
			}

			if(flag) {
				System.out.println("<!> Password contains illegal characters");
				return false; // invalid
			}
		}

		if(!containsLowerCase) {
			System.out.println("Password must contain at least one lowercase");
		}
		if(!containsUpperCase) {
			System.out.println("Password must contain at least one uppercase");
		}
		if(!containsNumber) {
			System.out.println("Password must contain at least one number");
		}
		if(!containsSymbol) {
			System.out.println("Password must contain at least one symbol");
		}

		if(containsLowerCase && containsUpperCase && containsNumber && containsSymbol) {
			// valid password
			System.out.println("Password is strong ^^");
			return true;
		}
		else {
			return false; // invalid
		}
	}
}
