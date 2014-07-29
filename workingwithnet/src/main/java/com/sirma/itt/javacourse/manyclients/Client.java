package com.sirma.itt.javacourse.manyclients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The client, which connect to a server and receives some messages.
 * 
 * @author Nikolay Ch
 * 
 */
public class Client extends Thread{
	private static Socket client;
	private static InputStreamReader input;
	private static BufferedReader reader;
	private static String all;

	/**
	 * Connects the client to the server and starts infinite cycle for reading
	 * messages from the server.
	 */
	public void run() {
		try {
			client = new Socket("localhost", 1948);
			ClientWindow.writeToField("Conected to the server.");
			input = new InputStreamReader(client.getInputStream());
			reader = new BufferedReader(input);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while (true) {
				String line = "";
				all = "";

				while (line != " ") {
					try {
						line = reader.readLine();
					} catch (IOException e) {
						break;

					}
					all += line;
					System.out.println(line);
					break;
				}
				System.out.println(all);
				ClientWindow.writeToField("The message: " + all);
			}
		} catch (Exception e) {
			ClientWindow.writeToField("The server is stopped.");
		}

	}

}
