package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage {
	public WebDriver driver;

	@FindBy(id = "userNavigationLabel")
	private WebElement menuButton;

	@FindBy(xpath="//span[text()='Log out']")
	private WebElement LogoutButton;

	public FacebookHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Logout() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(menuButton).click().perform();
		Thread.sleep(3000);
		LogoutButton.click();
	}

}
