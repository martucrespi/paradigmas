package Nemo;


public abstract class Commands {
	char key;
	public abstract void ejecutar(Nemo nemo, char instruccion);
	public abstract char getKey();
	

	

}
