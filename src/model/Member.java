package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class describes a member. A member can have several boats
 * that are stored in i ArrayList.
 * 
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPersonalNumber() {
		return personalNumber;
	}
	
	public String[][] getAllBoatsData() {
		String[][] boats = new String[getNumberOfBoats()][2];
		for (int i = 0; i < getNumberOfBoats(); i++) {
			boats[i][0] = boatList.get(i).getType();
			boats[i][1] = String.valueOf(boatList.get(i).getLength());
		}
		return boats;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public void addBoat(String type, double length) {
		boatList.add(new Boat(type, length));
	}
	
	public void removeBoat(int boatListNumber) {
		boatList.remove(boatListNumber - 1);
	}
	
	public String getBoatType(int index) {
		if (existsBoat(index + 1)) {
			return boatList.get(index).getType();
		} else {
			return "";
		}
	}

	public double getBoatLength(int index) {
		if (existsBoat(index + 1)) {
			return boatList.get(index).getLength();
		} else {
			return 0;
		}
	}
	
	public int getNumberOfBoats() {
		return boatList.size();
	}
	
	public void changeBoatType(int boatListNumber, String boatType) {
		if (existsBoat(boatListNumber)) {
			boatList.get(boatListNumber - 1).setType(boatType);
		}
	}
	
	public void changeBoatLength(int boatListNumber, double boatLength) {
		if (existsBoat(boatListNumber)) {
			boatList.get(boatListNumber - 1).setLength(boatLength);
		}		
	}
	
	/**
	 * Checks if the number of objects in the ArrayList boatList is greater then 
	 * zero and greater then or equal to boatListNumber.
	 * 
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
