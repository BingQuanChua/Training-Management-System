package viewadmin;

import view.MenuItem;
import view.SubMenu;
import view.ListPanel;
import view.UserUI;
import mj.UserProfileController;

import java.awt.Color;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
;

public class AdminUI extends UserUI {
    
	/**
	 * Admin interface
	 */
	private static final long serialVersionUID = 1L;
	private AddNewUser addNewUser;
	private AllTrainerList allTrainerList;
	private AllTraineeList allTraineeList;
	private AllTrainingList allTrainingList;
	private ListPanel reportList;
	
	private String userID;

	/**
	 * Create the frame.
	 */
	public AdminUI(String userID) {
	
		super(userID);
		this.userID = userID;
		initAdminComponents();
		initAdminMenu();
	}

	private void initAdminComponents() {
		
		addNewUser = new AddNewUser();
		allTrainerList = new AllTrainerList();
		allTraineeList = new AllTraineeList();
		allTrainingList = new AllTrainingList();
		reportList = new ListPanel();
		
		reportList.addItem(new Report("Python Advance Training Course"));
        reportList.addItem(new Report("Software Engineering with Java"));
		reportList.addItem(new Report("Introduction to OOPDS"));
		
	}

	// This method is called from within the constructor to initialize the form.
	private void initAdminMenu() {
		MenuItem menuANU = new MenuItem(" -- Add New User", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				getPanelBody().removeAll();
				getPanelBody().add(new SubMenu("Add New User", addNewUser));
				getPanelBody().repaint();
				getPanelBody().revalidate();
			}
		});
		MenuItem menuMTR = new MenuItem(" -- Manage Trainer", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				getPanelBody().removeAll();
				getPanelBody().add(new SubMenu("Manage Trainer", allTrainerList));
				getPanelBody().repaint();
				getPanelBody().revalidate();
			}
		});
		MenuItem menuMTE = new MenuItem(" -- Manage Trainee", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				getPanelBody().removeAll();
				getPanelBody().add(new SubMenu("Manage Trainee", allTraineeList));
				getPanelBody().repaint();
				getPanelBody().revalidate();
			}
		});
		
		MenuItem menuMTC = new MenuItem(" -- Manage Training Course", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				getPanelBody().removeAll();
				getPanelBody().add(new SubMenu("Manage Training Course", allTrainingList));
				getPanelBody().repaint();
				getPanelBody().revalidate();
			}
		});
		
		MenuItem menuRpt = new MenuItem(" -- Report", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				getPanelBody().removeAll();
				getPanelBody().add(new SubMenu("Report", reportList));
				getPanelBody().repaint();
				getPanelBody().revalidate();
			}
		});

		MenuItem menuEmployee = new MenuItem("Employee", null, menuANU, menuMTR,menuMTE);
		menuEmployee.setBackground(new Color(250, 240, 230));
		MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuRpt);	
		menuTraining.setBackground(new Color(250, 240, 230));
		super.addMenu(menuEmployee);
		super.addMenu(menuTraining);
		super.home(); //show home menu initially
	}
	
	public JPanel getPanelBody() {
		return super.getPanelBody();
	}
	
	public void home() {
		super.home();
	}
	
	public void trainingListSubMenu() {
		getPanelBody().removeAll();
		getPanelBody().add(new SubMenu("Manage Training Course", allTrainingList));
        getPanelBody().repaint();
		getPanelBody().revalidate();
	}
	
	public AddNewUser getAddNewUser() {
		return addNewUser;
	}
	
	public AllTrainerList getAllTrainerList() {
		return allTrainerList;
	}
	
	public AllTraineeList getAllTraineeList() {
		return allTraineeList;
	}
	 
	public AllTrainingList getAllTrainingList() {
		return allTrainingList;
	}
	
	public ListPanel getReportList() {
		return reportList;
	}

}
