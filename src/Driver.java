import model.UIParserTool;

public class Driver {
	
	public static void main(String[] args) {
		UIParserTool model = new UIParserTool();
		
		model.readFile("./json_files/temp_json.json");
		model.JSONparse();
	}
}