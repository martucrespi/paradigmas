package Nemo;

public class CRight extends Commands {
  
	public CRight () {
		this.key = 'r';
	}

	public void ejecutar(Nemo nemo, char instruccion) {
		//lista tipo commands de direcciones
		//for para buscar i == direc --> obj direction
		//get right del obj -> direction de nemo == get right
	}

	@Override
	public char getKey() {
		return this.key;
	}
	
	
	//ejecutar me deja hacer:
//	if (instruccion == 'r' && this.direc == "N") {
//		this.direc = "E";
//	}
//	else if (instruccion == 'r' && this.direc == "E") {
//		this.direc = "S";
//	}
//	else if (instruccion == 'r' && this.direc == "S") {
//		this.direc = "O";
//	}else if (instruccion == 'r' && this.direc == "O") {
//		this.direc = "N";
//	}
}
