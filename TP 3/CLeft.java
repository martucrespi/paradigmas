package Nemo;

public class CLeft extends Commands {

	
	public CLeft() {
		this.key = 'l';
	}
	
	public void ejecutar (Nemo nemo, char instruccion) {
	}

	@Override
	public char getKey() {
		return this.key;
	}

}
