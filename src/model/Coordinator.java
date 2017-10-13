package model;

import java.util.ArrayList;

/**
 * This class is the center of the model. Work to the other classes in the model 
 * is distributed from this class. Also calls to and from the model from the 
 * presenter goes through this class.
 * 
 * @author secret
 *
 */
public class Coordinator {
	private MemberArchive memberArchive;
	private PersistenceStorage persistenceStorage;
	
	public Coordinator(String savedRegistryFileName) {
		memberArchive = new MemberArchive();
		persistenceStorage = new PersistenceStorage(savedRegistryFileName);
	}
	
	public void addMember(String name, String personalNumber) {
		memberArchive.addMember(name, personalNumber);
	}
	
	public void deleteMember(int idNumber) {
		memberArchive.deleteMember(idNumber);
	}
	
	public void changeMemberName(int idNumber, String name) {
		memberArchive.changeMemberName(idNumber, name);
	}
	
	public void changeMemberPersonalNumber(int idNumber, String personalNumber) {
		memberArchive.changeMemberPersonalNumber(idNumber, personalNumber);
	}
	
	public boolean existsMember(int idNumber) {
		return memberArchive.existsMember(idNumber);
	}
	
	public ArrayList<Member>getAllMembers() {
		return memberArchive.getAllMembers();
	}
	
	public String getMemberName(int idNumber) {
		return memberArchive.getMemberName(idNumber);
	}
	
	public String getMemberPersonalNumber(int idNumber) {
		return memberArchive.getMemberPersonalNumber(idNumber);
	}
	
	public String[][] getMemberAllBoatsData(int idNumber) {
		return memberArchive.getMemberAllBoatsData(idNumber);
	}
	
	public void addBoat(int idNumber, String type, double length) {
		memberArchive.addBoat(idNumber, type, length);
	}
	
	public void deleteBoat(int idNumber, int boatNumber) {
		memberArchive.deleteBoat(idNumber, boatNumber);
	}
	
	public void changeBoatType(int idNumber, int boatListNumber, String boatType) {
		memberArchive.changeBoatType(idNumber, boatListNumber, boatType);
	}
	
	public void changeBoatLength(int idNumber, int boatListNumber, double boatLength) {
		memberArchive.changeBoatLength(idNumber, boatListNumber, boatLength);
	}	
	
	public boolean existsBoat(int idNumber, int boatListNumber) {
		return memberArchive.existsBoat(idNumber, boatListNumber);
	}

	
	public boolean save() {
		return persistenceStorage.save(memberArchive);
	}
	
	public void load() {
		memberArchive = (MemberArchive) persistenceStorage.load();
	}
	
	public boolean existsFile() {
		return persistenceStorage.existsFile();
	}

}
