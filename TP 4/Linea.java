package linea;

import java.util.ArrayList;

public class Linea {
	
	public ArrayList<Columns> board;
	
	public int width;
	public int height;
	public char gameType;
	private String turn;
	
	public Linea(int width, int height, char gameType) {
		this.width = width;
		this.height = height;
		this.gameType = gameType;
		setTurn("R");
		
		this.board = new ArrayList<Columns>();
        for (int i = 0; i < width; i++) {
            Columns column = new Columns();
            this.board.add(column);
        }
	}
	
	public void setTurn(String turn) {
		this.turn = turn;
	}
	
	public int width() {
		return this.width;
	}
	
	public int height() {
		return this.height;
	}
	
	public char gameType() {
		return this.gameType;
	}
	
	public boolean redPlays() {
		return turn() == "R";
	}

	public boolean bluePlays() {
		return turn() == "B";
	}
	
	private String turn(){
		return turn;
	}
	
	public void playRedAt(int column) {
		if (turn == "R") {
			if (column > board.size()) {
				throw new Error ("Cannot play out of bounds");
			}
			else {
				setTurn("B");
				int columnIndex = column - 1;
				board.get(columnIndex).add("R", this);
			}
		}
		else {
			throw new Error ("Red cannot play twice");
		}
	}
	
	public void playBlueAt(int column) {
		if (turn == "B") {
			if (column > board.size()) {
				throw new Error ("Cannot play out of bounds");
			}
			else {
				setTurn("R");
				int columnIndex = column - 1;
				board.get(columnIndex).add("B", this);
			}
		}
		else {
			throw new Error ("Blue cannot play twice");
		}
	}

}
