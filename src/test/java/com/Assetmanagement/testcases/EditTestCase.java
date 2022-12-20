package com.Assetmanagement.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.Assetmanagement.pageobject.EditUserPage;
import com.Assetmanagement.pageobject.InviteUserPage;
import com.Assetmanagement.pageobject.LoginPage;

//import junit.framework.Assert;

public class EditTestCase extends BaseClass
{
	@Test(priority=1)
	public void Edit_FirstName_LastName() throws Exception 
	{
		LoginPage l=new LoginPage(driver);
		//InviteUserPage x=new InviteUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,80);
		l.Enter_email(Email);
		logger.info("Entered the Email ID");
		l.Enter_Password(Password);
		logger.info("Entered Password");
		l.click();
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		List<WebElement> s=driver.findElements(By.xpath("//*[@class='me-auto navbar-nav']/a"));
		for(WebElement options : s){
			System.out.println("Headers Menu:"+options.getText());
			if(options.getText().equalsIgnoreCase("Users"))
			{
				Actions a=new Actions(driver);
				a.moveToElement(options).click().build().perform();
				logger.info("Successfully navigated to Users Page");
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'+ Invite New User')]")));

		EditUserPage edit=new EditUserPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ag-icon ag-icon-next']")));
		Screen s1 = new Screen();
		Pattern NextArrow = new Pattern(".\\Images\\" + "Next Arrow.PNG");
		s1.click(NextArrow);
		if(driver.findElement(By.xpath("//*[contains(text(),'xilyqyzi@mailo.icu')]")).isDisplayed()==true)
		{
			edit.Editbutton();
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		edit.FirstNameClear();
		Thread.sleep(2000);
		edit.FirstNameUpdate();
		Thread.sleep(2000);
		edit.LastNameClear();
		Thread.sleep(2000);
		edit.LastNameUpdate();
		Thread.sleep(2000);
		edit.Update();
		logger.info("Successfully updated the First and Last Name");
		Thread.sleep(8000);
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
		logger.info("Successfully logout from the application");
		l.Enter_email("xilyqyzi@mailo.icu");
		logger.info("Entered the Email ID");
		l.Enter_Password("Qwerty123@");
		logger.info("Entered the Password");
		l.click();
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		l.ProfileIcon();
		Thread.sleep(2000);
		String Name=driver.findElement(By.xpath("//*[contains(text(),'Samuel Jackson')]")).getText();
		if(Name.contentEquals("Samuel Jackson"))
		{
			logger.info("First Name and Last Name has been updated successfully");
		}
		Thread.sleep(3000);
		l.Logoutclick();

	}
	@Test(priority=2)
	public void Enable_DisableUser() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		EditUserPage edit=new EditUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,80);
		l.Enter_email(Email);
		logger.info("Entered the Email ID");
		l.Enter_Password(Password);
		logger.info("Entered Password");
		l.click();
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		List<WebElement> s=driver.findElements(By.xpath("//*[@class='me-auto navbar-nav']/a"));
		for(WebElement options : s){
			System.out.println("Headers Menu:"+options.getText());
			if(options.getText().equalsIgnoreCase("Users"))
			{
				Actions a=new Actions(driver);
				a.moveToElement(options).click().build().perform();
				logger.info("Successfully navigated to Users Page");
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'+ Invite New User')]")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		Screen scr = new Screen();
		Pattern NextArrow = new Pattern(".\\Images\\" + "Next Arrow.PNG");
		scr.click(NextArrow);
		if(driver.findElement(By.xpath("//*[contains(text(),'xilyqyzi@mailo.icu')]")).isDisplayed()==true)
		{
			edit.Editbutton();
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		Thread.sleep(2000);
		edit.DisableButton();
		logger.info("User has been disabled");
		Thread.sleep(8000);
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
		logger.info("Successfully logout from the application");
		l.Enter_email("xilyqyzi@mailo.icu");
		logger.info("Entered the Email ID");
		l.Enter_Password("Qwerty123@");
		logger.info("Entered the Password");
		l.click();
		logger.info("User is not able to login");
		edit.clearEmailfield();
		Thread.sleep(2000);
		l.Enter_email(Email);
		logger.info("Entered the Email ID");
		edit.clearPasswordfield();
		Thread.sleep(2000);
		l.Enter_Password(Password);
		logger.info("Entered Password");
		l.click();
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		List<WebElement> s2=driver.findElements(By.xpath("//*[@class='me-auto navbar-nav']/a"));
		for(WebElement options : s2){
			System.out.println("Headers Menu:"+options.getText());
			if(options.getText().equalsIgnoreCase("Users"))
			{
				Actions a=new Actions(driver);
				a.moveToElement(options).click().build().perform();
				logger.info("Successfully navigated to Users Page");
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'+ Invite New User')]")));
        Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		Pattern NextArrow1 = new Pattern(".\\Images\\" + "Next Arrow.PNG");
		Screen s3= new Screen();
		s3.click(NextArrow1);
		if(driver.findElement(By.xpath("//*[contains(text(),'xilyqyzi@mailo.icu')]")).isDisplayed()==true)
		{
			edit.Editbutton();
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		Thread.sleep(2000);
		edit.EnableButton();
		logger.info("User has been Enabled");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
		logger.info("Successfully logout from the application");
		l.Enter_email("xilyqyzi@mailo.icu");
		logger.info("Entered the Email ID");
		l.Enter_Password("Qwerty123@");
		logger.info("Entered the Password");
		l.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		logger.info("User is successfully navigated to Projects Dashboard Page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
	}
	
	@Test(priority=4)
	public void updateEmail() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		EditUserPage edit=new EditUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,80);
		l.Enter_email(Email);
		logger.info("Entered the Email ID");
		l.Enter_Password(Password);
		logger.info("Entered Password");
		l.click();
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		List<WebElement> s=driver.findElements(By.xpath("//*[@class='me-auto navbar-nav']/a"));
		for(WebElement options : s){
			System.out.println("Headers Menu:"+options.getText());
			if(options.getText().equalsIgnoreCase("Users"))
			{
				Actions a=new Actions(driver);
				a.moveToElement(options).click().build().perform();
				logger.info("Successfully navigated to Users Page");
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'+ Invite New User')]")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		
		Screen scr = new Screen();
		Pattern NextArrow = new Pattern(".\\Images\\" + "Next Arrow.PNG");
		scr.click(NextArrow);
		Thread.sleep(2000);
		scr.click(NextArrow);
		try 
		{
			
		if(driver.findElement(By.xpath("//*[contains(text(),'liwohehy@cyclelove.cc')]")).isDisplayed()==true)
		{
			edit.Editbutton1();
		}
		
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Incorrect XPATH:"+e.getMessage());
			
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		Thread.sleep(2000);
		InviteUserPage x=new InviteUserPage(driver);
		((JavascriptExecutor)driver).executeScript("window.open()");
		logger.info("Opened a new window tab");
		Set<String> handles=driver.getWindowHandles();
		List<String> ls= new ArrayList<String>(handles);
		int count=handles.size();
		System.out.println("Total Count:"+count);
		String WPM=ls.get(0);
		String Mail=ls.get(1);
		System.out.println("WPM key is:"+WPM);
		System.out.println("Mail key is:"+Mail);
		driver.switchTo().window(Mail);
	/*	driver.get(TempMail);
		logger.info("Navigated to tab containg the Temp mail");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='iconx']")));
		WebElement Temp=x.TempEmail();*/
		driver.get("https://www.tmail.gg/en");
		logger.info("Navigated to Temp mail tab");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@alt='Temp Mail - Disposable Temporary Email'])[2]")));
		Thread.sleep(3000);
		WebElement CopyButton=driver.findElement(By.xpath("//*[@class='custom-email-botton']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",CopyButton);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='custom-email-input']")));
		WebElement Temp=driver.findElement(By.xpath("//*[@class='custom-email-input']"));
		String c=Temp.getAttribute("value");
		System.out.println("Email is:"+c);
		Thread.sleep(2000);
		driver.switchTo().window(WPM);
		x.ClearEmail();
		Thread.sleep(2000);
		x.EnterEmail(c);
		Thread.sleep(2000);
		edit.Update();
		logger.info("Successfully updated the EmailID");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
		logger.info("Successfully logout from the application");
		l.Enter_email(c);
		logger.info("Entered the Updated Email ID");
		l.Enter_Password("Qwerty123@");
		logger.info("Entered the Password");
		l.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		logger.info("User is successfully navigated to Projects Dashboard Page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
		
	}
	
