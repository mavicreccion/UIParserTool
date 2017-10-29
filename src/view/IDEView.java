package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

public class IDEView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextArea textArea;
	private JTextArea txtFilename;
	
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public IDEView() {}
	
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		splitPane.setResizeWeight(0.4);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 434, 261);
		contentPane.add(splitPane);
		
		// pane containing the buttons
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		// buttons
		JButton btnRender = new JButton("Render");
		btnRender.setBounds(317, 51, 105, 23);
		btnRender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// open new window
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
		txtFilename.setEnabled(false);
		txtFilename.setBounds(125, 10, 296, 38);
		txtFilename.setWrapStyleWord(true);
		txtFilename.setLineWrap(true);
		txtFilename.setOpaque(false);
		txtFilename.setEditable(false);
		txtFilename.setFocusable(false);
		txtFilename.setBackground(UIManager.getColor("Label.background"));
	    txtFilename.setFont(UIManager.getFont("Label.font"));
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
}
