package com.example.du;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.example.du.WashingMachine;

public class WashingMachineTest {

	private WashingMachine washingMachine;
	
	@Ignore
	@Test
	public void test() {
		WashingMachine washingMachine = new WashingMachine();
		this.washingMachine = washingMachine;
		washingMachine.name = "Moja pralka";
		
		washingMachine = new WashingMachine();
		washingMachine.name = "Druga pralka";
		
		this.washingMachine = new WashingMachine();
		this.washingMachine.name = "Trzecia pralka";
		
		assertTrue(this.washingMachine.name != null);
		
		System.out.println(washingMachine.name);
		System.out.println(this.washingMachine.name);
	}
	
	@Test
	public void washTest() throws InterruptedException {
		WashingMachine washingMachine = new WashingMachine();
		washingMachine.name = "Szybka pralka";
		washingMachine.wash();
		
		new WashingMachine("Wolna pralka", 3000).wash();
		
		WashingMachine.staticMethod();
	}
}
