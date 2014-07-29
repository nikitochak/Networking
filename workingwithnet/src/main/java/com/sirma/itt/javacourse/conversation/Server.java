package com.sirma.itt.javacourse.conversation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The server.
 * 
 * @author Nikolay Ch
 * 
 */
public class Server {

	private static ServerSocket server;
	private static Socket socket = new Socket();

	/**
	 * Starts the server which waits for a connection from a socket, then writes
	 * a message to the socket.
	 * 
	 * @param main
	 */
	public static void main(String[] main) {

		try {
			new ServerWindow();

			server = new ServerSocket(666);
			ServerWindow.writeToField("The server is started");

			socket = server.accept();

			System.out.println(socket.getLocalAddress());
			ServerWindow
					.writeToField("The server and a socket have made a connection.");

			String message = "Message sent: " + System.currentTimeMillis()
					+ " \n";
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(message);

			bw.close();
			osw.close();
			os.close();
			ServerWindow.writeToField("The message is sent");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Closes the server and the socket.
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
