package view;

/**
 * Class to format and display the menus associated with creating a new boat, deleting a boat or
 * changing an attribute in a boat. 
 * 
 * @author Secret
 *
 */
public class BoatHandlerView extends View{

	/**
	 * Method used for changing information about a boat.
	 */
	public void displayBoatChangeMenu() {
		displayMenu("Change a boats information.");
	}	
	
	/**
	 * Method used for deleting a boat.
	 */
	public void displayBoatDeleteMenu() {
		displayMenu("Delete a boat.");
	}
	
	/**
	 * Method used for register a boat.
	 */
	public void displayBoatRegisterMenu() {
		displayMenu("Register boat.");
	}
}
