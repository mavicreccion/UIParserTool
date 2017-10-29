package parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.ParsedElement;
import model.ParsedElementType;

public class MyJSONParser extends GeneralParser {

	public MyJSONParser(String stringToParse) {
		super(stringToParse);
	}

	@Override
	public void parse() {
		
		ParsedElement parsedElement = null;
		
		try {
			JSONObject obj = new JSONObject(this.stringToParse);
			JSONArray arr = obj.getJSONArray("elements");
			
			JSONObject element = null;
			
			for(int i = 0; i < arr.length(); i ++) {
				element = arr.getJSONObject(i);
				parsedElement = new ParsedElement();
				
				String type = element.getString(ParsedElement.JSON_TYPE);
				parsedElement.setType(ParsedElementType.getValue(type));
				
				parsedElement.setX(element.getInt(ParsedElement.JSON_X));
				parsedElement.setY(element.getInt(ParsedElement.JSON_Y));
				parsedElement.setWidth(element.getInt(ParsedElement.JSON_WIDTH));
				parsedElement.setHeight(element.getInt(ParsedElement.JSON_HEIGHT));
				parsedElement.setText(element.getString(ParsedElement.JSON_TEXT));
				
				this.parsedElements.add(parsedElement);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
