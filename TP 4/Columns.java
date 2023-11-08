package linea;

import java.util.ArrayList;

public class Columns {
	
	public ArrayList<String> column = new ArrayList<>();

	public void add(String string, Linea linea) {
		if (linea.height() == column.size()) {
			throw new Error ("Cannot play out of bounds");
		}
		else {
			column.add(string);
		}
	} 

}
