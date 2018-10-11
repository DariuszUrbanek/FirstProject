package com.example.du.wazniak.zadanie1klasy;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.junit.Test;


public class DataTest {
	@Test //Adnotacja eng. "Annotation"
	public void dodajDzienTest() {
		Data data = new Data(31, 5, 2017);
		data.dodajDzien();
		assertEquals(data, new Data(1, 6, 2017));
	}
	
	@Test
	public void dodajDzienTest2() {
		Data data = new Data(30, 8, 2017);
		data.dodajDzien();
		assertEquals(data, new Data(31, 8, 2017));
	}
	
	@Test
	public void dodajMiesiacTest() {
		Data data = new Data(24, 12, 1980);
		data.dodajMiesiac();
		assertEquals(data, new Data(24, 1, 1981));
	}
	
	@Test
	public void dodajMiesiacTest2() {
		Data data = new Data(30, 01, 2000);
		data.dodajMiesiac();
		assertEquals(data, new Data(28, 2, 2000));
	}
	
	@Test
	public void odejmijDzienTest() {
		Data data = new Data(1, 1, 1980);
		data.odejmijDzien();
		assertEquals(data, new Data(31, 12, 1979));
	}
	
	@Test
	public void odejmijDzienTest2() {
		Data data = new Data(1, 3, 2020);
		data.odejmijDzien();
		assertEquals(data, new Data(28, 2, 2020));
	}
	
	@Test
	public void odejmijMiesiacTest() {
		Data data = new Data(23, 1, 2020);
		data.odejmijMiesiac();
		assertEquals(data, new Data(23, 12, 2019));
	}
	
	@Test
	public void odejmijMiesiacTest2() {
		Data data = new Data(31, 3, 2020);
		data.odejmijMiesiac();
		assertEquals(data, new Data(28, 2, 2020));
	}
	
	@Test
	public void odejmijTydzienTest() {
		Data data = new Data(3, 1, 2020);
		data.odejmijTydzien();
		assertEquals(data, new Data(27, 12, 2019));
		
	}
	
	@Test
	public void dodajTydzienTest() {
		Data data = new Data(27, 12, 2019);
		data.dodajTydzien();
		assertEquals(data, new Data(3, 1, 2020));
		
	}
	
//	@Test
//	public void test() {
////		System.out.println(new Data());
//		System.out.println(ZoneId.getAvailableZoneIds());
//				
//		Instant instant = Instant.now();
//		Duration duration = Duration.between(
//				LocalDateTime.ofInstant(instant,ZoneId.of("America/Cuiaba")), 
//				LocalDateTime.ofInstant(instant,ZoneId.of("Europe/London")));
//		System.out.println(duration.toNanos() / 1000000000. / 60. / 60.);
//	}
	
}
	
	
