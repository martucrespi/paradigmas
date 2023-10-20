package Nemo;

import java.util.ArrayList;

public class Nemo {

	// larga capsula en profundidad = 0 o =1
	public int x;
	public int y;
	public int profundidad;
	public String direc;
	public ArrayList<Commands> comandos = new ArrayList<Commands>();
	
	public Commands commandsFor(char instruccion) {
		comandos.add(new CDown());
		comandos.add(new CUp());
		comandos.add(new CLeft());
		comandos.add(new CRight());
		comandos.add(new CForward());
		comandos.add(new CMcapsula());
	
		for (int i = 0; i <= comandos.size(); i ++){
			if (instruccion == comandos.get(i).getKey()){
				return comandos.get(i);
				}
			}
		return null;
	}

	public Nemo () {
		this.x = 0;
		this.y = 0;
		this.profundidad = 0;
		this.direc = "N";
	}

	public int x() {
		return this.x;
	}
	
	public int y() {
		return this.y;
	}
	
	public int profundidad() {
		return this.profundidad;
	}
	
	public String direc() {
		return this.direc;
	}
	
	public void moverVacio(String instruccion) {
	}
	
	public void mover(char instruction) {
		this.commandsFor(instruction).ejecutar(this, instruction);
	}	

}
