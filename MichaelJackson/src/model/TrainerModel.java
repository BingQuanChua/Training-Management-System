package model;

public class TrainerModel extends User{
	
	@Override
	public boolean setUserID(String newUserID) {
		System.out.println("Trainer is not allow to change User ID");
		return false;
	}

}
