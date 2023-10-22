package Nemo;

public class CUp extends Commands{


	
	public CUp() {
		this.key = 'u';
	}

	
	public void execute(Nemo nemo) {
		if (nemo.depth == 0) {
			nemo.depth = 0;
		}
		else {
			nemo.depth += 1;
		}
	}

	public char getKey() {
		return this.key;
	}

}
