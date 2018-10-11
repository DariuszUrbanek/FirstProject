package com.example.du;

public class WashingMachine {
	private static String staticField = "treœæ pola klasowego"; 
	
	String name;
	long duration;
	
	public WashingMachine() {}
	
	public WashingMachine(String name, long duration) {
		this.name = name;
		this.duration = duration;
	}
	
	public void wash() throws InterruptedException {
		System.out.println(name + ": No to piorê");
		Thread.sleep(duration);
		System.out.println(name + ": No i skoñczy³em praæ");
	}
	
	public static void staticMethod() { //metoda klasowa
		System.out.println(staticField);
	}
}
