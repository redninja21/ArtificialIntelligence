package mancala;

public class Mancala {
	// Stores representation of mancala board
	int[] pocket = new int[14];
	boolean player = true; // Player 1 = true, Player 2 = false
	private static final int SIZE = 4;

	public Mancala() {
		pocket = new int[14];// Number of pockets
		reset();
	}

	public boolean playing(int pNum) {
		if (pNum == 1 && player) {
			return true;
		}
		if (pNum == 2 && !player) {
			return true;
		}
		return false;
	}

	public void reset() {
		pocket[0] = 0;
		pocket[7] = 0;
		for (int i = 1; i <= 6; i++) {
			pocket[i] = SIZE;
		}
		for (int i = 8; i <= 13; i++) {
			pocket[i] = SIZE;
		}
	}

	public boolean makeMove(Move m){
		return makeMove(m.pocket);
	}
	
	public int evaluate(int p){
		if(p ==1){
			if(pocket[7] > 6 * SIZE)
				return Integer.MAX_VALUE;
			if(pocket[0] > 6* SIZE)
				return Integer.MIN_VALUE;
			return pocket[7] - pocket[0];
		}
		else{
			if(pocket[0] > 6 * SIZE)
				return Integer.MAX_VALUE;
			if(pocket[7] > 6* SIZE)
				return Integer.MIN_VALUE;
			return pocket [0] - pocket [7];
		}
		
	}
	
	
	
	public boolean makeMove(int p) {
		int movesLeft = 0;
		int p2 = p + 7;
		int current = 0;
		int i = 0;
		if (player) {// placeholder
			movesLeft = pocket[p];
			pocket[p] = 0;
			
			for (i = 1; movesLeft > 0; movesLeft--, i++) {
				if (current >= 14) {
					pocket[current] = 1;
					pocket[current]++;
				} else {
					movesLeft = pocket[p + 7];
					pocket[p + 7] = 0;
				}
				pocket[current]++;
			}
		}
		for (int a = 1; movesLeft > 0; movesLeft--, a++) {
			if (p + a >= 14) {
				pocket[p + a - 13]++;
				pocket[p + a]++;
			} else {
				movesLeft = pocket[p2];
				pocket[p2] = 0;
			}
				for (int b = 1; movesLeft > 0; movesLeft--, b--) {
					if (p2 + b >= 14) {
						if (p2 + b == 21) {
							movesLeft++;
						} else
							pocket[p2 + b - 14]++;
					} else
						pocket[p2 + b]++;
				}

				
			}
	if (player && (current == 7 || current == 20)) 
			return true;
		
	return false;
	}

	public Mancala(Mancala other) {
		this.player = other.player;
		for (int i = 0; i < 14; i++) {
			this.pocket[i] = other.pocket[i];
		}
	}

	public Move[] getMoves() {
		int count = 0;
		Move[] moves = new Move[count];
		if (player) {
			for (int i = 0; i <= 6; i++) {
				if (pocket[i] > 0) {
					count++;
				}
			}
		} else {
			for (int i = 8; i <= 13; i++) {
				if (pocket[i] > 0) {
					count++;
				}
			}

			int index = 0;
			if (player) {
				for (int i = 0; i <= 6; i++) {
					if (pocket[i] > 0) {
						moves[index] = new Move (i);
						index++;
					}
				}
			} else {
				for (int i = 8; i <= 13; i++) {
					if (pocket[i] > 0) {
						moves[index] = new Move (i - 7);
						index++;
					}
				}
			}
		}
		return moves;
	}

	public void print() {
		System.out.println("_________________________");
		System.out.print("|  |");
		for (int i = 13; i >= 8; i--) {
			if (pocket[i] < 10)
				System.out.print(" ");
			System.out.print(pocket[i] + "|");
		}
		System.out.println("  |");
		System.out.print("|");
		if (pocket[0] < 10)
			System.out.print(" ");
		System.out.print(pocket[0] + "|");
		for (int i = 0; i < 17; i++) {
			System.out.print("-");
		}
		System.out.print("|");
		if (pocket[7] < 10)
			System.out.print(" ");
		System.out.println(pocket[7] + "|");
		System.out.print("|  |");
		for (int i = 1; i <= 6; i++) {
			if (pocket[i] < 10)
				System.out.print(" ");
			System.out.print(pocket[i] + "|");
		}
		System.out.println("  |");
		System.out.println("_________________________");
	}

	public void switchPlayer() {
		player = !player;
	}

	public int count(int p, int index) {
		if (p == 1)
			return pocket[p];
		else
			return pocket[p + 7];
	}
}
