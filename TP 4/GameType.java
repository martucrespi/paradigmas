package linea;

public abstract class GameType {
	
	char key;
	public abstract char getKey();
	public abstract boolean finished(Linea linea);

}