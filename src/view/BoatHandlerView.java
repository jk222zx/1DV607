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
	 * A class used for changing information about a boat.
	 * 
	 * @author 
	 *
	 */
	public void displayBoatChangeMenu() {
		displayMenu("Change a boats information.");
	}	
	
	/**
	 * A class used for deleting a boat.
	 * 
	 * @author 
	 *
	 */
	public void displayBoatDeleteMenu() {
		displayMenu("Delete a boat.");
	}
	
	/**
	 * A class used for register a boat.
	 * 
	 * @author 
	 *
	 */
	public void displayBoatRegisterMenu() {
		displayMenu("Register boat.");
	}
}
