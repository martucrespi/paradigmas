package linea0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest0 {
		
	
	@Test public void test01StartNewGameA() {
		Linea0 game = new Linea0(6, 6, 'A');
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
		assertEquals(game.gametype, 'A');
	}
	
	@Test public void test02StartsNewGameB() {
		Linea0 game = new Linea0(6, 6, 'B');
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
		assertEquals(game.gametype, 'B');
	}
	
	@Test public void test03StartsNewGameC() {
		Linea0 game = new Linea0(6, 6, 'C');
		assertEquals(game.columns, 6);
		assertEquals(game.rows, 6);
		assertEquals(game.gametype, 'C');
	}
	
	@Test public void test04RedPlays() {
		Linea0 game = new Linea0(6, 6, 'C');
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	@Test public void test05RedPlaysBluesTurn() {
		Linea0 game = new Linea0(6, 6, 'C');
		game.playRedAt(1);
		assertTrue(game.bluePlays());
		assertFalse(game.redPlays());
	}
	
	@Test public void test06RedAndBluePlay() {
		Linea0 game = new Linea0(6, 6, 'C');
		game.playRedAt(1);	
		game.playBlueAt(2);
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	@Test public void test07RedCannotPlayOutsideOutOfBoundsWidth() {
		Linea0 game = new Linea0(6, 6, 'C');
		try{
			game.playRedAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test08BlueCannotPlayOutsideOutOfBoundsWidth() {
		Linea0 game = new Linea0(6, 6, 'C');
		game.playRedAt(1);
		try{
			game.playBlueAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test09RedCannotPlayOutsideOutOfBoundsHeight() {
		Linea0 game = new Linea0(4, 4, 'A');
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
		Linea0 game = new Linea0(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(2);
		game.playBlueAt(2);
		game.playRedAt(2);
		try {
			game.playBlueAt(5);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test11RedCannotPlayTwice() {
		Linea0 game = new Linea0(4, 4, 'A');
		game.playRedAt(1);
		try {
			game.playRedAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Red cannot play twice"));
		}
	}
	
	@Test public void test12BlueCannotPlayTwice() {
		Linea0 game = new Linea0(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Blue cannot play twice"));
		}
	}
	
	@Test public void test13RedWinsAHorizontally() {
		Linea0 game = new Linea0(5, 5, 'A');
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
		Linea0 game = new Linea0(4, 4, 'A');
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
		Linea0 game = new Linea0(5, 5, 'A');
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
		Linea0 game = new Linea0(5, 5, 'A');
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
		Linea0 game = new Linea0(5, 5, 'B');
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
	
//	@Test public void test18RedWinsBDiagonallyDown() {
//		
//	}
//	
//	@Test public void test19BlueWinsBToTheRight() {
//		
//	}
//	
//	@Test public void test20BlueWinsBToTheLeft() {
//		
//	}

	@Test public void test21RedWinsCHorizontally() {
		Linea0 game = new Linea0(5, 5, 'C');
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
		Linea0 game = new Linea0(5, 5, 'C');
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
		Linea0 game = new Linea0(6, 6, 'B');
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
	
//	@Test public void test24RedWinsCToTheLeft() {
//		
//	}
	
	@Test public void test25BlueWinsCHorizontally() {
		Linea0 game = new Linea0(5, 5, 'C');
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
		Linea0 game = new Linea0(5, 5, 'C');
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
	
//	@Test public void test27BlueWinsCToTheRight() {
//		
//	}
//	
//	@Test public void test28BlueWinsCToTheLeft() {
//		
//	}
//	
//	@Test public void test29CannotPlayWhenWonA() {
//		
//	}
	
//	@Test public void test30CannotPlayWhenWonB() {
//		
//	}
//
//	@Test public void test31CannotPlayWhenWonC() {
//	
//	}
//	
//	@Test public void test32CannotPlayAfterDrawA() {
//		
//	}
//	
//	@Test public void test33CannotPlayAfterDrawB() {
//		
//	}
//
//	@Test public void test34CannotPlayAfterDrawC() {
//	
//	}
//	
//	
//
}





