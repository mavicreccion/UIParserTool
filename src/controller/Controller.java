package controller;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		for (int i=0; i < elements.size(); i++)
		{
			
			Font f = new Font("ARIAL", Font.PLAIN, elements.get(i).getFontsize());
			
			switch(elements.get(i).getType())
			{
				case LABEL: 
					JLabel label = new JLabel();
					label.setText(elements.get(i).getText());
					label.setLocation(elements.get(i).getX(), elements.get(i).getY());
					label.setSize(elements.get(i).getWidth(),elements.get(i).getHeight());
					label.setFont(f);
					view.addLabel(label);
					break;
				case BUTTON:
					JButton button = new JButton();
					button.setText(elements.get(i).getText());
					button.setLocation(elements.get(i).getX(), elements.get(i).getY());
					button.setSize(elements.get(i).getWidth(), elements.get(i).getHeight());
					button.setFont(f);
					button.setRolloverEnabled(false);
					view.addButton(button);
					break;
				case TEXTFIELD:
					JTextField textfield = new JTextField();
					textfield.setText(elements.get(i).getText());
					textfield.setLocation(elements.get(i).getX(), elements.get(i).getY());
					textfield.setSize(elements.get(i).getWidth(), elements.get(i).getHeight());
					textfield.setFont(f);
					view.addTextBox(textfield);
					break;
			}
			
			
		}
		
		/* 
		 * 	2. for each parsed element, create a java component
		 *  -- setBounds to set x, y, width, height
		 *  -- set text when initializing the component
		 *  -- call particular methods in the view when adding the component
		*/		
	}

}
