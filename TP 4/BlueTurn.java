package linea;

public class BlueTurn extends Status{
	
	public BlueTurn() {
		this.icon = 'O';
	}
	
	public char getIcon() {
		return this.icon;
	}

	public void play(Line linea, int column) {
		if (linea.turn == 'O') {
			if (column > linea.columns()) {
				throw new Error ("Cannot play out of bounds");
			}
			else {
				linea.setTurn('X');
				int columnIndex = column - 1;
				linea.board.get(columnIndex).add('O');
			}
		}
		else {
			throw new Error ("Blue cannot play twice");
		}
	}
}