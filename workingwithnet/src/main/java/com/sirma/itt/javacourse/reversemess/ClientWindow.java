package com.sirma.itt.javacourse.reversemess;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The client window that includes a field for writing messages from the user to
 * the server, button for sending the message, text area where the received
 * reversed message is written and a button for connection to the server.
 * 
 * @author Nikolay Ch
 * 
 */
public class ClientWindow {

	private static JTextArea area = new JTextArea(10, 10);
	private JFrame frame = new JFrame("Frame");
	private JPanel panel = new JPanel();
	private JTextField field = new JTextField();
	private JScrollPane scrollBar = new JScrollPane(area,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JButton button = new JButton("Connect");
	private JButton sendButton = new JButton("Send");

	/**
	 * Constructs the window.
	 */
	public ClientWindow() {
		setFrame();
		setPanel();
		setButton();
		setArea();
		setField();
		setSendButton();

		panel.add(button);
		panel.add(sendButton);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(scrollBar);
		frame.add(field, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();

	}

	/**
	 * Creates the frame.
	 */
	public void setFrame() {
		frame.setBounds(200, 200, 400, 400);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates the panel.
	 */
	public void setPanel() {
		panel.setPreferredSize(new Dimension(200, 100));
		panel.setBackground(Color.MAGENTA);
	}

	/**
	 * Creates the connection button.
	 */
	public void setButton() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Client().start();
				button.setEnabled(false);
				area.setText("conected");
			}
		});
		button.setPreferredSize(new Dimension(100, 50));
		button.setText("Connect");
	}

	/**
	 * Creates the text area.
	 */
	public void setArea() {
		area.setPreferredSize(new Dimension(400, 200));
		area.setEnabled(false);
	}

	/**
	 * Creates the text field.
	 */
	public void setField() {
		field.setPreferredSize(new Dimension(400, 50));
	}

	/**
	 * Creates the send button.
	 */
	public void setSendButton() {
		sendButton.setPreferredSize(new Dimension(200, 50));
		sendButton.setText("Send");
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (field.getText() != "") {
					if (field.getText() == ".") {
						Client.setCon(false);
					}
					Client.sendMessage(field.getText());

					// System.out.println(field.getText());
				}
			}
		});
	}

	/**
	 * Writes a message on the area.
	 * 
	 * @param message
	 *            the message which must be written.
	 */
	public static void setToArea(String message) {
		area.setText(message);
	}

	/**
	 * Starts the client window .
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ClientWindow();
	}
}
