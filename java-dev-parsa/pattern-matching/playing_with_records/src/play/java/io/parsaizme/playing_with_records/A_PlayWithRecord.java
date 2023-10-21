///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.playing_with_records;

import static java.lang.System.*;

import java.util.List;
import java.util.*;

public class A_PlayWithRecord {

	/**
	 * A record cannot be extended:)
	 *
	 * @param begin is a single component of a record
	 * @param end is another component
	 *
	 * <p>With these components, the compiler gives a constructor for free
	 *    The compiler also gives me accessors, toString, hashCode methods for free
	 *    The record components are mapped to instance fields of the record for free and they are final
	 *    A record is an object that is immutable
	 *    It is legal to have static fields in a record
	 * <p>
	 */
	
	/*
	record Range(int begin, int end) {
	}
	*/

	/**
	 * I would write my own constructor that overrides the one I get for free with the compiler in the following two sceanrios:
	 *
	 * (1) When I have a list data type in my record declaration, where it is desirable to have a different copy of the list for computation and so writing my own constructor is neat
	 *
	 * (2) When doind some kind of validation
	 *
	 */

	/* I would get a different copy of the list to avoid mutation from the outside world of this record
	record Range(int begin, int end, List<String> strings) {

		Range(int begin, int end, List<String> strings) {
			this.begin = begin;
			this.end = end;
			this.strings = List.copyOf(strings);
		}
	}
	*/

	/* ----WE CAN MAKE IT CLEANER----
	// Secondly, I could want to do some kind of classic validation on the components of my record, then I may override the free constructor
	// ----THIS IS THE CANNONICAL CONSTRUCTOR-----
	record Range(int begin, int end) {

		Range(int begin, int end) {
			if (end < begin)
				throw new IllegalArgumentException("Begin is greater than end");
			this.begin = begin;
			this.end = end;
		}
	}
	*/


	/*
	// -----COMPACT CONSTRUCTOR---------
	record Range(int begin, int end) {

		Range{
			if (end < begin)
				throw new IllegalArgumentException("Begin is greater than end");
		}

		// SECURITY CONSIDERATION
		// Suppose I want to create a constructor that only takes the `end` component of this record
		// Constructor overloading BUT IT HAS TO BE A CANNONICAL CONSTRUCTOR
		// 
		// There is one EXCEPTION, i.e., DESERIALIZATION since desirailization bypasses this validation rule since when this happens no constructor is called - SECURITY BREACH!!
		Range(int end) {
			this(0, end);
		}

	}
	*/

	/**
	 * Just like a class, a record can implement any Java Interface
	 */

	record Range(int begin, int end) implements Iterable<Integer> {

		Range{
			if (end < begin)
				throw new IllegalArgumentException("Begin is greater than end");
		}

		Range(int end) {
			this(0, end);
		}

		@Override
		public Iterator<Integer> iterator() {
			// An Anonymous class🥸
			return new Iterator<>() {
				int index = begin;
				@Override
				public boolean hasNext() {
					return index < end;
				}

				@Override
				public Integer next() {
					return index++; 
				}
			};
		}
	}

	public static void main(String[] args) {

		Range range = new Range(0, 5);
		System.out.println("range = " + range);
		System.out.println("begin = " + range.begin());
		System.out.println("keep going...");
		
		for (var value : range) {
			System.out.println("value = " + value);
		}
	}
}
