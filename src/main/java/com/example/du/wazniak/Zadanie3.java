package com.example.du.wazniak;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Zadanie3 {
	private static final int[] liczbyPierwsze = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
	
	
	private static MyArrayList czynnikiPierwsze(int liczba) {
				
		MyArrayList list = new MyArrayList();
		
		for(int liczbaPierwsza : liczbyPierwsze)
			while(liczba % liczbaPierwsza == 0) {
				liczba = liczba / liczbaPierwsza;
				list.add(liczbaPierwsza);
			}

		return list;
	}

	public static int najwiekszyDzielnik(int liczba1, int liczba2) {
		
		MyArrayList dzielniki1 = czynnikiPierwsze(liczba1);
		MyArrayList dzielniki2 = czynnikiPierwsze(liczba2);	
		
		int result = 1;
			
		for(int liczbaPierwsza : liczbyPierwsze) {
			int min = Math.min(dzielniki1.countOf(liczbaPierwsza), dzielniki2.countOf(liczbaPierwsza));
			for(int i = 0; i < min; i++)
				result *= liczbaPierwsza;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(najwiekszyDzielnik(60,24));
	}

	
//	24 = (2 * 2) * 2 * (3)
//	60 = (2 * 2 * 3) * 5
	
	private static class MyArrayList extends ArrayList<Integer> {

		private static final long serialVersionUID = 1L;

		public int countOf(Integer element) {			
			Iterator<Integer> iterator = iterator();
			int count = 0;
			while(iterator.hasNext()) {
				Integer currentElement = iterator.next();
				if(element.equals(currentElement))
					count++;
			}
			return count;
		}
	}
}
