package Nemo;

public class CMCapsule extends Commands {

	public static String nemoHasBeenDestroyed = "Nemo has been destroyed";


	public CMCapsule() {
		this.key = 'm';
	}

	public void execute(Nemo nemo) {
		if (nemo.depth <= -2) {
			throw new Error (nemoHasBeenDestroyed); 
		}
	}

	public char getKey() {
		return this.key;
	}
}
