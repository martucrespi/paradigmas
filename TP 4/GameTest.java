package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
		
	
	@Test public void test01StartNewGameA() {
		Line game = new Line(6, 6, 'A');
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
		assertEquals(game.gametype, 'A');
	}
	
	@Test public void test02StartsNewGameB() {
		Line game = new Line(6, 6, 'B');
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
		assertEquals(game.gametype, 'B');
	}
	
	@Test public void test03StartsNewGameC() {
		Line game = new Line(6, 6, 'C');
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
		assertEquals(game.gametype, 'C');
	}
	
	@Test public void test04RedPlays() {
		Line game = new Line(6, 6, 'C');
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	@Test public void test05RedPlaysBluesTurn() {
		Line game = new Line(6, 6, 'C');
		game.playRedAt(1);
		assertTrue(game.bluePlays());
		assertFalse(game.redPlays());
	}
	
	@Test public void test06RedAndBluePlay() {
		Line game = new Line(6, 6, 'C');
		game.playRedAt(1);	
		game.playBlueAt(2);
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	@Test public void test07RedCannotPlayOutsideOutOfBoundsWidth() {
		Line game = new Line(6, 6, 'C');
		try{
			game.playRedAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test08BlueCannotPlayOutsideOutOfBoundsWidth() {
		Line game = new Line(6, 6, 'C');
		game.playRedAt(1);
		try{
			game.playBlueAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test09RedCannotPlayOutsideOutOfBoundsHeight() {
		Line game = new Line(4, 4, 'A');
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
		Line game = new Line(4, 4, 'A');
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
		Line game = new Line(4, 4, 'A');
		game.playRedAt(1);
		try {
			game.playRedAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Player cannot play twice"));
		}
	}
	
	@Test public void test12BlueCannotPlayTwice() {
		Line game = new Line(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Player cannot play twice"));
		}
	}
	
	@Test public void test13RedWinsAHorizontally() {
		Line game = new Line(5, 5, 'A');
		game.playRedAt(1);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		assertTrue(game.finished());
	}
	
	@Test public void test14RedWinsAVertically() {
		Line game = new Line(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		assertTrue(game.finished());
	}
	
	@Test public void test15BlueWinsAHorizontally() {
		Line game = new Line(5, 5, 'A');
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
		assertTrue(game.finished());
		
	}
	
	@Test public void test16BlueWinsAVertically() {
		Line game = new Line(5, 5, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		assertTrue(game.finished());
	}
	
	@Test public void test17RedWinsBDiagonallyUp() {
		Line game = new Line(6, 6, 'B');
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
		assertTrue(game.finished());
	}
	
	@Test public void test18RedWinsBDiagonallyDown() {
		Line game = new Line(6, 6, 'B');
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
		assertTrue(game.finished());
	}
	
	@Test public void test19BlueWinsBDiagonallyUp() {
		Line game = new Line(6, 6, 'B');
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
		assertTrue(game.finished());
	}
	
	@Test public void test20BlueWinsBDiagonallyDown() {
		Line game = new Line(6, 6, 'B');
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
		assertTrue(game.finished());
	}

	@Test public void test21RedWinsCHorizontally() {
		Line game = new Line(5, 5, 'C');
		game.playRedAt(5);
		game.playBlueAt(5);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(3);
		game.playRedAt(4);
		assertTrue(game.finished());
	}
	
	@Test public void test22RedWinsCVertically() {
		Line game = new Line(5, 5, 'C');
		game.playRedAt(3);
		game.playBlueAt(5);
		game.playRedAt(3);
		game.playBlueAt(2);
		game.playRedAt(3);
		game.playBlueAt(4);
		game.playRedAt(3);
		assertTrue(game.finished());
	}
	
	@Test public void test23RedWinsCDiagonallyUp() {
		Line game = new Line(6, 6, 'C');
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
		assertTrue(game.finished());
	}
	
	@Test public void test24RedWinsCDiagonallyDown() {
		Line game = new Line(6, 6, 'C');
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
		assertTrue(game.finished());
	}
	
	@Test public void test25BlueWinsCHorizontally() {
		Line game = new Line(5, 5, 'C');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(3);
		game.playRedAt(2);
		game.playBlueAt(4);
		game.playRedAt(2);
		game.playBlueAt(5);
		assertTrue(game.finished());
	}
	
	@Test public void test26BlueWinsCVertically() {
		Line game = new Line(5, 5, 'C');
		game.playRedAt(2);
		game.playBlueAt(1);
		game.playRedAt(4);
		game.playBlueAt(1);
		game.playRedAt(2);
		game.playBlueAt(1);
		game.playRedAt(3);
		game.playBlueAt(1);
		assertTrue(game.finished());
	}
	
	@Test public void test27BlueWinsCDiagonallyUp() {
		Line game = new Line(6, 6, 'C');
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
		assertTrue(game.finished());
	}
	
	@Test public void test28BlueWinsCDiagonallyDown() {
		Line game = new Line(6, 6, 'C');
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
		assertTrue(game.finished());
	}
	
	@Test public void test29CannotPlayWhenWonA() {
		Line game = new Line(5, 5, 'A');
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
		Line game = new Line(6, 6, 'B');
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
		Line game = new Line(5, 5, 'C');
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
		Line game = new Line(3, 3, 'A');
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
		Line game = new Line(3, 3, 'B');
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
		Line game = new Line(3, 3, 'C');
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

}
