package Nemo;

import java.util.ArrayList;

public class CLeft extends Commands {
	
	public ArrayList<Directions> direcciones = new ArrayList<Directions>();
	
	public CLeft() {
		this.key = 'l';
	}
	
	public void ejDireccion(Nemo nemo, char instruccion) {
		
		direcciones.add(new North());
		direcciones.add(new South());
		direcciones.add(new East());
		direcciones.add(new West());
				
		for (int i = 0; i <= direcciones.size(); i ++) {
			if (nemo.direc == direcciones.get(i).getKey()) {
				direcciones.get(i).getLeft(nemo);
			}
		}
	}
	
	public void ejecutar(Nemo nemo, char instruction) {
		this.ejDireccion(nemo, instruction);
	}

	public char getKey() {
		return this.key;
	}

}
