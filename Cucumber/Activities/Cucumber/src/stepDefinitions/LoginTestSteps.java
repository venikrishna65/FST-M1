package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {

	 WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^User is on Login page$")
	    public void userIsOnLoginPage() throws Throwable {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 15);
	                
	        //Open the browser
	        driver.get("https://www.training-support.net/selenium/login-form");
	    }
	    
	    @When("^User enters username and password$")
	    public void userTypesUsernameAndPasswordAndHitsENTER() throws Throwable {
	        driver.findElement(By.name("Username")).sendKeys("admin");
	        driver.findElement(By.name("Password")).sendKeys("password");
	        driver.findElement(By.className("ui button")).click();
	    }

	    @When("^User enters \"admin\" and \"password\"$")
	    public void userTypesUsernameAndPasswordfromFeatureAndHitsENTER(String username, String password) throws Throwable {
	        driver.findElement(By.name("Username")).sendKeys(username);
	        driver.findElement(By.name("Password")).sendKeys(password);
	        driver.findElement(By.className("ui button")).click();
	    }
	    
	    @When("^User enters \"(.*)\" and \"(.*)\"$")
	    public void user_enters_and(String username, String password) throws Throwable {
	        //Enter username from Feature file
	        driver.findElement(By.id("username")).sendKeys(username);
	        //Enter password from Feature file
	        driver.findElement(By.id("password")).sendKeys(password);
	        //Click Login
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	    }
	    
	    @Then("^Read the page title and confirmation message$")
	    public void readPagetitleAndConfirmMessage() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
	        String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
	        System.out.println("Page Title is: " + driver.getTitle());
	        System.out.println("Confirmation message is: " + confirmationMessage);
	    }

	    @And("^Close the browser$")
	    public void closeTheBrowser() throws Throwable {
	        driver.close();
	    }
}
