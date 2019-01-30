package com.maven.baseclass;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BaseClass 
{
	public static WebDriver driver;

	public static WebDriver browser_LaunchIgnoreCase(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\AutomationPractiseMavenProject\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

		else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.geiko.driver", "C:\\Users\\HP\\eclipse-workspace\\AutomationPractiseMavenProject\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\HP\\eclipse-workspace\\AutomationPractiseMavenProject\\driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Is not a valid browser");
		}
		return driver;
		
	}

	public static void launchURL(String url) throws Exception {
		try {
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("URL is incorrect");
		}
	}

	public static void elementClick(WebElement element) throws Exception {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not clickable");
		}
	}

	public static void elementClear(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to clear the text in the webelement");
		}
	}

	public static void elementSendKeys(WebElement element, String value) throws Exception {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the webelement");
		}
	}

	public static String getElementText(WebElement element) throws Exception {
		try {
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}
	}

	public static String getElementAttribute(WebElement element, String value) throws Exception {
		try {
			String attribute = element.getAttribute(value);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get the text from the webelement");
		}
	}

	/*
	 * public void selectByIndex(WebElement element, S i, String options) throws
	 * Exception { try { Select s = new Select(element); if (s.equals(options)) {
	 * s.selectByValue(value); }else if (s.equals("index")) {
	 * 
	 * } s.selectByIndex(i); } catch (Exception e) { e.printStackTrace(); throw new
	 * Exception("Unable to select the option from dropdown"); } }
	 * 
	 * public void selectByValue(WebElement element, String value) throws Exception
	 * { try { Select s = new Select(element); } catch (Exception e) {
	 * e.printStackTrace(); throw new
	 * Exception("Unable to select the option from dropdown"); } }
	 * 
	 * public void selectByVisibleText(WebElement element, String value) throws
	 * Exception { try { Select s = new Select(element);
	 * s.selectByVisibleText(value); } catch (Exception e) { e.printStackTrace();
	 * throw new Exception("Unable to select the option from dropdown"); } }
	 */
	

	public static void selectDropDown(WebElement element, String options, String value) {

		Select sc = new Select(element);
		if (options.equals("value")) {
			sc.selectByValue(value);
		} else if (options.equals("index")) {
			sc.selectByIndex(Integer.parseInt(value));
		} else if (options.equals("visibletext")) {
			sc.selectByVisibleText(value);
		}

	}

	public static void moveToElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.moveToElement(element).build().perform();;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void actionClickElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.click(element).build().perform();;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void actionSendKeysElement(WebElement element, String value) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.sendKeys(element, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send text to the webelement");
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send text to the webelement");
		}
	}

	public static void doubleClickElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.doubleClick(element).build().perform();;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void contextClickElement(WebElement element) throws Exception {
		try {
			Actions a = new Actions(driver);
			a.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to move to the webelement");
		}
	}

	public static void waitUntilElementVisibility(WebElement element) throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is not visible");
		}
	}

	public static void waitUntilAlertPresent() throws Exception {
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Alert is not present");
		}
	}

	public static void acceptAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to accept the alert");
		}
	}

	public static void dismissAlert() throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to dismiss the alert");
		}
	}

	public static void sendKeysToAlert(String value) throws Exception {
		try {
			Alert a = driver.switchTo().alert();
			a.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to send keys to the alert");
		}
	}

}
