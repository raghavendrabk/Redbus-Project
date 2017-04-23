package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLoginPage1 {

	public WebDriver driver;
    //pageObjects
	@FindBy(id = "email")
	private WebElement EmailTextBox;

	@FindBy(id = "pass")
	private WebElement PassTextBox;

	@FindBy(id = "u_0_l")
	private WebElement LoginButton;

	public FaceBookLoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String login(String username, String Password) {
		EmailTextBox.sendKeys(username);
		PassTextBox.sendKeys(Password);
		LoginButton.click();
		return driver.getTitle();

	}

}
