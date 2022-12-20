package com.Assetmanagement.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Assetmanagement.pageobject.LoginPage;

import junit.framework.Assert;



public class LoginTestCase extends BaseClass
{
	@Test()
	public void logintest() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,60);
		try {
			l.Enter_email(Email);
			logger.info("Entered the Email ID");
		}
		
		catch(NoSuchElementException e)
		{
			
			System.out.println("Incorrect XPATH:"+e.getMessage());
			Assert.assertTrue(false);
			
		}
		try {
			l.Enter_Password(Password);
			logger.info("Entered Password");
		}
		
		catch(NoSuchElementException e)
		{
			
			System.out.println("Incorrect XPATH:"+e.getMessage());
			Assert.assertTrue(false);
			
		}
		try {
			l.click();
			logger.info("Login Successfully");
		}
		
		catch(NoSuchElementException e)
		{
			
			System.out.println("Incorrect XPATH:"+e.getMessage());
			Assert.assertTrue(false);
			
		}
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='profile me-4 pointer dropdown-toggle']")));
			logger.info("Successfully navigated to Project Dashboard page");
			l.ProfileIcon();
			logger.info("User is able to see the Profile Menu");
				
		}
		
		catch(Exception e)
		{
			
			System.out.println("Incorrect XPATH:"+e.getMessage());
			Assert.assertTrue(false);
			
		}
		Thread.sleep(3000);
		
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Log Out')]")));
			l.Logoutclick();
			logger.info("Successfully logged off from the application");
				
		}
		
		catch(Exception e)
		{
			
			System.out.println("Incorrect XPATH:"+e.getMessage());
			Assert.assertTrue(false);
			
		}
	}
}
