package modeluser;

public class TrainerModel extends User{
	
	private String trainerID;
	
	public TrainerModel(String trainerID){
		super();
		this.trainerID = trainerID;
	}
	
	public String getTrainerProfile(int choice) {
		try {
			return super.getUserProfile(trainerID, choice);
		} catch (Exception e) {
			System.out.println("getTrainerProfile fail");
		}
		
		return "";
	}
	
	public boolean setTrainerProfile(String content, int choice) {
		try {
			return super.setUserProfile(content, trainerID, choice);
		} catch (Exception e) {
			System.out.println("setTrainerProfile fail");
		}
		
		return false;
	}
	
	public boolean setTrainerPassword(String newPassword) {
		try {
			return super.setUserPassword(trainerID, newPassword);
		} catch (Exception e) {
			System.out.println("setTrainerPassword fail");
		}
		
		return false;
	}
}
