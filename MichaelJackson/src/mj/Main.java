package mj;

import login.Login;  
import view.UserUI;
import viewadmin.AdminUI;
import viewtrainee.TraineeUI;
import viewtrainer.TrainerUI;
import modeluser.AdminModel;
import modeluser.TrainerModel;
import modeluser.TraineeModel;
import controllertrainee.TraineeController;

import java.util.Scanner;

public class Main {

	private static Login login;
	private static AdminUI adminUI;
	private static TrainerUI trainerUI;
	private static TraineeUI traineeUI;
	private static AdminModel adminModel;
	private static TrainerModel trainerModel;
	private static TraineeModel traineeModel;
	private static UserUI userUI;
	private AdminModel user;
	private String userID;
	
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}/**/
		
		new Main();
	}

	
	public Main() {

		login = new Login();
		login.setVisible(false);
		

		Scanner scan = new Scanner(System.in);
		int loginRole = 0;
		boolean invalidChoice = true;
		while(invalidChoice) {
			
			System.out.println("Select loginRole (1 / 2 / 3) :");
			int choice = scan.nextInt();
			
			if(choice ==1) {
				loginRole = 1;
				userID = "adm00001";
				invalidChoice = false;
			} else
			if(choice == 2) {
				loginRole = 2;
				userID = "tnr00001";
				invalidChoice = false;
			} else
			if (choice == 3) {
				loginRole = 3;
				userID = "tne00001";
				invalidChoice = false;
			}
		}	
		
		// start showing the UI for admin/trainer/trainee	
		roleLogin(loginRole);
	}
	
	
	public void roleLogin(int loginRole) {
		login.setVisible(false);
		switch (loginRole) {
		case 1:
			adminUI = new AdminUI(userID);
			adminModel = new AdminModel(userID);
			new AdminController(adminUI,adminModel);
			adminUI.setVisible(true);
			break;
		case 2:
			trainerUI = new TrainerUI(userID);
			trainerModel = new TrainerModel(userID);
			new TrainerController(trainerUI, trainerModel);
			trainerUI.setVisible(true);
			break;
		case 3:
			traineeUI = new TraineeUI(userID);
			traineeModel = new TraineeModel(userID);
			new TraineeController(traineeUI, traineeModel);
			traineeUI.setVisible(true);
			break;
		}
	}

}
