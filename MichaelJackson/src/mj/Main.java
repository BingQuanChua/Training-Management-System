package mj;

import view.Login; 
import view.UserUI;
import viewadmin.AdminUI;
import viewtrainee.TraineeUI;
import viewtrainer.TrainerUI;

import java.util.Scanner;

import model.*;
import modeluser.AdminModel;

public class Main {

	private static Login login;
	private static AdminUI adminUI;
	private static TrainerUI trainerUI;
	private static TraineeUI traineeUI;
	private static UserUI userUI;
	private AdminModel user;
	private String userID;
	
	public Main() {

		login = new Login();
		int loginRole = 1;

		login.setVisible(false);
		userID = "adm00001";

		/* TEST MODEL */
		/* TEST MODEL *DeleteMe/ 
		try {
			
			System.out.println("TMS model testing\n");
			Scanner scan = new Scanner(System.in);
			user = new AdminModel("adm00003");
			
			boolean condition = true;
			while(condition) {
				
				System.out.println("Please input a choice:");
				int choice = scan.nextInt();
				scan.nextLine(); //to consume the "Enter" 
				System.out.println("Please input a new data:");
				String newData = scan.nextLine();
				
				if(choice < 1 || choice > 8 ) {
					condition = false;
				} else {
					if(choice == 8) {
						user.deleteExistingUser(newData);
					} else if(choice != 7) {
						System.out.println("\n\nDatabase Execution\n");
						user.setAdminProfile(newData, choice);
						user.getAdminProfile(choice);
					}
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/**/
	
		// start showing the UI for admin/trainer/trainee
		
		roleLogin(loginRole);
	}

	
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

	public void roleLogin(int loginRole) {
		login.setVisible(false);
		switch (loginRole) {
		case 1:
			adminUI = new AdminUI(userID);
			new AdminController(adminUI);
			adminUI.setVisible(true);
			break;
		case 2:
			trainerUI = new TrainerUI(userID);
			new TrainerController(trainerUI);
			trainerUI.setVisible(true);
			break;
		case 3:
			traineeUI = new TraineeUI(userID);
			new TraineeController(traineeUI);
			traineeUI.setVisible(true);
			break;
		}
	}

}
