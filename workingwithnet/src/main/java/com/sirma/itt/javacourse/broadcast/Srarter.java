package com.sirma.itt.javacourse.broadcast;

import java.util.ArrayList;
import java.util.List;

/**
 * First creates the messages and adds them to a list then starts the Mediator
 * which sends the messages.
 * 
 * @author Nikolay Ch
 * 
 */
public class Srarter {
	private static int number;
	private static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		number = (int) (Math.random() * 5) + 3;
		for (int i = 0; i < number; i++) {
			String message = Generator.generateString();
			list.add(message);
		}
		new Mediator(list).mediate();
	}
}
