package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
		
	
	@Test public void test01StartNewGameA() {
		Line game = CreateNewGame(6, 6, 'A');
		checksColumnsAndRows(game);
		assertEquals(game.gametype, 'A');
	}

	
	@Test public void test02StartsNewGameB() {
		Line game = CreateNewGame(6, 6, 'B');
		checksColumnsAndRows(game);
		assertEquals(game.gametype, 'B');
	}
	
	@Test public void test03StartsNewGameC() {
		Line game = CreateNewGame(6, 6,'C');
		checksColumnsAndRows(game);
		assertEquals(game.gametype, 'C');
	}

	
	@Test public void test04RedPlays() {
		Line game = CreateNewGame(6, 6,'A');
		checksIfIsRedsTurn(game);
	}
	
	@Test public void test05RedPlaysBluesTurn() {
		Line game = CreateNewGame(6, 6, 'A');
		game.playRedAt(1);
		assertTrue(game.bluePlays());
		assertFalse(game.redPlays());
	}
	
	@Test public void test06RedAndBluePlay() {
		Line game = CreateNewGame(6, 6, 'A');
		game.playRedAt(1);	
		game.playBlueAt(2);
		checksIfIsRedsTurn(game);
	}
	
	@Test public void test07RedCannotPlayOutsideOutOfBoundsWidth() {
		Line game = CreateNewGame(6, 6, 'A');
		try{
			game.playRedAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test08BlueCannotPlayOutsideOutOfBoundsWidth() {
		Line game = CreateNewGame(6, 6, 'A');
		game.playRedAt(1);
		try{
			game.playBlueAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test09RedCannotPlayOutsideOutOfBoundsHeight() {
		Line game = CreateNewGame(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(1);
		try {
			game.playRedAt(1);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test10BlueCannotPlayOutsideOutOfBoundsHeight() {
		Line game = CreateNewGame(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test11RedCannotPlayTwice() {
		Line game = CreateNewGame(4, 4, 'A');
		game.playRedAt(1);
		try {
			game.playRedAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Player cannot play twice"));
		}
	}
	
	@Test public void test12BlueCannotPlayTwice() {
		Line game = CreateNewGame(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Player cannot play twice"));
		}
	}
	
	@Test public void test13RedWinsAHorizontally() {
		Line game =CreateNewGame(5, 5, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		chekIfGameFInished(game);
	}
	
	@Test public void test14RedWinsAVertically() {
		Line game = CreateNewGame(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		chekIfGameFInished(game);
	}
	
	@Test public void test15BlueWinsAHorizontally() {
		Line game = CreateNewGame(5, 5, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(1);
		game.playRedAt(4);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(3);
		game.playRedAt(5);
		game.playBlueAt(4);
		chekIfGameFInished(game);
		
	}
	
	@Test public void test16BlueWinsAVertically() {
		Line game = CreateNewGame(5, 5, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		chekIfGameFInished(game);
	}
	
	@Test public void test17RedWinsBDiagonallyUp() {
		Line game = CreateNewGame(6, 6, 'B');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(5);
		game.playBlueAt(4);
		game.playRedAt(4);
		chekIfGameFInished(game);
	}
	
	@Test public void test18RedWinsBDiagonallyDown() {
		Line game = CreateNewGame(6, 6, 'B');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(4);
		chekIfGameFInished(game);
	}
	
	@Test public void test19BlueWinsBDiagonallyUp() {
		Line game = CreateNewGame(6, 6, 'B');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(5);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(6);
		game.playBlueAt(5);
		game.playRedAt(5);
		game.playBlueAt(5);
		chekIfGameFInished(game);
	}
	
	@Test public void test20BlueWinsBDiagonallyDown() {
		Line game = CreateNewGame(6, 6, 'B');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(6);
		game.playBlueAt(4);
		game.playRedAt(6);
		game.playBlueAt(5);
		chekIfGameFInished(game);
	}

	@Test public void test21RedWinsCHorizontally() {
		Line game = CreateNewGame(5, 5, 'C');
		game.playRedAt(5);
		game.playBlueAt(5);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		chekIfGameFInished(game);
	}
	
	@Test public void test22RedWinsCVertically() {
		Line game = CreateNewGame(5, 5, 'C');
		game.playRedAt(3);
		game.playBlueAt(5);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(3);
		chekIfGameFInished(game);
	}
	
	@Test public void test23RedWinsCDiagonallyUp() {
		Line game = CreateNewGame(6, 6, 'C');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(4);
		chekIfGameFInished(game);
	}
	
	@Test public void test24RedWinsCDiagonallyDown() {
		Line game = CreateNewGame(6, 6, 'C');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(4);
		game.playBlueAt(4);
		chekIfGameFInished(game);
	}
	
	@Test public void test25BlueWinsCHorizontally() {
		Line game = CreateNewGame(5, 5, 'C');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(3);
		game.playRedAt(2);
		game.playBlueAt(4);
		game.playRedAt(2);
		game.playBlueAt(5);
		chekIfGameFInished(game);
	}
	
	@Test public void test26BlueWinsCVertically() {
		Line game = CreateNewGame(5, 5, 'C');
		game.playRedAt(2);
		game.playBlueAt(1);
		game.playRedAt(4);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(1);
		game.playRedAt(3);
		game.playBlueAt(1);
		chekIfGameFInished(game);
	}
	
	@Test public void test27BlueWinsCDiagonallyUp() {
		Line game = CreateNewGame(6, 6, 'C');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(5);
		game.playRedAt(4);
		game.playBlueAt(4);
		game.playRedAt(6);
		game.playBlueAt(5);
		game.playRedAt(5);
		game.playBlueAt(5);
		chekIfGameFInished(game);
	}
	
	@Test public void test28BlueWinsCDiagonallyDown() {
		Line game = CreateNewGame(6, 6, 'C');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(6);
		game.playBlueAt(4);
		game.playRedAt(6);
		game.playBlueAt(5);
		chekIfGameFInished(game);
	}

	
	
	@Test public void test29CannotPlayWhenWonA() {
		Line game =CreateNewGame(5, 5, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("The game has ended"));
		}
	}
	
	@Test public void test30CannotPlayWhenWonB() {
		Line game = CreateNewGame(6, 6, 'B');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(3);
		game.playRedAt(4);
		game.playBlueAt(3);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(5);
		game.playBlueAt(4);
		game.playRedAt(4);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("The game has ended"));
		}
	}

	@Test public void test31CannotPlayWhenWonC() {
		Line game = CreateNewGame(5, 5, 'C');
		game.playRedAt(5);
		game.playBlueAt(5);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("The game has ended"));
		}
	}
	
	@Test public void test32CannotPlayAfterDrawA() {
		Line game = CreateNewGame(3, 3, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("The game has ended"));
		}
	}
	
	@Test public void test33CannotPlayAfterDrawB() {
		Line game = CreateNewGame(3, 3, 'B');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("The game has ended"));
		}
	}

	@Test public void test34CannotPlayAfterDrawC() {
		Line game = CreateNewGame(3, 3, 'C');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("The game has ended"));
		}
	}
	private Line CreateNewGame(int rows, int columns, char gameType) {
		Line game = new Line(rows, columns, gameType);
		return game;
	}
	
	private void checksColumnsAndRows(Line game) {
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
	}
	
	private void checksIfIsRedsTurn(Line game) {
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	private void chekIfGameFInished(Line game) {
		assertTrue(game.finished());
	}

	
}
