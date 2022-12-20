package com.Assetmanagement.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	 public LoginPage(WebDriver sdriver)
	  {
		  driver=sdriver;
		  PageFactory.initElements(sdriver,this);
	  }
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Login for Customers')]")
	  WebElement LoginFormTitle;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='email']")
	  WebElement EmailField;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='password']")
	  WebElement PasswordField;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='button']")
	  WebElement LoginButton;
	  @FindBy(how=How.XPATH,using="//*[@class='profile me-4 pointer dropdown-toggle']")
	  WebElement ProfileIcon;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Log Out')]")
	  WebElement Logout;
	  
	  
	  public WebElement LoginFormtitle()
	  {
		 WebElement title=LoginFormTitle;
		 return title;
	  }
	  public void Enter_email(String Username)
	  {
		  EmailField.sendKeys(Username);
	  }
	  public void Enter_Password(String Username)
	  {
		  PasswordField.sendKeys(Username);
	  }
	  public void click()
	  {
		  LoginButton.click();
	  }
	  public void Logoutclick()
	  {
		  Logout.click();
	  }
	  public void ProfileIcon()
	  {
		  ProfileIcon.click();
	  }
	  
}
