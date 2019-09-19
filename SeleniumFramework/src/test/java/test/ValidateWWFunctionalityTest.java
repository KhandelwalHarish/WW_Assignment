package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FindLocationDetails;
import pages.FindStudioPage;
import pages.MeetingLocation;
import pages.WWHomePage;

public class ValidateWWFunctionalityTest {
	private static WebDriver driver =null;

	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}

	@Test
	public void WWTest() {
		try {
			goToFindStudio();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static void goToFindStudio() {

		String actualHomePageTitle;
		String expectedHomePageTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
		String actualFindStudioPageTitle;
		String expectedFindStudioPageTitle = "Find WW Studios & Meetings Near You | WW USA";		
		WWHomePage homePage = new WWHomePage(driver);		
		FindStudioPage findStudio = new FindStudioPage(driver);
		MeetingLocation studioLocation = new MeetingLocation(driver);
		FindLocationDetails locationdetails = new FindLocationDetails(driver);

		//navigate to the home page
		driver.get("https://www.weightwatchers.com/us/");

		//getting the actual home page title
		actualHomePageTitle = homePage.getPageTitle();

		//comparing the page title and printing the result in the console
		if (actualHomePageTitle.equals(expectedHomePageTitle)) {
			System.out.println("Step 1 Passed: Home Page Title matches the expected result");
		} else
			System.out.println("Step 1 Failed: Title mismatch or not present");

		//navigate to find studio page
		homePage.clickFindStudio();
		System.out.println("Step 2 Passed: Clicking Find Studio");		

		//validating  "Find a studio" page title		
		actualFindStudioPageTitle = findStudio.getPageTitle();		
		if (actualFindStudioPageTitle.equals(expectedFindStudioPageTitle)) {
			System.out.println("Step 3 Passed: Find a studio Page Title matches the expected result");
		} else
			System.out.println("Step 3 Failed: Title mismatch or not present");
		//entering the zip code
		findStudio.setZipInSearchBox("10011");
		System.out.println("Step 4 Passed:Entering the Zip code");	

		//clicking the search button
		findStudio.clickSearchButton();
		System.out.println("Step 5 Passed: Clicking the search button");	

		//finding the first location from the search result
		studioLocation.findLocationName();
		System.out.println("Step 6 Passed: First Location Name printed");	

		//finding the location distance of the first location present in the search result
		studioLocation.findLocationDistance();
		System.out.println("Step 7 Passed: Location distance printed");	

		//clicking the first location 
		studioLocation.clickMeetingLocation();
		System.out.println("Step 8 Passed: Clicking the first meeting location");	

		//printing the current day
		locationdetails.findCurrentDay();
		System.out.println("Step 9 Passed: Printing the current day");	

		//Operating hours of the location
		locationdetails.operatingHours();
		System.out.println("Step 10 Passed: Printing the operating hours of the location for the current day");	

		//close browser      	 
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}

}
