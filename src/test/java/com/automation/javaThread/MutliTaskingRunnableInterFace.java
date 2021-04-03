package com.automation.javaThread;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MutliTaskingRunnableInterFace {

	public static void main(String[] c) {

		Runnable r1 = new Runnable() {

			public void run() {

				WebDriver driver;
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://google.com");
				System.out.println("Title : " + driver.getTitle());
				driver.quit();
			}
		};

		Thread t1 = new Thread(r1);
		t1.start();

	}
}
