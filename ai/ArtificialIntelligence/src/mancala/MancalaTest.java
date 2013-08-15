package mancala;

public class MancalaTest {
	public static void main(String[] args){
		Mancala board = new Mancala();
		MiniMaxAgent agent = new MiniMaxAgent(5,1);
		board.print();
		board.makeMove(agent.getMove(board));
		board.print();
	}
}
