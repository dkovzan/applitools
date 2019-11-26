package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page {

	private static final Logger logger = LoggerFactory.getLogger(Page.class);

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public static final String Host = System.getProperty("host");

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
			return element != null && element.isDisplayed();
		}catch (Exception ex) {
			logger.warn("Exception occurs while searching web element:\n", ex);
			return false;
		}
	}

	void waitVisibilityOf(WebElement element) {
		if (!isDisplayed(element)) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	static void enterText(String text, WebElement element) {
		if (text != null)
			logger.info("Entering text: " + text + " into field " + element.getText());
			element.sendKeys(text);
	}

	public static String getPlaceholder(WebElement element) {
		return element.getAttribute("placeholder");
	}

	public static String getImageSource(WebElement element) {
		if (element != null)
			return element.getAttribute("src");
		logger.info("Image source of null element cannot be obtained");
		return null;
	}

	public static WebElement getChildImage(WebElement element) {
		try {
			return element.findElement(By.xpath("img"));
		} catch (Exception ex) {
			logger.warn("Exception occurs while searching web element:\n", ex);
			return null;
		}

	}

	void moveToElement(WebElement element) {
		actions.moveToElement(element);
	}
}
