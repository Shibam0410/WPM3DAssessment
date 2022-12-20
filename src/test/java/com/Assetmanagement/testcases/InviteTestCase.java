package com.Assetmanagement.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.Assetmanagement.pageobject.InviteUserPage;
import com.Assetmanagement.pageobject.LoginPage;

public class InviteTestCase extends BaseClass
{
	@Test(priority=1)
	public void Invite() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		InviteUserPage x=new InviteUserPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,180);
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
		/*driver.get(TempMail);
		logger.info("Navigated to tab containg the Temp mail");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='iconx']")));
		WebElement Temp=x.TempEmail();
		String c=Temp.getAttribute("value");
		System.out.println("Email is:"+c);
		driver.findElement(By.xpath("//button[@class='iconx']")).click();
		Thread.sleep(2000);*/
		driver.get("https://www.tmail.gg/en");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@alt='Temp Mail - Disposable Temporary Email'])[2]")));
		Thread.sleep(3000);
		WebElement CopyButton=driver.findElement(By.xpath("//*[@class='custom-email-botton']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",CopyButton);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='custom-email-input']")));
		WebElement Temp=driver.findElement(By.xpath("//*[@class='custom-email-input']"));
		String c=Temp.getAttribute("value");
		System.out.println("Email is:"+c);
		Thread.sleep(3000);
		driver.switchTo().window(WPM);
		logger.info("Copied the Temp email and navigated back to Invite Page");
		x.ClickInviteButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Invite User')]")));
		x.EnterFirstName();
		Thread.sleep(2000);
		x.EnterLastName();
		Thread.sleep(2000);
		x.EnterEmail(c);
		Thread.sleep(2000);
		x.Projects();
		List<WebElement> Projectlist=driver.findElements(By.xpath("//*[@class='optionContainer']/li"));
		for(WebElement options : Projectlist){
			System.out.println("Projects Listed:"+options.getText());
			if(options.getText().equalsIgnoreCase("Kelly building Assessment"))
			{
				Actions a=new Actions(driver);
				a.moveToElement(options).click().build().perform();
				logger.info("Suceesfully selected the Project from dropdown");
			}


		}
		driver.findElement(By.xpath("//*[contains(text(),'Project/s')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit']")));
        x.SendInvite();
    	Thread.sleep(3000);
    	logger.info("User has been invited successfully");
    	driver.close();
    	Thread.sleep(3000);
		driver.switchTo().window(Mail);
		logger.info("User has navigated to Mail Tab");
	}
	@Test(priority=2)
	public void Signup() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,180);
		InviteUserPage x=new InviteUserPage(driver);
		Actions a=new Actions(driver);
		WebElement Inbox=driver.findElement(By.xpath("//*[contains(text(),'Subject')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Inbox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Welcome to the Asset Management Web Portal')])[2]")));
		WebElement MailClick=driver.findElement(By.xpath("(//*[contains(text(),'Welcome to the Asset Management Web Portal')])[2]"));
		a.moveToElement(MailClick).click().perform();
		Thread.sleep(2000);
		Screen s2 = new Screen();
		Pattern CloseButton = new Pattern(".\\Images\\" + "Close Button.PNG");
		s2.click(CloseButton);
		//driver.findElement(By.xpath("//*[@class='ns-8atfj-e-16 button-common close-button']")).click();
		String parent=driver.getWindowHandle();
		System.out.println("Parent1 Title is:"+driver.getTitle());
		System.out.println("Key is:"+parent);
		WebElement Delete=driver.findElement(By.xpath("(//*[contains(text(),'Delete')])[2]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Delete);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-12 ov-h subject']")));
		Thread.sleep(2000);
		Pattern AcceptInvitationButton = new Pattern(".\\Images\\" + "Accept Invitation.PNG");
		s2.click(AcceptInvitationButton);
		logger.info("User has accepted the Invitation");
		Set<String> handles1=driver.getWindowHandles();
		int count1=handles1.size();
		System.out.println("Total Count of all the tabs:"+count1);
		Thread.sleep(3000);
		for(String Handle2:handles1)
		{
			if(!Handle2.equals(parent))
			{
				driver.switchTo().window(Handle2);
				System.out.println("Child Title is:"+driver.getTitle());
				System.out.println("Key is:"+Handle2);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Sign Up')])[1]")));
			    x.EnterPassword();	
				Thread.sleep(3000);
				x.RetypePassword();
				Thread.sleep(3000);
				x.SignUp();
				Thread.sleep(3000);
				logger.info("User has signed up sucessfully");
			}

		}
	}
}
