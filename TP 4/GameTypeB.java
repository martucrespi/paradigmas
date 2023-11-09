package linea;

public class GameTypeB extends GameType{
	
	public GameTypeB() {
		this.key = 'B';
	}
	
	public char getKey() {
		return this.key;
	}
	

	public boolean finished(Linea linea) {
		int counter = 0;
		for (int e = 2; e < linea.height()-1 ; e++) {
			for (int k = 0; k < linea.width()-2 ; k++) {
				if (linea.board.get(k).compareElementDiagonallyDown(linea.board.get(k+1), e)){
					counter += 1;
					 if (counter == 3) {
			                return true;
					 }
				}else {
					counter = 0;
				}
			}
		}
		
		for (int e = 1; e < linea.height()-2 ; e++) {
			for (int k = 0; k < linea.width()-2 ; k++) {
				if (linea.board.get(k).compareElementDiagonallyUp(linea.board.get(k+1), e)){
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

	

}