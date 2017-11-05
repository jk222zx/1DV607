package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A superclass to all the other view classes.
 * 
 * @author Secret
 *
 */
public abstract class View {
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Method to read a char.
	 * @return	The char inputed by the user.
	 */
	public char readChar() {
		char ch = '\u0000';
		try {
			ch = scanner.nextLine().charAt(0);
		}
		catch (IndexOutOfBoundsException e) {
			//Empty
		}
		return ch;		
	}
	
	/**
	 * Method to read a String.
	 * @return	The String inputed by the user.
	 */
	public String readString() {
		String result = "";
		try {
			result = scanner.nextLine();
		}
		catch (NoSuchElementException e) {
			System.out.println("No line was found!");
		}
		catch (IllegalStateException e) {
			System.out.println("Scanner was closed!");
		}
		return result;
	}	
	
	/**
	 * Method to read an integer (int).
	 * @return	The integer inputed by the user.
	 */
	public int readInt() {
		int i = 0;
		try {
			i = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			//Empty
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("You didn't enter anything!");
		}
		return i;
	}	
	
	/**
	 * Method to read a double.
	 * @return	The double inputed by the user.
	 */
	public double readDouble() {
		double d = 0;
		try {
			d = Double.parseDouble(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			//Empty
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("You didn't enter anything!");
		}
		return d;
	}
	
	/**
	 * Method to display a default message. 
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("displayMenu default");
		System.out.println();
	}
	
	/**
	 * Method to display a message given as parameter as a String.
	 * @param text
	 */
	public void displayMenu(String text) {
		System.out.println();
		System.out.println(text);
		System.out.println();
	}
	
	/**
	 * Method to display a message and get as input from the user a members id number.
	 * @return	An int representing the members id number.
	 */
	public int inputIdNumber() {
		System.out.println();
		System.out.print("Please type the member ID and press enter, or just press enter to exit option. -> ");
		return readInt();		
	}	
	
	/**
	 * Method to display a message and get as input from the user a members name. 
	 * @return	A String representing the members name.
	 */
	public String inputMemberName() {
		System.out.println();
		System.out.print("Please type the full members name and press enter. -> ");
		return readString();
	}
	
	/**
	 * Method to display a message and get as input from the user a members personal number.
	 * @return	A String representing the members personal number.
	 */
	public String inputMemberPersonalNumber() {
		System.out.println();
		System.out.print("Please type the member personal number and press enter. -> ");
		return readString();		
	}
	
	/**
	 * Method to display a message that there is no member with a id number equal to parameter idNumber.
	 * @param memberNumber
	 */
	public void noSuchMemberMessage(int idNumber) {
		System.out.println();
		System.out.println("A member with member number " + idNumber + " does not exists, exiting.");
		System.out.println();
	}
	
	/**
	 * Method to display a message and get as input from the user a boats list number. 
	 * @return	An int representing the number of a boat in a list.
	 */
	public int inputBoatNumber() {
		System.out.println();
		System.out.print("Please type the boat number and press enter, or just press enter to exit option. -> ");
		return readInt();		
	}	
	
	/**
	 * Method to display a message and get as input from the user a boats type.
	 * @return	A String representing the boats type.
	 */
	public String inputBoatType() {
		System.out.println();
		System.out.print("Please type the boats type and press enter. -> ");
		return readString();
	}
	
	/**
	 * Method to display a message and get as input from the user a boats length.
	 * @return	A double representing the boats length.
	 */
	public double inputBoatLength() {
		System.out.println();
		System.out.print("Please type the boats length and press enter. -> ");
		return readDouble();		
	}
	
	/**
	 * Method to display a message that there is no boat with a list number equal to parameter boatListNumber. 
	 * @param boatListNumber
	 */
	public void noSuchBoatMessage(int boatListNumber) {
		System.out.println();
		System.out.println("Boat number " + boatListNumber + " does not exists, exiting.");
		System.out.println();
	}
}
