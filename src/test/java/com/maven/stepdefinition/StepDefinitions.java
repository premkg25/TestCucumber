package com.maven.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.maven.baseclass.BaseClass;
import com.maven.pom.MAP_CartPage;
import com.maven.pom.MAP_EnterEmailAndSignIn;
import com.maven.pom.MAP_HomePage;
import com.maven.pom.MAP_MyAccountPage;
import com.maven.pom.MAP_RegistrationDetails;
import com.maven.pom.MAP_SelectItems;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends BaseClass {
	static WebDriver driver;
	
	

	@Given("^user prefers to launch chrome browser$")
	public void user_prefers_to_launch_chrome_browser() throws Throwable {
		String Bn = System.getProperty("BrowserName");
		if (Bn.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (Bn.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		Thread.sleep(10000);
	}

	@When("^User verify Amazon$")
	public void user_verify_system_info() throws InterruptedException, Throwable {
		driver.get("https://www.amazon.in");
		Thread.sleep(10000);
		
	}

	@When("^User verify facebook$")
	public void user_verify_fa() throws InterruptedException, Throwable {
		driver.get("https://www.facebook.com");
		Thread.sleep(10000);
		
	}
}