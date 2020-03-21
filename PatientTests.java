package org.iit.mmp.patienttest;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.iit.mmp.HelperMethods.HelperMethod;
import org.iit.mmp.adminmodule.AdminLogin;
import org.iit.mmp.adminmodule.AdminPage;
import org.iit.mmp.patientmodule.PatientLogin;
import org.iit.mmp.patientmodule.RegistrationPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

             /*
              * 1. REGISTER THE PATIENT
              * 2. LOGIN TO ADMIN PORTAL
              * 3. APPROVE THE PATIENT BASED ON USERNAME
              * 4. LOGIN TO PATIENT PORTAL
              * 5. 	LOGIN USING USERNAME AND PASSWORD
              * 
              * 
              */
            		

public class PatientTests {
	
	WebDriver driver;
	Random rnd = new Random();
	HashMap<String, String> hMap = new HashMap<String, String>();


	@Test
	public void approvePatient() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	//	WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		RegistrationPage regpage = new RegistrationPage(driver);
		String usernameValue = "testUName" + rnd.nextInt(90);
		String passwordValue = "testPword" + rnd.nextInt(90);
		hMap = regpage.registerPatient(usernameValue, passwordValue);
		
		String actualmsg = hMap.get("successmsg").trim();
		String expectedmsg = "Thank you for registering with MMP.";
		Assert.assertEquals(actualmsg, expectedmsg);
		
		
		/*    Admin Login  */
		
	
		driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
		AdminLogin admin = new AdminLogin(driver);
		admin.logintoAdmin("Thomas_444", "Edison_444");
		
		
		HelperMethod submenu = new HelperMethod(driver);
		submenu.navigateToSubMenu("Users");
		
		
		AdminPage adminpage = new AdminPage(driver);
		String actual = adminpage.approvePatient(hMap).trim();
		String expected = "USER has been updated.";
		Assert.assertEquals(actual, expected);
		
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		PatientLogin patientlogin = new PatientLogin(driver);
		
		patientlogin.patientLogin(usernameValue, passwordValue);
		String actualvalue = patientlogin.fetchUname().trim();
		String expectedvalue = usernameValue;
		
		Assert.assertEquals(actualvalue, expectedvalue);
		
		
			
		
		
		
   }
	
	
	
}
