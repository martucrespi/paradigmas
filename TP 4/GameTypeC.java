package linea;

public class GameTypeC extends GameType{
	
	public GameTypeC() {
		this.key = 'C';
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

}
