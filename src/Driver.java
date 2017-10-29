import java.awt.EventQueue;

import controller.Controller;
import model.UIParserTool;
import view.IDEView;

public class Driver {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					// model
					UIParserTool model = new UIParserTool();
					
					// view
					IDEView view = new IDEView();
					
					// controller
					new Controller(model, view);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public static void main(String[] args) {
//		UIParserTool model = new UIParserTool();
//		
//		model.readFile("./json_files/temp_json.json");
//		model.JSONparse();
//		
//		
//	}
}