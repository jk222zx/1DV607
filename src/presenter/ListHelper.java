package presenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import model.Coordinator;
import model.Member;

public class ListHelper {
	private Coordinator coordinator;
	
	public ListHelper(Coordinator coordinator) {
		this.coordinator = coordinator;
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
		
		Iterator<Member> it = memberList.iterator();
		while (it.hasNext()) {
			Member nextMember = it.next();
			int numberOfBoats = nextMember.getNumberOfBoats();
			String[][] stringArr2 = new String[1][3];
			String[][] sA2Temp;
			
			stringArr2[0][0] = nextMember.getName();
			stringArr2[0][1] = nextMember.getPersonalNumber();
			stringArr2[0][2] = String.valueOf(nextMember.getIdNumber());	
			
			for (int index = 0; index < numberOfBoats; index++) {
				sA2Temp = new String[stringArr2.length + 1][];
				for (int i = 0; i < sA2Temp.length - 1; i++) {
					sA2Temp[i] = Arrays.copyOf(stringArr2[i], stringArr2[i].length);
				}
				sA2Temp[sA2Temp.length - 1] = new String[2];;
				sA2Temp[sA2Temp.length - 1][0] = nextMember.getBoatType(index); 

				sA2Temp[sA2Temp.length - 1][1] = String.valueOf(nextMember.getBoatLength(index));
				stringArr2 = new String[sA2Temp.length][];
				for (int i = 0; i < sA2Temp.length; i++) {
					stringArr2[i] = Arrays.copyOf(sA2Temp[i], sA2Temp[i].length);
				}
			}	
			arrList.add(stringArr2);
		}			
		return arrList;
	}
}