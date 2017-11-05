package view;

/**
 * Class to display messages at the start and at the stop of the program. Also the
 * displaying of message if a file with saved data is found or not are being 
 * handled here.
 * 
 * @author Secret
 *
 */
public class StartEndView extends View{
	
	/**
	 * Method to display the start message.
	 */
	public void displayStartMenu() {
		System.out.println("----MEMBER REGISTRY----");
	}
	
	/**
	 * Method to display the stop message.
	 */
	public void displayEndMenu() {
		System.out.println();
		System.out.println("----PROGRAM ENDED----");
	}
	
	/**
	 * Method to display message if a file with saved data was found at the start of
	 * the program.
	 */
	public void savedDataExistsMessage() {
		System.out.println();
		System.out.println("File with saved data found.");
	}
	
	/**
	 * Method to display message if a file with saved data was not found at the start 
	 * of the program.
	 */
	public void savedDataMissingMessage() {
		System.out.println();
		System.out.println("File with saved data NOT found.");
		System.out.println("(This is normal the first time the program is used.)");
	}
}
