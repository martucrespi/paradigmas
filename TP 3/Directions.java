package Nemo;

public abstract class Directions {

	String right;
	String left;
	String key;
	public abstract void getRight(Nemo nemo);
	public abstract void getLeft(Nemo nemo);
	public abstract void moveForwards(Nemo nemo);
	public abstract String getKey();
}

