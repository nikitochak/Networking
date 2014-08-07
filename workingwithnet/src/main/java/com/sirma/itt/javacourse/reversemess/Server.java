package com.sirma.itt.javacourse.reversemess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The server which waits for a client to connect and reverses its messages.
 * 
 * @author Nikolay Ch
 * 
 */
public class Server extends Thread {
	private ServerSocket server;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader buffReader;

	/**
	 * Closes the server.
	 */
	public void stopServer() {
		try {
			server.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			server = new ServerSocket(1948);
			socket = server.accept();
			ServerWindow.writeToField("Connected.");
			buffReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("Hello\n");
			ServerWindow.writeToField("Welcome message sent.");
			while (true) {
				readClientMessage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reads the message from the client and invokes the sendMessage method.
	 */
	public void readClientMessage() {
		try {
			while (buffReader.ready()) {
				writeClientMessage(buffReader.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes the reversed message on the text area and on the clients input
	 * stream.
	 * 
	 * @param message
	 *            the clients message
	 */
	public void writeClientMessage(String message) {
		int length = message.length();
		String reversed = "The reverse of " + message + " is ";
		for (int i = length - 1; i >= 0; i--) {
			reversed += message.charAt(i);
		}

		ServerWindow.writeToField(reversed);
		writer.println(reversed+"\n");
	}
}
