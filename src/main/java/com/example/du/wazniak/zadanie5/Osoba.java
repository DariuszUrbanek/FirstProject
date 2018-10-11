package com.example.du.wazniak.zadanie5;

/*
 * Napisz program sk³adaj¹cy siê z dwu klas, umieszczonych w dwu plikach (ale w jednym pakiecie). 
 * Jeden plik ma zawieraæ definicjê klasy Osoba 
 * (z imieniem i nazwiskiem oraz metodami pozwalaj¹cymi na odczytywanie i zapisywanie tych atrybutów oraz konstruktorem), 
 * drugi ma wczytaæ od u¿ytkownika dane 10 osób, zapamiêtaæ je w tablicy osób, a nastêpnie wypisaæ w odwrotnej kolejnoœci.
 */

public class Osoba {
	private String imie;
	private String nazwisko;

	@Override
	public String toString() {
		return imie + " " + nazwisko;
	}

	public Osoba(String imie, String nazwisko) {
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

}
