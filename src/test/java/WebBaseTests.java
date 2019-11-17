import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebBaseTests {

	static final String host = "https://demo.applitools.com";
	static final String pageUnderTest = host + "/hackathon.html";
	///hackathonV2.html
	///hackathon.html

	WebDriver driver;
	WebDriverWait wait;
	Website website;

	@Before
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.get(pageUnderTest);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10, 500);
		website = new Website(driver, wait);
	}

	@After
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
