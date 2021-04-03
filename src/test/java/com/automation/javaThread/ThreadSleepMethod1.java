package com.automation.javaThread;

class ThreadSleepMethod1 extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		ThreadSleepMethod1 t1 = new ThreadSleepMethod1();
		ThreadSleepMethod1 t2 = new ThreadSleepMethod1();
		ThreadSleepMethod1 t3 = new ThreadSleepMethod1();
		ThreadSleepMethod1 t4 = new ThreadSleepMethod1();

		
		  t1.start(); t2.start(); t3.start(); t4.start();
		 
		
//		  t1.run(); t2.run(); t3.run(); t4.run();
		 
	}
}
