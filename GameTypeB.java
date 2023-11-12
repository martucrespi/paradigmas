package linea;

import java.util.stream.IntStream;

public class GameTypeB extends GameType{
	
//	private static final int DIAGONAL_WIN_COUNT = 3;
	
	public GameTypeB() {
		this.key = 'B';
	}
	
	public char getKey() {
		return this.key;
	}

	
//	public boolean finished(Linea linea) {
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
	
//	public boolean finished(Linea linea, char player) {
//		return checkDescendingDiagonalWin(player, linea) || checkAscendingDiagonalWin(player, linea);
//	}
//	
//	public boolean checkDescendingDiagonalWin(char player, Linea linea) {
//		return IntStream.range(0, linea.rows() - 3)
//				.anyMatch(row -> IntStream.range(0, linea.columns() - 3).anyMatch(col -> IntStream.range(0, 4).allMatch(
//						i -> linea.board.get(col + i).size() > row + i && linea.board.get(col + i).get(row + i) == player)));
//	}
//
//	public boolean checkAscendingDiagonalWin(char player, Linea linea) {
//		return IntStream.range(3, linea.rows())
//				.anyMatch(row -> IntStream.range(0, linea.columns() - 3).anyMatch(col -> IntStream.range(0, 4).allMatch(
//						i -> linea.board.get(col + i).size() > row - i && linea.board.get(col + i).get(row - i) == player)));
//	}	
	
	public boolean winningMethod(Linea linea, char player) {
		return checkDiagonal(linea, player);
	}
	
	public boolean checkDiagonal(Linea linea, char player) {
		boolean diagonallyDown = IntStream.range(0, linea.rows() - 3)
									.anyMatch(i -> IntStream.range(0, linea.columns() - 3 )
											.anyMatch(j -> IntStream.range(0, 4)
													.allMatch(k -> linea.board.get(i + k).get(j + k) == player)));
		
		boolean diagonallyUp = IntStream.range(3, linea.rows() - 3)
									.anyMatch(i -> IntStream.range(0, linea.columns())
											.anyMatch(j -> IntStream.range(0, 4)
													.allMatch(k -> linea.board.get(i + k).get(j - k) == player)));
		
		return diagonallyUp || diagonallyDown;
	}

}
