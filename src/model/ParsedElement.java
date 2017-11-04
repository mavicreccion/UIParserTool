package model;

public class ParsedElement {
	
	public static final String JSON_X = "x";
	public static final String JSON_Y = "y";
	public static final String JSON_HEIGHT = "height";
	public static final String JSON_WIDTH = "width";
	public static final String JSON_TEXT = "text";
	public static final String JSON_FONTSIZE = "font-size";
	public static final String JSON_TYPE = "type";
	
	private ParsedElementType type;
	private int x, y;
	private int width, height;
	private String text;
	private int fontsize;
	
	public ParsedElement() {}

	public ParsedElementType getType() {
		return type;
	}

	public void setType(ParsedElementType type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFontsize() {
		return fontsize;
	}

	public void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}
	
	

}
