package controlleradmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.ListPanel;
import view.UserProfile;
import viewadmin.AddNewCourse;
import viewadmin.AdminUI;
import viewadmin.EditCourse;
import viewadmin.ManageTraining;
import viewadmin.Report;
import viewadmin.ManageUser;
import modeluser.AdminModel;
import mj.UserProfileController;

public class AdminController {
	private AdminUI adminUI;
	private AdminModel adminModel;
	private AddNewCourse addNewCourse; // all adding and editing a training course shares the same panel
	private EditCourse editCourse; 
	private TrainingCourseController trainingCourseController;
	private UserManagementController userManagementController;
	private boolean isTextAreaEditable = false;
	private UserProfile userProfile;

	
	public AdminController(AdminUI adminUI,AdminModel adminModel) {
	
		this.adminUI = adminUI;
		this.adminModel = adminModel;
		userManagementController = new UserManagementController(adminUI,adminModel,this);
		
		userProfile = new UserProfile();
		addNewCourse = new AddNewCourse();
		editCourse = new EditCourse();
		
		System.out.println("\n\n********************\n"
				 		 + "TraineeController\n\n");
		
		System.out.println("\nUser Management\n\n");
		setAddNewUserListener();
		
		setTrainerList();
		setManageTrainerListener();
		
		setTraineeList();
		setManageTraineeListener();
		
		System.out.println("\nTraining Course Management\n\n");
		setManageTrainingCourseListener();
		
		System.out.println("\nProgress and Evaluation Management\n\n");
		setReport(adminUI, adminModel);
		setReportListener();
		
		System.out.println("\n\nTraineeController\n"
				 		 + "*********************\n");
	}
	
	private void setAddNewUserListener() {
		adminUI.getAddNewUser().getTrainerBox().addActionListener(trainerBoxListener);
		adminUI.getAddNewUser().getTraineeBox().addActionListener(traineeBoxListener);
		
		adminUI.getAddNewUser().getAddButton().addActionListener(addUserButtonListener);
		adminUI.getAddNewUser().getCancelButton().addActionListener(backToMenuListener);
	}
	
	private void setTrainerList() {
		ArrayList <String> trainerList = new ArrayList<>();
		adminModel.getAllTrainerID(trainerList);

		try {
			for(int i = 0;  i< trainerList.size(); i++) {	
				ManageUser tempUser = new ManageUser(
						adminModel.getUserName(trainerList.get(i), 2), 
						trainerList.get(i));
				if(adminModel.getUserName(trainerList.get(i),2) == null) 
					tempUser = new ManageUser("TrainerName",trainerList.get(i));
				adminUI.getAllTrainerList().getTrainerList().addItem(tempUser);	
			}
		} catch (Exception e) {
			System.out.println("Fail to get list of trainers.");
		}
	}
	
	private void setManageTrainerListener() {

		adminUI.getAllTrainerList().getBackButton().addActionListener(backToMenuListener);
		ListPanel trainerPanel = adminUI.getAllTrainerList().getTrainerList();
		for (int i = 0; i < trainerPanel.getListOfPanel().size(); i++) {
			addDeleteTrainerListener((ManageUser) trainerPanel.getItem(i));
			addProfileListener((ManageUser) trainerPanel.getItem(i));
		}
	}
	
	private void setTraineeList() {
		ArrayList <String> traineeList = new ArrayList<>();
		adminModel.getAllTraineeID(traineeList);

		try {
			for(int i = 0;  i< traineeList.size(); i++) {
				
				ManageUser tempUser = new ManageUser(
						adminModel.getUserName(traineeList.get(i), 1), 
						traineeList.get(i));
				if(adminModel.getUserName(traineeList.get(i),1) == null) 
					tempUser = new ManageUser("TraineeName", traineeList.get(i));
				adminUI.getAllTraineeList().getTraineeList().addItem(tempUser);	
				
			}
		} catch (Exception e) {
			System.out.println("Fail to get list of trainers.");
		}
	}
	
	private void setManageTraineeListener() {
		
		adminUI.getAllTraineeList().getBackButton().addActionListener(backToMenuListener);
		ListPanel traineePanel = adminUI.getAllTraineeList().getTraineeList();
		for (int i = 0; i < traineePanel.getListOfPanel().size(); i++) {
			addDeleteTraineeListener((ManageUser) traineePanel.getItem(i));
			addProfileListener((ManageUser) traineePanel.getItem(i));
		}
	}
	
