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

	public int size() {
		return column.size();
	} 
	
	public boolean verticalElementsAreEqual() {
	    int counter = 0;
	    for (int i = 0; i < column.size() - 1; i++) {
	        if (column.get(i) == column.get(i + 1)) {
	            counter += 1;
	            if (counter == 3) {
	                return true;
	            }
	        } else {
	            counter = 0;
	        }
	    }
	    return false;
	}
	
	public boolean compareElementsBetweenColumns(Columns aColumn, int element) {
		return this.get(element) == aColumn.get(element);
	}
	
	public boolean compareElementDiagonallyUp(Columns aColumn, int element) {
		return this.get(element) == aColumn.get(element + 1);
	}
	
	public boolean compareElementDiagonallyDown(Columns aColumn, int element) {
		return this.get(element) == aColumn.get(element - 1);
	}

	private String get(int element) {
		return column.get(element);
	}




}