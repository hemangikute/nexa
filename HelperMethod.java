package org.iit.mmp.HelperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperMethod {
	
	
	WebDriver driver;
	
	public HelperMethod(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	

	public void navigateToSubMenu(String subMenuTxt)
	{
		
		driver.findElement(By.xpath("//ul/li[@class='submenu']/a/span[contains(text(),'"+subMenuTxt+"')]")).click();
	    System.out.println("submenu users clicked");
	}

}
