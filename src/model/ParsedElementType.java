package model;

public enum ParsedElementType {
	
	LABEL, TEXTFIELD, BUTTON;
	
	public static ParsedElementType getValue(String type) {
		switch(type) {
		case "label": return LABEL;
		case "button": return BUTTON;
		case "textbox": return TEXTFIELD;
		default: return null;
		}
	}

}
