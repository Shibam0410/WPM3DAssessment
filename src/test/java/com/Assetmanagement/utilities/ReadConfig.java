package com.Assetmanagement.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	
	  Properties pro;
	  public ReadConfig()
	  {
		  File src=new File("./Configuration/config.properties");
		  try
		  {
			  FileInputStream fis=new FileInputStream(src);
			  pro=new Properties();
			  pro.load(fis);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception is:"+e.getMessage());
		  }
	  }
	  
	  public String getDevUrl()
	  {
		  String url=pro.getProperty("DevURL");
		  return url;
	  }
	  public String Email()
	  {
		  String Email=pro.getProperty("Email");
		  return Email;
	  }
	  public String Password()
	  {
		  String Password=pro.getProperty("Password");
		  return Password;
	  }
	  public String TempMail()
	  {
		  String TempEmail=pro.getProperty("TempMail");
		  return TempEmail;
	  }
}

