package com.sirma.itt.javacourse.calculator;

/**
 * Keeps the methods of the calculator.
 * 
 * @author Nikolay Ch
 * 
 */
public class Methods {
	
	private static Double firstDouble; // used if the first number is decimal
	private static Double secondDouble;//used if the second field is decimal
	private static Integer firstInteger; // used if the first is integer
	private static Integer secondInteger;// used if the second is integer
	private static Double resultDouble; // used if the result is double
	private static String result = ""; //the string the each method returns
	private static Integer resultInteger;//used if the result is integer
	private static boolean isSecond = false;//keep which turn is 
	
	
	/**
	 * Getter for the field that keeps which number is.
	 * 
	 * @return the value
	 */
	public static boolean isSecond() {
		return isSecond;
	}

	/**
	 * Sets the boolean field to true if the first number is finished.
	 * 
	 * @param isSecond
	 *            true if you want to set the current number to be the second.
	 */
	public static void setSecond(boolean isSecond) {
		Methods.isSecond = isSecond;
	}

	/**
	 * Sums the two numbers.
	 * 
	 * @return the result
	 */
	public static String sum() {

		result = "";
		if (isInt(Listener.getFirst()) && isInt(Listener.getSecond())) {
			firstInteger = Integer.parseInt(Listener.getFirst());
			secondInteger = Integer.parseInt(Listener.getSecond());
			resultInteger = firstInteger + secondInteger;
			result += resultInteger;
		} else {
			firstDouble = Double.parseDouble(Listener.getFirst());
			secondDouble = Double.parseDouble(Listener.getSecond());
			resultDouble = firstDouble + secondDouble;
			result = String.format("%3f", resultDouble);
		}
		return result;

	}

	/**
	 * Takes from first the value of second.
	 * 
	 * @return the result
	 */
	public static String substract() {
		result = "";
		if (isInt(Listener.getFirst()) && isInt(Listener.getSecond())) {
			firstInteger = Integer.parseInt(Listener.getFirst());
			secondInteger = Integer.parseInt(Listener.getSecond());
			resultInteger = firstInteger - secondInteger;
			result += resultInteger;
		} else {
			firstDouble = Double.parseDouble(Listener.getFirst());
			secondDouble = Double.parseDouble(Listener.getSecond());
			if (isInt(firstDouble - secondDouble)) {
				resultInteger = (int) (firstDouble - secondDouble);
				result += resultInteger;
			} else {
				resultDouble = firstDouble - secondDouble;
				result = String.format("%3f", resultDouble);
			}
		}
		return result;
	}

	/**
	 * Divides first to the second.
	 * 
	 * @return the result
	 */
	public static String divide() {
		result = "";
		firstDouble = Double.parseDouble(Listener.getFirst());
		secondDouble = Double.parseDouble(Listener.getSecond());

		if (secondDouble == 0.0) {
			result = "0";
		} else {
			resultDouble = firstDouble / secondDouble;
			if (isInt(resultDouble)) {
				resultInteger = (int) (firstDouble / secondDouble);
				result += resultInteger;
			} else {
				result = String.format("%2f", resultDouble);
			}
		}
		return result;
	}

	/**
	 * Multiplies the first and the second.
	 * 
	 * @return the result
	 */
	public static String multiply() {
		result = "";
		if (isInt(Listener.getFirst()) && isInt(Listener.getSecond())) {
			firstInteger = Integer.parseInt(Listener.getFirst());
			secondInteger = Integer.parseInt(Listener.getSecond());
			resultInteger = firstInteger * secondInteger;
			result += resultInteger;

		} else {
			firstDouble = Double.parseDouble(Listener.getFirst());
			secondDouble = Double.parseDouble(Listener.getSecond());
			resultDouble = firstDouble * secondDouble;
			if (isInt(resultDouble)) {
				resultInteger = (int) (firstDouble * secondDouble);
				result += resultInteger;
			} else {
				result = String.format("%3f", resultDouble);
			}
		}

		return result;
	}

	/**
	 * Checks if the number in the string is integer.
	 * 
	 * @param number
	 *            the string
	 * @return true if the string is integer
	 */
	public static boolean isInt(String number) {
		try {
			@SuppressWarnings("unused")
			int num = Integer.parseInt(number);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	/**
	 * Checks if a double is actually an integer.
	 * 
	 * @param doubleNum
	 *            the double number
	 * @return true if its rest is equal to zero
	 */
	public static boolean isInt(Double doubleNum) {
		int how = 100000000;
		int rest = (int) ((doubleNum * how) % how);
		if (rest == 0) {
			return true;
		} else {
			return false;
		}
	}

}
