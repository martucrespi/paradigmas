package Nemo;

import java.util.ArrayList;

public class Nemo {

	public int x;
	public int y;
	public int depth;
	public String direc;
	public ArrayList<Commands> commands = new ArrayList<Commands>();
	
	public Commands commandsFor(char instruction) {
		commands.add(new CDown());
		commands.add(new CUp());
		commands.add(new CLeft());
		commands.add(new CRight());
		commands.add(new CForward());
		commands.add(new CMCapsule());
	
		return commands.stream()
		        .filter(command -> instruction == command.getKey())
		        .findFirst()
		        .orElse(null);
	}

	public Nemo () {
		this.x = 0;
		this.y = 0;
		this.depth = 0;
		this.direc = "N";
	}
	
	public Nemo (int x, int y, int prof, String direc) {
		this.x = x;
		this.y = y;
		this.depth = prof;
		this.direc = direc;
	}

	public int x() {
		return this.x;
	}
	
	public int y() {
		return this.y;
	}
	
	public int depth() {
		return this.depth;
	}
	
	public String direc() {
		return this.direc;
	}
	
	public void move(char instruction) {
		this.commandsFor(instruction).execute(this);
	}
	
	public void move(String instruction) {
		instruction.chars().forEach(c -> move((char) c));
	}

}
