package com.sirma.itt.javacourse.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The client that receives the messages from the one of the groups.
 * 
 * @author Nikolay Ch
 * 
 */
public class SmallClient {
	private static InetAddress address;
	private static DatagramPacket packet;
	private static MulticastSocket socket;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SmallClient.class);

	/**
	 * Creates a connection to the group by Multicast Socket, receives the
	 * messages and prints them on the console.
	 * 
	 * @param args
	 * @throws IOException
	 *             when an error occurs
	 */
	public static void main(String[] args) throws IOException {
		socket = new MulticastSocket(1949);
		address = InetAddress.getByName("230.0.0.1");
		socket.joinGroup(address);
		for (int i = 0; i < 5; i++) {
			byte[] buf = new byte[16];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);

			String received = new String(packet.getData());
			LOGGER.info(received);
		}
		socket.leaveGroup(address);
		socket.close();
	}
}
