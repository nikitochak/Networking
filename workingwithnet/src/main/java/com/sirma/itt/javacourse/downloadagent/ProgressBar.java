package com.sirma.itt.javacourse.downloadagent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * The progress bar which shows how of the download is finished.
 * 
 * @author Nikolay Ch
 * 
 */
public class ProgressBar {
	private static JFrame frame = new JFrame();
	private static JProgressBar progressBar = new JProgressBar(0, 100);
	private static JLabel label = new JLabel("Progress Bar");
	private static JPanel panelBar = new JPanel();
	private static JTextField text = new JTextField();
	private static DownloadAgent agent = new DownloadAgent();

	/**
	 * Creates the label.
	 */
	public static void setLabel() {
		label.setBounds(0, 0, 300, 100);
		label.setPreferredSize(new Dimension(300, 20));
		label.setFont(new Font("Progress Bar", Font.ITALIC, 20));
	}

	public static void setTextField() {
		text.setPreferredSize(new Dimension(300, 50));
		// the field waits the customer to enter the link and to press enter
		text.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String link = text.getText();

					text.setText("Now we will download the file");
					text.setEnabled(false);
					try {
						agent.downloadFile(link);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					text.setText("The file is downloaded.");
					text.setEnabled(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	/**
	 * Creates the panel.
	 */
	public static void setPanel() {
		panelBar.setBackground(Color.BLUE);
		panelBar.setPreferredSize(new Dimension(300, 100));
	}

	/**
	 * Creates the frame.
	 */
	public static void setFrame() {
		frame.setTitle("ProgressBar");
		frame.setVisible(true);
		frame.setBackground(Color.gray);
		frame.setBounds(200, 200, 300, 300);
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
	}

	/**
	 * Creates the progress bar.
	 */
	public static void setProgressBar() {
		progressBar.setPreferredSize(new Dimension(300, 50));
		progressBar.setToolTipText("aide bomba");
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.red);
	}

	/**
	 * Constructs all above made components and adds them to the frame.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		setProgressBar();
		setFrame();
		setLabel();
		setPanel();
		setTextField();

		progressBar.add(label);
		panelBar.add(label, 0);
		panelBar.add(progressBar, new BorderLayout(50, 50));
		frame.add(panelBar, BorderLayout.SOUTH);
		frame.add(text);
		setToBar();

	}

	/**
	 * Sets the current value to the progress bar.
	 */
	public static void setToBar() {
		int number = 0;
		/*
		 * 
		 * for (int i = 0; i < 100;) {
		 * 
		 * if (number != agent.getCurrentValue()) { progressBar.setValue(i);
		 * System.out.println(number); number = agent.getCurrentValue(); i++; }
		 * 
		 * }
		 */
		int i = 0;
		while (number < 100) {
			if (number != agent.getCurrentValue()) {
				System.out.println(System.currentTimeMillis());
				number = agent.getCurrentValue();
				i++;
				progressBar.setValue(i);
			}
		}

	}
}
