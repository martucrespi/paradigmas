package linea0;

import java.util.ArrayList;

public class GameTypeA0 extends GameType0{
	
	public GameTypeA0() {
		this.key = 'A';
	}

	public char getKey() {
		return this.key;
	}

	
	public boolean finished(Linea0 linea) {
		
		for(int i = 0; i < linea.columns(); i ++) {
				if (verticalElementsAreEqual(linea.board.get(i))) {
						return true;
					}
		}
		
		
		int counter = 0;
		for (int e = 0; e < linea.columns()-1 ; e++) {
			for (int k = 0; k < linea.rows()-1 ; k++) {
				if (linea.board.get(k).get(e).equals((linea.board.get(k+1).get(e)))){
					counter += 1;
					 if (counter == 3) {
			                return true;
					 }
				}else {
					counter = 0;
				}
			}
		}
		
		return false;
	}

	
	public boolean verticalElementsAreEqual(ArrayList<String> column) {
		int counter = 0;
	    for (int j = 0; j < column.size() - 1; j++) {
	        if (column.get(j).equals(column.get(j + 1))) {
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
}
