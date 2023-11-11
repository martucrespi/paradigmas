package linea0;

import java.util.ArrayList;


public class Linea0 {
	
	public ArrayList<ArrayList<Character>> board;
	
	public int rows;
	public int columns;
	public char gametype;
	private String turn;
	public ArrayList<GameType0> gameTypes = new ArrayList<GameType0>();
	
	public Linea0 (int rows, int columns, char gameType) {
		this.rows = rows;
		this.columns = columns;
		this.gametype = gameType;
		setTurn("R");
		
		this.board = new ArrayList<>();
		for (int i = 0; i < columns; i++) {
			ArrayList<Character> column = new ArrayList<>();
			column.add('N');
			this.board.add(column);
		}
	}
	
	public GameType0 gameTypeFor(char gtype) {
		gameTypes.add(new GameTypeA0());
		gameTypes.add(new GameTypeB0());
		gameTypes.add(new GameTypeC0());
   	
   		return gameTypes.stream()
   		        .filter(type -> gtype == type.getKey())
   		        .findFirst()
   		        .orElse(null);
   	}
	
	public boolean finished() {
		return this.gameTypeFor(this.gameType()).finished(this);
	}
	
	public void setTurn(String turn) {
		this.turn = turn;
	}
	
	public int columns() {
		return this.columns;
	}
	
	public int rows () {
		return this.rows;
	}
	
	public char gameType() {
		return this.gametype;
	}
	
	public boolean redPlays() {
		return turn() == "R";
	}
	
	public boolean bluePlays() {
		return turn() == "B";
	}
	
	public String turn() {
		return turn;
	}
	
	
	public void playRedAt(int column) {
		if (turn == "R") {
			if (column > this.columns()) {
				throw new Error ("Cannot play out of bounds");
			}else {
				setTurn("B");
				int columnIndex = column -1;
				board.get(columnIndex).add('X');
			}
		}else {
			throw new Error ("Red cannot play twice");
		}
	}
	
	public void playBlueAt(int column) {
		if (turn == "B") {
			if (column > this.columns()) {
				throw new Error ("Cannot play out of bounds");
			}else {
				setTurn("R");
				int columnIndex = column -1;
				board.get(columnIndex).add('O');
			}
		}else {
			throw new Error ("Blue cannot play twice");
		}
	}
	

}
