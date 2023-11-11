package linea0;

public class GameTypeB0 extends GameType0{

	public GameTypeB0() {
		this.key = 'B';
	}
	
	public char getKey() {
		return this.key;
	}

	
	public boolean finished(Linea0 linea) {
		int counter = 0;
		int index;
		for (int e = 0; e < linea.columns()-2 ; e++) {
			for (int k = 0; k < linea.rows()-2 ; k++) {
				index = e +1;
				if (linea.board.get(k).get(e).equals((linea.board.get(k+1).get(index)))){
					counter += 1;
					 if (counter == 3) {
			                return true;
					 }
				}else {
					counter = 0;
				}
			}
		}
		
		    return false;
	}

}
