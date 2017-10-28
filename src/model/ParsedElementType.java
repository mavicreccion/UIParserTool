package model;

public enum ParsedElementType {
	
	LABEL, TEXTBOX, BUTTON;
	
	public static ParsedElementType getValue(String type) {
		switch(type) {
		case "label": return LABEL;
		case "button": return BUTTON;
		case "textbox": return TEXTBOX;
		default: return null;
		}
	}

}
