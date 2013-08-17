package mancala;

import java.util.Scanner;

public class MancalaTest {
	public static void main(String[] args) {
		Mancala board = new Mancala();
		Scanner keyboard = new Scanner(System.in);
		MiniMaxAgent agent = new MiniMaxAgent(1, 1);
		for (int i = 0; i < 6; i++) {
			board.print();
			board.makeMove(agent.getMove(board));
			board.print();
			board.switchPlayer();
			System.out.println("Enter a pocket: ");
			int pocket = keyboard.nextInt();
			board.makeMove(pocket);
		}
	}
}
