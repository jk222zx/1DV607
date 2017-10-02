package view;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A superclass to all the other view classes.
 * 
 * @author 
 *
 */
public abstract class View {
	private Scanner scanner = new Scanner(System.in);
	
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
	
	public void displayMenu() {
		System.out.println();
		System.out.println("displayMenu default");
		System.out.println();
	}
	
	public void displayMenu(String text) {
		System.out.println();
		System.out.println();
		System.out.println(text);
	}
	
	public int inputMemberNumber() {
		System.out.println();
		System.out.print("Please type the member number and press enter, or just press enter to exit option. -> ");
		return readInt();		
	}	
	
	public String inputMemberName() {
		System.out.println();
		System.out.print("Please type the full members name and press enter. -> ");
		return readString();
	}
	
	public String inputMemberPersonalNumber() {
		System.out.println();
		System.out.print("Please type the member personal number and press enter. -> ");
		return readString();		
	}
	
	public void noSuchMemberMessage(int memberNumber) {
		System.out.println();
		System.out.println("A member with member number " + memberNumber + " does not exists, exiting.");
		System.out.println();
	}
	
	public int inputBoatNumber() {
		System.out.println();
		System.out.print("Please type the boat number and press enter, or just press enter to exit option. -> ");
		return readInt();		
	}	
	
	public String inputBoatType() {
		System.out.println();
		System.out.print("Please type the boats type and press enter. -> ");
		return readString();
	}
	
	public double inputBoatLength() {
		System.out.println();
		System.out.print("Please type the boats length and press enter. -> ");
		return readDouble();		
	}
	
	public void noSuchBoatMessage(int boatListNumber) {
		System.out.println();
		System.out.println("Boat number " + boatListNumber + " does not exists, exiting.");
		System.out.println();
	}
}
