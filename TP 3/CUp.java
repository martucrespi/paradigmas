package Nemo;

public class CUp extends Commands{


	
	public CUp() {
		this.key = 'u';
	}

	
	public void ejecutar(Nemo nemo, char instruccion) {
		// if profundidad == 1 --> no sube mas
		nemo.profundidad += 1;
		
	}



	@Override
	public char getKey() {
		return this.key;
	}
	
}
