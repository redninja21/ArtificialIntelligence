package prisonersdilemma;

public interface Agent {
	public boolean Cooperate();
	
	public void remember(boolean otherPlayerDecision);
	
	public void reset();
}
