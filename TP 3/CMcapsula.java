package Nemo;

public class CMcapsula extends Commands {

	public CMcapsula() {
		this.key = 'm';
	}


	public void ejecutar(Nemo nemo, char instruccion) {
		//si profundidad no es 1 0 o -1, tira error
	}


	@Override
	public char getKey() {
		return this.key;
	}
}
