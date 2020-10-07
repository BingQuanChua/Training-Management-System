package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.ListPanel;
import view.SubMenu;
import viewadmin.AddNewCourse;
import viewadmin.AdminUI;
import viewadmin.AllTrainingList;
import viewadmin.EditCourse;
import viewadmin.ReportTraining;
import viewadmin.ManageTraining;
import viewadmin.Report;
import modeluser.AdminModel;

public class AdminController {
	private AdminUI adminUI;
	private AdminModel adminModel;
	private AddNewCourse addNewCourse; // all adding and editing a training course shares the same panel
	private EditCourse editCourse; 
	private TrainingCourseController trainingCourseController;
	private boolean isTextAreaEditable = false;

	private UserManagementController userManagementController;

	
	public AdminController(AdminUI adminUI,AdminModel adminModel) {
	
		this.adminUI = adminUI;
		this.adminModel = adminModel;
		userManagementController = new UserManagementController(adminUI,adminModel);
		addNewCourse = new AddNewCourse();
		editCourse = new EditCourse();

		
		setAddNewUserListener();
		setManageTrainerList();
		setManageTrainerListener();
		setManageTraineeList();
		setManageTraineeListener();
		setManageTrainingCourseListener();
		setReportListener();
	}
	
	private void setAddNewUserListener() {
		adminUI.getAddNewUser().getAddButton().addActionListener(addUserButtonListener);
		adminUI.getAddNewUser().getCancelButton().addActionListener(backToMenuListener);
	}
	
	private void setManageTrainerList() {
		ArrayList <String> trainerList = new ArrayList<>();
		adminModel.getAllTrainerID(trainerList);
		
		String trainerID,trainerName;
		try {
			for(int i = 0;  i< trainerList.size(); i++) {
				
				trainerID = trainerList.get(i);
				trainerName = adminModel.getUserName(trainerID, 2);
		
				adminUI.getAllTrainerList().addTrainerList(trainerName);
			
			}
		} catch (Exception e) {
			System.out.println("Fail to get list of trainers");
		}
	}
	
	private void setManageTrainerListener() {

		adminUI.getAllTrainerList().getBackButton().addActionListener(backToMenuListener);
	}
	
	private void setManageTraineeList() {
		ArrayList <String> traineeList = new ArrayList<>();
		adminModel.getAllTraineeID(traineeList);
		
		String traineeID,traineeName;
		try {
			for(int i = 0;  i< traineeList.size(); i++) {
				
				traineeID = traineeList.get(i);
				traineeName = adminModel.getUserName(traineeID, 1);
				adminUI.getAllTraineeList().addTraineeList(traineeName);
				
			}
		} catch (Exception e) {
			System.out.println("Fail to get list of trainees");
		}
	}
	
	private void setManageTraineeListener() {
		
		adminUI.getAllTraineeList().getBackButton().addActionListener(backToMenuListener);
	}
	
	private void setManageTrainingCourseListener() {
		addNewCourse = new AddNewCourse();
		editCourse = new EditCourse();
		trainingCourseController = new TrainingCourseController(adminUI.getAllTrainingList(), addNewCourse, editCourse);
		
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
	
	private void setReportListener() {
		ListPanel p = adminUI.getReportList();
		for (int i = 0; i < p.getListOfPanel().size(); i++) {
			addIndividualReportListener((Report) p.getItem(i));
		}
	}
	

	ActionListener addUserButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			userManagementController.addNewUser();
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
				editCourse.getTrainerID().setEditable(true);
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
					editCourse.getTrainerID().setEditable(false);
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
				editCourse.getTrainerID().setEditable(false);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
				}
			}
		});
	}
	
	private void addIndividualReportListener(Report r) {
		r.getTrainingButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				adminUI.getPanelBody().removeAll();
				adminUI.getPanelBody().add(r.getIndividualReport());
		        adminUI.getPanelBody().repaint();
				adminUI.getPanelBody().revalidate();
			}
		});
	}
}
