package Nemo;

public class Nemo {

	private int x;
	private int y;
	private int profundidad;
	private String direc;

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
	
	public void mover(char instruccion) {
		if (instruccion == 'd') {
			this.profundidad -= 1;
		}
		if (instruccion == 'u') {
			this.profundidad += 1;
		}
		
		if (instruccion == 'r' && this.direc == "N") {
			this.direc = "E";
		}
		else if (instruccion == 'r' && this.direc == "E") {
			this.direc = "S";
		}
		else if (instruccion == 'r' && this.direc == "S") {
			this.direc = "O";
		}else if (instruccion == 'r' && this.direc == "O") {
			this.direc = "N";
		}
		
		
		if (instruccion == 'l' && this.direc == "N") {
			this.direc = "O";
		}
		else if (instruccion == 'l' && this.direc == "O") {
			this.direc = "S";
		}
		else if (instruccion == 'l' && this.direc == "S") {
			this.direc = "E";
		}else if (instruccion == 'l' && this.direc == "E") {
			this.direc = "N";
		}
	}
		

}
