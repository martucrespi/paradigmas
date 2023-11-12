package linea;

public class RedTurn extends Players{
	
	public RedTurn() {
		this.icon = "R";
	}
	
	public String getIcon() {
		return this.icon;
	}
	
	public void play(Linea linea, int column) {
		if (linea.turn == "R") {
			if (column > linea.board.size()) {
				throw new Error ("Cannot play out of bounds");
			}
			else {
				linea.setStatus("B");
				int columnIndex = column - 1;
				linea.board.get(columnIndex).add("R", linea);
			}
		}
		else {
			throw new Error ("Red cannot play twice");
		}
	}
	
}
	

