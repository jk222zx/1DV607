package view;

/**
 * A class used for viewing a specific members information.
 * 
 * @author 
 *
 */
public class MemberLookAtView extends View {
	public void displayMenu() {
		displayMenu("Look at a members information.");
	}
	
	public void displayMemberInfo(String text) {
		System.out.println();
		System.out.println(text);
	}
}
