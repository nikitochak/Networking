package com.sirma.itt.javacourse.downloadagent;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
				FileOutputStream output = new FileOutputStream(new File(name));

				URL myURL = new URL(url);
				URLConnection myURLConnection = null;
				BufferedInputStream in = null;

				try {
					myURLConnection = myURL.openConnection();
					in = new BufferedInputStream(
							myURLConnection.getInputStream());
					lenght = myURLConnection.getContentLengthLong();

					final byte data[] = new byte[1024];
					int count;
					while ((count = in.read(data, 0, 1024)) != -1) {
						output.write(data, 0, count);
						remain += count;
						setProgress(Math.min(getPersent(remain), 100));
					}

				} catch (IOException e) {
					e.printStackTrace();
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
