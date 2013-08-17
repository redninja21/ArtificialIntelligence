package mancala;

import static org.junit.Assert.*;

import org.junit.Test;

public class MancalaBoardTest {

	@Test
	public void testBoard() {
		Mancala board = new Mancala();
		board.print();
	}
	
	@Test
	public void testMove(){
		Mancala board = new Mancala();
		board.makeMove(1);
	
		assertEquals(board.count(1,1),0);
		assertEquals(board.count(1,2),5);
		assertEquals(board.count(1,3),5);

	}

}
