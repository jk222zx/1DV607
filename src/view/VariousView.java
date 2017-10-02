package view;

/**
 * A class used for summing up different views that does not have its own class.
 * 
 * @author 
 *
 */
public class VariousView extends View {
	public void answerOutOfRangeMessage() {
		System.out.println();
		System.out.println("Selection out of range!");
		System.out.println("Please select one of the numbers to the left of respective option.");
	}
	
	public void memberDataSaveMessage(boolean saveOk) {
		System.out.println();
		if (saveOk) {
			System.out.println("Member data saved.");		
		} else {
			System.out.println("Something went wrong. Member data not saved.");
		}
	}
}
