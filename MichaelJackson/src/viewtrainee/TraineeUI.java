package viewtrainee;

import view.UserUI;
import view.ListPanel;
import view.MenuItem;
import view.SubMenu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class TraineeUI extends UserUI {
	
	// Variables declaration
	private static final long serialVersionUID = 1L;
    private ListPanel availableTrainingList;
    private SubMenu subMenuATC;
    private ListPanel enrolledTrainingList;
    private SubMenu subMenuETC; 
    private String userID;
 
    //Constructor
    public TraineeUI(String userID) {
    	super(userID);
    	this.userID = userID;
    	initTraineeComponents();
    	initTraineeMenu();
    }
    

	// This method is called from within the constructor to initialize the form.
    private void initTraineeComponents() {
        
        availableTrainingList = new ListPanel();
        subMenuATC = new SubMenu("Available Training Course", availableTrainingList);

		enrolledTrainingList = new ListPanel();
        subMenuETC = new SubMenu("Enrolled Training Course", enrolledTrainingList);
        
    }
   
    // This method is called from within the constructor to initialize the form.
    private void initTraineeMenu() {
    	
        //  create subMenu Training
        MenuItem menuMTC = new MenuItem(" -- Available Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	getPanelBody().removeAll();
            	getPanelBody().add(subMenuATC);
            	getPanelBody().repaint();
            	getPanelBody().revalidate();
            }
        });
        MenuItem menuTP = new MenuItem(" -- Enrolled Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	getPanelBody().removeAll();
            	getPanelBody().add(subMenuETC);
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
 	
 	public String getTraineeID() {
 		return userID;
 	}
    
 	public ListPanel getAvailableTrainingList() {
 		return availableTrainingList;
 	}

 	public ListPanel getEnrolledTrainingList() {
 		return enrolledTrainingList;
 	}

 	
 	/******************************
 	 * For Controller 
 	 * Add available training course
 	 * Add enrolled training course
 	 *****************************/
 	
 	public void addAvailableTraining(
 			String courseID, String courseName, String courseDesc,
 			String trainerID, String trainerName) {

 		availableTrainingList.addItem(new AvailableTraining(
 				courseID, courseName, courseDesc,
 				trainerID, trainerName));
 	}

 	public void addEnrolledTraining(
 			String courseID, String courseName, String courseDesc,
 			String trainerID, String trainerName, String traineeName) {

 		enrolledTrainingList.addItem(new EnrolledTraining(
 				courseID, courseName, courseDesc, 
 				trainerID, trainerName, 
 				userID, traineeName));
 	}
}
