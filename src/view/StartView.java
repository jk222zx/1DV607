package view;

/**
 * A class used for displaying the start of the program execution.
 * 
 * @author 
 *
 */
public class StartView extends View{
	public void displayMenu() {
		System.out.println("----MEMBER REGISTRY----");
	}
	
	public void savedDataExistsMessage() {
		System.out.println();
		System.out.println("File with saved data found.");
	}
	
	public void savedDataMissingMessage() {
		System.out.println();
		System.out.println("File with saved data NOT found.");
		System.out.println("(This is normal the first time the program is used.)");
	}
}
