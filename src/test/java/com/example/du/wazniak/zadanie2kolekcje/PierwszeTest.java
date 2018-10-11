package com.example.du.wazniak.zadanie2kolekcje;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class PierwszeTest {
	
	private static final List<Long> pierwsze = Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L);
	
	
	@Test
	public void test () {		
		Iterator<Long> iterator = new Pierwsze();
		
		for(Long pierwsza: pierwsze) {
			assertTrue(pierwsza.equals(iterator.next()));			
			
		}		
	}	
}
