package linea;

import java.util.ArrayList;

public class Linea1 {
public ArrayList<Columns> board;
	
	public int width;
	public int height;
	public char gametype;
	public String turn;
	public ArrayList<GameType> gameTypes = new ArrayList<GameType>();
	public ArrayList<Players> player = new ArrayList<Players>();
	
	public Linea(int width, int height, char gameType) {
		this.width = width;
		this.height = height;
		this.gametype = gameType;
		setStatus("R");
		
		this.board = new ArrayList<Columns>();
        for (int i = 0; i < width; i++) {
            Columns column = new Columns();
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
		return this.gameTypeFor(this.gametype()).finished(this);
	}
	
	public void setStatus(String turn) {
		this.turn = turn;
	}
	
	public int width() {
		return this.width;
	}
	
	public int height() {
		return this.height;
	}
	
	public char gametype() {
		return this.gametype;
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
	
	public Players playTurn(String icon) {
		player.add(new RedTurn());
		player.add(new BlueTurn());
		player.add(new GameFinished());
		
		return player.stream()
				.filter(player -> icon == player.getIcon())
   		      	.findFirst()
   		        .orElse(null);
	}
	
	
	public void playRedAt(int column) {
		this.playTurn("R").play(this, column); //cambiar R a X, B a O y string a char 
	}
	
	public void playBlueAt(int column) {
		this.playTurn("B").play(this, column);
	}
}
