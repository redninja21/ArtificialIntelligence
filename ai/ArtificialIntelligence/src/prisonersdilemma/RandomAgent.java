package prisonersdilemma;

public class RandomAgent implements Agent{
	public boolean Cooperate() {
		if(Math.random() <0.5){
			return true;
		}
		return false;
	}

	public void remember(boolean otherPlayerDecision) {
				
	}

	@Override
	public void reset() {
		
		
	}

}
