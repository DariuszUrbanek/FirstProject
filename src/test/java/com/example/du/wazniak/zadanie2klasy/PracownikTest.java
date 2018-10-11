package com.example.du.wazniak.zadanie2klasy;

import org.junit.Test;

public class PracownikTest {

	@Test
	public void test() {
		Pracownik pracownik = new Pracownik("Janusz", "Kowalski", "Miszcz programuf");
		System.out.println(pracownik);
	}

}
