package com.sirma.itt.javacourse.calculator;

import java.awt.Dimension;

import javax.swing.JTextField;

/**
 * Represents the screen for the calculator.
 * 
 * @author Nikolay Ch
 * 
 */
@SuppressWarnings("serial")
public class Screen extends JTextField {

	/**
	 * Constructs the screen so it can be written on him only by the buttons.
	 * 
	 * @param name
	 *            the name
	 */
	public Screen(String name) {
		super(name);
		setPreferredSize(new Dimension(300, 60));
		setEnabled(false);
		setVisible(true);
	}

}
