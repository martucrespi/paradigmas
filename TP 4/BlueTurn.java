package linea;

public class BlueTurn extends Players{
	
	public BlueTurn() {
		this.icon = "B";
	}
	
	public String getIcon() {
		return this.icon;
	}

	public void play(Linea linea, int column) {
		if (linea.turn == "B") {
			if (column > linea.board.size()) {
				throw new Error ("Cannot play out of bounds");
			}
			else {
				linea.setStatus("R");
				int columnIndex = column - 1;
				linea.board.get(columnIndex).add("B", linea);
			}
		}
		else {
			throw new Error ("Blue cannot play twice");
		}
	}

}
