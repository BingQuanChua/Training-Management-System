package mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.ListPanel;
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
	private boolean isTextAreaEditable = false;
	private UserManagementController userManagementController;

	
	public AdminController(AdminUI adminUI,AdminModel adminModel) {
	
		this.adminUI = adminUI;
		this.adminModel = adminModel;
		userManagementController = new UserManagementController(adminUI,adminModel);
		addNewCourse = new AddNewCourse();
		editCourse = new EditCourse();
		
		setAddNewUserListener();
		setManageTrainerListener();
		setManageTraineeListener();
		setManageTrainingCourseListener();
		setReportListener();
	}
	
	private void setAddNewUserListener() {
		adminUI.getAddNewUser().getAddButton().addActionListener(addUserButtonListener);
		adminUI.getAddNewUser().getCancelButton().addActionListener(backToMenuListener);
	}
	
	private void setManageTrainerListener() {
		adminUI.getAllTrainerList().getBackButton().addActionListener(backToMenuListener);
	}
	
	private void setManageTraineeListener() {
		adminUI.getAllTraineeList().getBackButton().addActionListener(backToMenuListener);
	}
	
	private void setManageTrainingCourseListener() {
			
		adminUI.getAllTrainingList().getAddNewTrainingButton().addActionListener(addNewTrainingListener);	
		addNewCourse.getAddButton().addActionListener(addNewTrainingButtonListener);
		addNewCourse.getCancelButton().addActionListener(backToMenuListener);
		
		
		ListPanel p = adminUI.getAllTrainingList().getTrainingList();
		for (int i = 0; i < p.getListOfPanel().size(); i++) {
			addEditTrainingPanelListener((ManageTraining) p.getItem(i));
		}
		// editCourse.getEditButton().addActionListener(editButtonListener);
		editCourse.getCancelButton().addActionListener(backToMenuListener);
		editCourse.getEditButton().addActionListener(editButtonListener);
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
				JOptionPane.showConfirmDialog (null, "New training course has been added successfully.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				adminUI.home();
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
					editCourse.getTrainingName().setEditable(true);
					editCourse.getTrainerID().setEditable(true);
					editCourse.getTrainingDate().setEditable(true);
					editCourse.getTrainingDesc().setEditable(true);
					editCourse.getEditButton().setText("Save");
					isTextAreaEditable = true;
				}
				else {
					editCourse.getTrainingName().setEditable(false);
					editCourse.getTrainerID().setEditable(false);
					editCourse.getTrainingDate().setEditable(false);
					editCourse.getTrainingDesc().setEditable(false);
					editCourse.getEditButton().setText("Edit");
					isTextAreaEditable = false;
				}
		}
	};
	
	private void addEditTrainingPanelListener(ManageTraining mt) {
		mt.getTrainingButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// add details of this particular training course from model
				
				adminUI.getPanelBody().removeAll();
				adminUI.getPanelBody().add(editCourse);
		        adminUI.getPanelBody().repaint();
				adminUI.getPanelBody().revalidate();
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
