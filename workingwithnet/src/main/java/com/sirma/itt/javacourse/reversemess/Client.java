package com.sirma.itt.javacourse.reversemess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Connects to a server, sends him messages and gets them reversed.
 * 
 * @author Nikolay Ch
 * 
 */
public class Client extends Thread {
	private Socket socket;
	private InputStreamReader reader;
	private BufferedReader buffReader;
	private static OutputStreamWriter writer;
	private String message = "";
	private static boolean isConnected = true;

	/**
	 * Connects to a server.
	 */
	public void run() {
		try {
			socket = new Socket("localhost", 1948);
			writer = new OutputStreamWriter(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (isConnected) {
			receiveMessage();
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
	public static void sendMessage(String message) {
		try {
			System.out.println(message);
			writer.write(message);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Receives the message and writes it in the area.
	 */
	public void receiveMessage() {
		String line = "";
		System.out.println("Are vutre.");
		message = "";
		try {
			reader = new InputStreamReader(socket.getInputStream());
			buffReader = new BufferedReader(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (line != null) {
			try {
				line = buffReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (line != null) {
				message += line + "\n";
			}
		}
		ClientWindow.setToArea(message);
		System.out.println(message);
	}

	/**
	 * Setter for the field isConnected.
	 * 
	 * @param flag
	 *            the value
	 */
	public static void setCon(boolean flag) {
		isConnected = flag;
	}
}
