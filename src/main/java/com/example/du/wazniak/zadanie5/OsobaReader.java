package com.example.du.wazniak.zadanie5;

import java.util.Arrays;
import java.util.Scanner;

import com.example.du.util.Strings;

public class OsobaReader {
	
private static final int SIZE = 3;

	private static Osoba readOsoba(Scanner input) {

		System.out.println("Podaj imie: ");
		String imie = input.nextLine();

		System.out.println("Podaj nazwisko: ");
		String nazwisko = input.nextLine();

		return new Osoba(imie, nazwisko);

	}
	
	private static void przepisz(Osoba[] source, Osoba[] destination) {
		for(int i=0; i<source.length; i++) {
			destination[i] = source[i];
		}
	}
	
	private static Osoba[] dodajOsobeDoTablicy(Osoba osoba, Osoba[] tablicaOsob, int index) {
		if(index<tablicaOsob.length) {
			tablicaOsob[index] = osoba;
			return tablicaOsob;
		} else {
			Osoba[] nowaTablicaOsob = new Osoba[tablicaOsob.length*2];
			przepisz(tablicaOsob, nowaTablicaOsob);
			nowaTablicaOsob[index] = osoba;
			return nowaTablicaOsob;
		}
	}

	public static void main(String[] args) {	
		int counter = 0;
		
		Osoba[] osoby = new Osoba[SIZE];

		try (Scanner input = new Scanner(System.in)) {
			while (true) {

				Osoba readOsoba = readOsoba(input);
				
				if(Strings.isBlank(readOsoba.getNazwisko()))
					break;
				
				osoby = dodajOsobeDoTablicy(readOsoba, osoby, counter);
				
				counter++;
			}
		}

		for (int i = counter - 1; i >= 0; i--) {
			System.out.println(osoby[i]);
		}

		System.out.println(Arrays.asList(osoby));
	}

	
}
