import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebBaseTests {

	static final Properties props = getAppProperties();
	static final String host = props.getProperty("host");
	static final String applicationUnderTest = host + props.getProperty("applicationUnderTest");
	///hackathonV2.html
	///hackathon.html

	WebDriver driver;
	WebDriverWait wait;
	Page page;

	@Before
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + props.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.get(applicationUnderTest);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10, 500);
		page = new Page(driver, wait);
	}

	@After
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	private static Properties getAppProperties() {
		Properties prop = new Properties();
		try {
			//load a properties file from class path, inside static method
			prop.load(WebBaseTests.class.getClassLoader().getResourceAsStream("application.properties"));
			//System.setProperties(prop);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

}
