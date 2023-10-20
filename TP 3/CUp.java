package Nemo;

public class CUp extends Commands{


	
	public CUp() {
		this.key = 'u';
	}

	
	public void ejecutar(Nemo nemo, char instruccion) {
		if (nemo.profundidad == 1) {
			nemo.profundidad = 1;
		}
		else {
			nemo.profundidad += 1;
		}
	}

	public char getKey() {
		return this.key;
	}


	@Override
	public void movimiento(Nemo nemo, String direction) {}
	
}
