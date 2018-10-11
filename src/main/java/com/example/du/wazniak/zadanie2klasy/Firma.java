package com.example.du.wazniak.zadanie2klasy;

import com.example.du.util.Strings;

public class Firma {
	private Pracownik[] tabelaPracownikow = new Pracownik[100];
	private int liczbaPracownikow = 0;
	private String nazwa;

	public Firma(String nazwa) {
		if (Strings.isBlank(nazwa))
			// if(nazwa == null || nazwa.isEmpty()) --> Ten sam efekt co wy¿ej.
			throw new IllegalArgumentException("Nazwa firmy nie mo¿e byæ pusta osiole!");
		this.nazwa = nazwa;
	}

	public void dodajPracownika(Pracownik pracownik) {
		if (liczbaPracownikow > 100)
			throw new IllegalStateException("Za du¿o pracowników.");
		tabelaPracownikow[liczbaPracownikow] = pracownik;
		liczbaPracownikow++;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Witam w firmie " + nazwa + ". Oto pracownicy:\n");
		for (Pracownik chlop : tabelaPracownikow) {
			if (chlop != null) {
				result.append(chlop.toString()).append("\n");
			}
		}
		return result.toString();
	}
}

/*

[] ---> array
 
									Collection (Interface)
					 /                     |                    \
			 List (Interface):	    Set (Interface):		Map (Interface):
			           
				ex. ArrayList		ex.	HashSet           ex.   HashMap
					 
*/
