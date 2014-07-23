package com.sirma.itt.javacourse.calculator;

import java.awt.Dimension;

import javax.swing.JButton;

/**
 * Constructs the buttons for the calculator.
 * 
 * @author Nikolay Ch
 * 
 */
public class Buttons {

	public static JButton[] buttons = new JButton[18];

	/**
	 * Sets the size and the text of the buttons and adds them an action
	 * listener.
	 */
	public static void setButtons() {
		for (int i = 0; i < 10; i++) {
			String toString = "";
			toString += i;
			buttons[i] = new JButton(toString);
			buttons[i].setPreferredSize(new Dimension(55, 55));
			buttons[i].addActionListener(new Listener());

		}

		buttons[10] = new JButton(".");
		buttons[10].setPreferredSize(new Dimension(55, 55));
		buttons[10].addActionListener(new Listener());

		buttons[11] = new JButton("*");
		buttons[11].setPreferredSize(new Dimension(55, 55));
		buttons[11].addActionListener(new Listener());

		buttons[12] = new JButton("/");
		buttons[12].setPreferredSize(new Dimension(55, 55));
		buttons[12].addActionListener(new Listener());

		buttons[13] = new JButton("+");
		buttons[13].setPreferredSize(new Dimension(55, 55));
		buttons[13].addActionListener(new Listener());

		buttons[14] = new JButton("-");
		buttons[14].setPreferredSize(new Dimension(55, 55));
		buttons[14].addActionListener(new Listener());

		buttons[15] = new JButton("=");
		buttons[15].setPreferredSize(new Dimension(55, 55));
		buttons[15].addActionListener(new Listener());

		buttons[16] = new JButton("L");
		buttons[16].setPreferredSize(new Dimension(55, 55));
		buttons[16].addActionListener(new Listener());

		buttons[17] = new JButton("A");
		buttons[17].setPreferredSize(new Dimension(55, 55));
		buttons[17].addActionListener(new Listener());
	}

}
