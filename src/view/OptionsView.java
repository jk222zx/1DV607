package view;

/**
 * A class used for displaying the options.
 * 
 * @author Secret
 *
 */
public class OptionsView extends View{
	/**
	 * Method to display the main menu. All available options are declared in the enum MenuOptions.
	 */
	public void displayMenu() 
	{
		System.out.println();
		System.out.println();
		System.out.println("OPTIONS MENU");
		System.out.println();
		System.out.println("Select option by entering the number or letter at the beginning at the row and press enter.");
		System.out.println();
		System.out.println(MenuOptions.CREATEMEMBER.getOption1() + ": Create new member");
		System.out.println(MenuOptions.DELETEMEMBER.getOption1() + ": Delete member");
		System.out.println(MenuOptions.CHANGEMEMBER.getOption1() + ": Change a members information");
		System.out.println(MenuOptions.LOOKATMEMBER.getOption1() + ": Look at a specific members information");
		System.out.println(MenuOptions.COMPACTLIST.getOption1() + ": Compact List");
		System.out.println(MenuOptions.VERBOSELIST.getOption1() + ": Verbose List");
		System.out.println(MenuOptions.REGISTERBOAT.getOption1() + ": Register a new boat");
		System.out.println(MenuOptions.DELETEBOAT.getOption1() + ": Delete a boat");
		System.out.println(MenuOptions.CHANGEBOAT.getOption1() + ": Change a boats information");
		System.out.println(MenuOptions.SAVEMEMBER.getOption1() + ": Save member data.");
		System.out.println(MenuOptions.QUIT.getOption1() + ": Quit program (member data will automatically be saved).");
		System.out.println();
		System.out.print("Enter number or letter and press ENTER -> ");
	}	
}
