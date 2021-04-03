package com.automation.javaThread;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiTaskingThread extends Thread{
	
	public MultiTaskingThread(String url) {
		// TODO Auto-generated constructor stub
		run(url);
	}
	
	public void run(String url) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Title : "+driver.getTitle());
		driver.quit();
	}
	
	
	public static void main(String[]a){
		MultiTaskingThread t1 = new MultiTaskingThread("https://google.com");
		MultiTaskingThread t2 = new MultiTaskingThread("https://bing.com");
		MultiTaskingThread t3 = new MultiTaskingThread("https://facebook.com");
		
		t1.start();t2.start();t3.start();
	}

}
