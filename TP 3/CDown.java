package Nemo;

public class CDown extends Commands {


	public CDown() {
		this.key = 'd';
	}

	public void execute(Nemo nemo) {
		nemo.depth -= 1;
	}

	public char getKey() {
		return this.key;
	}

}