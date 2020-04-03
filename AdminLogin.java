package org.iit.mmp.adminmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin {
	
	WebDriver driver;
	//constructor
	public AdminLogin(WebDriver driver) 
	{
		this.driver = driver;
}

	public void logintoAdmin(String username, String password)
	{
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("admin")).click();
		system.out.println("hello there");

	}

}
