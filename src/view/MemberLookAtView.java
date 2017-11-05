package view;

import java.util.Formatter;

/**
 * A class used for viewing a specific members information.
 * 
 * @author Secret
 *
 */
public class MemberLookAtView extends View {
	/**
	 * Method to display data about a member.
	 */
	public void displayMemberInfo(int idNumber, String name, String personalNumber, String[][] allBoatsData) {
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
