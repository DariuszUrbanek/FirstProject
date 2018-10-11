package com.example.du.wazniak.zadanie3klasy;

import java.util.Arrays;

import com.example.du.util.ArrayAppender;

public class Liczba {
	private Integer[] cyfry = new Integer[5];

	public Liczba(String liczba) {
		for (int i = 0; i < liczba.toCharArray().length; i++) {
			cyfry = ArrayAppender.dodajElementDoTablicy(
					Integer.valueOf(Character.toString(liczba.toCharArray()[liczba.toCharArray().length - 1 - i])),
					cyfry, i);
		}
		
//		try {
//			
//		} catch(InnyWyjatek e) {
//			//nic nie robie, kontynuuje
//		} catch(EntityExistsException e) {
//			throw e;
//		} catch(Exception e) {
//			logger.error("jakis blad wystapil", e);
//			return null;
//		}
//		
//		//dalszy kod
	}
	
	public void mnozenie(int mnoznik) {
		int dziesiatki = 0;

		for (int i = 0; i < cyfry.length; i++) {
			int wynikMnozenia = (cyfry[i] == null ? 0 : cyfry[i]) * mnoznik + dziesiatki;
			int jednosci = wynikMnozenia % 10;
			dziesiatki = wynikMnozenia / 10;
			cyfry[i] = jednosci;
		}

		int liczbaKtoraSieNieMiesci = dziesiatki;
		int i = cyfry.length;
		while (liczbaKtoraSieNieMiesci > 0) {
			cyfry = ArrayAppender.dodajElementDoTablicy(liczbaKtoraSieNieMiesci % 10, cyfry, i);
			liczbaKtoraSieNieMiesci = liczbaKtoraSieNieMiesci / 10;
			i++;
		}
	}

	@Override
	public int hashCode() {
		Liczba liczba = normalize();

		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(liczba.cyfry);
		return result;
	}

	private Liczba normalize() {
		return new Liczba(toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Liczba other = (Liczba) obj;

		for (int i = 0; i < Math.min(this.cyfry.length, other.cyfry.length); i++) {
			if (this.cyfry[i] != other.cyfry[i])
				return ((this.cyfry[i] == null || this.cyfry[i] == 0)
						&& (other.cyfry[i] == null || other.cyfry[i] == 0));
		}

		for (int i = Math.min(this.cyfry.length, other.cyfry.length); i < Math.max(this.cyfry.length,
				other.cyfry.length); i++) {
			Integer cyfra = (this.cyfry.length > other.cyfry.length ? this.cyfry : other.cyfry)[i];
			if (cyfra != null && cyfra != 0)
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (int i = cyfry.length - 1; i >= 0; i--) {
			if (cyfry[i] != null)
				result.append(cyfry[i]);
		}
		return result.toString().replaceAll("^0+", "");
	}

	public static long silnia(long number) {
		long result = 1;
		if (number < 0)
			throw new IllegalArgumentException();
		if (number <= 1)
			return result;
		for (int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}
	
//	public static wypiszCosNaEkran()  {
//		try {
//			System.out.println(silniaRekurencja(pobierzNumerDomuZbazy()));
//		} catch(IllegalArgumentException e) {
//			throw new ZlyNumerDomuWBAzieException(e);
//		}
//	}
//
//	polecial ZlyNumerDomuWBAzieException:
//		at: 103
//		..
//	Caused by:
//		at: 117
//		...
	
	public static long silniaRekurencja(long number) {
		long result = 1;
		if (number < 0)
			throw new IllegalArgumentException();
		if (number <= 1)
			return result;
		return number * silniaRekurencja(number - 1);
	}
}
