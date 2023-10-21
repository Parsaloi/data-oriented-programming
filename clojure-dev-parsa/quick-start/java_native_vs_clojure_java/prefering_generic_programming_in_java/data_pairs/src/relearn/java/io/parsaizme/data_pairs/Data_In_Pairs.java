///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.data_pairs;

import static java.lang.System.*;

import java.time.*;

public class Data_In_Pairs {

	public static void main(String[] args) {

		LocalDate[] birthdays = 
			{
				LocalDate.of(1906, 12,  9), // Grace Hopper
				LocalDate.of(1815, 12, 10), // Ada Lovelance
				LocalDate.of(1903, 12, 3), // John von Neumann
				LocalDate.of(1910, 6, 22), // K. Zuse
			};

		Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());
	}
}

class ArrayAlg {

	/**
	 * Get the minimum and maximum of an array of object of generic type T
	 *
	 * @param arr an array of objects of generic type T
	 * @return a pair with the `min` and `max` values, or null if `arr` is null or empty
	 */

	public static <T extends Comparable> Pair<T> minimax(T[] arr) {

		if (arr == null || arr.length == 0)
			return null;

		T min = arr[0];
		T max = arr[0];

		// ATTENTION!! Prefer Lambda expressions to for loops
		for (int i = 1; i < arr.length; i++) {
			if (min.compareTo(arr[i]) > 0) min = arr[i];
			if (max.compareTo(arr[i]) < 0 ) max = arr[i];
		}

		return new Pair<>(min, max);
	}
}
