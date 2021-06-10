package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		//open URL
		driver.get("http://alchemy.hguy.co/crm");
		//print title
		String pageTitle= driver.getTitle();
		System.out.println("Title of the page is : "+pageTitle);
		 
		String title= "SuiteCRM";
			
		if(pageTitle.equals(title))
		{
			System.out.println("Page title is matched");
			driver.close();
		}
		
	}

}
