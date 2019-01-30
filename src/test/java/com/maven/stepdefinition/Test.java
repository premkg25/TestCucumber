package com.maven.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException, Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		Thread.sleep(10000);
		driver.findElement(By.id("photo")).click();
		Runtime.getRuntime().exec("E:\\Test\\Mav_AutomationPractise\\src\\test\\java\\com\\maven\\stepdefinition\\TestAuto.exe");
	}
}
