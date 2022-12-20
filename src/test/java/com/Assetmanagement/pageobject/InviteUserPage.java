package com.Assetmanagement.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InviteUserPage 
{
	WebDriver driver;
	 public InviteUserPage(WebDriver sdriver)
	  {
		  driver=sdriver;
		  PageFactory.initElements(sdriver,this);
	  }
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Users')]")
	  WebElement Users;
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'+ Invite New User')]")
	  WebElement InviteButton;
	  @FindBy(how=How.XPATH,using="//*[@name='firstName']")
	  WebElement FirstNameField;
	  @FindBy(how=How.XPATH,using="//*[@name='lastName']")
	  WebElement LastNameField;
	  @FindBy(how=How.XPATH,using="//*[@name='email']")
	  WebElement EmailField;
	  @FindBy(how=How.XPATH,using="//input[@id='i-email']")
	  WebElement TempMail_Email;
	  @FindBy(how=How.XPATH,using="//*[@id='search_input']")
	  WebElement ProjectsField;
	  @FindBy(how=How.XPATH,using="//*[@id='submit']")
	  WebElement SubmitButton;
	  @FindBy(how=How.XPATH,using="//*[@id='password']")
	  WebElement EnterPassword;
	  @FindBy(how=How.XPATH,using="//*[@id='conf-password']")
	  WebElement RetypePassword;
	  @FindBy(how=How.XPATH,using="//*[@id='submit']")
	  WebElement SignupButton;
	 

	  
	  
	  
	  
	 
	  
	  public void UsersList()
	  {
		 Users.click();
	  }
	  
	  public void ClickInviteButton()
	  {
		 InviteButton.click();
	  }
	  public WebElement TempEmail()
	  {
		  WebElement Temp=TempMail_Email;
		  return Temp;
	  }
	  public void EnterFirstName()
	  {
		 FirstNameField.sendKeys("James");
	  }
	  public void EnterLastName()
	  {
		 LastNameField.sendKeys("Laclong");
	  }
	  public void EnterEmail(String Email)
	  {
		 EmailField.sendKeys(Email);
	  }
	  public void ClearEmail()
	  {
		 EmailField.clear();
	  }
	  
	  public void Projects()
	  {
		  ProjectsField.click();
	  }
	  
	  public void SendInvite()
	  {
		  SubmitButton.click();
	  }
	  public void EnterPassword()
	  {
		  EnterPassword.sendKeys("Qwerty123@");
	  }
	  public void RetypePassword()
	  {
		  RetypePassword.sendKeys("Qwerty123@");
	  }
	  public void SignUp()
	  {
		  SignupButton.click();
	  }
	 
	 
}
