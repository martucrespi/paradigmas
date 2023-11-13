package linea;

import java.util.stream.IntStream;

public class GameTypeB extends GameType{
		
	public GameTypeB() {
		this.key = 'B';
	}
	
	public char getKey() {
		return this.key;
	}

	
//	public boolean finished(Line linea) {
//		int counter = 0;
//		int index;
//		for (int e = 0; e < linea.columns()-2 ; e++) {
//			for (int k = 0; k < linea.rows()-2 ; k++) {
//				index = e +1;
//				if (linea.board.get(k).get(e).equals((linea.board.get(k+1).get(index)))){
//					counter += 1;
//					 if (counter == 3) {
//			                return true;
//					 }
//				}else {
//					counter = 0;
//				}
//			}
//		}
//		
//		    return false;
//	}	
	
	
	public boolean winningMethod(Line linea, char player) {
		return checkDiagonal(linea, player);
	}
	
	public boolean checkDiagonal(Line linea, char player) {
	    boolean diagonallyDown = IntStream.range(0, linea.rows() - 3)
	        .anyMatch(i -> IntStream.range(0, linea.columns() - 3)
	            .anyMatch(j -> IntStream.range(0, 4)
	                .allMatch(k -> {
	                    int rowIndex = i + k;
	                    int colIndex = j + k;
	                    return rowIndex < linea.rows() && colIndex < linea.columns() &&
	                           linea.board.get(rowIndex).get(colIndex) == player;
	                })));

	    boolean diagonallyUp = IntStream.range(3, linea.rows())
	        .anyMatch(i -> IntStream.range(0, linea.columns() - 3)
	            .anyMatch(j -> IntStream.range(0, 4)
	                .allMatch(k -> {
	                    int rowIndex = i - k;
	                    int colIndex = j + k;
	                    return rowIndex >= 0 && colIndex < linea.columns() &&
	                           linea.board.get(rowIndex).get(colIndex) == player;
	                })));

	    return diagonallyUp || diagonallyDown;
	}


}