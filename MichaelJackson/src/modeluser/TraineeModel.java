package modeluser;

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
			System.out.println("getTraineeProfile fail");
		}
		
		return "";
	}
	
	public boolean setTraineeProfile(String content, int choice) {
		try {
			return super.setUserProfile(content, traineeID, choice);
		} catch (Exception e) {
			System.out.println("setTraineeProfile fail");
		}
		
		return false;
	}
	
	public boolean setTraineePassword(String newPassword) {
		try {
			return super.setUserPassword(traineeID, newPassword);
		} catch (Exception e) {
			System.out.println("setTraineePassword fail");
		}
		
		return false;
	}
}
