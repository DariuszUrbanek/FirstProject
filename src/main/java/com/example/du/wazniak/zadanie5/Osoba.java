package com.example.du.wazniak.zadanie5;

/*
 * Napisz program sk�adaj�cy si� z dwu klas, umieszczonych w dwu plikach (ale w jednym pakiecie). 
 * Jeden plik ma zawiera� definicj� klasy Osoba 
 * (z imieniem i nazwiskiem oraz metodami pozwalaj�cymi na odczytywanie i zapisywanie tych atrybut�w oraz konstruktorem), 
 * drugi ma wczyta� od u�ytkownika dane 10 os�b, zapami�ta� je w tablicy os�b, a nast�pnie wypisa� w odwrotnej kolejno�ci.
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
