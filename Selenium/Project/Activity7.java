package activities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver= new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver, 10);
		//open URL
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();

		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        WebElement sales = driver.findElement(By.id("grouptab_0"));
        sales.click();
        WebElement leads= driver.findElement(By.id("moduleTab_9_Leads"));
        leads.click();
        System.out.println("leads selected");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='suitepicon suitepicon-action-info'])[2]")));
        WebElement addInfo=driver.findElement(By.xpath("(//*[@class='suitepicon suitepicon-action-info'])[2]"));
        addInfo.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-15")));
		
	WebElement mo = driver.findElement(By.xpath(".//div[@id='ui-id-5']/span"));
	String mobile = mo.getText();
	System.out.println("MobileNo is:" + mobile);
	driver.close();
	}

}
