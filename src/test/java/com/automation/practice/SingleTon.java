package com.automation.practice;

public class SingleTon {

	public static void main(String[] args) {
		A s = A.getInstance();
		A s1 = A.getInstance();
		s.show();s1.show();
		
		B b =B.INSTANCE;
		b.showagian();
	}
	
}

class A {
	
	static A instace;
	
	private A() {
		// TODO Auto-generated constructor stub
		System.out.println("I am private constructor");
	}
	
	public static A getInstance() {
		if(instace==null) {
			instace = new A();
		}
		return instace;
	}
	
	public void show() {
		System.out.println("Hello I am a private person");
	}
}

enum B{
	INSTANCE;
	
	public void showagian() {
		System.out.println("Hello I am from B");
	}
}