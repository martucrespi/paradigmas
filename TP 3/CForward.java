package Nemo;

import java.util.ArrayList;

public class CForward extends Commands{
	
	public ArrayList<Directions> direcciones = new ArrayList<Directions>();

	public CForward() {
		this.key = 'f';
	}
	
	public void movimiento(Nemo nemo, String direction) {
		
		direcciones.add(new North());
		direcciones.add(new South());
		direcciones.add(new East());
		direcciones.add(new West());
		
		for (int i = 0; i <= direcciones.size(); i ++) {
			if (nemo.direc == direcciones.get(i).getKey()) {
				direcciones.get(i).moveForwards(nemo);
			}
		}
	}

	public char getKey() {
		return this.key;
	}

	@Override
	public void ejecutar(Nemo nemo, char instruccion) {}
}
