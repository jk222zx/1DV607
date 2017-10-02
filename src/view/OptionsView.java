package view;

/**
 * A class used for displaying the options.
 * 
 * @author 
 *
 */
public class OptionsView extends View{
	public void displayMenu() {
		System.out.println();
		System.out.println();
		System.out.println("OPTIONS MENU");
		System.out.println();
		System.out.println("Select option by entering the number at the beginning at the row.");
		System.out.println();
		System.out.println("1: Create new member");
		System.out.println("2: Delete member");
		System.out.println("3: Change a members information");
		System.out.println("4: Look at a specific members information");
		System.out.println("5: Compact List");
		System.out.println("6: Verbose List");
		System.out.println("7: Register a new boat");
		System.out.println("8: Delete a boat");
		System.out.println("9: Change a boats information");
		System.out.println("S: Save member data.");
		System.out.println("Q: Quit program (member data will automatically be saved).");
		System.out.println();
		System.out.print("Enter number and press ENTER -> ");
	}
}
