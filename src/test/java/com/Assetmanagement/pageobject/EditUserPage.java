package com.Assetmanagement.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage 
{
	WebDriver driver;
	 public EditUserPage(WebDriver sdriver)
	  {
		  driver=sdriver;
		  PageFactory.initElements(sdriver,this);
	  }
	  
	  @FindBy(how=How.XPATH,using="//*[@class='ag-icon ag-icon-next']")
	  WebElement Next;
	  
	  
	  @FindBy(how=How.XPATH,using="(//*[contains(text(),'Edit')])[3]")
	  WebElement EditButton;
	  
	  @FindBy(how=How.XPATH,using="(//*[contains(text(),'Edit')])[6]")
	  WebElement EditButton1;
	  
	  @FindBy(how=How.XPATH,using="//*[@name='firstName']")
	  WebElement FirstName;
	  
	  @FindBy(how=How.XPATH,using="//*[@name='lastName']")
	  WebElement LastName;
	  
	  @FindBy(how=How.XPATH,using="//*[@name='email']")
	  WebElement Email;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='submit']")
	  WebElement UpdateButton;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Disable')]")
	  WebElement DisableUser;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='email']")
	  WebElement EmailField;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='password']")
	  WebElement PasswordField;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Enable')]")
	  WebElement EnableUser;
	  
	  @FindBy(how=How.XPATH,using="(//*[@class='icon_cancel closeIcon'])[1]")
	  WebElement UpdateProject;
	  
	  @FindBy(how=How.XPATH,using="(//*[contains(text(),'View Project')])[3]")
	  WebElement ViewProjectButton;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='btn-close']")
	  WebElement CloseViewProject;
	  
	  public void NextArrow()
	  {
		 Next.click();
	  }
	  
	  public void Editbutton()
	  {
		  EditButton.click();
	  }
	  public void Editbutton1()
	  {
		  EditButton1.click();
	  }
	  public void FirstNameClear()
	  {
		 FirstName.clear();
	  }
	  public void FirstNameUpdate()
	  {
		 FirstName.sendKeys("Samuel");
	  }
	  public void LastNameClear()
	  {
		 LastName.clear();
	  }
	  public void LastNameUpdate()
	  {
		 LastName.sendKeys("Jackson");
	  }
	  public void Update()
	  {
		  UpdateButton.click();
	  }
	  
	  public void DisableButton()
	  {
		  DisableUser.click();
	  }
	  
	  public void clearEmailfield()
	  {
		  EmailField.clear();
	  }
	  public void clearPasswordfield()
	  {
		  PasswordField.clear();
	  }
	  
	  public void EnableButton()
	  {
		  EnableUser.click();
	  }
	  
	  public void RemoveProject()
	  {
		  UpdateProject.click();
	  }
	  
	  public void ViewProjectButton()
	  {
		  ViewProjectButton.click();
	  }
	  
	  public void ClosePopupwindow()
	  {
		  CloseViewProject.click();
	  }
	 
}
