package com.sirma.itt.javacourse.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Thread that is started by the Mediator and sends the messages to two groups.
 * 
 * @author Nikolay Ch
 * 
 */
public class SendThread extends Thread {
	protected DatagramSocket socket;
	private List<String> small = new ArrayList<String>();
	private List<String> big = new ArrayList<String>();
	private InetAddress address;
	private DatagramPacket packet;

	/**
	 * Takes the two lists and initializes the fields.
	 * 
	 * @param small
	 *            the list with the small words
	 * @param big
	 *            the list with big words
	 */
	public SendThread(List<String> small, List<String> big) {
		this.small = small;
		this.big = big;
		try {
			socket = new DatagramSocket(1948);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (small.size() > 0) {
			byte[] buf = new byte[16];
			buf = small.get(small.size() - 1).getBytes();
			small.remove(small.size() - 1);
			try {
				address = InetAddress.getByName("230.0.0.1");
				packet = new DatagramPacket(buf, buf.length, address, 1949);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (big.size() > 0) {
			try {
				byte[] buf = new byte[32];
				buf = big.get(big.size() - 1).getBytes();
				big.remove(big.size() - 1);

				InetAddress group = InetAddress.getByName("230.0.0.2");

				packet = new DatagramPacket(buf, buf.length, group, 1949);
				socket.send(packet);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		socket.close();
	}
}
