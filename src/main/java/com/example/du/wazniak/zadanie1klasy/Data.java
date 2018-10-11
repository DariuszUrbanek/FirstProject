package com.example.du.wazniak.zadanie1klasy;

import java.time.LocalDate;

/*
 * Zdefiniuj klasê opisuj¹c¹ datê. Zastanów siê nad wyborem wewnêtrznej reprezentacji dat. 
 * Zdefiniuj metody pozwalaj¹ce na odczytywanie bie¿¹cej daty i przestawianie jej o jeden tydzieñ w przód i w ty³. 
 * Zadbaj o dobranie odpowiednich modyfikatorów dostêpu do sk³adowych.
 */

public class Data {
	private int rok;
	private int miesiac;
	private int dzien;

	private static final int[] DNI_W_MIESIACU = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public Data() {

		LocalDate localDate = LocalDate.now();
		rok = localDate.getYear();
		miesiac = localDate.getMonthValue();
		dzien = localDate.getDayOfMonth();

		// Calendar calendar = Calendar.getInstance();
		// rok = calendar.get(Calendar.YEAR);
		// miesiac = calendar.get(Calendar.MONTH) + 1;
		// dzien = calendar.get(Calendar.DAY_OF_MONTH);
	}

	public Data(int dzien, int miesiac, int rok) {
		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;

		if (miesiac <= 0 || miesiac > 12) {
			throw new IllegalArgumentException("Nieprawid³owy miesi¹c osiole! Poda³eœ miesi¹c: " + miesiac);
		}

		if (dzien < 1 || dzien > DNI_W_MIESIACU[miesiac - 1]) {
			throw new IllegalArgumentException("Nieprawid³owy dzieñ osiole! Poda³eœ dzieñ: " + dzien);
		}
	}

	@Override
	public String toString() {
		return "Data [rok=" + rok + ", miesiac=" + miesiac + ", dzien=" + dzien + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dzien;
		result = prime * result + miesiac;
		result = prime * result + rok;
		return result;
	}

	// je¿eli a.equals(b) to a.hashCode() == b.hashCode()
	// jezeli a.hashCode() == b.hashCode() to niekoniecznie a.equals(b)

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (dzien != other.dzien)
			return false;
		if (miesiac != other.miesiac)
			return false;
		if (rok != other.rok)
			return false;
		return true;
	}

	public void dodajDzien() {

		if (dzien == DNI_W_MIESIACU[miesiac - 1]) {
			dzien = 1;
			dodajMiesiac();
		} else {
			dzien++;
		}
	}

	public void dodajMiesiac() {
		if (miesiac == 12) {
			miesiac = 1;
			rok++;
		} else {
			miesiac++;
		}
		dzien = Math.min(dzien, DNI_W_MIESIACU[miesiac - 1]);
	}

	public void dodajLata(int ile) {
		rok += ile;
	}

	public void odejmijDzien() {
		if (dzien == 1) {
			odejmijMiesiac();
			dzien = DNI_W_MIESIACU[miesiac - 1];
		} else {
			dzien--;
		}
	}

	public void odejmijMiesiac() {
		if (miesiac == 1) {
			miesiac = 12;
			rok--;
		} else {
			miesiac--;
		}
		dzien = Math.min(dzien, DNI_W_MIESIACU[miesiac - 1]);
	}

	public void dodajTydzien() {
		for (int i = 0; i < 7; i++) {
			dodajDzien();
		}
	}

	public void odejmijTydzien() {
		for (int i = 0; i < 7; i++) {
			odejmijDzien();
		}
	}

}
