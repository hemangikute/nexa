

package org.iit.mmp.patientmodule;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {
	
	HashMap<String, String> hMap = new HashMap<String, String>();
	Random rnd = new Random();

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) 
	{
		this.driver = driver;	}

	public HashMap<String,String> registerPatient(String username, String password) throws Exception
	{
		
		WebElement firstnameTxtField = driver.findElement(By.id("firstname"));
		String fNameValue = "testFN" + (char) (65+rnd.nextInt(26));
		firstnameTxtField.sendKeys(fNameValue);
		hMap.put("firstname", firstnameTxtField.getAttribute("value"));
		
		WebElement lastnameTxtField = driver.findElement(By.id("lastname"));
		String lNameValue = "testLN" + (char) (65+rnd.nextInt(26));
		lastnameTxtField.sendKeys(lNameValue);
		hMap.put("lastname", lastnameTxtField.getAttribute("value"));
		
		
		SimpleDateFormat sdf = new  SimpleDateFormat("MM/dd/YYYY");
		Date d = new Date();
		
		
		WebElement datepickerTxtField = driver.findElement(By.id("datepicker"));
		datepickerTxtField.sendKeys(sdf.format(d));
		hMap.put("datepicker", datepickerTxtField.getAttribute("value"));
		
		
		WebElement licenseTxtField = driver.findElement(By.id("license"));
		licenseTxtField.sendKeys("12345678");
		hMap.put("license", licenseTxtField.getAttribute("value"));
		
		
		WebElement ssnTxtField = driver.findElement(By.id("ssn"));
		long ssnvalue = 100000000 + rnd.nextInt(900000000);
		ssnTxtField.sendKeys(""+ssnvalue);
		hMap.put("ssn", ssnTxtField.getAttribute("value"));
		
		
		WebElement stateTxtField = driver.findElement(By.id("state"));
		stateTxtField.sendKeys("Iowa");
		hMap.put("state", stateTxtField.getAttribute("value"));
		
		
		WebElement cityTxtField = driver.findElement(By.id("city"));
		cityTxtField.sendKeys("Asbury");
		hMap.put("city", cityTxtField.getAttribute("value"));
		
		
		WebElement addressTxtField = driver.findElement(By.id("address"));
		addressTxtField.sendKeys("10 street");
		hMap.put("address", addressTxtField.getAttribute("value"));
		
		
		WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
		long zipvalue = 10000 + rnd.nextInt(90000);  //generating random 5 digit no using random class
		zipcodeTxtField.sendKeys(""+zipvalue);
		hMap.put("zipcode", zipcodeTxtField.getAttribute("value"));
		
		
		WebElement ageTxtField = driver.findElement(By.id("age"));
		long ageValue = 10 + rnd.nextInt(90);
		ageTxtField.sendKeys(""+ageValue);
		hMap.put("age", ageTxtField.getAttribute("value"));
		
		
		WebElement heightTxtField = driver.findElement(By.id("height"));
		heightTxtField.sendKeys("123");
		hMap.put("height", heightTxtField.getAttribute("value"));
		
		
		WebElement weightTxtField = driver.findElement(By.id("weight"));
		weightTxtField.sendKeys("45");
		hMap.put("weight", weightTxtField.getAttribute("value"));
		
		
		WebElement pharmacyTxtField = driver.findElement(By.id("pharmacy"));
		pharmacyTxtField.sendKeys("ddf");
		hMap.put("pharmacy", pharmacyTxtField.getAttribute("value"));
		
		
		WebElement pharma_adressTxtField = driver.findElement(By.id("pharma_adress"));
		pharma_adressTxtField.sendKeys("ddf");
		hMap.put("pharma_adress", pharma_adressTxtField.getAttribute("value"));
		
		
		WebElement emailTxtField = driver.findElement(By.id("email"));
		String emailValue = "testEmail" + rnd.nextInt(90)+ (char) (65+rnd.nextInt(26))+ "@gmail.com";
		emailTxtField.sendKeys(emailValue);
		hMap.put("email", emailTxtField	.getAttribute("value"));
		
		
		WebElement passwordTxtField = driver.findElement(By.id("password"));
		passwordTxtField.sendKeys(password);
		hMap.put("password", passwordTxtField.getAttribute("value"));
		
		
		WebElement usernameTxtField = driver.findElement(By.id("username"));
		usernameTxtField.sendKeys(username);
		hMap.put("username", usernameTxtField	.getAttribute("value"));
		
		
		WebElement confirmpasswordTxtField = driver.findElement(By.id("confirmpassword"));
		confirmpasswordTxtField.sendKeys(password);
		hMap.put("password", passwordTxtField.getAttribute("value"));
		
		Select select = new Select(driver.findElement(By.id("security")));
		select.selectByVisibleText("what is your pet name");
		
		WebElement answerTxtField = driver.findElement(By.id("answer"));
		answerTxtField.sendKeys(username);
		hMap.put("answer", answerTxtField.getAttribute("value"));
		
		driver.findElement(By.name("register")).click();
		
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();
		String successmsg = alrt.getText();
		System.out.println("suceessmsg"+successmsg);
		hMap.put("successmsg", successmsg);
		Thread.sleep(2000);
		alrt.accept();
		Thread.sleep(2000);
		return hMap;
		
		
	}
	
	

}
