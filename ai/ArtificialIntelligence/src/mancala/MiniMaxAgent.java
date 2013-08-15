package mancala;

public class MiniMaxAgent implements Agent {
	int depth;
	int me;

	public MiniMaxAgent(int depth, int me) {
		this.me = me;
		this.depth = depth;
	}

	public Move getMove(Mancala board) {

		return max(board, depth);
	}

	public Move max(Mancala board, int depth) {
		//TODO: check if there are no available moves
		Move[] moves = board.getMoves();
	if(depth == 0 || moves.length == 0){
		Move foo = new Move(0);
		foo.value = board.evaluate(me);
		return foo;
	}
	
		for (Move move : moves) {
			Mancala b = new Mancala(board);
			if (b.makeMove(move)) {
				Move continuation = max(b, depth);
				move.value = continuation.value;
			} else {
				int value = b.evaluate(me);
				if (value == Integer.MAX_VALUE || value == Integer.MIN_VALUE)
					move.value = value;
				else {
					b.switchPlayer();
					Move next = min(b, depth - 1);
					move.value = next.value;
				}
			}
		}
		
		Move best = new Move(0);
		int value = best.value;
		for(Move move: moves){
			if(move.value > value){
				best = move;
				value = move.value;
			}
		}
		return best;
	}

	public Move min(Mancala board, int depth) {
		Move[] moves = board.getMoves();
		if(depth == 0 || moves.length == 0){
			Move foo = new Move(0);
			foo.value = board.evaluate(me);
			return foo;
		}
		
			for (Move move : moves) {
				Mancala b = new Mancala(board);
				if (b.makeMove(move)) {
					Move continuation = min(b, depth);
					move.value = continuation.value;
				} else {
					int value = b.evaluate(me);
					if (value == Integer.MAX_VALUE || value == Integer.MIN_VALUE)
						move.value = value;
					else {
						Move next = max(b, depth - 1);
						move.value = next.value;
					}
				}
			}
			
			Move best = moves[0];
			int value = best.value;
			for(Move move: moves){
				if(move.value < value){
					best = move;
					value = move.value;
				}
			}
			return best;
	}
}
