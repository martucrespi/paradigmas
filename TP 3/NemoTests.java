package Nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTests {

	private char Down = 'd';
	private char Up = 'u';
	private char Left = 'l';
	private char Right = 'r';
	private char Forward = 'f';
	private char Capsule = 'm';
	private String North = "N";
	private String South = "S";
	private String East = "E";
	private String West = "W";
	
	@Test public void test00InitialPosition() {
		Nemo nemo = newNemo();
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
	}
	@Test public void test01InitialDepth() {
		Nemo nemo = newNemo();
		checkDepth(nemo, 0);
	 }
	@Test public void test02InitialDirection() {
		Nemo nemo = newNemo();
		checkDirection(nemo, North);
	 }
	@Test public void test03NemoDoesntMoveWhenEmptyInstructions() {
		Nemo nemo = newNemo();
		newStringMove(nemo, "");
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
		checkDepth(nemo, 0);
		checkDirection(nemo, North);
	 }
	@Test public void test04NemoMovesDown() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Down);
		checkDepth(nemo, -1);
	 }
	@Test public void test05NemoMovesUp() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Down);
		newCharMove(nemo, Down);
		checkDepth(nemo, -2);
		newCharMove(nemo, Up);
		checkDepth(nemo, -1);
	 }
	@Test public void test06NemoTurnsRight() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Right);
		checkDirection(nemo, East);
	 }
	@Test public void test07NemoTurnsLeft() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Left);
		checkDirection(nemo, West);
	 }
	@Test public void test08NemoMakesFullTurnRight() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Right);
		checkDirection(nemo, East);
		newCharMove(nemo, Right);
		checkDirection(nemo, South);
		newCharMove(nemo, Right);
		checkDirection(nemo, West);
		newCharMove(nemo, Right);
		checkDirection(nemo, North);
	 }
	@Test public void test09NemoMakesFullTurnLeft() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Left);
		checkDirection(nemo, West);
		newCharMove(nemo, Left);
		checkDirection(nemo, South);
		newCharMove(nemo, Left);
		checkDirection(nemo, East);
		newCharMove(nemo, Left);
		checkDirection(nemo, North);
	 }
	@Test public void test10NemoMovesForward() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Forward);
		checkCoordY(nemo, 1);
		newCharMove(nemo, Right);
		newCharMove(nemo, Forward);
		checkCoordX(nemo, 1);
		newCharMove(nemo, Right);
		newCharMove(nemo, Forward);
		checkCoordY(nemo, 0);
		newCharMove(nemo, Right);
		newCharMove(nemo, Forward);
		checkCoordX(nemo, 0);
	}	
	@Test public void test11NemoGoesAboveLevel0() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Up);
		newCharMove(nemo, Up);
		newCharMove(nemo, Up);
		checkDepth(nemo, 0);
	}
	@Test public void test12NemoReleasesCapsuleLevel0() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Capsule);
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
		checkDepth(nemo, 0);
		checkDirection(nemo, North);
	}
	@Test public void test13NemoReleasesCapsuleUnderwater() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Down);
		newCharMove(nemo, Capsule);
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
		checkDepth(nemo, -1);
		checkDirection(nemo, North);
	}
	@Test public void test14NemoReleasesCapsuleTwoLevelsUnderwater() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Down);
		newCharMove(nemo, Down);
		assertThrowsLike(() -> newCharMove(nemo, Capsule), CMCapsule.nemoHasBeenDestroyed);
	}
	@Test public void test15NemoReceivesAString() {
		Nemo nemo = newNemo();
		newStringMove(nemo, "dfdrf");
		checkCoordX(nemo, 1);
		checkCoordY(nemo, 1);
		checkDepth(nemo, -2);
		checkDirection(nemo, East);
	}
	@Test public void test16NemoReceivesDifferentXYCoordinates() {
		Nemo nemo = newNemoWithCoords(5, 2, 0, North);
		checkCoordX(nemo, 5);
		checkCoordY(nemo, 2);
		checkDepth(nemo, 0);
		checkDirection(nemo, North);
	}
	@Test public void test17NemoReceivesDifferentDepth() {
		Nemo nemo = newNemoWithCoords(0, 0, -3, North);
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
		checkDepth(nemo, -3);
		checkDirection(nemo, North);
	}
	@Test public void test18NemoReceivesDifferentDirection() {
		Nemo nemo = newNemoWithCoords(0, 0, 0, West);
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
		checkDepth(nemo, 0);
		checkDirection(nemo, West);
	}
	@Test public void test19NemoMovesStartingInDifferentCoordinates() {
		Nemo nemo = newNemoWithCoords(5, 2, -3, West);
		newCharMove(nemo, Up);
		newCharMove(nemo, Left);
		newCharMove(nemo, Up);
		newCharMove(nemo, Capsule);
		checkCoordX(nemo, 5);
		checkCoordY(nemo, 2);
		checkDepth(nemo, -1);
		checkDirection(nemo, South);
	}
	@Test public void test20NemoStartsInDifferentCoordsEndsDestroyed() {
		Nemo nemo = newNemoWithCoords(5, 2, -3, West);
		newCharMove(nemo, Up);
		newCharMove(nemo, Left);
		assertThrowsLike(() -> newCharMove(nemo, Capsule), CMCapsule.nemoHasBeenDestroyed);
		newCharMove(nemo, Up);
		assertFalse(nemo.depth() == -2);
	}
	@Test public void test21NemoMovesStartingInDifferentCoordinatesString() {
		Nemo nemo = newNemoWithCoords(10, 3, -3, East);
		newStringMove(nemo, "ulum");
		checkCoordX(nemo, 10);
		checkCoordY(nemo, 3);
		checkDepth(nemo, -1);
		checkDirection(nemo, North);
	}
	@Test public void test22NemoMovesStartingInDifferentCoordsStringEndsDestroyed() {
		Nemo nemo = newNemoWithCoords(5, 2, -3, West);
		newStringMove(nemo, "ulffrumddll");
		assertThrowsLike(() -> newCharMove(nemo, Capsule), CMCapsule.nemoHasBeenDestroyed);
	}
	@Test public void test23NemoMovesInASquare() {
		Nemo nemo = newNemo();
		newStringMove(nemo, "flflflfl");
		checkCoordX(nemo, 0);
		checkCoordY(nemo, 0);
		checkDepth(nemo, 0);
		checkDirection(nemo, North);
	}
	@Test public void test24NemoMovesMixingStringAndChar() {
		Nemo nemo = newNemo();
		newCharMove(nemo, Down);
		newCharMove(nemo, Left);
		newCharMove(nemo, Forward);
		newStringMove(nemo, "mllfffuurfrrfffddumr");
		checkCoordX(nemo, 2);
		checkCoordY(nemo, 2);
		checkDepth(nemo, -1);
		checkDirection(nemo, East);
	}
	private Nemo newNemo() {
		Nemo nemo = new Nemo();
		return nemo;
	}
	private Nemo newNemoWithCoords(int x, int y, int depth, String direction) {
		Nemo nemo = new Nemo(x, y, depth, direction);
		return nemo;
	}
	private void newCharMove(Nemo nemo, char move) {
		nemo.move(move);
	}
	private void newStringMove(Nemo nemo, String move) {
		nemo.move(move);
	}
	private void checkCoordX(Nemo nemo, int coord) {
		assertEquals( nemo.x(), coord);
	}
	private void checkCoordY(Nemo nemo, int coord) {
		assertEquals( nemo.y(), coord);
	}
	private void checkDepth(Nemo nemo, int depth) {
		assertEquals(nemo.depth(), depth);
	}
	private void checkDirection(Nemo nemo, String direction) {
		assertEquals( nemo.direc(), direction);
	}
	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message, 
				assertThrows(Error.class, executable).getMessage());
	}
}



