package com.sirma.itt.javacourse.calculator;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * The frame for the calculator.
 * 
 * @author Nikolay Ch
 * 
 */
public class Frame {

	public JFrame frame = new JFrame("Frame");

	/**
	 * Constructs the frame.
	 */
	public Frame(String title) {
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 407);
		frame.setPreferredSize(new Dimension(300, 407));
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
