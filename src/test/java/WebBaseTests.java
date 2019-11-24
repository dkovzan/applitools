import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebBaseTests {

	WebDriver driver;
	WebDriverWait wait;
	Page page;

	@Before
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + Util.props.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.get(Util.loginPageUrl);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10, 500);
		page = new Page(driver, wait);
	}

	@After
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
