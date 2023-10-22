package Nemo;

import java.util.ArrayList;

public class CRight extends Commands {
	
	public ArrayList<Directions> directions = new ArrayList<Directions>();
  
	public CRight () {
		this.key = 'r';
	}

	public void execute(Nemo nemo) {			
		
		directions.add(new North());
		directions.add(new South());
		directions.add(new East());
		directions.add(new West());
				
		directions.stream()
        	.filter(direction -> nemo.direc == direction.getKey())
        	.findFirst()
        	.ifPresent(direction -> direction.getRight(nemo));
	}

	public char getKey() {
		return this.key;
	}

}
