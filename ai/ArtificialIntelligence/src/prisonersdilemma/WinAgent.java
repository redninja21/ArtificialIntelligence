package prisonersdilemma;

public class WinAgent implements Agent {

	int otherCooperates = 0;
	int otherCompetes = 0;
	boolean shouldCooperate = false;

	public boolean Cooperate() {
		
		return shouldCooperate;
	}
	
	public void remember(boolean otherPlayerDecision) {
			shouldCooperate = otherPlayerDecision;
	}


	@Override
	public void reset() {
		shouldCooperate = false;
	}

}
