package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookRightClick {
	
	public WebDriver driver;
	
	@FindBy(xpath="//button[text()='Post']")
	private WebElement postButton;
	
	
	public FaceBookRightClick(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void rightClick(){
		Actions action = new Actions(driver);
		action.contextClick(postButton).perform();
	}

}
