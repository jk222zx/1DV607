package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class describes a holder of members. The members are represented as objects of class Member and
 * all those objects are stored in an ArrayList named memberList.
 * 
 * @author secret
 *
 */
public class MemberArchive implements Serializable {
	private static final long serialVersionUID = 1L; 
	private ArrayList<Member> memberList;
	
	/**
	 * Constructor
	 */
	public MemberArchive() {
		memberList = new ArrayList<Member>();
	}
	
	/**
	 * Searches through all members and checks which member number is highest
	 * and then return a number that is one higher.
	 * 
	 * @return	An integer that is one higher then the highest member number. 
	 */
	private int getNextFreeIdNumber() {
		int max = 1;
		int nextIdNumber;
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			nextIdNumber = it.next().getIdNumber();
			if (max <= nextIdNumber) {
				max = nextIdNumber + 1;
			}
		}
		return max;
	}
	
	/**
	 * Returns the object of class Member whose attribute idNumber matches the argument idNumber.
	 * 
	 * @param idNumber
	 * @return	An object of class Member
	 */
	private Member getMember(int idNumber) {;
		Member member;
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			member = it.next();
			if (idNumber == member.getIdNumber()) {
				return member;
			}
		}		
		return null;
	}
		
	/**
	 * Creates an object of class Member and adds it to the ArrayList memberList. 
	 * 
	 * @param name
	 * @param personalNumber
	 */
	public void addMember(String name, String personalNumber) {
		memberList.add(new Member(name, personalNumber, getNextFreeIdNumber()));
	}

	public String getMemberName(int idNumber) {
		if (existsMember(idNumber)) {
			return getMember(idNumber).getName();
		} else {
			return "";
		}
	}
	
	public String getMemberPersonalNumber(int idNumber) {
		if (existsMember(idNumber)) {
			return getMember(idNumber).getPersonalNumber();
		} else {
			return "";
		}
	}		

	
	public String[][] getMemberAllBoatsData(int idNumber) {
		if (existsMember(idNumber)) {
			return getMember(idNumber).getAllBoatsData();
		} else {
			return new String[0][0];
		}		
	}

	public ArrayList<Member>getAllMembers() {
		return memberList;
	}
	
	/**
	 * Removes an object of class Member whose attribute idNumber matches the argument idNumber from
	 * the ArrayList memberList.
	 * 
	 * @param idNumber
	 */
	public void deleteMember(int idNumber) {
		if (existsMember(idNumber)) {
			memberList.remove(getMember(idNumber));
		}		
	}

	/**
	 * Changes the attribute name at the object of class Member whose attribute idNumber 
	 * matches the argument idNumber.
	 * 
	 * @param idNumber
	 * @param name
	 */
	public void changeMemberName(int idNumber, String name) {
		if (existsMember(idNumber)) {
			getMember(idNumber).setName(name);
		}
	}
	
	/**
	 * Changes the attribute personalNumber at the object of class Member whose attribute idNumber 
	 * matches the argument idNumber.
	 * 
	 * @param idNumber
	 * @param personalNumber
	 */
	public void changeMemberPersonalNumber(int idNumber, String personalNumber) {
		if (existsMember(idNumber)) {
			getMember(idNumber).setPersonalNumber(personalNumber);
		}
	}	
	
	/**
	 * Checks if an object of class Member whose attribute idNumber matches the 
	 * argument idNumber exists.
	 * 
	 * @param idNumber
	 * @return	true if the object exists, false otherwise. 
	 */
	public boolean existsMember(int idNumber) {
		return getMember(idNumber) != null;
	}
	
	public void addBoat(int idNumber, String boatType, double length) {
		if (existsMember(idNumber)) {
			getMember(idNumber).addBoat(boatType, length);
		}
	}

	public void deleteBoat(int idNumber, int boatListNumber) {
		if (existsMember(idNumber)) {
			getMember(idNumber).removeBoat(boatListNumber);
		}		
	}

	public void changeBoatType(int idNumber, int boatListNumber, String boatType) {
		if (existsMember(idNumber)) {
			getMember(idNumber).changeBoatType(boatListNumber, boatType);
		}	
	}
	
	public void changeBoatLength(int idNumber, int boatListNumber, double boatLength) {
		if (existsMember(idNumber)) {
			getMember(idNumber).changeBoatLength(boatListNumber, boatLength);
		}	
	}
	
	public boolean existsBoat(int idNumber, int boatListNumber) {
		if (existsMember(idNumber)) {
			return getMember(idNumber).existsBoat(boatListNumber);
		} else {
			return false;
		}
	}

}
