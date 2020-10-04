package view;

import javax.swing.JButton;

public class JButtonWithID extends JButton {
	
	String firstID;
	String secondID;
	
	JButtonWithID(String text){
		super(text);
	}
	
	JButtonWithID(String text , String firstID){
		super(text);
		this.firstID = firstID;
	}
	
	JButtonWithID(String text , String firstID, String secondID){
		super(text);
		this.firstID = firstID;
		this.secondID = secondID;
	}
	
	public String getFirstID(){
		return firstID;
	}
	
	public String getSecondID(){
		return secondID;
	}

}
