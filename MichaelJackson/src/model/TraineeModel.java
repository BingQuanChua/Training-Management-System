package model;

public class TraineeModel extends User{
	
	private String traineeID;
	
	public TraineeModel(String traineeID){
		super();
		this.traineeID = traineeID;
	}
	
	public String getTrainerProfile(int choice) {
		try {
			return super.getUserProfile(traineeID, choice);
		} catch (Exception e) {
			System.out.println("getTrainerProfile fail");
		}
		
		return "";
	}
	
	public boolean setTrainerProfile(String content, int choice) {
		try {
			return super.setUserProfile(content, traineeID, choice);
		} catch (Exception e) {
			System.out.println("setTrainerProfile fail");
		}
		
		return false;
	}
	
	public boolean setTrainerPassword(String newPassword) {
		try {
			return super.setUserPassword(traineeID, newPassword);
		} catch (Exception e) {
			System.out.println("setTrainerPassword fail");
		}
		
		return false;
	}
	
	@Override
	public boolean setUserID(String oldUserID, String newUserID) {
		System.out.println("Trainee is not allow to change User ID");
		return false;
	}

}
