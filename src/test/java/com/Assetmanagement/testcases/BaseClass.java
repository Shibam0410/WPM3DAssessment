package com.Assetmanagement.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Assetmanagement.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	public String URL=readconfig.getDevUrl();
	public String Email=readconfig.Email();
	public String Password=readconfig.Password();
	public String TempMail=readconfig.TempMail();
	public  WebDriver driver;
	public Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void LaunchApplication(String br) throws Exception, IOException
	{
		logger=Logger.getLogger("WPM3DAssetManagement");
		PropertyConfigurator.configure("Log4j.Properties");
		 
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			logger.info("URL is opened");
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			logger.info("URL is opened");
		}
}
	
	//@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
}
