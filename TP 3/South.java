package Nemo;

public class South extends Directions{
	
	public South() {
		this.key = "S";
	}

	public void getRight(Nemo nemo) {
		nemo.direc = "W";
	}

	public void getLeft(Nemo nemo) {
		nemo.direc = "E";
	}

	public void moveForwards(Nemo nemo) {
		nemo.y -= 1;
	}
	
	public String getKey() {
		return this.key;
	}

}