package view;

/**
 * A class used for displaying the options.
 * 
 * @author Secret
 *
 */
public class OptionsView extends View{
	
	/**
	 * Method to display the main menu. All available options are shown here.
	 * @param createMember
	 * @param deleteMember
	 * @param changeMember
	 * @param lookAtMember
	 * @param compactList
	 * @param verboseList
	 * @param registerBoat
	 * @param deleteBoat
	 * @param changeBoat
	 * @param saveMember
	 * @param quit
	 */
	public void displayMenu(String createMember, 
							String deleteMember, 
							String changeMember,
							String lookAtMember,
							String compactList,
							String verboseList,
							String registerBoat,
							String deleteBoat,
							String changeBoat,
							String saveMember,
							String quit) 
	{
		System.out.println();
		System.out.println();
		System.out.println("OPTIONS MENU");
		System.out.println();
		System.out.println("Select option by entering the number or letter at the beginning at the row and press enter.");
		System.out.println();
		System.out.println(createMember + ": Create new member");
		System.out.println(deleteMember + ": Delete member");
		System.out.println(changeMember + ": Change a members information");
		System.out.println(lookAtMember + ": Look at a specific members information");
		System.out.println(compactList + ": Compact List");
		System.out.println(verboseList + ": Verbose List");
		System.out.println(registerBoat + ": Register a new boat");
		System.out.println(deleteBoat + ": Delete a boat");
		System.out.println(changeBoat + ": Change a boats information");
		System.out.println(saveMember + ": Save member data.");
		System.out.println(quit + ": Quit program (member data will automatically be saved).");
		System.out.println();
		System.out.print("Enter number or letter and press ENTER -> ");
	}
}
