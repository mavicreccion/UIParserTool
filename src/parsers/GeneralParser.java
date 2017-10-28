package parsers;

import java.util.ArrayList;

import model.ParsedElement;

public abstract class GeneralParser {
	
	protected ArrayList<ParsedElement> parsedElements;
	protected String stringToParse;
	
	public GeneralParser(String stringToParse) {
		this.parsedElements = new ArrayList<>();
		this.stringToParse = stringToParse;
	}
	
	public ArrayList<ParsedElement> getParsedElements() {
		return this.parsedElements;
	}
	
	public abstract void parse();
	

}
