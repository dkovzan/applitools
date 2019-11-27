package seleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.Page;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;

public class WebBase {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static Page page;

	@BeforeClass
	public static void initProperties() {
		loadProperties();
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(getDimension());
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(LoginPage.Url);
		wait = new WebDriverWait(driver, 10, 500);
		page = new Page(driver, wait);
	}

	@After
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	private static void loadProperties() {
		Properties props = System.getProperties();
		try {
			props.load(new FileInputStream(new File("resources/test.properties")));
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}

	private Dimension getDimension() {
		return new Dimension(Integer.parseInt(System.getProperty("screen.width")), Integer.parseInt(System.getProperty("screen.height")));
	}
}
