package com.sirma.itt.javacourse.manyclients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The server. It waits for a connect from a clients and when a new one connects
 * it notifies the previous.
 * 
 * @author Nikolay Ch
 * 
 */
public class Server {
	private static List<Socket> list = new ArrayList<Socket>();
	private static ServerSocket server;
	private static Socket socket = new Socket();
	private static InfoThread thread;

	/**
	 * Waits for a client to connect. Adds him to a list and starts new thread
	 * which notifies the previous clients for the new connection.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerWindow();
		try {
			server = new ServerSocket(1948);
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				socket = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ServerWindow.writeToField("New client has connected. Its number "
					+ (list.size() + 1));
			list.add(socket);
			thread = new InfoThread(list);
			thread.start();
		}
	}

	/**
	 * Closes the server.
	 */
	public static void stopServer() {
		try {
			server.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
