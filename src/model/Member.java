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
	 * Method to get a two dimensional String Array containing every attributes in every
	 * Boat object in ArrayList boatList.
	 * @return	A two dimensional String Array representing every attributes in every
	 * 			Boat object in ArrayList boatList.
	 */
	public String[][] getAllBoatsData() {
		String[][] boats = new String[getNumberOfBoats()][2];
		for (int i = 0; i < getNumberOfBoats(); i++) {
			boats[i][0] = boatList.get(i).getType();
			boats[i][1] = String.valueOf(boatList.get(i).getLength());
		}
		return boats;
	}
	
	/**
	 * Method to get attribute idNumber.
	 * @return	An int representing the attribute idNumber.
	 */
	public int getIdNumber() {
		return idNumber;
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
	public void removeBoat(int boatListNumber) {
		boatList.remove(boatListNumber - 1);
	}
	
	/**
	 * Method to get the attribute type from a Boat object in ArrayList boatList. 
	 * The Boat object has index equal to parameter index in boatList.
	 * @param index
	 * @return	A String representing the attribute type.
	 */
	public String getBoatType(int index) {
		if (existsBoat(index + 1)) {
			return boatList.get(index).getType();
		} else {
			return "";
		}
	}

	/**
	 * Method to get the attribute length from a Boat object in ArrayList boatList. 
	 * The Boat object has index equal to parameter index in boatList.
	 * @param index
	 * @return	A double representing the attribute length.
	 */
	public double getBoatLength(int index) {
		if (existsBoat(index + 1)) {
			return boatList.get(index).getLength();
		} else {
			return 0;
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
	 * Method to change the attribute type in a Boat object in ArrayList boatList. 
	 * The Boat object has index equal to boatListNumber - 1 in boatList
	 * @param boatListNumber
	 * @param boatType
	 */
	public void changeBoatType(int boatListNumber, String boatType) {
		if (existsBoat(boatListNumber)) {
			boatList.get(boatListNumber - 1).setType(boatType);
		}
	}
	
	/**
	 * Method to change the attribute length in a Boat object in ArrayList boatList. 
	 * The Boat object has index equal to boatListNumber - 1 in boatList
	 * @param boatListNumber
	 * @param boatLength
	 */
	public void changeBoatLength(int boatListNumber, double boatLength) {
		if (existsBoat(boatListNumber)) {
			boatList.get(boatListNumber - 1).setLength(boatLength);
		}		
	}
	
	/**
	 * Method to check if there is a Boat object with index boatListNumber - 1 in
	 * ArrayList boatList.
	 * @param 	boatListNumber
	 * @return	True if the number of objects (boats) in boatList are 
	 * 			greater then zero and not greater then boatListNumber.
	 * 			False otherwise.
	 */
	public boolean existsBoat(int boatListNumber) {
		if (0 < boatListNumber && boatListNumber <= boatList.size()) {
			return true;
		} else {
			return false;
		}		
	}

}
