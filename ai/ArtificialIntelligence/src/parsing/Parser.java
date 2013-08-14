package parsing;

public class Parser {

	Lexer lexer;
	
	public Parser(){
		lexer  = new Lexer();
	}
	
	public Sentence parse(String input){
		lexer.lex(input);
		return parseSentence();
	}
	
	public Sentence parseSentence(){
		Subject subject = parseSubject();
		Verb verb = parseVerb();
		Predicate predicate = parsePredicate();
	}
	public Noun parseNoun(){
		String noun = English.get().getNoun(lexer.peekNext());
		if(noun != null){
			System.out.println("Noun[" + lexer.getNext() + "]");
		}
	}
	
	public Verb parseVerb(){
		
	}
	
	public Predicate parsePredicate(){
		
	}
	
	public Subject parseSubject(){
		String subject = English.get().getSubject(lexer.peekNext() );
		if(subject != null){
			System.out.println("Subject[" + lexer.getNext() + "] ");
		}
		return null;
	}
	
}
