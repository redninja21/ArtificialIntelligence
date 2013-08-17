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
		//Setup the loop
		int count = pocket[(player) ? p : p + 7];
		pocket[(player)? p : p+ 7] = 0;
		int next = (player) ? p + 1 : p + 8;
		// For each piece in the pocket
		for(int i = 0; i < count; i++){
			// Check for wrap around
			if(next>13) next = (player) ? 1 : 0;
			if(!player && next == 7)next++;
			//Increment the pocket
			pocket[next]++;
			//Increment next
			next++;
		}
	return (next - 1 == 7 || next - 1 == 0);
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
