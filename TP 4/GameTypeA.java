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
			if (linea.board.get(i).elementsAreAllequal()) {
				return true;
				}		
		}
		return false;
		}
	
//	public String whoWon() {
//		
//	}
	
}
