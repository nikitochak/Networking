package com.sirma.itt.javacourse.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The listener for the buttons. Keeps the information given by the buttons and
 * interacts with the methods for calculating.
 * 
 * @author Nikolay Ch
 * 
 */
public class Listener implements ActionListener {
	private int num; // the pressed number
	private static String first = ""; // the first number 
	private static String second = ""; // the second number
	private char character; // the command character
	
	
	
	
	/**
	 * Getter for the first number.
	 * 
	 * @return the first
	 */
	public static String getFirst() {
		return first;
	}

	/**
	 * Getter for the second number.
	 * 
	 * @return the second
	 */
	public static String getSecond() {
		return second;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (!Methods.isSecond()) { // there are two numbers - one before the
									// option character and one after
									// looks which turn is
			try {
				num = Integer.parseInt(e.getActionCommand());
				first += num;// adds to the first the pressed number if
								// it is number
				Construct.screen.setText(first);
			} catch (NumberFormatException i) {
				if (e.getActionCommand() == ".") {
					try {
						@SuppressWarnings("unused")
						int number = Integer.parseInt(first);// if the
						// number is integer makes it decimal
						first += ".";
						Construct.screen.setText(first);

					} catch (NumberFormatException exNum) {
						// else does nothing and waits for another command
					}
				} else if (e.getActionCommand() == "L") {
					first = first.substring(0, first.length() - 1); // deletes
																	// the last
																	// character
					Construct.screen.setText(first);
				} else if (e.getActionCommand() == "A") {
					first = "";
					Construct.screen.setText(first); // deletes the
														// whole number
				} else {
					character = e.getActionCommand().charAt(0); // keeps
																// the
																// command
					Methods.setSecond(true); // sets the next number to be put
												// to the second
				}
			}

		} else { // if it is set to be the second's turn
			try {
				num = Integer.parseInt(e.getActionCommand());
				second += num; // if the pressed button is number adds
								// it
				Construct.screen.setText(second);
			} catch (NumberFormatException i) {
				if (e.getActionCommand() == ".") {

					if (!second.contains(".")) {// checks if the second
												// is integer
						second += "."; // makes it decimal
						Methods.setSecond(true);
						Construct.screen.setText(second);
					}

				} else if (e.getActionCommand() == "A") {
					second = ""; // deletes the whole number
					Construct.screen.setText(second);
				} else if (e.getActionCommand() == "L") {
					second = second.substring(0, second.length() - 1); // deletes
																		// the
																		// last
																		// character
					Construct.screen.setText(second);
				} else {
					switch (character) { // invokes the methods
											// depending on the command
											// options
					case '+':
						first = Methods.sum();
						second = "";
						break;
					case '-':
						first = Methods.substract();
						second = "";
						break;
					case '*':
						first = Methods.multiply();
						second = "";
						break;
					case '/':
						first = Methods.divide();
						second = "";
						break;

					}
					character = e.getActionCommand().charAt(0);// takes
					// the command character after the second
				}
				if (character == '=') {// if it is = prints the result
					Construct.screen.setText(first);
					Methods.setSecond(false);
				}
			}
		}
	}



}
