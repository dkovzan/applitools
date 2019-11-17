import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Website {

	WebDriver driver;
	WebDriverWait wait;

	Website(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	Website(WebDriver driver) {
		this.driver = driver;
	}

	LoginPage loginPage() {
		return new LoginPage(driver);
	}

	public static boolean isDisplayed(WebElement element) {
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

	public static void enterText(String text, WebElement element) {
		element.sendKeys(text);
	}
}
