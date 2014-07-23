package com.sirma.itt.javacourse.downloadagent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.SwingWorker;

/**
 * Has a method for downloading a file from the net.
 * 
 * @author Nikolay Ch
 * 
 */
public class DownloadAgent {

	private SwingWorker<Void, Void> worker;
	private long lenght;
	private long remain = 0;

	/**
	 * Downloads from the net by creating a URLConnection from the given string
	 * and reads form its input stream.
	 * 
	 * @param url
	 *            the string with the address of the file
	 * @throws IOException
	 *             when an error occurs in reading from the stream or writing it
	 *             into a file
	 */
	public void downloadFile(final String url) throws IOException {
		worker = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				String[] stringDirectories = url.split("/");// separates the
															// string
				String name = stringDirectories[stringDirectories.length - 1];
				FileOutputStream output;

				URL myURL = new URL(url);
				URLConnection myURLConnection = null;
				InputStreamReader in = null;
				byte b = 0;
				try {
					myURLConnection = myURL.openConnection(); // makes a
																// connection
					InputStream is = myURLConnection.getInputStream(); // gets
																		// the
																		// input
																		// stream
					in = new InputStreamReader(is);
					lenght = myURLConnection.getContentLengthLong();// gets the
																	// length of
																	// the file
				} catch (IOException e) {

					e.printStackTrace();
				}

				File newFile = new File(name); // takes the name and extension
												// and makes a file
				output = new FileOutputStream(newFile);

				while (b != -1) {
					b = (byte) in.read();
					output.write(b);
					remain += 1;
					setProgress(Math.min(getPersent(remain), 100));// sets the
																	// progress
				}

				output.close();

				return null;
			}

		};

	}

	/**
	 * Calculates what percent of the all is the remaining number.
	 * 
	 * @param remain
	 *            the number with the remaining bytes
	 * @return the percent
	 */
	public int getPersent(long remain) {
		return (int) ((remain * 100) / lenght);
	}

	/**
	 * Getter for the swing worker.
	 * 
	 * @return the worker
	 */
	public SwingWorker<Void, Void> getWorker() {
		return worker;
	}

}
