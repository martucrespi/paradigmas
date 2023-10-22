package Nemo;

public class East extends Directions{
	
	public East() {
		this.key = "E";
	}

	public void getRight(Nemo nemo) {
		nemo.direc = "S";
	}

	public void getLeft(Nemo nemo) {
		nemo.direc = "N";
	}

	public void moveForwards(Nemo nemo) {
		nemo.x += 1;
	}
	
	public String getKey() {
		return this.key;
	}

}
