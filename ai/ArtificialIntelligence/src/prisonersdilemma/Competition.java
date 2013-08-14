package prisonersdilemma;

public class Competition {
	Agent one, two;
	int oneScore = 0, twoScore = 0;
	int oneWin = 0, twoWin = 0, draws = 0;

	public static void main(String[] args) {
		Competition c = new Competition(new WinAgent(), new VariableAgent(0.7));
		c.iterate(10000,10000);
	}

	public Competition(Agent one, Agent two) {
		this.one = one;
		this.two = two;
	}
	
	public void iterate(int rounds,int times){
		for(int i = 0;i < times; i++){
			iterate(times);
			one.reset();
			two.reset();
		}
		System.out.println(oneWin + " Agent 1 - " + twoWin + " Agent 2 - " + draws + " Draws" );
	}

	public void iterate(int times) {
		for (int i = 0; i < times; i++) 
			iterate();
			if (oneScore < twoScore) {
				oneWin++;
				
			} else if(twoScore < oneScore){
				twoWin++;
				
			}else{
				draws++;
				
			}
			
			//System.out.println("One: "+ oneScore);
			//System.out.println("Two: " + twoScore);
			oneScore = 0;
			twoScore = 0;
	}

	public void iterate() {
		boolean oneCooperate = one.Cooperate();
		boolean twoCooperate = two.Cooperate();
		one.remember(twoCooperate);
		two.remember(oneCooperate);

		if (oneCooperate && twoCooperate) {
			oneScore += 1;
			twoScore += 1;
		}
		if (oneCooperate && !twoCooperate) {
			oneScore += 10;
			twoScore += 0;
		}
		if (!oneCooperate && twoCooperate) {
			oneScore += 0;
			twoScore += 10;
		}
		if (!oneCooperate && !twoCooperate) {
			oneScore += 5;
			twoScore += 5;
		}
	}
}
