import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.actions = new Actions(driver);
	}

	Page(WebDriver driver) {
		this.driver = driver;
	}

	LoginPage loginPage() {
		return new LoginPage(driver);
	}
	AppPage appPage() {
		return new AppPage(driver);
	}

	static boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		}catch (Exception ex) {
			System.out.println("Exception occurs while searching web element: " + ex);
			return false;
		}
	}

	public void waitVisibilityOf(WebElement element) {

		if (!isDisplayed(element)) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	}

	static void enterText(String text, WebElement element) {
		if (text != null)
			element.sendKeys(text);
	}

	static String getPlaceholder(WebElement element) {
		return element.getAttribute("placeholder");
	}

	static String getParentLinkUrl(WebElement element) {
		return element.findElement(By.xpath("parent::a")).getAttribute("href");
	}

	static String getChildLinkUrl(WebElement element) {
		return element.findElement(By.xpath("a")).getAttribute("href");
	}

	void moveToElement(WebElement element) {
		actions.moveToElement(element);
	}
}
