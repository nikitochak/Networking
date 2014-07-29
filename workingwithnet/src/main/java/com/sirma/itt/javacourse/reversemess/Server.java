package com.sirma.itt.javacourse.reversemess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The server which waits for a client to connect and reverses its messages.
 * 
 * @author Nikolay Ch
 * 
 */
public class Server {
	private ServerSocket server;
	private Socket socket;
	private OutputStreamWriter writer;
	private BufferedReader buffReader;
	private boolean toContinue = true;
	private String message;
	private String line;

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

	public void create() {

		try {
			server = new ServerSocket(1948);
			socket = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ServerWindow.writeToField("The client has connected.");

		try {
			buffReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write("Hello Message.");
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		ServerWindow.writeToField("The hello message has been sent.");
		new Thread() {

			@Override
			public void run() {
				System.out.println("Vutre u servera.");
				while (toContinue) {
					String get = null;
					get = readClientMessage();
					System.out.println(get);
					if (get != null) {
						writeReverseMessage(get);
						System.out.println(get);
					}
				}
			}
		}.start();
	}

	/**
	 * Reverses a string.
	 * 
	 * @param string
	 *            the string which must be reversed
	 * @return the reversed string
	 */
	public String readClientMessage() {
		try {
			line = buffReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(line);
		return line;
	}

	/**
	 * Reverses a string and writes it into the clients stream.
	 * 
	 * @param string
	 *            the string which must be reversed
	 */
	public void writeReverseMessage(String string) {
		String reversed = "";
		int length = string.length();
		for (int i = length - 1; i >= 0; i--) {
			reversed += string.charAt(i);
		}
		message = "The reverse of " + line + " is " + reversed;
		System.out.println(message);
		ServerWindow.writeToField(message);
		try {
			writer.write(message);
			writer.flush();
		} catch (Exception e) {
		}
	}
}
