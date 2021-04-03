package com.automation.javaThread;

import org.testng.annotations.Test;

public class ThreadImplementingRunnable implements Runnable{

	
	@Test
	public void test1() {
		Runnable t1 = new ThreadImplementingRunnable();
		Thread t = new Thread(t1);
		t.start();
	}

	public void run() {
		System.out.println("Thread is running... Is it?");
	}
}
