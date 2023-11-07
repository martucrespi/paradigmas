package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class GameTest {
	
	@Test public void test00StartNewGameA() {
		Linea game = new Linea(6, 6, 'A');
		assertEquals(game.width, 6);
		assertEquals(game.height, 6);
		assertEquals(game.gameType, 'A');
	}
	
	@Test public void test01StartsNewGameB() {
		Linea game = new Linea(6, 6, 'B');
		assertEquals(game.width, 6);
		assertEquals(game.height, 6);
		assertEquals(game.gameType, 'B');
	}
	
	@Test public void test02StartsNewGameC() {
		Linea game = new Linea(6, 6, 'C');
		assertEquals(game.width, 6);
		assertEquals(game.height, 6);
		assertEquals(game.gameType, 'C');
	}
	
	@Test public void test03RedPlays() {
		Linea game = new Linea(6, 6, 'C');
		assertTrue(game.redPlays());
		assertFalse(game.bluePlays());
	}
	
//	@Test public void test04RedAndBluePlay() {
//		
//	}
//	
//	@Test public void test05NoPlayingOutsideOutOfBoundsWidth() {
//		
//	}
//	
//	@Test public void test06NoPlayingOutsideOutOfBoundsHeight() {
//		
//	}
//	
//	@Test public void test07CannotPlayWhenWonA() {
//		
//	}
//	
//	@Test public void test08CannotPlayWhenWonB() {
//		
//	}
//
//	@Test public void test09CannotPlayWhenWonC() {
//	
//	}
//	
//	@Test public void test10CannotPlayAfterDrawA() {
//		
//	}
//	
//	@Test public void test11CannotPlayAfterDrawB() {
//		
//	}
//
//	@Test public void test12CannotPlayAfterDrawC() {
//	
//	}
//	
//	@Test public void test13RedCannotPlayTwice() {
//		
//	}
//	
//	@Test public void test14BlueCannotPlayTwice() {
//		
//	}
//	
//	
//
}

// si o si el codigo pregunta que jugada queres hacer o si por ejemplo podes hacerlo llamando a una funcion jugar?
// hay q si o si seguir la interfaz





