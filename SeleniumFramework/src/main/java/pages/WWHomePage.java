package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class WWHomePage {

	WebDriver driver =null;
	String pageTitle;

	By find_studio = By.id("ela-menu-visitor-desktop-supplementa_find-a-studio");

	public WWHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle(){

		pageTitle = driver.getTitle();

		return pageTitle;
	}

	public void clickFindStudio() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(find_studio));

		driver.findElement(find_studio).sendKeys(Keys.RETURN);
	}

}
