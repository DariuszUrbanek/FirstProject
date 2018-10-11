package com.example.du;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoApplication {

	private static String field = "Ala ma kota";

	private static AtomicReference<String> field2 = new AtomicReference<String>("Ala ma kota");

	private static class Printer {

		private Supplier<String> fieldReferenceSupplier;

		public Printer(Supplier<String> printerField) {
			this.fieldReferenceSupplier = printerField;
		}

		public void print() {
			System.out.println(fieldReferenceSupplier.get());
		}

	}

	private static class Printer2 {

		private AtomicReference<String> fieldReferenceSupplier;

		public Printer2(AtomicReference<String> printerField) {
			this.fieldReferenceSupplier = printerField;
		}

		public void print() {
			System.out.println(fieldReferenceSupplier.get());
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Supplier<String> supplier = () -> field;

		Printer printer = new Printer(() -> field); // to samo
		Printer printerA = new Printer(supplier); // to samo
		Printer printerB = new Printer(DemoApplication::getField); // to samo
		field = "Zosia ma psa";
//		printer.print();

		Printer2 printer2 = new Printer2(field2);
		field2.set("Zosia ma psa");
//		printer2.print();

//		reduceCount();
//
//		joinStrings();
//
//		spelling();
//		
//		sumMinMax();
//		
//		longestString();
//		
//		containsU();		
//		containsAndrzej();
		aaaaeeeeeeeeeeeeeString();

	}

	public static class Pair<T> {
		
		public T first;
		public T second;
		
		public Pair() {}

		public Pair(T first, T second) {
			this.first = first;
			this.second = second;
		}
		
		public static <T> Pair<T> of(T first, T second) {
			return new Pair<T>(first,second);
		}

	}

	private static void sumMinMax() {
		List<Integer> list = Arrays.asList(154,232,3,54,122,87,45,23,5,65,6,7,8,9,5,234,54,345,234,123,432,321,6,7,88,9,54);

		Integer min = list.stream().reduce(Integer.MAX_VALUE, (a,b) -> a > b ? b : a);
		Integer max = list.stream().reduce(Integer.MIN_VALUE, (a,b) -> a < b ? b : a);
		
		System.out.println(min + max);		
	}
	
	private static void longestString() {
		List<String> list = Arrays.asList("Janusz","Bogdanowicz", "surykatka", "kormoran","ja");

		String longest = list.stream().reduce("", (a,b) -> a.length() < b.length() ? b : a);
		
		System.out.println(longest);		
	}
	
	private static void containsU() {
		List<String> list = Arrays.asList("Janusz","Bogdanowicz", "surykatka", "kormoran","ja");

		String containsU = list.stream().reduce("", (a,b) -> b.contains("u") ? b : a);
		
		System.out.println(containsU);		
	}
	
	private static void containsAndrzej() {
		List<String> list = Arrays.asList("Janusz","Bogdanowicz", "Andrzej","surykatka", "kormoran","ja", "Andrzejewski");

		String contains = list.stream().reduce("figa", (a,b) -> b.equals("Andrzej") ? b : a);
		
		System.out.println(contains);		
	}
	
	private static void aaaaeeeeeeeeeeeeeString() {
		List<String> list = Arrays.asList("Janusz","Bogdanowicz", "Andrzej","surykatka", "kormoran","ja", "Andrzejewski");

		String contains = list.stream().reduce("", (a,b) -> a + b.replaceAll("[^aeiouyAEIOUY]", ""));
		
		System.out.println(contains);		
	}
	
	private static void joinStrings() {
		List<String> lista = Arrays.asList("ala", "ma", "kota");

		String result = lista.stream().reduce("", (x, y) -> !x.isEmpty() ? x + " " + y : y);
		System.out.println("'" + result + "'");

		System.out.println(lista.stream().collect(Collectors.joining(" ", "'", "'")));
	}

	private static void reduceCount() {
		int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);

		System.out.println(count);
	}

	public static String getField() {
		return field;
	}

	public static void spelling() {

		Function<String, Stream<Character>> speller = s -> s.chars().mapToObj(c -> new Character((char) c));

		System.out.println(speller.apply("Darkoslaw").collect(Collectors.toList()));

		System.out.println("===================================================\nresult of using: Stream.map()");
		System.out.println(Stream.of("Ala", "ma", "kota").map(DemoApplication::spell).collect(Collectors.toList()));
		// = Stream.of(Stream.of("A", "l", "a"), Stream.of("m","a"), Stream.of("k", "o",
		// "t", "a"));

		System.out.println("===================================================\nresult of using: Stream.flatMap()");
		System.out.println(Stream.of("Ala", "ma", "kota").flatMap(s -> s.chars().mapToObj(c -> new Character((char) c)))
				.collect(Collectors.toList())); // = [A, l, a, m, a, k, o, t, a]
	}

	public static Stream<Character> spell(String string) {
		Function<String, Stream<Character>> speller = s -> s.chars().mapToObj(c -> new Character((char) c));
		return speller.apply(string);
	}

}
