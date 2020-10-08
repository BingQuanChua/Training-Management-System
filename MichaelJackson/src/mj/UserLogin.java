package mj;

import controlleradmin.AdminController;
import controllertrainee.TraineeController;
import controllertrainer.TrainerController;

import modeluser.AdminModel;
import modeluser.TraineeModel;
import modeluser.TrainerModel;

import viewadmin.AdminUI;
import viewtrainee.TraineeUI;
import viewtrainer.TrainerUI;

public class UserLogin {
	
	private static AdminUI adminUI;
	private static TrainerUI trainerUI;
	private static TraineeUI traineeUI;
	private static AdminModel adminModel;
	private static TrainerModel trainerModel;
	private static TraineeModel traineeModel;
	
	// Initialize admin / trainer / trainee
		public UserLogin(int loginRole, String userID) {
			
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
