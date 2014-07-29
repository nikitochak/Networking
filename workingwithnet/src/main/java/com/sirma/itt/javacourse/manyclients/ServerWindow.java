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
 * The window for the info from the server.
 * 
 * @author Nikolay Ch
 * 
 */
public class ServerWindow {

	private static JTextArea field = new JTextArea(5, 20);
	private static String output = "";
	private static JButton serverStop = new JButton();

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JScrollPane scroll;

	/**
	 * Creates a frame then adds to it a panel which contains a text area for
	 * the messages. Adds to the frame a button which stops the server.
	 */
	public ServerWindow() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 400, 100);
		frame.setPreferredSize(new Dimension(400, 200));

		panel.setBounds(0, 100, 300, 100);
		panel.setBackground(Color.GREEN);

		field.setEnabled(false);
		field.setPreferredSize(new Dimension(300, 100));

		scroll = new JScrollPane(field, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel.add(scroll);

		serverStop.setPreferredSize(new Dimension(100, 100));
		serverStop.setVisible(true);
		serverStop.setText("StopServer");
		serverStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				output += "Server is stopped.";
				field.setText(output);
				System.out.println(output);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Server.stopServer();
			}
		});

		frame.add(serverStop, BorderLayout.WEST);
		frame.add(new JLabel("Here is the text"), BorderLayout.CENTER);

		frame.add(panel, BorderLayout.SOUTH);

		frame.pack();
	}

	/**
	 * Method for writing on the window.
	 * 
	 * @param what
	 *            the string which the server wants to write.
	 */
	public static void writeToField(String what) {
		output += what;

		output += " \n";

		System.out.println(output);
		field.setText(output);
	}

}
