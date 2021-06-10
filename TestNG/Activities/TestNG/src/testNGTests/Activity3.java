package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
	
  @Test
  public void LoginTest() {
	  //enter credentials
	  driver.findElement(By.name("Username")).sendKeys("admin");
      driver.findElement(By.name("Password")).sendKeys("password");
      
      //click Login button
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
            
      //Get and verify login confirmation message
      String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
      System.out.println("Page Title is: " + driver.getTitle());
      System.out.println("Confirmation message is: " + confirmationMessage);
      Assert.assertEquals("Welcome Back, admin", confirmationMessage);
  }
  @BeforeClass
  public void beforeClass() {
	//Create a new instance of the Firefox driver
      driver = new FirefoxDriver();
      
      //Open browser
      driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  //close the browser
	  driver.close();
  }

}
