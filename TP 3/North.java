package Nemo;

public class North extends Directions{
	
	public North() {
		this.key = "N";
	}

	public void getRight(Nemo nemo) {
		nemo.direc = "E";
	}

	public void getLeft(Nemo nemo) {
		nemo.direc = "W";
	}

	public void moveForwards(Nemo nemo) {
		nemo.y += 1;
	}

	public String getKey() {
		return this.key;
	}

}