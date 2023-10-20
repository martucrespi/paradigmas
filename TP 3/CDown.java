package Nemo;

public class CDown extends Commands {


	public CDown() {
		this.key = 'd';
	}

	public void ejecutar(Nemo nemo, char instruccion) {
		nemo.profundidad -= 1;
	}

	public char getKey() {
		return this.key;
	}

	@Override
	public void movimiento(Nemo nemo, String direction) {}
}