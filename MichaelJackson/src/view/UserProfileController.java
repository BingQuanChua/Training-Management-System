package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class UserProfileController {
	private UserProfile userProfile;
	private boolean isTextAreaEditable = false;
	
	public UserProfileController(UserProfile userProfile) {
		this.userProfile = userProfile;
		userProfile.getEditButton().addActionListener(editButtonListener);
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
				userProfile.getEditButton().setText("Edit");
				isTextAreaEditable = false;
				JOptionPane.showConfirmDialog (null, "All changes have been saved.","Success",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	};
}
