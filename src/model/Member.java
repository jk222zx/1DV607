package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class describes a member. A member can have several boats
 * that are stored in i ArrayList.
 * @author secret
 *
 */
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String personalNumber;
	private int idNumber;
	private ArrayList<Boat> boatList = new ArrayList<Boat>();
		
	public Member(String name, String personalNumber, int idNumber) {
		this.name = name;
		this.personalNumber = personalNumber;
		this.idNumber = idNumber;
	}

	/**
	 * Method to get attribute name.
	 * @return	A String representing the attribute name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to get attribute personalNumber.
	 * @return	A String representing the attribute personalNumber.
	 */
	public String getPersonalNumber() {
		return personalNumber;
	}

	/**
	 * Method to get attribute idNumber.
	 * @return	An int representing the attribute idNumber.
	 */
	public int getIdNumber() {
		return idNumber;
	}	
	
	/**
	 * Method to set attribute name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Method to set attribute personalNumber.
	 * @param personalNumber
	 */
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	/**
	 * Method to create and add a Boat object to ArrayList boatList.
	 * @param type
	 * @param length
	 */
	public void addBoat(String type, double length) {
		boatList.add(new Boat(type, length));
	}
	
	/**
	 * Method to delete a Boat object from ArrayList boatList. The Boat object
	 * being deleted has index equal to boatListNumber - 1 in boatList.
	 * @param boatListNumber
	 */
	public void removeBoat(int index) {
		boatList.remove(index);
	}
	
	/**
	 * Method to get a boat object.
	 * @param index
	 * @return	The boat object with index "index" in boatlist.
	 */
	public Boat getBoat(int index) {
		if (existsBoat(index)) {
			return boatList.get(index);
		} else {
			return null;
		}
	}
	
	/**
	 * Method to get the number of Boat objects in ArrayList boatList.
	 * @return	The number of Boat objects in boatList.
	 */
	public int getNumberOfBoats() {
		return boatList.size();
	}
	
	/**
	 * Method to check if there is a Boat object with index boatListNumber - 1 in
	 * ArrayList boatList.
	 * @param 	boatListNumber
	 * @return	True if the number of objects (boats) in boatList are 
	 * 			greater then zero and not greater then boatListNumber.
	 * 			False otherwise.
	 */
	public boolean existsBoat(int index) {
		if (0 <= index && index < boatList.size()) {
			return true;
		} else {
			return false;
		}		
	}

}
