package com.expedia.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.qa.testbase.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
		// Page Factory
	@FindBy(linkText= "Sign in")
	WebElement clickonsignin;
	
	@FindBy(xpath = "//img[contains(text(),'expedia logo')]")
	WebElement ExpediaLogo;
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateLogo() {
		return ExpediaLogo.isDisplayed();
	}
	
}