	@Test(priority=3)
	public void updateProject() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		EditUserPage edit=new EditUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,100);
		l.Enter_email(Email);
		logger.info("Entered the Email ID");
		l.Enter_Password(Password);
		logger.info("Entered Password");
		l.click();
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='me-auto navbar-nav']/a")));
		List<WebElement> s=driver.findElements(By.xpath("//*[@class='me-auto navbar-nav']/a"));
		for(WebElement options : s){
			System.out.println("Headers Menu:"+options.getText());
			if(options.getText().equalsIgnoreCase("Users"))
			{
				Actions a=new Actions(driver);
				a.moveToElement(options).click().build().perform();
				logger.info("Successfully navigated to Users Page");
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'+ Invite New User')]")));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		Thread.sleep(3000);
		Screen scr = new Screen();
		Pattern NextArrow = new Pattern(".\\Images\\" + "Next Arrow.PNG");
		scr.click(NextArrow);
		if(driver.findElement(By.xpath("//*[contains(text(),'xilyqyzi@mailo.icu')]")).isDisplayed()==true)
		{
			edit.Editbutton();
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		edit.RemoveProject();
		Thread.sleep(2000);
		edit.Update();
		logger.info("Project has been successfully removed");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'View Project')])[3]")));
		edit.ViewProjectButton();
		Thread.sleep(2000);
		edit.ClosePopupwindow();
		Thread.sleep(2000);
		edit.Editbutton();
		Thread.sleep(4000);
		WebElement dropdown=driver.findElement(By.xpath("//*[@class='searchBox ']"));
		dropdown.click();
		Thread.sleep(2000);
		logger.info("Displaying the lists of Projects  under Dropdown list ");
		WebElement select1=driver.findElement(By.xpath("//*[contains(text(),'Kelon Building Assessment')]"));
		select1.click();
		Thread.sleep(2000);
		edit.Update();
		logger.info("Added New project");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'View Project')])[3]")));
		edit.ViewProjectButton();
		Thread.sleep(4000);
		edit.ClosePopupwindow();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
		l.ProfileIcon();
		Thread.sleep(2000);
		l.Logoutclick();
	}
}

