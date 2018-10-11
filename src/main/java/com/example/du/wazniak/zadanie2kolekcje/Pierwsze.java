package com.example.du.wazniak.zadanie2kolekcje;

import java.util.ArrayList;
import java.util.Iterator;

public class Pierwsze implements Iterator<Long> {

	ArrayList<Long> pierwsze = new ArrayList<Long>();

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Long next() {

		Long last = pierwsze.isEmpty() ? 1L : pierwsze.get(pierwsze.size() - 1);

		Long candidate = last + 1;

		while (!czyPierwsza(candidate)) {
			candidate++;
		}

		pierwsze.add(candidate);

		return candidate;
	}

	private boolean czyPierwsza(Long candidate) {
		for (Long pierwsza : pierwsze) {
			if(pierwsza > Math.sqrt(candidate)) {
				break;				
			}
			if (candidate % pierwsza == 0) {
				return false;
			}
		}
		return true;
	}

}
