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
import controllertrainer.TrainerController;

import java.util.Scanner;

import controlleradmin.AdminController;

public class Main {
	
	private Login login;
	
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

		//login = new Login();
		//login.setVisible(true);
		
/**/
		Scanner scan = new Scanner(System.in);
		int loginRole = 0;
		String userID = "";
		UserLogin userLogin;
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
			
			if(!invalidChoice)
				userLogin = new UserLogin(loginRole, userID);
		}
/**/
	}

}
