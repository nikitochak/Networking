package com.sirma.itt.javacourse.manyclients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The window which updates the clients info.
 * 
 * @author Nikolay Ch
 * 
 */
public class ClientWindow {

	private static JTextArea field = new JTextArea(5, 20);
	private static String output = "";

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JScrollPane scroll;
	private JButton button = new JButton();

	/**
	 * Makes the frame, adds it a panel which has a text area where the text
	 * info be shown.
	 */
	public ClientWindow() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 400, 100);
		frame.setPreferredSize(new Dimension(400, 200));

		button.setPreferredSize(new Dimension(150, 50));
		button.setText("Connect");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Client().start();
			}
		});

		panel.setBounds(0, 100, 300, 100);
		panel.setBackground(Color.GREEN);

		field.setEnabled(false);
		field.setPreferredSize(new Dimension(300, 100));

		scroll = new JScrollPane(field, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel.add(scroll);

		frame.add(new JLabel("Here is the text"), BorderLayout.EAST);
		frame.add(button, BorderLayout.WEST);
		frame.add(panel, BorderLayout.SOUTH);

		frame.pack();
	}

	/**
	 * Method for writing a string on the window.
	 * 
	 * @param what
	 *            the string which the client want to write
	 */
	public static void writeToField(String what) {
		output += what;
		output += "\n";
		field.setText(output);
	}

	public static void main(String[] args) {
		new ClientWindow();
	}
}
