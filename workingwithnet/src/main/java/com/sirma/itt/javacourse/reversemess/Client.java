package com.sirma.itt.javacourse.reversemess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Connects to a server, sends him messages and gets them reversed.
 * 
 * @author Nikolay Ch
 * 
 */
public class Client extends Thread {
	private boolean isConnected = true;
	private PrintWriter writer;
	private Socket socket;
	private BufferedReader buffReader;
	private String message = "";

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 1948);
			writer = new PrintWriter(socket.getOutputStream(), true);
			buffReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			receiveMessage();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (isConnected) {

		}

		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Sends the message.
	 * 
	 * @param message
	 *            the message which must be send
	 */
	public void sendMessage(String message) {
		if (!message.equals(".")) {
			writer.println(message);
			receiveMessage();
		} else {
			ClientWindow.setToArea("Bye bye");
			System.exit(0);
			isConnected = false;
		}
	}

	/**
	 * Receives the message and writes it in the area.
	 */
	public void receiveMessage() {

		message = "";
		try {
			while (!buffReader.ready()) {

			}

			while (buffReader.ready()) {
				message += buffReader.readLine();
			}
			if (message != "") {
				ClientWindow.setToArea(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
