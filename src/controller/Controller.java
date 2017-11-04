package controller;

import java.util.ArrayList;

import model.ParsedElement;
import model.UIParserTool;
import view.IDEView;

public class Controller {
	
	private UIParserTool model;
	private IDEView view;
	
	public Controller(UIParserTool model, IDEView view) {
		this.model = model;
		this.view = view;
		this.view.setController(this);
	}
	
	public void setFilename(String filename) {
		model.readFile(filename);
	}
	
	public void displayFileString() {
		view.displayStringFromFile(model.getFileAsString());
	}
	
	public void render() {
		
		// 1. parse
		ArrayList<ParsedElement> elements = model.JSONparse();
		
		/* 
		 * 	2. for each parsed element, create a java component
		 *  -- setBounds to set x, y, width, height
		 *  -- set text when initializing the component
		 *  -- call particular methods in the view when adding the component
		*/		
	}

}
