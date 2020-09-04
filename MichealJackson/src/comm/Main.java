package comm;

public class Main {

	private static Login login;
	// private static AdminUI adminUI;
	private static TrainerUI trainerUI;
	private static TraineeUI traineeUI;

	public Main() {

		// adminUI = new TrainerUI();
		trainerUI = new TrainerUI();
		traineeUI = new TraineeUI();
		login = new Login();
		
		int loginRole = 2;
		login.setVisible(true);
		
		// start showing the UI for admin/trainer/trainee
		// roleLogin(loginRole);
	}

	public static void main(String args[]) {
		new Main();
		/* Set the Nimbus look and feel */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TrainerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			java.util.logging.Logger.getLogger(TraineeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/*
		 * Create and display the form java.awt.EventQueue.invokeLater(new Runnable() {
		 * public void run() {
		 * 
		 * switch(loginRole) { case 1: // adminUI.setVisible(true); break; case 2:
		 * trainerUI.setVisible(true); break; case 3: traineeUI.setVisible(true); break;
		 * }
		 * 
		 * } });
		 */
	}

	public void roleLogin(int loginRole) {
		login.setVisible(false);
		switch (loginRole) {
		case 1:
			// adminUI.setVisible(true);
			break;
		case 2:
			trainerUI.setVisible(true);
			break;
		case 3:
			traineeUI.setVisible(true);
			break;
		}
	}

}
