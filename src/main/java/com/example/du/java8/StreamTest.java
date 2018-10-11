package com.example.du.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamTest {
	char r = 'r';

	@Test
	public void test() {

		List<String> list = Arrays.asList("My", "name", "is", "Dariusz", "your", "mother", "name", "is", "Ewa");

		boolean test = list.stream().allMatch(d -> d.toLowerCase().charAt(0) < 'o');

		long count = list.stream().distinct().count();

		List<String> lista = list.stream().filter(a -> a.length() > 3).collect(Collectors.toList());

		// list.stream().forEach(a -> System.out.println(a));

		// list.stream().peek(a -> System.out.println(a)).limit(3).forEach(a ->
		// System.out.println(a)); //good example

		// list.stream().map(z -> z.length()).forEachOrdered(System.out::println);

		String string = list.stream().map(z -> z.length()).map(String::valueOf)
				.collect(Collectors.joining(",", "[", "]"));

		System.out.println(string);
	}

}
