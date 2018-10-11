package com.example.du;

public class WashingMachine {
	private static String staticField = "tre�� pola klasowego"; 
	
	String name;
	long duration;
	
	public WashingMachine() {}
	
	public WashingMachine(String name, long duration) {
		this.name = name;
		this.duration = duration;
	}
	
	public void wash() throws InterruptedException {
		System.out.println(name + ": No to pior�");
		Thread.sleep(duration);
		System.out.println(name + ": No i sko�czy�em pra�");
	}
	
	public static void staticMethod() { //metoda klasowa
		System.out.println(staticField);
	}
}
