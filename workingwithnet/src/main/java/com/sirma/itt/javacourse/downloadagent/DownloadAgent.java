package com.sirma.itt.javacourse.downloadagent;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Has a method for downloading a file from the net.
 * 
 * @author Nikolay Ch
 * 
 */
public class DownloadAgent {
	private static long remain = 0;

	private long lenght;

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
		InputStream is = null;
		FileOutputStream output;
		URLConnection myURLConnection = null;
		String[] stringDirectories = url.split("/");// separates the
													// string
		String name = stringDirectories[stringDirectories.length - 1];
		URL myURL = new URL(url);
		byte b = 0;
		try {
			myURLConnection = myURL.openConnection();
			lenght = myURLConnection.getContentLengthLong();
			is = myURLConnection.getInputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		File newFile = new File(name); 
		output = new FileOutputStream(newFile);
		while (b != -1) {
			b = (byte) is.read();
			output.write(b);
			remain += 1;
		}

		output.close();
	}

	/**
	 * Calculates what percent of the all is the remaining number.
	 * 
	 * @param remain
	 *            the number with the remaining bytes
	 * @return the percent
	 */
	public int getPercent(long remain) {
		try {
			return (int) ((remain * 100) / lenght);
		} catch (ArithmeticException e) {
			return 0;
		}
	}

	/**
	 * Getter for the current value.
	 * 
	 * @return the current value
	 */
	public int getCurrentValue() {
		try {
			return (int) ((remain * 100) / lenght);
		} catch (ArithmeticException e) {
			return 0;
		}
	}

}
