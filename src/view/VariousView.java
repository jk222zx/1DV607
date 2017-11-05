package view;

/**
 * A class used for summing up different views that does not have its own class.
 * 
 * @author Secret
 *
 */
public class VariousView extends View {
	
	/**
	 * Method to display message that an invalid option was selected.
	 */
	public void answerOutOfRangeMessage() {
		System.out.println();
		System.out.println("Selection out of range!");
		System.out.println("Please select one of the numbers to the left of respective option.");
	}
	
	/**
	 * Method to display the result from a try to save data.
	 * @param saveOk
	 */
	public void memberDataSaveMessage(boolean saveOk) {
		System.out.println();
		if (saveOk) {
			System.out.println("Member data saved.");		
		} else {
			System.out.println("Something went wrong. Member data not saved.");
		}
	}
}
