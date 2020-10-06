package view;

import javax.swing.JButton;

public class JButtonID extends JButton {
	
	String UserID;
	String MaterialID; // For Mark As Done Button Button
	
	JButtonID(String text , String UserID){
		super(text);
		this.UserID = UserID;
		this.MaterialID = "";
	}
	
	JButtonID(String text , String UserID, String MaterialID){
		super(text);
		this.UserID = UserID;
		this.MaterialID = MaterialID;
	}
	
	public String getUserID(){
		return UserID;
	}
	
	public String getMaterialID(){
		return MaterialID;
	}
	
	public void setUserID(String UserID){
		this.UserID = UserID;
	}
	
	public void setMaterialID(String MaterialID){
		this.MaterialID = MaterialID;
	}

}
