package activities;

	import java.net.MalformedURLException;
	import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileBy;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

	public class Activity5 {
	    AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;

	    @BeforeClass
	    public void beforeClass() throws MalformedURLException {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel_4_Emulator");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage", "com.google.android.apps.messaging");
	        caps.setCapability("appActivity", ".ui.ConversationListActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 5);
	    }

	    @Test
	    public void smsTest() throws InterruptedException {
	        // Locate the button to write a new message and click it
	    	// driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create New Message\")")).click();
	        
	    	driver.findElement(MobileBy.AccessibilityId("Start new conversation")).click();
	        
	        // Enter the number to send message to
	        String contactBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/auto_complete_contact\")";
	        
	        Thread.sleep(3000);
	        // Enter your own phone number
	        //driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("7979026144");
	        
	        MobileElement number = driver.findElement(MobileBy.className("android.widget.MultiAutoCompleteTextView"));
	        number.sendKeys("7979026144");
	        Thread.sleep(7000);
	        
	        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	        
	        // Wait for message box to load
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));
	       //Type in a message
	        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");
	        // Send the message
	        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();
	 
	        // Wait for message to show
	        String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
	 
	        // Assertion
	        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
	        Assert.assertEquals(sentMessageText, "Hello from Appium");
	    }
	 
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
	 
	    