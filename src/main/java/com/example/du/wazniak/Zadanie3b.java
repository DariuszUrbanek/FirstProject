package com.example.du.wazniak;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Zadanie3b {
	private static final List<Integer> liczbyPierwsze = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
	
	private static List<Integer> czynnikiPierwsze(int liczba) {
		return liczbyPierwsze.stream().flatMap(lp -> IntStream.range(1,10).filter(l -> liczba % ((int) Math.pow(lp, l)) == 0).mapToObj(l -> lp)).collect(Collectors.toList());
	}
	
	public static int najwiekszyDzielnik(int liczba1, int liczba2) {			
		List<Integer> dzielniki1 = czynnikiPierwsze(liczba1);
		List<Integer> dzielniki2 = czynnikiPierwsze(liczba2);	
	
		return liczbyPierwsze.stream().map(e -> (int) Math.pow(e,Math.min(countOf(e,dzielniki1), countOf(e,dzielniki2)))).reduce((e1,e2) -> e1 * e2).get();
	}
	
	public static void main(String[] args) {
		System.out.println(najwiekszyDzielnik(60,24));
	}

	public static int countOf(Integer element, List<Integer> list) {
		return (int) list.stream().filter(e -> e.equals(element)).count();
	}
}
