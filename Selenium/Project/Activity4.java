package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

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
		//https://alchemy.hguy.co/crm/index.php?module=Home&action=index

		String strUrl = driver.getCurrentUrl();

		if (strUrl.equals("https://alchemy.hguy.co/crm/index.php?module=Home&action=index")) {
			System.out.println("You are on Home Page!!! ");
			driver.close();
		}
		else
			System.out.println("Login Failed");

	}


}
