package com.maven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MAP_HomePage {

	static WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement signInText;
	
	
	
	public WebElement getSignInText() {
		return signInText;
	}

	public MAP_HomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
}
