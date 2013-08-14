public class MiniMaxPlayer implements TicTacToePlayer {
	private char me;

	public Move getMove(TicTacToeGame game) {
		me = game.getCurrentPlayer();
		if(game.isDraw()||game.hasWinner()){
			return null;
		}
		return max(game);

	}

	private Move max(TicTacToeGame game) {

		Move[] moves = getAllMoves(game);

		for (int i = 0; i < moves.length; i++) {
			TicTacToeGame g = new TicTacToeGame(game);
			g.makeMove(moves[i]);
			if (g.getGameWinner() == me) {
				moves[i].utility = 1;
			} else if (g.isDraw()) {
				moves[i].utility = 0;
			} else if (g.hasWinner() && g.getGameWinner() != me) {
				moves[i].utility = -1;
			} else {
				Move m = min(g);
				moves[i].utility = m.utility;
			}
		}
		Move best = moves[0];
		int max = -1;
		for(int i = 0; i < moves.length; i ++){
			if(moves[i].utility > max){
				best = moves[i];
				max = moves[i].utility;
				
			}
		}
		return best;
	}

	private Move min(TicTacToeGame game) {

		Move[] moves = getAllMoves(game);

		for (int i = 0; i < moves.length; i++) {
			TicTacToeGame g = new TicTacToeGame(game);
			g.makeMove(moves[i]);
			if (g.getGameWinner() == me) {
				moves[i].utility = 1;
			} else if (g.isDraw()) {
				moves[i].utility = 0;
			} else if (g.hasWinner() && g.getGameWinner() != me) {
				moves[i].utility = -1;
			} else {
				Move m = max(g);
				moves[i].utility = m.utility;
			}
		}
		Move best = moves[0];
		int min = 11;
		for(int i = 0; i < moves.length; i ++){
			if(moves[i].utility < min){
				best = moves[i];
				min = moves[i].utility;
				
			}
		}
		return best;
	}

	private Move[] getAllMoves(TicTacToeGame game) {
		int moveCount = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (game.canPlacePieceAt(x, y))
					moveCount++;
			}
		}
		Move[] moves = new Move[moveCount];
		int index = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (game.canPlacePieceAt(x, y)) {
					moves[index] = new Move(x, y);
					index++;
				}
			}
		}
		return moves;
	}
}
