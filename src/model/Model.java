package model;

import java.util.ArrayList;

/**
 * This class is the center of the model. Work to the other classes in the model 
 * is distributed from this class. Also calls to and from the model from the 
 * presenter goes through this class.
 * 
 * @author 
 *
 */
public class Model {
	private MemberArchive memberArchive;
	private PersistenceStorage persistenceStorage;
	
	public Model(String savedRegistryFileName) {;
		memberArchive = new MemberArchive();
		persistenceStorage = new PersistenceStorage(savedRegistryFileName);
	}
	
	public void addMember(String name, String personalNumber) {
		memberArchive.addMember(name, personalNumber);
	}
	
	public void deleteMember(int memberNumber) {
		memberArchive.deleteMember(memberNumber);
	}
	
	public void changeMemberName(int memberNumber, String name) {
		memberArchive.changeMemberName(memberNumber, name);
	}
	
	public void changeMemberPersonalNumber(int memberNumber, String personalNumber) {
		memberArchive.changeMemberPersonalNumber(memberNumber, personalNumber);
	}
	
	public boolean existsMember(int memberNumber) {
		return memberArchive.existsMember(memberNumber);
	}
	 
	public String getMemberData(int memberNumber) {
		return memberArchive.memberToString(memberNumber);
	}
	
	public void addBoat(int memberNumber, String type, double length) {
		memberArchive.addBoat(memberNumber, type, length);
	}
	
	public void deleteBoat(int memberNumber, int boatNumber) {
		memberArchive.deleteBoat(memberNumber, boatNumber);
	}
	
	public void changeBoatType(int memberNumber, int boatListNumber, String boatType) {
		memberArchive.changeBoatType(memberNumber, boatListNumber, boatType);
	}
	
	public void changeBoatLength(int memberNumber, int boatListNumber, double boatLength) {
		memberArchive.changeBoatLength(memberNumber, boatListNumber, boatLength);
	}	
	
	public boolean existsBoat(int memberNumber, int boatListNumber) {
		return memberArchive.existsBoat(memberNumber, boatListNumber);
	}
	 
	public String getBoatData(int memberNumber, int boatListNumber) {
		return memberArchive.boatToString(memberNumber, boatListNumber);
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
	
	public ArrayList<String[]> getCompactList() {
		return memberArchive.getCompactList();
	}
	
	public ArrayList<String[][]> getVerboseList() {
		return memberArchive.getVerboseList();
	}
}
