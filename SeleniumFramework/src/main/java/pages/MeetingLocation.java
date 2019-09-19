package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MeetingLocation {

	WebDriver driver = null;
	
	By meetingLocation = By.cssSelector("div[class='location__name']");
	By locationDistance = By.cssSelector("div[class='location__distance']");
	
	
	public MeetingLocation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void findLocationName() {
		
		List<WebElement> locations = driver.findElements(meetingLocation);
		System.out.println(locations.get(0).getText());
	}
	
	public void findLocationDistance() {
		
		List<WebElement> distance = driver.findElements(locationDistance);
		System.out.println(distance.get(0).getText());
		
	}
	
	public void clickMeetingLocation() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(meetingLocation));
	
		List<WebElement> locations = driver.findElements(meetingLocation);
		locations.get(0).click();
	}
}

