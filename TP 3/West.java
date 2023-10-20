package Nemo;

public class West extends Directions{
	
//	String right = "N";
//	String left = "S";
	
	public West() {
		this.key = "W";
	}

	public void getRight(Nemo nemo) {
		nemo.direc = "N";
	}

	public void getLeft(Nemo nemo) {
		nemo.direc = "S";
	}

	public void moveForwards(Nemo nemo) {
		nemo.x -= 1;
	}
	
	public String getKey() {
		return this.key;
	}

}
