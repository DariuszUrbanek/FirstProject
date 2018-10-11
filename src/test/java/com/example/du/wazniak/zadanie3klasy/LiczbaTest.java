package com.example.du.wazniak.zadanie3klasy;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiczbaTest {

	@Test
	public void test() {
//		Liczba liczba = new Liczba(String.valueOf(52768L));
//		liczba.mnozenie(58394);
//		
//		assertEquals(liczba, new Liczba(String.valueOf(52768L * 58394L)));

		System.out.println(Liczba.silnia(4));
		assertEquals(Liczba.silnia(4), 24L);
		
		System.out.println(Liczba.silniaRekurencja(4));
	
	}

}
