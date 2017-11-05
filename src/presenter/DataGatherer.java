package presenter;

import java.util.ArrayList;
import java.util.Iterator;

import model.Boat;
import model.Coordinator;
import model.Member;

public class DataGatherer {
	private Coordinator coordinator;
	
	public DataGatherer(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
	
	/**
	 * 
	 * @param idNumber
	 * @return
	 */
	public String getName(int idNumber) {
		if (coordinator.existsMember(idNumber)) {
			return coordinator.getMember(idNumber).getName();
		} else {
			return "";
		}
	}	
	
	/**
	 * 
	 * @param idNumber
	 * @return
	 */
	public String getPersonalNumber(int idNumber) {
		if (coordinator.existsMember(idNumber)) {
			return coordinator.getMember(idNumber).getPersonalNumber();
		} else {
			return "";
		}
	}	
	
	/**
	 * Method to get all boat data from one member. Returns a two dimensional String array.
	 * Each boats data is stored in two Strings, the first is the boats type and the second 
	 * is the boats length.
	 * E.g.
	 * boatArr2[0][0] = "Sailing boat"
	 * boatArr2[0][1] = "12.2"
	 * boatArr2[1][0] = "Motor boat"
	 * boatArr2[1][1] = "4.3"
	 * etc.
	 * @param idNumber
	 * @return	A two dimensional String array.
	 */
	public String[][] getBoatData(int idNumber) {
		if (coordinator.existsMember(idNumber)) {
			Member member = coordinator.getMember(idNumber);
			Boat boat;
			String[][] boatArr2 = new String[member.getNumberOfBoats()][2];
			for (int i = 0; i < member.getNumberOfBoats(); i++) {
				boat = member.getBoat(i);
				boatArr2[i][0] = boat.getType();
				boatArr2[i][1] = String.valueOf(boat.getLength());
			}
			return boatArr2;
		} else {
			return new String[0][0];
		}
	}
	
	/**
	 * Returns an ArrayList containing String Arrays.
	 * There are three Strings in each Array. The Strings contains in order 
	 * the name, member number and number of boats attached to the member.
	 * 
	 * @return	An ArrayList consisting of String arrays each containing three strings. 
	 * 			The first String in each Array contain the value of the attribute name.
	 * 			The second String in each Array contain a string representation of the value of the attribute IdNumber.
	 * 			The third String in each Array contain a string representation of the number of Boat objects in the ArrayList boatList.  
	 */
	public ArrayList<String[]> listCompact() {
		ArrayList<Member>memberList = coordinator.getAllMembers();
		ArrayList<String[]> arrList = new ArrayList<String[]>();
		
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			Member nextMember = it.next();
			String[] stringArr = new String[3];
			stringArr[0] = nextMember.getName();
			stringArr[1] = String.valueOf(nextMember.getIdNumber());
			stringArr[2] = String.valueOf(nextMember.getNumberOfBoats());
			
			arrList.add(stringArr);
		}			
		return arrList;
	}
	
	/**
	 * Returns an ArrayList containing two dimensional String arrays.
	 * The first String Array in each list element consists of the member name, 
	 * personal number and member id. Each following String array contains a boat type 
	 * and a boat length.
	 * E.g. 
	 * ArrayList.get(2)[0][0] = name, 
	 * ArrayList.get(2)[0][1] = personal number,
	 * ArrayList.get(2)[0][2] = member id,
	 * ArrayList.get(2)[1][0] = boat number 1 type,
	 * ArrayList.get(2)[1][1] = boat number 1 length,
	 * ArrayList.get(2)[2][0] = boat number 2 type,
	 * ArrayList.get(2)[2][1] = boat number 2 length,
	 * etc. 
	 * 
	 * @return	An ArrayList containing two dimensional String arrays.
	 */
	public ArrayList<String[][]> listVerbose() {
		ArrayList<Member>memberList = coordinator.getAllMembers();
		ArrayList<String[][]> arrList = new ArrayList<String[][]>();
		Boat boat;
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			Member nextMember = it.next();
			int numberOfBoats = nextMember.getNumberOfBoats();
			String[][] stringArr2 = new String[1 + numberOfBoats][];
			
			stringArr2[0] = new String[3];
			stringArr2[0][0] = nextMember.getName();
			stringArr2[0][1] = nextMember.getPersonalNumber();
			stringArr2[0][2] = String.valueOf(nextMember.getIdNumber());
			
			for (int i = 0; i < numberOfBoats; i++) {
				boat = nextMember.getBoat(i);
				stringArr2[i + 1] = new String[2];
				stringArr2[i + 1][0] = boat.getType();
				stringArr2[i + 1][1] = String.valueOf(boat.getLength());
			}
			arrList.add(stringArr2);
		}			
		return arrList;
	}
}