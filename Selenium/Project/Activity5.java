package activities;

import java.awt.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		//open URL
		driver.get("http://alchemy.hguy.co/crm");


		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));

		username.sendKeys("admin");
		//Thread.sleep(3000);
		password.sendKeys("pa$$w0rd");

		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));

		login.click();
		
		String toolbarcolor= driver.findElement(By.id("toolbar")).getCssValue("color");
		
		System.out.println("Color of toolbar : "+toolbarcolor);
		
		driver.close();
	}

}
