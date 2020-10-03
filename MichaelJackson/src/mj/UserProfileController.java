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
		adminModel.setAdminProfile((userProfile.getTxtName().getText()),1);
		adminModel.setAdminProfile((userProfile.getTxtGender().getText()),4);
		adminModel.setAdminProfile((userProfile.getTxtPosition().getText()),2);
		adminModel.setAdminProfile((userProfile.getTxtContact().getText()),5);
		adminModel.setAdminProfile((userProfile.getTxtEmail().getText()),6);
		adminModel.setAdminProfile((userProfile.getTxtDesc().getText()),3);
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
				userProfile.getEditButton().setText("Edit");
				isTextAreaEditable = false;
				JOptionPane.showConfirmDialog (null, "All changes have been saved.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	};
	/*
	ActionListener profileListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			userProfile.getTxtName().setText(adminModel.getAdminProfile(1));
		}
	};
	*/
	
}
