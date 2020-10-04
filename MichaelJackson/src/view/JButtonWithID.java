package view;

import javax.swing.JButton;

public class JButtonWithID extends JButton {
	
	String ID;
	
	JButtonWithID(String text , String ID){
		super(text);
		this.ID = ID;
	}
	
	public String getID(){
		return ID;
	}

}
