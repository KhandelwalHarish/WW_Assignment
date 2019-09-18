package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MeetingLocation {

	WebDriver driver = null;
	
	By meetingLocation = By.xpath("//div[@class='meeting-location']");
	
	
	public MeetingLocation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void findLocationName() {
		
		List<WebElement> locations = driver.findElements(meetingLocation);
		System.out.println(locations.get(1));
	}
}
