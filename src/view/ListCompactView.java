package view;

/**
 * A class used for displaying a compact list.
 * 
 * @author 
 *
 */
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;

public class ListCompactView extends View {
	private Formatter formatter;
	
	public void displayMenu() {
		displayMenu("Show compact list.");
	}
	
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
		System.out.print(formatter.toString());
		formatter.close();
	}
}
