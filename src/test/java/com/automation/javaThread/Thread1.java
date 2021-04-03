package com.automation.javaThread;

import org.testng.annotations.Test;

public class Thread1 extends Thread{

	public void run() {
		System.out.println("Thread is running");
	}
	
	@Test
	public void test1() {
		Thread1 t1 = new Thread1();
		t1.start();
	}
}