	private void setManageTrainingCourseListener() {
		addNewCourse = new AddNewCourse();
		editCourse = new EditCourse();
		trainingCourseController = new TrainingCourseController(adminUI.getAllTrainingList(), addNewCourse, editCourse, adminModel);
		
		trainingCourseController.showTrainingList();
		adminUI.getAllTrainingList().getAddNewTrainingButton().addActionListener(addNewTrainingListener);	
		addNewCourse.getAddButton().addActionListener(addNewTrainingButtonListener);
		addNewCourse.getCancelButton().addActionListener(backToTrainingListMenuListener);
		
		
		ListPanel p = adminUI.getAllTrainingList().getTrainingList();
		for (int i = 0; i < p.getListOfPanel().size(); i++) {
			addEditTrainingPanelListener((ManageTraining) p.getItem(i));
			addDeleteTrainingListener((ManageTraining) p.getItem(i));
		}
		
		editCourse.getEditButton().addActionListener(editButtonListener);
		editCourse.getCancelButton().addActionListener(backToTrainingListMenuListener);
		
	}
	
	
	private void setReport(AdminUI adminUI, AdminModel adminModel) {
		new ReportController(adminUI, adminModel);
	}
	
	private void setReportListener() {
		ListPanel p = adminUI.getReportList();
		for (int i = 0; i < p.getListOfPanel().size(); i++) {
			addIndividualReportListener((Report) p.getItem(i));
		}
	}
	
	ActionListener trainerBoxListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String lastID = adminModel.getLastUserID(1);
				int id = Integer.parseInt(lastID.substring(3, 8))+1;
				String newID = String.format("tnr%05d", id);
				
