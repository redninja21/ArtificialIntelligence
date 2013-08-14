
public class ELIZA {
	
	public static void main(String[]args){
		ELIZA eliza = new ELIZA();
		String answer = eliza.ask("I'm not feeling well today.");
		System.out.println(answer);
	}
	
	public String ask(String question){
		if(question.matches("I'm not feeling ((\\w|\\s)+)+.*")){
		return	question.replaceAll("I'm not feeling ((\\w|\\s)+)+.*", "Why are you not feeling $1 ?");
		}
		
		return "Sorry, I don't know.";
	}
	
}
