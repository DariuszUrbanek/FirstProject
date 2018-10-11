package com.example.du.polymorphism;

import org.junit.Test;

public class Polymorphism {

	@Test
	public void test() {
		
		A a;
		a = new A();
		System.out.println(a.field);
		a.print();
		
		System.out.println("=====");
		
		A a2;
		a2 = new B();
		System.out.println("//Fields are not polymorphic:");
		System.out.println("//Reference type A:");
		System.out.println(a2.field);
		System.out.println("//Reference type B:");
		B b = (B) a2;
		System.out.println(b.field);
		System.out.println("//Methods are polymorphic:");
		System.out.println("//Reference type A:");
		a2.print(); //direct external call
		System.out.println("//Reference type B:");
		B b2 = (B) a2;
		a2.print();
		System.out.println("\nA.executeInnerMethodField():");
		a2.executeInnerMethodField(); //non-direct internal call
		System.out.println("(Polymorphism still works!)");
		
		System.out.println("");
		System.out.println("//B methods can @Override A methods. The actual object type matters.");
		System.out.println("//B fields can only hide A fields. The reference type matters.");
		
		//Polymorphism short:
		//When accessing class fields reference type matters.
		//When running class methods actual object type matters.
	}

	public static class A {

		public String field = "This is A.field";
		
		public void print() {
			System.out.println("Hello from A!");
		}
		
		public void executeInnerMethodField() {
			print();
		}
		
	}
	
	public static class B extends A {
		
		//@Override //Illegal: "The annotation @Override is disallowed for this location"
		public String field = "This is B.field";
		//using "super.field" one can access super type's field
		
		@Override
		public void print() {
			System.out.println("hello from B!");
		}
				
	}

}
