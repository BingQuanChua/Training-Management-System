package model;

public class JDBCinfo {
	
	private static String url = "jdbc:mysql://localhost:3306/mjtms ?useTimezone=true&serverTimezone=UTC ";
	private static String serverName = "root";
	private static String serverPassword = "";
	
	public static String getURL() {
		return url;
	}
	
	public static String getServerName() {
		return serverName;
	}
	
	public static String getServerPassword() {
		return serverPassword;
	}

}
