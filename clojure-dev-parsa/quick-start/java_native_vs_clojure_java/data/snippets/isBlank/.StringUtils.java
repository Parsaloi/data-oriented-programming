///usr/bin/env jbang "$0" "$@" ; exit $?

package data.snippets.isBlank;

import static java.lang.System.*;

import java.util.*;

public class StringUtils {

	public static void main(String... args) {

		// Chenking if "    " is either empty, as in "" or consisting of only whitespaces as in this example case

		// we are expecting a String input from the user and a resolves YES/NO output from the system
		var userInput = new String();
		boolean flag = true;

		try {
			// Let's now process the user request and keep asking for user input for the purpose of real time testing...
			while (true) {
				var in = new Scanner(System.in);
				System.out.println("Type anything...");
				userInput = in.next();

				/* -----DITCHING JAVA FOR DATA_LOG IN FLIX & CLOJURE FOR LOGIC PROGRAMMING------
				 *
				 * -------------LEARNING THE FLIX PROGRAMMING LANGUAGE-------------------
				 *  ------------LEARNING THE CLOJURE PROGRAMMING LANGUAGE------------------
				 *  -----------LEARNING HIGH_LEVEL ABSTRACTIONS IN JAVA-----------------
				 *
				 *
				 *  -----------------!!THIS AN ANTIPATTERN!!--------------------
				// First we validate that the user is providing the expected input data
				flag = isBlank(userInput);

				// Handling error --------------DOES NOT WORK----------
				//if (flag != true)
				//	throw new IllegalArgumentException("You input is invalid!");
				
				// isBlank
				// If the answer is Yes then print invalid
                		if (flag)
                        		System.out.println("Your input " + userInput + " is valid");

                		// isNotBlank
                		// If the answer is NOW, then print invalid

                		if (!flag)
                        	System.out.println("Congratulations! You input is invalid");
				*/
				// -----------------------THERE ARE BETTER ABSTRACTION IN CLOJURE AND FLIX---------------------
			}

		} catch (Exception e) {
			System.out.println("Control flow agent successfully passed the try block!");
		}

		// If the answer is Yes then print invalid
		if (flag != true)
			System.out.println("Your input " + userInput + " is valid");

		// Now let's pressent the happy path output to user
		// If the answer is NOW, then print invalid

		if (flag == true)
			System.out.println("Congratulations! You input is invalid");

	}

	/**
	 * @param str the raw form of a String object parsed as a low level CharSequence object
	 * @return boolean 
	 * isBlank() checks to see whether a string is blank: either empty or consisting of only whitespaces
	 */
	public static boolean isBlank(final CharSequence str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
}
