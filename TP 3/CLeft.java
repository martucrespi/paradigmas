package Nemo;

import java.util.ArrayList;

public class CLeft extends Commands {
	
	public ArrayList<Directions> directions = new ArrayList<Directions>();
	
	public CLeft() {
		this.key = 'l';
	}
	
	public void execute(Nemo nemo) {
		
		directions.add(new North());
		directions.add(new South());
		directions.add(new East());
		directions.add(new West());
				
		directions.stream()
        	.filter(direction -> nemo.direc == direction.getKey())
        	.findFirst()
        	.ifPresent(direction -> direction.getLeft(nemo));
	}

	public char getKey() {
		return this.key;
	}

}
