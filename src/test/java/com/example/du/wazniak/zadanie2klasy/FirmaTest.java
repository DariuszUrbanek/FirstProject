package com.example.du.wazniak.zadanie2klasy;

import org.junit.Test;

public class FirmaTest {

	@Test
	public void test() {
		Firma firma = new Firma("Januszex");
		firma.dodajPracownika(new Pracownik("Janusz", "Kulczyk", "Niezbyt dobry miszcz programuf"));
		System.out.println(firma);
	}

}
