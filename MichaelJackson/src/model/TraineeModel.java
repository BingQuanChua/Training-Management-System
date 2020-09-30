package model;

public class TraineeModel extends User{
	
	@Override
	public boolean setUserID(String newUserID) {
		System.out.println("Trainee is not allow to change User ID");
		return false;
	}

}
