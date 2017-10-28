package model;

public class ParsedElement {
	
	public static final String JSON_X = "x";
	public static final String JSON_Y = "y";
	public static final String JSON_HEIGHT = "height";
	public static final String JSON_WIDTH = "width";
	public static final String JSON_TEXT = "text";
	public static final String JSON_TYPE = "type";
	
	private ParsedElementType type;
	private double x, y;
	private double width, height;
	private String text;
	
	public ParsedElement() {}

	public ParsedElementType getType() {
		return type;
	}

	public void setType(ParsedElementType type) {
		this.type = type;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
