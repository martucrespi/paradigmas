package linea;

public abstract class GameType {
	
	char key;
	public abstract char getKey();
	public abstract boolean winningMethod(Linea linea, char player);

}
