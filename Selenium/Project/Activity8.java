package activities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver, 10);
		//open URL
		driver.get("http://alchemy.hguy.co/crm");


		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        driver.findElement(By.id("grouptab_0")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("moduleTab_9_Accounts")).click();
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr"));
		for(int i=1; i<=rows.size(); i++) {
			if(i%2!=0 && i<10)
			{
		    WebElement row = driver.findElement(By.xpath("//*[@id='MassUpdate']/div[3]/table/tbody/tr[" + i + "]"));
		    System.out.println("Row " + i + ": " + row.getText());
			}
		}
		driver.close();
		
	}

}
