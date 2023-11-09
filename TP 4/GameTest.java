package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
	

	
//	TENEMOS QUE HACER QUE NO SE PUEDA HACER UN BOARD DE MENOS DE 4X4 
	
//	 IMPORTANTEEEE
	
	
	
	
	@Test public void test00StartNewGameA() {
		Linea game = new Linea(6, 6, 'A');
		assertEquals(game.width, 6);
		assertEquals(game.height, 6);
		assertEquals(game.gametype, 'A');
	}
	
	@Test public void test01StartsNewGameB() {
		Linea game = new Linea(6, 6, 'B');
		assertEquals(game.width, 6);
		assertEquals(game.height, 6);
		assertEquals(game.gametype, 'B');
	}
	
	@Test public void test02StartsNewGameC() {
		Linea game = new Linea(6, 6, 'C');
		assertEquals(game.width, 6);
		assertEquals(game.height, 6);
		assertEquals(game.gametype, 'C');
	}
	
	@Test public void test05RedPlays() {
		Linea game = new Linea(6, 6, 'C');
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	@Test public void test06RedPlaysBluesTurn() {
		Linea game = new Linea(6, 6, 'C');
		game.playRedAt(1);
		assertTrue(game.bluePlays());
		assertFalse(game.redPlays());
	}
	
	@Test public void test07RedAndBluePlay() {
		Linea game = new Linea(6, 6, 'C');
		game.playRedAt(1);	
		game.playBlueAt(2);
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
	@Test public void test08RedCannotPlayOutsideOutOfBoundsWidth() {
		Linea game = new Linea(6, 6, 'C');
		try{
			game.playRedAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test09BlueCannotPlayOutsideOutOfBoundsWidth() {
		Linea game = new Linea(6, 6, 'C');
		game.playRedAt(1);
		try{
			game.playBlueAt(7);
		}catch(Error e){
			assertTrue(e.getMessage().equals("Cannot play out of bounds"));
		}
	}
	
	@Test public void test10RedCannotPlayOutsideOutOfBoundsHeight() {
		Linea game = new Linea(4, 4, 'A');
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
	
	@Test public void test11BlueCannotPlayOutsideOutOfBoundsHeight() {
		Linea game = new Linea(4, 4, 'A');
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
	
	@Test public void test12RedCannotPlayTwice() {
		Linea game = new Linea(4, 4, 'A');
		game.playRedAt(1);
		try {
			game.playRedAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Red cannot play twice"));
		}
	}
	
	@Test public void test13BlueCannotPlayTwice() {
		Linea game = new Linea(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		try {
			game.playBlueAt(2);
		}catch(Error e) {
			assertTrue(e.getMessage().equals("Blue cannot play twice"));
		}
	}
	
//	@Test public void test10RedWinsAHorizontally() {
//	
//	}
	
	@Test public void test10RedWinsAVertically() {
		Linea game = new Linea(4, 4, 'A');
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		game.playBlueAt(2);
		game.playRedAt(1);
		assertTrue(game.finished());
	}
	
//	@Test public void test11BlueWinsAHorizontally() {
//		
//	}
	
	@Test public void test11BlueWinsAVertically() {
		Linea game = new Linea(5, 5, 'A');
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
	
//	@Test public void test12RedWinsBToTheRight() {
//		
//	}
//	
//	@Test public void test12RedWinsBToTheLeft() {
//		
//	}
//	
//	@Test public void test13BlueWinsBToTheRight() {
//		
//	}
//	
//	@Test public void test13BlueWinsBToTheLeft() {
//		
//	}
//	
//	@Test public void test14RedWinsCHorizontally() {
//		
//	}
//	
//	@Test public void test14RedWinsCVertically() {
//		
//	}
//	
//	@Test public void test14RedWinsCToTheRight() {
//		
//	}
//	
//	@Test public void test14RedWinsCToTheLeft() {
//		
//	}
//	
//	@Test public void test15BlueWinsCHorizontally() {
//		
//	}
//	
//	@Test public void test15BlueWinsCVertically() {
//		
//	}
//	
//	@Test public void test15BlueWinsCToTheRight() {
//		
//	}
//	
//	@Test public void test15BlueWinsCToTheLeft() {
//		
//	}
//	
//	@Test public void test10CannotPlayWhenWonA() {
//		
//	}
	
//	@Test public void test09CannotPlayWhenWonB() {
//		
//	}
//
//	@Test public void test10CannotPlayWhenWonC() {
//	
//	}
//	
//	@Test public void test11CannotPlayAfterDrawA() {
//		
//	}
//	
//	@Test public void test12CannotPlayAfterDrawB() {
//		
//	}
//
//	@Test public void test13CannotPlayAfterDrawC() {
//	
//	}
//	
//	
//
}

// hay q si o si seguir la interfaz





