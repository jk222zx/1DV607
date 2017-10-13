package view;

import java.util.Formatter;

/**
 * A class used for viewing a specific members information.
 * 
 * @author Secret
 *
 */
public class MemberLookAtView extends View {
	private int idNumber;
	private String name;
	private String personalNumber;
	private String[][] allBoatsData;
	
	/**
	 * Method to display information about the look at a member menu.
	 */
	public void displayMenu() {
		displayMenu("Look at a members information.");
	}
	
	/**
	 * Method to set a members unique member number in this class.
	 * @param idNumber
	 */
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	/**
	 * Method to set a members name in this class.
	 * @param name
	 */
	public void setMemberName(String name) {
		this.name = name;
	}
	
	/**
	 * Method to set a members personal number in this class. 
	 * @param personalNumber
	 */
	public void setMemberPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	/**
	 * Method to set the data about all a members boats in this class.
	 * @param allBoatsData
	 */
	public void setMemberAllBoatsData(String[][] allBoatsData) {
		this.allBoatsData = allBoatsData;
	}
	
	/**
	 * Method to display data about a member.
	 */
	public void displayMemberInfo() {
		Formatter formatter = new Formatter();
		formatter.format("%n");
		formatter.format("%1$-20s %2$-20s %n", "Member number:", String.valueOf(idNumber));
		formatter.format("%1$-20s %2$-20s %n", "Name:", name);
		formatter.format("%1$-20s %2$-20s %n", "Personal number:", personalNumber);
		for (int i = 0; i < allBoatsData.length; i++) {
			formatter.format("%1$-21s", "Boat number: " + String.valueOf(i + 1));
			formatter.format("%1$-20s", "Type: " + allBoatsData[i][0]);
			formatter.format("%1$-20s", "Length: " + allBoatsData[i][1]);
			formatter.format("%n");
		}
		System.out.println(formatter.toString());
		formatter.close();
	}
}
