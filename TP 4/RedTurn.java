package linea;

public class RedTurn extends Status{
	
	public RedTurn() {
		this.icon = 'X';
	}
	
	public char getIcon() {
		return this.icon;
	}
	
	public void play(Linea linea, int column) {
		if (linea.turn == 'X') {
			if (column < 0 || column > linea.columns()) {
				throw new Error ("Cannot play out of bounds");
			}
			else {
				linea.setTurn('O');
				int columnIndex = column - 1;
				linea.board.get(columnIndex).add('X');
			}
		}
		else {
			throw new Error ("Red cannot play twice");
		}
	}
	
}
	

