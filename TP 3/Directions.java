package Nemo;

public  abstract class Directions {

	String right;
	String left;
	public abstract String getRight();
	public abstract String getLeft();
	public abstract void moveForwards(Nemo nemo);
}

