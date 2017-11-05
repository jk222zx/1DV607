package view;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

/**
 * A class format and display the two types of lists that are used in the program.
 * 
 * @author Secret
 *
 */
public class ListHandlerView extends View{
	private Formatter formatter;
	
	public void displayCompactListMenu() {
		displayMenu("Show compact list.");
	}
	
	public void displayVerboseListMenu() {
		displayMenu("Show verbose list.");
	}
	
	/**
	 * Method to format and display the compact list.
	 * @param arrL
	 */
	public void displayCompactList(ArrayList<String[]> arrL) {
		formatter = new Formatter();
		formatter.format("%n");
		formatter.format("%1$-29s %2$-29s %3$-29s %n", "Name", "Member id", "Number of registered boats");
		Iterator<String[]> it = arrL.iterator();
		while (it.hasNext()) {
			String[] sArr = it.next();	
			for(String s: sArr) {
				formatter.format("%1$-30s", s);
			}
			formatter.format("%n");
		}
		System.out.println(formatter.toString());
		formatter.close();
	}

	/**
	 * Method to format and display the verbose list.
	 * @param arrList
	 */
	public void displayVerboseList(ArrayList<String[][]> arrList) {
		formatter = new Formatter();
		Iterator<String[][]> it = arrList.iterator();
		while (it.hasNext()) {
			String[][] sArr2 = it.next();
			formatter.format("%n");
			for(int i = 0; i < sArr2.length; i++) {
				if (i == 0) {
					formatter.format("%1$-29s %2$-29s %3$-29s %n", "Name", "Personal number", "Member id");
				} else if (i == 1) {
					formatter.format("%n");
					formatter.format("%1$-29s %2$-29s %n", "Type of boat", "Length of boat");
				}
				for(int j = 0; j < sArr2[i].length; j++) {
					formatter.format("%1$-30s", sArr2[i][j]);
				}
				formatter.format("%n");
			}
		}
		System.out.println(formatter.toString());
		formatter.close();		
	}
}
