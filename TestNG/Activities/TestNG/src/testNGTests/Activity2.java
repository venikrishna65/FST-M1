package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	
  @Test(priority = 0)
  public void test1() {
	// Check the title of the page
      String title = driver.getTitle();
          
      //Print the title of the page
      System.out.println("Page title is: " + title);
          
          //Assertion for page title
      Assert.assertEquals("Target Practice", title);
  }
  
  @Test(priority = 2)
  public void test2() {
	          
	//This test case will Fail
      WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
      Assert.assertTrue(blackButton.isDisplayed());
      Assert.assertEquals(blackButton.getText(), "black");
      
	  }
  
  @Test(priority = 1, enabled = false)
  public void test3() {
	  System.out.println("Test 3");
  }
  
  @Test(priority = 3) 
  public void test4() {
	  System.out.println("Test 4");
	//This test will be skipped and will be be shown as skipped
      throw new SkipException("Skipping test case"); 
  }
  
  @BeforeClass
  public void beforeMethod() {
	//Create a new instance of the Firefox driver
      driver = new FirefoxDriver();
      
      //Open browser
      driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterMethod() {
	  //close the browser
	  driver.close();
  }
}
