package viewtrainer;

import view.UserUI;
import view.ListPanel;
import view.MenuItem;
import view.SubMenu;

import java.awt.Color;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class TrainerUI extends UserUI {

	/**
	 * Trainer interface (currently extends JFrame, will change to JPanel later)
	 */
	
	private static final long serialVersionUID = 1L;
	
    private ListPanel trainingList;
    private SubMenu subMenuMTC;
    private ListPanel trainingProgressList;
    private SubMenu subMenuTP;
    private String userID;

	// Constructor
	public TrainerUI(String userID) {
		super(userID);
		this.userID = userID;
		setProfileButtonText("Trainer Profile");
		initTrainerComponents();
		initTrainerMenu(); //Based on role		
	}
	
	private void initTrainerComponents() {
        
        // list of assigned training 
        trainingList = new ListPanel();
        subMenuMTC = new SubMenu("Manage Training Course", trainingList);
        
        // list of training progress
        trainingProgressList = new ListPanel();
        subMenuTP = new SubMenu("Training Progress", trainingProgressList);

    }
	
	// This method is called from within the constructor to initialize the form.
	private void initTrainerMenu() {
		MenuItem menuMTC = new MenuItem(" -- Manage Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	getPanelBody().removeAll();
            	getPanelBody().add(subMenuMTC);
            	getPanelBody().repaint();
            	getPanelBody().revalidate();
            }
        });
        MenuItem menuTP = new MenuItem(" -- Training Progress", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	getPanelBody().removeAll();
            	getPanelBody().add(subMenuTP);
            	getPanelBody().repaint();
            	getPanelBody().revalidate();
            }
        });

        MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuTP);
        menuTraining.setBackground(new Color(250, 240, 230));
        super.addMenu(menuTraining);
        super.home(); //show home menu initially
	} 
	
	public JPanel getPanelBody() {
		return super.getPanelBody();
	}
	
	public void home() {
		super.home();
	}
	
	public ListPanel getTrainingList() {
		return trainingList;
	}
	
	public ListPanel getTrainingProgressList() {
		return trainingProgressList;
	}
	
	public void addTrainingProgress(String courseID, String courseName) {
		trainingProgressList.addItem(new TrainingProgress(courseID, courseName));
	}

}
