package com.example.du.wazniak.zadanie2klasy;

import com.example.du.wazniak.zadanie5.Osoba;

public class Pracownik extends Osoba {
	private String stanowisko;

	public Pracownik(String imie, String nazwisko, String stanowisko) {
		super(imie, nazwisko);
		this.stanowisko = stanowisko;

	}
	
	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	@Override
	public String toString() {
		return "Pracownik " + super.toString() + " zajmuje stanowisko " + stanowisko + ".";
	}

}
