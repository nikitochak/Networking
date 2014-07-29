package com.sirma.itt.javacourse.manyclients;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Thread which is started every time when a new socket connects. Notifies the
 * previous for the new one and sends welcome message to the new client.
 * 
 * @author Nikolay Ch
 * 
 */
public class InfoThread extends Thread {
	private List<Socket> list = new ArrayList<Socket>();
	private OutputStream out;
	private OutputStreamWriter writer;

	/**
	 * Initializes the list.
	 * 
	 * @param list
	 *            the list with the connected sockets
	 */
	public InfoThread(List<Socket> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < list.size(); i++) {
			try {
				System.out.println(i);
				out = list.get(i).getOutputStream();
				writer = new OutputStreamWriter(out);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (i == list.size() - 1) {
				try {
					writer.write("You are the " + list.size()
							+ " connection.\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					writer.write("New connection. It is number " + list.size()
							+ " \n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
