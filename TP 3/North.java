package Nemo;

public class North extends Directions{
	
	String right = "E";
	String left = "O";

	@Override
	public String getRight() {
			return this.right;
	}


	@Override
	public String getLeft() {
		return this.left;
	}


	@Override
	public void moveForwards(Nemo nemo) {
		nemo.y += 1;
		
	}

}
