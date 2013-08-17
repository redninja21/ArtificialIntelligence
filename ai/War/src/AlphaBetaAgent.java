

public class AlphaBetaAgent implements Agent {

	int depth;
	int me;
	Board board;
	int count = 0;
	
	public AlphaBetaAgent(int depth){
		this.depth = depth;
	}
	
	public Move max(Board board, int depth, Move alpha, Move beta){
		
		count++;
			if(depth == 0 )
			return new Move(board.getScoreAdvantage(me));
			Move[] moves = board.getLegalMoves();
			if(moves.length == 0)
				return new Move(board.getScoreAdvantage(me));
			Move best = new Move(alpha);
			for(Move move: moves){
				 Move next = min(move.move(board), depth - 1, best, beta);
				 board.unmove(1);
				 move.setValue(next.getValue());
				 if(move.getValue()>best.getValue())
					 best = move;
			}
			return best;
	}
	
	public Move min(Board board, int depth, Move alpha, Move beta){
		count++;
		if(depth == 0 )
		return new Move(board.getScoreAdvantage(me));
		Move[] moves = board.getLegalMoves();
		if(moves.length == 0)
			return new Move(board.getScoreAdvantage(me));
		Move best = new Move(beta);
		for(Move move: moves){
			 Move next = max(move.move(board), depth - 1, best, alpha);
			 board.unmove(1);
			 move.setValue(next.getValue());
			 if(move.getValue()<best.getValue())
				 best = move;
		}
		return best;
	}
	@Override
	public Move getMove() {
		count = 0;
		Move m = max(board, depth, new Move(Integer.MIN_VALUE), new Move(Integer.MAX_VALUE));
		count = 0;
		long time = System.currentTimeMillis();
		System.out.println("Game tree had " + count + " nodes.");
		System.out.println(System.currentTimeMillis() - time + " ms.");
		return m;
	}

	@Override
	public void setID(int id) {
		me = id;
	}

	@Override
	public int getID() {

		return me;
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public int getScore() {
		return board.getScore(me);
	}

	@Override
	public String getName() {

		return "Minimax Agent";
	}

	@Override
	public String getProperty() {

		return "depth " + depth;
	}

}
