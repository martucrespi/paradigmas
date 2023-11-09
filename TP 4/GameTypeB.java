package linea;

public class GameTypeB extends GameType{
	
	public GameTypeB() {
		this.key = 'B';
	}
	
	public char getKey() {
		return this.key;
	}
	

	public boolean finished(Linea linea) {
		return false;
	}

	

}
