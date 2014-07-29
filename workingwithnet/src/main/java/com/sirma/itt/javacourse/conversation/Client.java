package com.sirma.itt.javacourse.conversation;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * The client, which connect to a server and receives some messages.
 * 
 * @author Nikolay Ch
 * 
 */
public class Client {
	private static Socket client;
	private static Scanner scan;
	private static String all;

	/**
	 * Creates a socket and connects it to the server then waits for message
	 * from the server. When the message is received the socket closes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new ClientWindow();
			client = new Socket("localhost", 666);
			ClientWindow.writeToField("Conected to the server.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Inside");
		try {

			scan = new Scanner(client.getInputStream());

			String line = "";
			all = "";
			ClientWindow.writeToField("Reading the message from the server.");
			while (scan.hasNext()) {
				line = scan.nextLine();
				all += line;
				all += "\n";
			}

			ClientWindow.writeToField("The message: " + all);

			ClientWindow.writeToField("Disconnected.");
			Thread.sleep(500);
			client.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
