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
	private static char character; // the command character
	private String helper = "";

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
					if (first.length() > 0) {
						// deletes the last character
						first = first.substring(0, first.length() - 1);
					}
					Construct.screen.setText(first);
				} else if (e.getActionCommand() == "A") {
					first = "";
					Construct.screen.setText(first); // deletes the
														// whole number
				} else if (e.getActionCommand() == "-" && first.length() == 0) {
					first += "-";
					Construct.screen.setText(first);
				} else if (e.getActionCommand() == "=") {
					Construct.screen.setText(first);
				} else {
					if (Methods.isInt(first) || Methods.isDouble(first)) {
						// keeps the command
						character = e.getActionCommand().charAt(0);
						Methods.setSecond(true); // sets the next number to be
													// put
													// to the second
					}
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
					// checks if the second is integer
					if (!second.contains(".") && second.length() > 1) {
						second += "."; // makes it decimal
						Construct.screen.setText(second);

					}

				} else if (e.getActionCommand() == "A") {
					second = ""; // deletes the whole number

					Construct.screen.setText(second);
				} else if (e.getActionCommand() == "L") {
					// deletes the last character
					if (second.length() > 1) {
						second = second.substring(0, second.length() - 1);
					}
					Construct.screen.setText(second);
				} else {
					if (Methods.isDouble(second) || Methods.isInt(second)) {
						switch (character) {
						// invokes the method depending on the command option
						case '+':
							helper = "";
							helper += Methods.sum();
							first = "";
							first += helper;
							second = "";
							System.out.println(first);
							break;
						case '-':
							first = "";
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
						default:
							System.out.println(character);

						}
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
