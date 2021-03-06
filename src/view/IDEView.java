package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

public class IDEView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 600;
	
	private JPanel contentPane;
	private JTextArea textArea;
	private JTextArea txtFilename;
	
	private Controller controller;
	
	private ParsedView parsedView;

	/**
	 * Create the frame.
	 */
	public IDEView() {}
	
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		
		// content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// split pane
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.25);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, FRAME_WIDTH - 16, FRAME_HEIGHT - 39);
		contentPane.add(splitPane);
		
		// pane containing the buttons
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		// buttons
		JButton btnRender = new JButton("Render");
		btnRender.setBounds(310, 90, 105, 23);
		btnRender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open new window only if there's json file selected
				if(!textArea.getText().isEmpty()) {
					parsedView = new ParsedView();
					parsedView.setVisible(true);
					
					controller.render();
				} else {
					// show error
					JOptionPane.showMessageDialog(getParent(), "No JSON file selected", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnRender);
		
		JButton btnOpen = new JButton("Open...");
		btnOpen.setBounds(10, 11, 105, 23);
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// open file explorer
				JFileChooser jfc = new JFileChooser();
				
				// only open json files
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILE", "json");
				jfc.setFileFilter(filter);
				
				// if open
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {				
					// set the filename to the controller
					File selectedFile = jfc.getSelectedFile();
					controller.setFilename(selectedFile.getAbsolutePath());
					controller.displayFileString();
					
					txtFilename.setText(selectedFile.getAbsolutePath());
				}				
			}
		});
		panel.add(btnOpen);
		
		// filename of the chosen json files
		txtFilename = new JTextArea("");
		txtFilename.setBounds(10, 50, 350, 38);
		txtFilename.setWrapStyleWord(true);
		txtFilename.setLineWrap(true);
		txtFilename.setOpaque(false);
		txtFilename.setEditable(false);
		txtFilename.setBackground(UIManager.getColor("Label.background"));
	    txtFilename.setBorder(UIManager.getBorder("Label.border"));
		panel.add(txtFilename);
		
		// json text area
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		splitPane.setRightComponent(scrollPane);
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		initGUI();
	}
	
	public void displayStringFromFile(String fileAsString) {
		textArea.setText(fileAsString);
	}
	
	public void addLabel(JLabel label) {
		this.parsedView.addLabel(label);
	}
	
	public void addTextBox(JTextField textbox) {
		this.parsedView.addTextBox(textbox);
	}
	
	public void addButton(JButton button) {
		this.parsedView.addButton(button);
	}
}
