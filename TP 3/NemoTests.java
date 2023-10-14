package Nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NemoTests {

	@Test public void test00InitialPosition() {
		Nemo nemo = new Nemo();
		assertEquals( nemo.x(), 0);
		assertEquals( nemo.y(), 0);
		assertEquals(nemo.profundidad(), 0);
		assertEquals( nemo.direc(), "N");
	}
	
	@Test public void test01NemoDoesntMoveWhenEmptyInstructions() {
		Nemo nemo = new Nemo();
		nemo.moverVacio("");
		assertEquals( nemo.x(), 0);
		assertEquals( nemo.y(), 0);
		assertEquals(nemo.profundidad(), 0);
		assertEquals( nemo.direc(), "N");
	}
	
	@Test public void test02NemoMovesDown() {
		Nemo nemo = new Nemo();
		nemo.mover('d');
		assertEquals(nemo.profundidad(), -1);
	}
	
	@Test public void test03NemoMovesUp() {
		Nemo nemo = new Nemo();
		nemo.mover('u');
		assertEquals(nemo.profundidad(), 1);
	}
	

	@Test public void test04NemoTurnsRight() {
		Nemo nemo = new Nemo();
		nemo.mover('r');
		assertEquals( nemo.direc(), "E");
	}
	
	@Test public void test05NemoTurnsLeft() {
		Nemo nemo = new Nemo();
		nemo.mover('l');
		assertEquals( nemo.direc(), "O");
	}
	
	@Test public void test06NemoMakesFullTurnRight() {
		Nemo nemo = new Nemo();
		nemo.mover('r');
		assertEquals( nemo.direc(), "E");
		nemo.mover('r');
		assertEquals( nemo.direc(), "S");
		nemo.mover('r');
		assertEquals( nemo.direc(), "O");
		nemo.mover('r');
		assertEquals( nemo.direc(), "N");
	}
	
	@Test public void test06NemoMakesFullTurnLeft() {
		Nemo nemo = new Nemo();
		nemo.mover('l');
		assertEquals( nemo.direc(), "O");
		nemo.mover('l');
		assertEquals( nemo.direc(), "S");
		nemo.mover('l');
		assertEquals( nemo.direc(), "E");
		nemo.mover('l');
		assertEquals( nemo.direc(), "N");
	}
	
	

	
}
	
	