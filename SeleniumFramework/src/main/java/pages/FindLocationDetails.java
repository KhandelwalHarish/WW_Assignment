package pages;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindLocationDetails {
	WebDriver driver = null;
	String dayName;
	
	By operatingHours1 = By.xpath("//div[@id='content']/div/div/ui-view/ui-view/div/div[2]/div/div/div[2]/div/hours-list/ul/li[5]/div/div[2]/div");
	By operatingHours2 = By.xpath("//div[@id='content']/div/div/ui-view/ui-view/div/div[2]/div/div/div[2]/div/hours-list/ul/li[5]/div/div[2]/div[2]");
	
	               
	public FindLocationDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void findCurrentDay() {
		
		LocalDate date = LocalDate.now();
		DayOfWeek dow = date.getDayOfWeek();
		dayName = dow.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
		System.out.println(dayName);
		//return dayName;
		
	}
	
	public void operatingHours() {
		
		WebElement hours1 = driver.findElement(operatingHours1);
		WebElement hours2 = driver.findElement(operatingHours2);
		//List<WebElement> hours = driver.findElements(operatingHours);
		System.out.println(hours1.getText());
		System.out.println(hours2.getText());
		
	}
	
	
	
}
