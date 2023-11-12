package linea;

import java.util.ArrayList;

public class Linea {
	
	public ArrayList<ArrayList<Character>> board;
	
	public int rows;
	public int columns;
	public char gametype;
	public char turn;
	public ArrayList<GameType> gameTypes = new ArrayList<GameType>();
	public ArrayList<Status> status = new ArrayList<Status>();
	
	
	public Linea (int rows, int columns, char gameType) {
		this.rows = rows;
		this.columns = columns;
		this.gametype = gameType;
		setTurn('X');
		
		this.board = new ArrayList<>();
		for (int i = 0; i < columns; i++) {
			ArrayList<Character> column = new ArrayList<>();
			column.add('N');
			this.board.add(column);
		}
	}
	
	public GameType gameTypeFor(char gtype) {
		gameTypes.add(new GameTypeA());
		gameTypes.add(new GameTypeB());
		gameTypes.add(new GameTypeC());
   	
   		return gameTypes.stream()
   		        .filter(type -> gtype == type.getKey())
   		        .findFirst()
   		        .orElse(null);
   	}
	
	public boolean finished() {
		return this.gameTypeFor(this.gameType()).winningMethod(this, this.turn());
	}
	
	public void setTurn(char turn) {
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
		return turn() == 'X';
	}

	public boolean bluePlays() {
		return turn() == 'O';
	}
	
	private char turn(){
		return turn;
	}
	
	public Status playTurn(char icon) {
		status.add(new RedTurn());
		status.add(new BlueTurn());
		status.add(new GameFinished());
		
		return status.stream()
				.filter(status -> icon == status.getIcon())
   		      	.findFirst()
   		        .orElse(null);
	}
	
	
	public void playRedAt(int column) {
		this.playTurn('X').play(this, column);
	}
	
	public void playBlueAt(int column) {
		this.playTurn('O').play(this, column);
	}
	
}
