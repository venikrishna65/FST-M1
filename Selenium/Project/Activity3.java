package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		//open URL
		driver.get("http://alchemy.hguy.co/crm");
		
		WebElement firstlink = driver.findElement(By.xpath("//a[@id='admin_options']"));
		System.out.println("First copyright text is : "+firstlink.getText());
		
		driver.close();
	}

}
