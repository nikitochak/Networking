package com.sirma.itt.javacourse.broadcast;

/**
 * Has a method for generating random string.
 * 
 * @author Nikolay Ch
 */
public class Generator {
	/**
	 * Generates a random string.
	 * 
	 * @return the generated string
	 */
	public static String generateString() {
		String generated = "";
		int length = (int) (Math.random() * 10) + 1;
		;
		char character = '0';
		for (int i = 0; i < length; i++) {
			character = (char) ((int) (Math.random() * 25) + 'a');
			generated += character;
		}
		return generated;
	}
}