				adminUI.getAddNewUser().getUserIDField().setText(newID);
				System.out.println(adminUI.getAddNewUser().getTrainerBox().isSelected());
			} catch (Exception e1) {
				System.out.println("getLastTrainerID Failed");
			}
			
		}
	};
	
	ActionListener traineeBoxListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String lastID = adminModel.getLastUserID(2);
				int id = Integer.parseInt(lastID.substring(3, 8))+1;
				String newID = String.format("tne%05d", id);
				
				adminUI.getAddNewUser().getUserIDField().setText(newID);
				System.out.println(adminUI.getAddNewUser().getTrainerBox().isSelected());
			} catch (Exception e1) {
				System.out.println("getLastTraineeID Failed");
			}
			
		}
	};
	

	ActionListener addUserButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				userManagementController.addNewUser();
		
			} catch (Exception e1) {
				System.out.println("addUserButtonListener Fail");
			}
			
		}
	};
	
	ActionListener backToMenuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			adminUI.home(); // basically just go back home page
		}
	};
	
	ActionListener backToTrainingListMenuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// basically just go back all training list page
			adminUI.trainingListSubMenu();
		}
	};
	
	// switches the panel body
	ActionListener addNewTrainingListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
						
			// set back to initial state
			String lastID = trainingCourseController.getLatestTrainingCourseID();
			addNewCourse.getTxtCourseID().setText(lastID);
			addNewCourse.getTxtName().setText("Enter training course name");
			addNewCourse.getTxtDesc().setText("Enter short description");
			addNewCourse.getTxtDate().setText("Enter training date (format: YYYY-MM-DD)");
			
			
			ArrayList<String> allTrainerID = new ArrayList<>();
			adminModel.getAllTrainerID(allTrainerID);
			addNewCourse.getTrainerIDComboBox().removeAllItems();
			addNewCourse.getTrainerIDComboBox().addItem("--please select a trainer--");
			for (int i = 0; i < allTrainerID.size(); i++) {
				try {
					String trainerID = allTrainerID.get(i);
					String name;
					name = adminModel.getUserProfile(trainerID, 1);
					addNewCourse.getTrainerIDComboBox().addItem(trainerID + " - " + name);
				} catch (Exception e1) {
					System.out.println("addNewTrainingListener: get trainer details failed");
				}	
				
			}
			
			
			adminUI.getPanelBody().removeAll();
			adminUI.getPanelBody().add(addNewCourse);
	        adminUI.getPanelBody().repaint();
			adminUI.getPanelBody().revalidate();
		}
	};
	
	// handles what happens after pressing "add" button
	ActionListener addNewTrainingButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int response = JOptionPane.showConfirmDialog (null, "Are you sure want to add the training course?","WARNING",JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				boolean success = trainingCourseController.addNewCourse();
				if (success) {
					JOptionPane.showConfirmDialog (null, "New training course has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					// add new actionListener to the newly created training
					ListPanel p = adminUI.getAllTrainingList().getTrainingList();
					addEditTrainingPanelListener((ManageTraining) p.getItem(p.getListOfPanel().size()-1));
					addDeleteTrainingListener((ManageTraining) p.getItem(p.getListOfPanel().size()-1));
					
					
					adminUI.trainingListSubMenu();
				}
				else {
					JOptionPane.showConfirmDialog (null, "Failed to add new training course.\nPlease check your input.","Failed",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
				}	
			}
		}
	};
	
	ActionListener editButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// enable edit
			// "edit" -> "save"
			// rewrite data in database
		
			if(!isTextAreaEditable) {
				// Editing
				editCourse.getTrainingName().setEditable(true);
				editCourse.getTrainerIDComboBox().setEditable(true);
				editCourse.getTrainingDate().setEditable(true);
				editCourse.getTrainingDesc().setEditable(true);
				editCourse.getEditButton().setText("Save");
				isTextAreaEditable = true;
			}
			else {
				// Saving 
				boolean success = trainingCourseController.setCourseDetails(editCourse.getCurrentCourseID());
				if (success) {
					editCourse.getTrainingName().setEditable(false);
					editCourse.getTrainerIDComboBox().setEditable(false);
					editCourse.getTrainingDate().setEditable(false);
					editCourse.getTrainingDesc().setEditable(false);
					editCourse.getEditButton().setText("Edit");
					isTextAreaEditable = false;
					
					System.out.println("Override course details success");
					JOptionPane.showConfirmDialog (null, "Training course details overwritten successfully","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					adminUI.trainingListSubMenu();
				}
				else {
					JOptionPane.showConfirmDialog (null, "Failed to edit training course details.\nPlease check your input.","Failed",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	};
	
	// add listener to all ManageTraining
	// clicking the training name will bring user to editCourse interface
	private void addEditTrainingPanelListener(ManageTraining mt) {
		mt.getTrainingButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				adminUI.getPanelBody().removeAll();
				adminUI.getPanelBody().add(editCourse);
		        adminUI.getPanelBody().repaint();
				adminUI.getPanelBody().revalidate();
				editCourse.getTrainingName().setEditable(false);
				editCourse.getTrainerIDComboBox().setEditable(false);
				editCourse.getTrainingDate().setEditable(false);
				editCourse.getTrainingDesc().setEditable(false);
				editCourse.getEditButton().setText("Edit");
				isTextAreaEditable = false;
				//isTextAreaEditable = true; // initial state, not editable
				
				// add details of this particular training course from model
				try {
					trainingCourseController.getTrainingDetails(mt.getCourseID());
					editCourse.setCurrentCourseID(mt.getCourseID());
				} catch (Exception e1) {
					System.out.println("addEditTrainingPanelListener Fail");
				}
			}
		});
	}
	
	private void addDeleteTrainingListener(ManageTraining mt) {
		mt.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this training course?", "Delete Training Course", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					// Delete from database
					trainingCourseController.deleteTrainingCourse(mt.getCourseID());
					
					// Wipe from view
					ListPanel p = adminUI.getAllTrainingList().getTrainingList();
					p.getListOfPanel().remove(mt);
					p.getContainerPanel().removeAll();
					for (JPanel temp : p.getListOfPanel()) {
						p.getContainerPanel().add(temp);
					}
					p.getContainerPanel().repaint();
					p.getContainerPanel().revalidate();
					
					JOptionPane.showConfirmDialog (null, "Successfully deleted training course","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	private void addIndividualReportListener(Report r) {
		r.getTrainingButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				adminUI.getPanelBody().removeAll();
				adminUI.getPanelBody().add(r.getReportTraining());
		        adminUI.getPanelBody().repaint();
				adminUI.getPanelBody().revalidate();
			}
		});
	}

	public void addDeleteTrainerListener(ManageUser mu) {
		mu.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this trainer?", "Delete Trainer", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					// Delete from database
					adminModel.deleteExistingUser(mu.getUserID());
					
					// Wipe from view
					ListPanel trainerPanel = adminUI.getAllTrainerList().getTrainerList();
					trainerPanel.getListOfPanel().remove(mu);
					trainerPanel.getContainerPanel().removeAll();
					for (int i = 0; i < trainerPanel.getListOfPanel().size(); i++) {
						ManageUser temp = (ManageUser) trainerPanel.getListOfPanel().get(i);
						temp.getNumberLabel().setText((i+1)+".");
						trainerPanel.getContainerPanel().add(temp);
					}
					trainerPanel.getContainerPanel().repaint();
					trainerPanel.getContainerPanel().revalidate();
					JOptionPane.showConfirmDialog (null, "Successfully deleted this trainer","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	public void addDeleteTraineeListener(ManageUser mu) {
		mu.getDeleteButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete this trainee?", "Delete Trainee", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
				// 0 = yes, 1 = no, 2 = cancel
				if (input == 0) {
					// Delete from database
					adminModel.deleteExistingUser(mu.getUserID());
					
					// Wipe from view
					ListPanel traineePanel = adminUI.getAllTraineeList().getTraineeList();
					traineePanel.getListOfPanel().remove(mu);
					traineePanel.getContainerPanel().removeAll();
					for (int i = 0; i < traineePanel.getListOfPanel().size(); i++) {
						ManageUser temp = (ManageUser) traineePanel.getListOfPanel().get(i);
						temp.getNumberLabel().setText((i+1)+".");
						traineePanel.getContainerPanel().add(temp);
					}
					traineePanel.getContainerPanel().repaint();
					traineePanel.getContainerPanel().revalidate();
					JOptionPane.showConfirmDialog (null, "Successfully deleted this trainee","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	public void addProfileListener(ManageUser mu) {
		mu.getProfileButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				adminUI.getPanelBody().removeAll();
				adminUI.getPanelBody().add(userProfile);
		        adminUI.getPanelBody().repaint();
				adminUI.getPanelBody().revalidate();
				
			
				try {
					userProfile.getEditButton().setVisible(false);	
					new UserProfileController(userProfile, mu.getUserID());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}