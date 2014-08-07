package com.sirma.itt.javacourse.broadcast;

import java.util.ArrayList;
import java.util.List;

/**
 * Separates a list on two and starts a thread which sends each list to a group.
 * 
 * @author Nikolay Ch
 */
public class Mediator {

	private List<String> all = new ArrayList<String>();
	private List<String> small = new ArrayList<String>();
	private List<String> big = new ArrayList<String>();

	/**
	 * Initializes the field with the messages.
	 * 
	 * @param all
	 *            the list with the messages.
	 */
	public Mediator(List<String> all) {
		this.all = all;
	}

	/**
	 * Separates the small strings from the bigger and starts the thread for
	 * sending them.
	 */
	public void mediate() {
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).length() > 5) {
				big.add(all.get(i));
			} else {
				small.add(all.get(i));
			}
		}

		new SendThread(small, big).start();
	}
}
