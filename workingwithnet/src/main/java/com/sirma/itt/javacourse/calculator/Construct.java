package com.sirma.itt.javacourse.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * Constructs the calculator.
 * 
 * @author Nikolay Ch
 * 
 */
public class Construct {
	private static JPanel panelButtons = new JPanel();
	private static JPanel panelScreen = new JPanel();
	private static Frame frame = new Frame("Calculator");
	public static Screen screen = new Screen("Calculate");

	/**
	 * Starts the calculator.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		constructPanels();
		Buttons.setButtons();
		screen.setFont(new Font("Are", Font.BOLD, 40));

		for (int i = 0; i < 18; i++) {
			panelButtons.add(Buttons.buttons[i]);
		}

		frame.frame.add(panelButtons, BorderLayout.PAGE_END);

		panelScreen.add(screen);
		frame.frame.add(panelScreen, BorderLayout.PAGE_START);
		frame.frame.pack();

	}

	/**
	 * Constructs the panels.
	 */
	public static void constructPanels() {
		panelScreen.setPreferredSize(new Dimension(100, 100));
		panelScreen.setBackground(Color.yellow);

		panelButtons.setPreferredSize(new Dimension(200, 307));
		panelButtons.setBackground(Color.red);

	}

}
