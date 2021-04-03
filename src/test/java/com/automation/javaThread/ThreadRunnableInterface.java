package com.automation.javaThread;

public class ThreadRunnableInterface {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println("Hello");
		});
		
		Thread t2 = new Thread(()->{
			System.out.println("Hey");
		});
		
		t1.start();
		t2.start();  
	}
	
}
