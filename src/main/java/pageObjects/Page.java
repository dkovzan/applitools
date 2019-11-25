package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Config;

public class Page {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
	}

	Page(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage loginPage() {
		return new LoginPage(driver);
	}
	public AppPage appPage() {
		return new AppPage(driver);
	}

	public static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		}catch (Exception ex) {
			System.out.println("Exception occurs while searching web element: " + ex);
			return false;
		}
	}

	void waitVisibilityOf(WebElement element) {

		if (element == null || !isDisplayed(element)) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	static void enterText(String text, WebElement element) {
		if (text != null)
			element.sendKeys(text);
	}

	public static String getPlaceholder(WebElement element) {
		return element.getAttribute("placeholder");
	}

	public static String getImageSource(WebElement element) {
		return element != null ? element.getAttribute("src") : null;
	}

	public static WebElement getChildImage(WebElement element) {
		try {
			return element.findElement(By.xpath("img"));
		} catch (Exception ex) {
			System.out.println("Exception occurs while searching web element: " + ex);
			return null;
		}

	}

	void moveToElement(WebElement element) {
		actions.moveToElement(element);
	}
}
