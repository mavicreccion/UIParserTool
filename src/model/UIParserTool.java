package model;

import java.util.ArrayList;

import data_readers.DataReader;
import data_readers.FileReader;
import parsers.GeneralParser;
import parsers.MyJSONParser;

public class UIParserTool {
	
	private String fileAsString;
	
	public void readFile(String filename) {
		DataReader reader = new FileReader(filename);
		reader.read();
		
		this.fileAsString = reader.getOutputString();
	}
	
	public void JSONparse() {
		GeneralParser parser = new MyJSONParser(this.fileAsString);
		parser.parse();
		
		ArrayList<ParsedElement> elements = parser.getParsedElements();
		for(int i = 0; i < elements.size(); i ++) {
			System.out.println(ParsedElement.JSON_TYPE + ": " + elements.get(i).getType());
			System.out.println(ParsedElement.JSON_X + ": " + elements.get(i).getX());
			System.out.println(ParsedElement.JSON_Y + ": " + elements.get(i).getY());
			System.out.println(ParsedElement.JSON_WIDTH + ": " + elements.get(i).getWidth());
			System.out.println(ParsedElement.JSON_HEIGHT + ": " + elements.get(i).getHeight());
			System.out.println(ParsedElement.JSON_TEXT + ": " + elements.get(i).getText());
		}
	}
	
	public String getFileAsString() {
		return this.fileAsString;
	}

}
