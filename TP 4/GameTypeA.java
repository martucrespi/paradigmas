package linea;

public class GameTypeA extends GameType{
	
	public GameTypeA(){
		this.key = 'A';
	}
	
	public char getKey() {
		return this.key;
	}

	public boolean finished(Linea linea) {
		for(int i = 0; i < linea.width(); i++) {
			if (linea.board.get(i).verticalElementsAreEqual()) {
				return true;
				}		
		}
		
		int counter = 0;
		for (int e = 0; e < linea.height()-1 ; e++) {
			for (int k = 0; k < linea.width()-1 ; k++) {
				if (linea.board.get(k).compareElementsBetweenColumns(linea.board.get(k+1), e)){
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
	
//	public String whoWon() {
//		
//	}
	
}