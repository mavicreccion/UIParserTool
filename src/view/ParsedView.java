package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ParsedView extends JFrame {
	
	private static final int FRAME_WIDTH = 1366;
	private static final int FRAME_HEIGHT = 768;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ParsedView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
	}
	
	public void addLabel(JLabel label) {
		this.contentPane.add(label);
	}
	
	public void addTextBox(JTextField textbox) {
		this.contentPane.add(textbox);
	}
	
	public void addButton(JButton button) {
		this.contentPane.add(button);
	}

}
