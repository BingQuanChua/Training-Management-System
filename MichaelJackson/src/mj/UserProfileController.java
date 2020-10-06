package mj;
import view.UserProfile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import modeluser.AdminModel;

public class UserProfileController {
	private AdminModel adminModel;
	private UserProfile userProfile;
	private boolean isTextAreaEditable = false;
    private String userID;
    
	public UserProfileController(UserProfile userProfile,String userID) {
		this.userProfile = userProfile;
		this.userID = userID;
		adminModel = new AdminModel(userID);
		setActionListener();
		setProfile();
	}
	
	private void setActionListener() {
		userProfile.getEditButton().addActionListener(editButtonListener);
	}
	private void setProfile() {
		userProfile.getTxtName().setText(adminModel.getAdminProfile(1));
		userProfile.getTxtGender().setText(adminModel.getAdminProfile(4));
		userProfile.getTxtPosition().setText(adminModel.getAdminProfile(2));
		userProfile.getTxtContact().setText(adminModel.getAdminProfile(5));
		userProfile.getTxtEmail().setText(adminModel.getAdminProfile(6));
		userProfile.getTxtDesc().setText(adminModel.getAdminProfile(3));
	}
	
	private void updateProfile() {
		if(validateEmpty()){
		adminModel.setAdminProfile((userProfile.getTxtName().getText()),1);
		
		if(validateGender()) {
			adminModel.setAdminProfile((userProfile.getTxtGender().getText()),4);
		}
		else {
			JOptionPane.showConfirmDialog (null, "Error!Gender can only be 'm' or 'f'.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		adminModel.setAdminProfile((userProfile.getTxtPosition().getText()),2);
		
		if(validateContact(userProfile.getTxtContact().getText())) {
			adminModel.setAdminProfile((userProfile.getTxtContact().getText()),5);
		}
		else {
			JOptionPane.showConfirmDialog (null, "Error! Please enter correct contact number format (E.g.,0125707526).","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		adminModel.setAdminProfile((userProfile.getTxtEmail().getText()),6);
		adminModel.setAdminProfile((userProfile.getTxtDesc().getText()),3);
	}
		else {
			JOptionPane.showConfirmDialog (null, "Error! No empty field allowed.","ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	ActionListener editButtonListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!isTextAreaEditable) {
				userProfile.getTxtName().setEditable(true);
				userProfile.getTxtGender().setEditable(true);
				userProfile.getTxtPosition().setEditable(true);
				userProfile.getTxtContact().setEditable(true);
				userProfile.getTxtEmail().setEditable(true);
				userProfile.getTxtDesc().setEditable(true);
				userProfile.getEditButton().setText("Save");
				isTextAreaEditable = true;
			}
			else {
				userProfile.getTxtName().setEditable(false);
				userProfile.getTxtGender().setEditable(false);
				userProfile.getTxtPosition().setEditable(false);
				userProfile.getTxtContact().setEditable(false);
				userProfile.getTxtEmail().setEditable(false);
				userProfile.getTxtDesc().setEditable(false);
				updateProfile();
				
				if(validateGender() && validateEmpty() && validateContact(userProfile.getTxtContact().getText())) {
					userProfile.getEditButton().setText("Edit");
					isTextAreaEditable = false;
					JOptionPane.showConfirmDialog (null, "All changes have been saved.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
				
				else {
					JOptionPane.showConfirmDialog (null, "Error! Changes have not been saved.","Error",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
				userProfile.getTxtName().setEditable(true);
				userProfile.getTxtGender().setEditable(true);
				userProfile.getTxtPosition().setEditable(true);
				userProfile.getTxtContact().setEditable(true);
				userProfile.getTxtEmail().setEditable(true);
				userProfile.getTxtDesc().setEditable(true);
				}
			}
		}
	};
	
	private boolean validateGender() {
		if(userProfile.getTxtGender().getText().equals("m") || userProfile.getTxtGender().getText().equals("f")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean validateEmpty() {
		if(userProfile.getTxtName().getText().equals("") || userProfile.getTxtGender().getText().equals("") || 
			userProfile.getTxtPosition().getText().equals("") || userProfile.getTxtContact().getText().equals("") ||
			userProfile.getTxtEmail().getText().equals("") || userProfile.getTxtDesc().getText().equals("")){
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean validateContact(String content) {
		 try {
			 Integer.parseInt(content);  
			 return true;
		 } catch(NumberFormatException e){  
			 return false;  
		 }  
	}
	
}
