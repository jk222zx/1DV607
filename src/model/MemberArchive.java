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
	 * @param idNumber
	 * @return	An object of class Member
	 */
	public Member getMember(int idNumber) {;
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
	 * Method to get an ArrayList containing all Member objects in ArrayList memberList.
	 * @return	An ArrayList with Member objects.
	 */
	public ArrayList<Member>getAllMembers() {
		return memberList;
	}
	
	/**
	 * Creates an object of class Member and adds it to the ArrayList memberList. 
	 * @param name
	 * @param personalNumber
	 */
	public void addMember(String name, String personalNumber) {
		memberList.add(new Member(name, personalNumber, getNextFreeIdNumber()));
	}
	
	/**
	 * Removes an object of class Member whose attribute idNumber matches the argument idNumber from
	 * the ArrayList memberList.
	 * @param idNumber
	 */
	public boolean deleteMember(int idNumber) {
		if (existsMember(idNumber)) {
			memberList.remove(getMember(idNumber));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if an object of class Member whose attribute idNumber matches the 
	 * argument idNumber exists.
	 * @param idNumber
	 * @return	true if the object exists, false otherwise. 
	 */
	public boolean existsMember(int idNumber) {
		return getMember(idNumber) != null;
	}
}
