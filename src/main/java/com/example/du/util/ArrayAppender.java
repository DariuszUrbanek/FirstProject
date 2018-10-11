package com.example.du.util;

import java.lang.reflect.Array;

public class ArrayAppender {
	
	public static <E> void przepisz(E[] source, E[] destination) {
		for(int i=0; i<source.length; i++) {
			destination[i] = source[i];
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <E> E[] dodajElementDoTablicy(E element, E[] tablica, int index) {
		if(index<tablica.length) {
			tablica[index] = element;
			return tablica;
		} else {
			E[] nowaTablica = (E[]) Array.newInstance(element.getClass(), tablica.length*2);
			przepisz(tablica, nowaTablica);
			nowaTablica[index] = element;
			return nowaTablica;
		}
	}

}
