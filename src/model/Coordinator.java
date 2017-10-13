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
	
	/**
	 * Method to create and add a new Member object in object memberArchive.
	 * @param name
	 * @param personalNumber
	 */
	public void addMember(String name, String personalNumber) {
		memberArchive.addMember(name, personalNumber);
	}
	
	/**
	 * Method to delete a Member object from object memberArchive.
	 * @param idNumber
	 */
	public void deleteMember(int idNumber) {
		memberArchive.deleteMember(idNumber);
	}
	
	/**
	 * Method to change the attribute name in a Member object selected through 
	 * its attribute idNumber in object memberArchive.
	 * @param idNumber
	 * @param name
	 */
	public void changeMemberName(int idNumber, String name) {
		memberArchive.changeMemberName(idNumber, name);
	}
	
	/**
	 * Method to change the attribute personalNumber in a Member object selected through 
	 * its attribute idNumber in object memberArchive.
	 * @param idNumber
	 * @param personalNumber
	 */
	public void changeMemberPersonalNumber(int idNumber, String personalNumber) {
		memberArchive.changeMemberPersonalNumber(idNumber, personalNumber);
	}
	
	/**
	 * Method to control if a Member object with the attribute idNumber equal to argument
	 * idNumber exists in object memberArchive.
	 * @param idNumber
	 * @return	True if a Member object with idNumber equal to argument idNumber exists.
	 * 			False otherwise.
	 */
	public boolean existsMember(int idNumber) {
		return memberArchive.existsMember(idNumber);
	}
	
	/**
	 * Method to get an ArrayList containing all Member objects in object memberArchive.
	 * @return	An ArrayList with Member objects.
	 */
	public ArrayList<Member>getAllMembers() {
		return memberArchive.getAllMembers();
	}
	
	/**
	 * Method to get the attribute name from a Member object with the attribute idNumber 
	 * equal to argument idNumber. 
	 * @param idNumber
	 * @return	A String representing the attribute name in a Member object.
	 */
	public String getMemberName(int idNumber) {
		return memberArchive.getMemberName(idNumber);
	}
	
	/**
	 * Method to get the attribute personalNumber from a Member object with the attribute 
	 * idNumber equal to argument idNumber. 
	 * @param idNumber
	 * @return	A String representing the attribute personalNumber in a Member object.
	 */
	public String getMemberPersonalNumber(int idNumber) {
		return memberArchive.getMemberPersonalNumber(idNumber);
	}
	
	/**
	 * Method to get a two dimensional String Array containing every attributes in every
	 * Boat object associated to Member object with the attribute idNumber equal to 
	 * argument idNumber.   
	 * @param idNumber
	 * @return	A two dimensional String Array representing every attributes in every
	 * 			Boat object associated to a Member object.
	 */
	public String[][] getMemberAllBoatsData(int idNumber) {
		return memberArchive.getMemberAllBoatsData(idNumber);
	}
	
	/**
	 * Method to create and add a Boat object to a Member object.
	 * @param idNumber
	 * @param type
	 * @param length
	 */
	public void addBoat(int idNumber, String type, double length) {
		memberArchive.addBoat(idNumber, type, length);
	}
	
	/**
	 * Method to delete a Boat object identified with the argument boatListNumber from 
	 * a Member object with the attribute idNumber equal to argument idNumber.
	 * @param idNumber
	 * @param boatListNumber
	 */
	public void deleteBoat(int idNumber, int boatListNumber) {
		memberArchive.deleteBoat(idNumber, boatListNumber);
	}
	
	/**
	 * Method to change the attribute boatType in a Boat object identified with the 
	 * argument boatListNumber in a Member object with the attribute idNumber equal to 
	 * argument idNumber.
	 * @param idNumber
	 * @param boatListNumber
	 * @param boatType
	 */
	public void changeBoatType(int idNumber, int boatListNumber, String boatType) {
		memberArchive.changeBoatType(idNumber, boatListNumber, boatType);
	}
	
	/**
	 * Method to change the attribute boatLength in a Boat object identified with the 
	 * argument boatListNumber in a Member object with the attribute idNumber equal to 
	 * argument idNumber.
	 * @param idNumber
	 * @param boatListNumber
	 * @param boatLength
	 */
	public void changeBoatLength(int idNumber, int boatListNumber, double boatLength) {
		memberArchive.changeBoatLength(idNumber, boatListNumber, boatLength);
	}	
	
	/**
	 * Method to control if a Boat object identified with the argument boatListNumber
	 * exists in Member object with the attribute idNumber equal to argument idNumber.
	 * @param idNumber
	 * @param boatListNumber
	 * @return	True if a Boat object with boatNumber equal to argument boatListNumber exists
	 * 			in Member object with idNumber equal to argument idNumber.
	 * 			False otherwise.
	 */ 
	public boolean existsBoat(int idNumber, int boatListNumber) {
		return memberArchive.existsBoat(idNumber, boatListNumber);
	}

	/**
	 * Method to save all objects of classes Member and Boat as well as the relation 
	 * between them in an external file. 
	 * @return	True if nothing unexpected happened.
	 * 			False otherwise.
	 */
	public boolean save() {
		return persistenceStorage.save(memberArchive);
	}
	
	/**
	 * Method to load a file containing objects of classes Member and Boat as well as the
	 * relations between them.
	 */
	public void load() {
		memberArchive = (MemberArchive) persistenceStorage.load();
	}
	
	/**
	 * Method to test if a file with name given as parameter in the constructor to this 
	 * object exists in the file system.
	 * @return	True if the file exists.
	 * 			False otherwise.
	 */
	public boolean existsFile() {
		return persistenceStorage.existsFile();
	}

}
