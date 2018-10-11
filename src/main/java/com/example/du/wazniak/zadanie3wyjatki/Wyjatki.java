package com.example.du.wazniak.zadanie3wyjatki;

import java.io.Closeable;
import java.util.Scanner;

public class Wyjatki {

	public static void main(String[] args) {
		example2();
	}

	private static void example1() {
		MyScanner scanner = null;
		try {
			scanner = new MyScanner();
			throw new RuntimeException("try");

			// } catch (RuntimeException e) {
			// System.out.println("Runtime exception ");
			// throw new RuntimeException("catch Runtime exception");
			// } catch (Exception e) {
			// System.out.println("Exception123 ");
		} finally {
			System.out.println("Finally");

			if (scanner != null)
				try {
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private static void example2() {
		try (Scanner scanner = new Scanner(System.in)) {
			throw new IllegalStateException("example2");
		}
	}

	private static class MyScanner implements Closeable {

		@Override
		public void close() {
			throw new RuntimeException("MyScanner.close()");
		}

	}
}
