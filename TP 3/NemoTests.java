 @Test public void test00InitialPosition() {
	Nemo nemo = new Nemo();
	assertEquals( nemo.x(), 0);
	assertEquals( nemo.y(), 0);
 }
 @Test public void test01InitialDepth() {
	Nemo nemo = new Nemo();
	assertEquals(nemo.profundidad(), 0);
 }
 @Test public void test02InitialDirection() {
	Nemo nemo = new Nemo();
	assertEquals( nemo.direc(), "N");
 }
 @Test public void test03NemoDoesntMoveWhenEmptyInstructions() {
	Nemo nemo = new Nemo();
	nemo.moverVacio("");
	assertEquals( nemo.x(), 0);
	assertEquals( nemo.y(), 0);
	assertEquals(nemo.profundidad(), 0);
	assertEquals( nemo.direc(), "N");
 }
 @Test public void test04NemoMovesDown() {
	Nemo nemo = new Nemo();
	nemo.mover('d');
	assertEquals(nemo.profundidad(), -1);
 }
 @Test public void test05NemoMovesUp() {
	Nemo nemo = new Nemo();
	nemo.mover('u');
	assertEquals(nemo.profundidad(), 1);
 }
 @Test public void test06NemoTurnsRight() {
	Nemo nemo = new Nemo();
	nemo.mover('r');
	assertEquals( nemo.direc(), "E");
	}
 @Test public void test07NemoTurnsLeft() {
	Nemo nemo = new Nemo();
	nemo.mover('l');
	assertEquals( nemo.direc(), "O");
 }
 @Test public void test08NemoMakesFullTurnRight() {
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
 @Test public void test09NemoMakesFullTurnLeft() {
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
 @Test public void test10NemoMovesForward() {
	Nemo nemo = new Nemo();
	nemo.mover('f');
	assertEquals(nemo.y(), 1);
	nemo.mover('r');
	nemo.mover('f');
	assertEquals(nemo.x(), 1);
	nemo.mover('r');
	nemo.mover('f');
	assertEquals(nemo.y(), 0);
	nemo.mover('r');
	nemo.mover('f');
	assertEquals(nemo.x(), 0);
}
