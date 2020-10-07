package model;

import java.util.ArrayList;
import java.util.Scanner;

import modeltraining.*;

public class JDBCtest {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		JDBCexecute database = new JDBCexecute();
		boolean invalidChoice = true;
		while(invalidChoice) {
			
			System.out.print("Please input testing choice\n"
					+ "1 - executeUpdate\n"
					+ "2 - executeQuery\n"
					+ "3 - executeMultiRowQuery\n"
					+ "4 - Exit JDBC Testing\n"
					+ "choice : ");
			int choice = scan.nextInt();
			scan.nextLine();
			
			if (choice ==1) {
				
				System.out.print("executeUpdate: ");
				String query = scan.nextLine();
				try {
					if(!database.executeUpdate(query)) {
						throw new Exception();
					}
				} catch (Exception e) {
					System.out.println("executeUpdate testing fail\n\n");
				}
			} else
			if (choice == 2) {
				
				System.out.print("executeQuery: ");
				String query = scan.nextLine();
				System.out.print("column: ");
				String column = scan.next();
				try {
					database.executeQuery(query, column);
				} catch (Exception e) {
					System.out.println("executeQuery testing fail\n\n");
				}
			} else
			if (choice == 3) {
				
				System.out.print("executeQuery: ");
				String query = scan.nextLine();
				System.out.print("column: ");
				String column = scan.next();
				ArrayList<String> list = new ArrayList<String>();
				try {
					database.executeMultiRowQuery(query, column, list);
				} catch (Exception e) {
					System.out.println("executeMultiRowQuery testing fail\n\n");
				}
				
			} else
			if (choice == 4) {
				System.out.println("Exit JDBC Testing");
				invalidChoice = false;
			}
			
			/* /
			TrainingProgress tp = new TrainingProgress();
			System.out.println("Progress: " + tp.calculateProgress("tne00001", "trc00001"));
			/**/
		}
		
	}

}
