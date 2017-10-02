package view;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

/**
 * A class used for displaying a more complete, verbose, list.
 * 
 * @author 
 *
 */
public class ListVerboseView extends View {
	private Formatter formatter;
	
	public void displayMenu() {
		displayMenu("Show verbose list.");
	}
	
	public void displayVerboseList(ArrayList<String[][]> arrL) {
		formatter = new Formatter();
		Iterator<String[][]> it = arrL.iterator();
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
		System.out.print(formatter.toString());
		formatter.close();		
	}
}
