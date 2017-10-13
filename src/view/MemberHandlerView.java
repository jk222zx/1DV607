package view;

/**
 * Class to format and display the menus associated with creating a new member, deleting a member or
 * changing an attribute in a member. 
 * 
 * @author Secret
 *
 */
public class MemberHandlerView extends View{
	
	/**
	 * Method to display the menu to create a new member.
	 */
	public void displayMemberCreateMenu() {
		displayMenu("Create new member.");
	}
	
	/**
	 * Method to display the menu to change an attribute in a member.
	 */
	public void displayMemberChangeMenu() {
		displayMenu("Change a members data.");
	}	
	
	/**
	 * Method to display the menu to change the name attribute in a member.
	 * @return
	 */
	public String inputMemberChangeName() {
		System.out.println();
		System.out.println("Please type the members new full name and press enter.");
		System.out.print("If you do not want to change the name - leave it empty and press enter. -> ");
		return readString();
	}
	
	/**
	 * Method to display the menu to change the personalNumber attribute in a member.
	 * @return
	 */
	public String inputMemberChangePersonalNumber() {
		System.out.println();
		System.out.println("Please type the members new personal number and press enter.");
		System.out.print("If you do not want to change the personal number - leave it empty and press enter.-> ");
		return readString();		
	}
	
	/**
	 * Method to display the menu to delete a new member.
	 */
	public void displayMemberDeleteMenu() {
		displayMenu("Delete a member.");
	}
}
