package view;

/**
 * A class used for changing a members information.
 * 
 * @author 
 *
 */
public class MemberChangeView extends View {
	public void displayMenu() {
		displayMenu("Change a members data.");
	}	
	
	public String inputMemberName() {
		System.out.println();
		System.out.println("Please type the members new full name and press enter.");
		System.out.print("If you do not want to change the name - leave it empty and press enter. -> ");
		return readString();
	}
	
	public String inputMemberPersonalNumber() {
		System.out.println();
		System.out.println("Please type the members new personal number and press enter.");
		System.out.print("If you do not want to change the personal number - leave it empty and press enter.-> ");
		return readString();		
	}
}
