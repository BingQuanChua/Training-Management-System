package mj;

import view.Login;
import viewadmin.AdminUI;
import viewtrainee.TraineeUI;
import viewtrainer.TrainerUI;

import java.util.Scanner;

import model.*;

public class Main {

	private static Login login;
	private static AdminUI adminUI;
	private static TrainerUI trainerUI;
	private static TraineeUI traineeUI;
	private User user;

	public Main() {

		login = new Login();
		int loginRole = 3;

		login.setVisible(false);
		
		
		/* Test Database */
		try {
			System.out.println("TMS model testing\n");
			Scanner scan = new Scanner(System.in);
			user = new User();
			boolean condition = true;
			while(condition) {
				
				System.out.print("Please input a new data:");
				String input = scan.nextLine();
				
				if(input == "q" || input == " ") {
					condition = false;
					
				} else {
					user.setName("tnr00001", input);
					user.getUserProfile("tnr00001", 1);
					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/**/
		
		// start showing the UI for admin/trainer/trainee
		// roleLogin(loginRole);
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
			adminUI = new AdminUI();
			adminUI.setVisible(true);
			break;
		case 2:
			trainerUI = new TrainerUI();
			new TrainerController(trainerUI);
			trainerUI.setVisible(true);
			break;
		case 3:
			traineeUI = new TraineeUI();
			new TraineeController(traineeUI);
			traineeUI.setVisible(true);
			break;
		}
	}

}
