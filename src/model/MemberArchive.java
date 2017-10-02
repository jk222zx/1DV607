package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class describes a holder of members. They are all stored in an ArrayList.
 * 
 * @author 
 *
 */
public class MemberArchive implements Serializable {
	private static final long serialVersionUID = 1L; 
	private ArrayList<Member> memberList;

	/**
	 * Searches through all members and checks which member number is highest
	 * and then return a number that is one higher.
	 * 
	 * @return	An integer that is one higher then the highest member number. 
	 */
	private int getNextFreeMemberNumber() {
		int max = 1;
		int nextMemberNumber;
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			nextMemberNumber = it.next().getMemberNumber();
			if (max <= nextMemberNumber) {
				max =  nextMemberNumber + 1;
			}
		}
		return max;
	}

	private Member getMember(int memberNumber) {;
		Member member;
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			member = it.next();
			if (memberNumber == member.getMemberNumber()) {
				return member;
			}
		}		
		return null;
	}
	
	public MemberArchive() {
		memberList = new ArrayList<Member>();
	}
	
	public void addMember(String name, String personalNumber) {
		memberList.add(new Member(name, personalNumber, getNextFreeMemberNumber()));
	}

	public void deleteMember(int memberNumber) {
		if (existsMember(memberNumber)) {
			memberList.remove(getMember(memberNumber));
		}		
	}

	public void changeMemberName(int memberNumber, String name) {
		if (existsMember(memberNumber)) {
			getMember(memberNumber).setName(name);
		}
	}
	
	public void changeMemberPersonalNumber(int memberNumber, String personalNumber) {
		if (existsMember(memberNumber)) {
			getMember(memberNumber).setPersonalNumber(personalNumber);
		}
	}	
	
	public boolean existsMember(int memberNumber) {
		return getMember(memberNumber) != null;
	}
	
	public String memberToString(int memberNumber) {
		if (existsMember(memberNumber)) {
			return getMember(memberNumber).toString();
		} else {
			return "";
		}		
	}

	public int getNumberOfMembers() {
		return memberList.size();
	}
	
	public ArrayList<String[]> getCompactList() {
		ArrayList<String[]> result = new ArrayList<String[]>();
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			result.add(it.next().getCompactData());
		}			
		return result;
	}
	
	public ArrayList<String[][]> getVerboseList() {
		ArrayList<String[][]> result = new ArrayList<String[][]>();
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			result.add(it.next().getVerboseData());
		}			
		return result;
	}
	
	public void addBoat(int memberNumber, String boatType, double length) {
		if (existsMember(memberNumber)) {
			getMember(memberNumber).addBoat(boatType, length);
		}
	}

	public void deleteBoat(int memberNumber, int boatListNumber) {
		if (existsMember(memberNumber)) {
			getMember(memberNumber).removeBoat(boatListNumber);
		}		
	}

	public void changeBoatType(int memberNumber, int boatListNumber, String boatType) {
		if (existsMember(memberNumber)) {
			getMember(memberNumber).changeBoatType(boatListNumber, boatType);
		}	
	}
	
	public void changeBoatLength(int memberNumber, int boatListNumber, double boatLength) {
		if (existsMember(memberNumber)) {
			getMember(memberNumber).changeBoatLength(boatListNumber, boatLength);
		}	
	}
	
	public boolean existsBoat(int memberNumber, int boatListNumber) {
		if (existsMember(memberNumber)) {
			return getMember(memberNumber).existsBoat(boatListNumber);
		} else {
			return false;
		}
	}
	
	public String boatToString(int memberNumber, int boatListNumber) {
		String result = "";
		if (existsMember(memberNumber)) {
			if (getMember(memberNumber).existsBoat(boatListNumber)) {
				result = getMember(memberNumber).boatToString(boatListNumber);
			}
		}
		return result;		
	}
}
