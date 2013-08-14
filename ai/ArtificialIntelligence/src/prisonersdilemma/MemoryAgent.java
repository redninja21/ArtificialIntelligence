package prisonersdilemma;

public class MemoryAgent implements Agent {

	int otherCooperates = 0;
	int otherCompetes = 0;
	

	public boolean Cooperate() {
		if(otherCooperates > otherCompetes){
			return true;
		}
				return false;
	}

	
	public void remember(boolean otherPlayerDecision) {
			if(otherPlayerDecision){
				otherCooperates++;
			}
			else{
				otherCompetes++;
			}
	}


	@Override
	public void reset() {
		otherCompetes = 0;
		otherCooperates = 0;
	}

}
