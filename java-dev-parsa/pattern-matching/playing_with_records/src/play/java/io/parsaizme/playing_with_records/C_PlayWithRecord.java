///usr/bin/env jbang "$0" "$@" ; exit $?

package io.parsaizme.playing_with_records;

import static java.lang.System.*;

import java.util.List;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class C_PlayWithRecord {

	/* ----PREVIOUS LESSON * Java record FUNDAMENTALS----------
	record Range(int begin, int end) implements Iterable<Integer> {

		// THE COMPACT CONSTRUCTOR
		Range{
			if (end < begin)
				throw new IllegalArgumentException("Begin is greater than end");
		}

		// CONSTRUCTOR OVERLOADING
		Range(int end) {
			this(0, end);
		}

		@Override
		public Iterator<Integer> iterator() {
			// An anonymous class 🥸
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
	*/

	// Since the `Serializable` interface projects a secuity vulnerability by bypassing constructors
	
	static record RangeRecord(int begin, int end) implements Serializable {

		RangeRecord{
			//if (end < begin) {
			//	throw new IllegalArgumentException("End must be greater than begin");
			//}
		}
	}

	static class RangeClass implements Serializable {

		private final int begin;
		private final int end;

		RangeClass(int begin, int end) {
			
			/**TESTING DESERIALIZATION USING THE RANGE CLASS*/
			if (begin > end) {
				throw new IllegalStateException("Begin must be smaller than end");
			
			}
			this.begin = begin;
			this.end = end;
			System.out.println("Running Range class constructor");
		}

		@Override
		public String toString() {
			return "Range{" +
				"begin=" + begin +
				", end=" + end +
				'}';
		}
	}
	
	public static void main(String... args) throws IOException, ClassNotFoundException {

		/* ----PREVIOUS LAB LESSON * TESTING Java record funtional behaviour-----
		Range range = new Range(0, 5);
		System.out.println("range = " + range);
		System.out.println("begin = " + range.begin());
		System.out.println("keep going...");

		for (var value : range) {
			System.out.println("value = " + value);
		}
		*/

		//var range = new RangeRecord(10, 0);
		//System.out.println("range = " + range);

		//var fos = Files.newOutputStream(Path.of("files/range-10-0.dat"));
		//var oos = new ObjectOutputStream(fos);

		//oos.writeObject(range);

		/**DESRIALIZING TO TEST IF THE VALIDATION RULE WILL BE BROKEN??*/
		 var is = Files.newInputStream(Path.of("files/range-10-0.dat"));
		 var ois = new ObjectInputStream(is);
		 System.out.println("Reading range");
		 var readRange = ois.readObject();
		 System.out.println("readRange = " + readRange);

	}
}
