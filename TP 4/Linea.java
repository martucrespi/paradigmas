package linea;

import java.util.ArrayList;

public class Linea {
	
	public ArrayList<Columns> board = new ArrayList<>();
	
	public int width;
	public int height;
	public char gameType;
	private String turn;
	
	public Linea(int width, int height, char gameType) {
		this.width = width;
		this.height = height;
		this.gameType = gameType;
		
		this.board = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < width; i++) {
            ArrayList<Object> column = new ArrayList<Object>();
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
	
	public void PlayRedAt(int column) {
		if (turn == "R") {
			setTurn("B");
			int columnIndex = column - 1;
			board[0].
		}
		else {
			throw new Error ("Red cannot play twice");
		}
	}
	
	public void manoJuega(int column) {
		if (turn == "B") {
			setTurn("R");
			board.add(column-1, "O");
		}
		else {
			throw new Error ("Blue cannot play twice");
		}
	}

}
