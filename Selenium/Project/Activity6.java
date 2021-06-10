package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Activity6 {

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
		
		//WebElement toolbar= driver.findElement(By.xpath("//ul[@class='nav navbar-nav']"));
		// StringBuilder sb=new StringBuilder();

		String ActualResult=driver.findElement(By.id("grouptab_3")).getText();
		String ExpecRe="ACTIVITIES";
		Assert.assertEquals(ActualResult, ExpecRe);
		System.out.println("ACTIVITIES menu is verified");
				 
		   
		driver.close();
		
	}

}
