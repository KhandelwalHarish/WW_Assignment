package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindStudioPage {

	WebDriver driver =null;
	String findStudioPageTitle;

	By meeting_searchbox = By.xpath("//input[@type='text'][@name='meetingSearch']");
	By meeting_search_button =By.xpath("//button[text()='Submit']");
			//className("btn spice-translated");

	public FindStudioPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle(){
		
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		findStudioPageTitle = driver.getTitle();
		return findStudioPageTitle;
	}


	public void setZipInSearchBox(String Zip) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(meeting_searchbox));

		driver.findElement(meeting_searchbox).sendKeys(Zip);
	}

	public void clickSearchButton() {
		driver.findElement(meeting_search_button).sendKeys(Keys.RETURN);
	}

}
