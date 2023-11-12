package linea;

public abstract class Status {
	
	char icon;
	public abstract char getIcon();
	public abstract void play(Linea linea, int column);

}
