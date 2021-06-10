package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		//open URL
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement image=driver.findElement(By.xpath("//*[@id='form']/div[1]/img"));
		System.out.println("URL of the header image : "+image.getAttribute("src"));
		
		driver.close();
	}

}
