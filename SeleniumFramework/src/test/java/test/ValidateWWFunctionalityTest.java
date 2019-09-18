package test;

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
		
		//navigate to the home page
		driver.get("https://www.weightwatchers.com/us/");
		actualHomePageTitle = homePage.getPageTitle();
		if (actualHomePageTitle.equals(expectedHomePageTitle)) {
			System.out.println("Step 1 Passed: Home Page Title matches the expected result");
		} else
			System.out.println("Step 1 Failed:Title mismatch or not present");

		//navigate to find studio page
		homePage.clickFindStudio();
		System.out.println("Step 2 Passed:Clicking Find Studio");		
		//Validating  "Find a studio" page title		
		actualFindStudioPageTitle = findStudio.getPageTitle();		
		if (actualFindStudioPageTitle.equals(expectedFindStudioPageTitle)) {
			System.out.println("Step 3 Passed: Find a studio Page Title matches the expected result");
		} else
			System.out.println("Step 3 Failed:Title mismatch or not present");
		
		findStudio.setZipInSearchBox("10011");
		findStudio.clickSearchButton();
		
		studioLocation.findLocationName();
	
		
		//List<WebElement> test = driver.findElements(By.xpath("//div[@class='schedule-detailed']"));
		//test.get(1)
			//    List<WebElement> test21 = element.findElements(By.xpath("/div"));

	}




}
