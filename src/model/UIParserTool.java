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
	
	public ArrayList<ParsedElement> JSONparse() {
		GeneralParser parser = new MyJSONParser(this.fileAsString);
		parser.parse();
		
		return parser.getParsedElements();
	}
	
	public String getFileAsString() {
		return this.fileAsString;
	}

}
