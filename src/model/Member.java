package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;

/**
 * This class describes a member. A member can have several boats
 * that are stored in i ArrayList.
 * 
 * @author 
 *
 */
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String personalNumber;
	private int memberNumber;
	private ArrayList<Boat> boatList = new ArrayList<Boat>();
	
	private Boat getBoat(int boatListNumber) {;
		if (existsBoat(boatListNumber)) {
			return boatList.get(boatListNumber - 1);
		}
		return null;
	}
	
	public Member(String name, String personalNumber, int memberNumber) {
		this.name = name;
		this.personalNumber = personalNumber;
		this.memberNumber = memberNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}
	
	public void setMemberNumber(int memberNumber) {
		this.memberNumber  = memberNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPersonalNumber() {
		return personalNumber;
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public void addBoat(String type, double length) {
		boatList.add(new Boat(type, length));
	}
	
	public void removeBoat(int boatListNumber) {
		boatList.remove(boatListNumber - 1);
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
	
	public int getNumberOfBoats() {
		return boatList.size();
	}
	
	public String boatToString(int boatListNumber) {
		if (existsBoat(boatListNumber)) {
			return getBoat(boatListNumber).toString();
		} else {
			return "";
		}
	}
	
	/**
	 * Return true if the number of boats in the ListArray boatList are
	 * in range one to boatListNumber. 
	 * 
	 * @param 	boatListNumber
	 * @return	True if the number of objects (boats) in boatList are 
	 * 			greater then zero and not greater then boatListNumber.
	 * 			False is returned otherwise.
	 */
	public boolean existsBoat(int boatListNumber) {
		if (0 < boatListNumber && boatListNumber <= boatList.size()) {
			return true;
		} else {
			return false;
		}		
	}
	
	public String[] getCompactData() {
		String[] result = new String[3];
		result[0] = getName();
		result[1] = String.valueOf(getMemberNumber());
		result[2] = String.valueOf(getNumberOfBoats());
		return result;
	}
	
	/**
	 * Returns a two dimensional String array where the first String Array
	 * contains the member name, personal number and member id. Each 
	 * following String array contains a boat type and a boat length.
	 * E.g. 
	 * returnArray[0][0] = name, 
	 * returnArray[0][1] = personal number,
	 * returnArray[0][2] = member id,
	 * returnArray[1][0] = boat number 1 type,
	 * returnArray[1][1] = boat number 1 length,
	 * returnArray[2][0] = boat number 2 type,
	 * returnArray[2][1] = boat number 2 length,
	 * etc. 
	 * 
	 * @return	A two dimensional String array.
	 */
	public String[][] getVerboseData() {
		String[][] result = new String[1][3];
		String[][] tempArr;
		Boat boat;
		result[0][0] = getName();
		result[0][1] = getPersonalNumber();
		result[0][2] = String.valueOf(getMemberNumber());		
		Iterator<Boat> it = boatList.iterator();
		while (it.hasNext()) {
			boat = it.next();
			tempArr = new String[result.length + 1][];
			for (int i = 0; i < tempArr.length - 1; i++) {
				tempArr[i] = Arrays.copyOf(result[i], result[i].length);
			}
			tempArr[tempArr.length - 1] = new String[2];;
			tempArr[tempArr.length - 1][0] = boat.getType(); 
			tempArr[tempArr.length - 1][1] = String.valueOf(boat.getLength());
			result = new String[tempArr.length][];
			for (int i = 0; i < tempArr.length; i++) {
				result[i] = Arrays.copyOf(tempArr[i], tempArr[i].length);
			}
		}
		return result;
	}
	
	public String toString() {
		Formatter formatter = new Formatter();
		String s;
		formatter.format("%1$-20s %2$-20s %n", "Member number:", String.valueOf(memberNumber));
		formatter.format("%1$-20s %2$-20s %n", "Name:", name);
		formatter.format("%1$-20s %2$-20s %n", "Personal number:", personalNumber);
		Iterator<Boat> it = boatList.iterator();
		int i = 0;
		while (it.hasNext()) {
			i++;
			formatter.format("%1$-20s %2$-20s %n", "Boat number: " + String.valueOf(i), it.next().toString());
		}
		s = formatter.toString();
		formatter.close();
		return s;
	}
}
