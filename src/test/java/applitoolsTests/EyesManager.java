package applitoolsTests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EyesManager {

	private static final Logger logger = LoggerFactory.getLogger(EyesManager.class);

	private Eyes eyes;
	private String appName;
	private WebDriver driver;

	EyesManager(WebDriver driver, String appName) {
		this.driver = driver;
		this.appName = appName;

		eyes = new Eyes();
		eyes.setApiKey(System.getProperty("applitools.api.key"));
		eyes.setForceFullPageScreenshot(true);

		logger.info("Applitools Eyes are successfuly initialised.");
	}

	void setBatchName(BatchInfo batchInfo) {
		eyes.setBatch(batchInfo);
	}

	void validateWindow() {
		String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
		logger.info("Opening eyes for test " + testName);
		eyes.open(driver, appName, testName, getResolution());
		eyes.checkWindow();
		eyes.closeAsync();
		logger.info("Eyes are closed.");
	}

	void validateRegion(By locator) {
		String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
		logger.info("Opening eyes for test " + testName);
		eyes.open(driver, appName, testName, getResolution());
		eyes.checkRegion(locator);
		eyes.closeAsync();
		logger.info("Eyes are closed.");
	}

	void abort() {
		eyes.abortIfNotClosed();
		logger.info("Aborting eyes if not closed.");
	}

	private RectangleSize getResolution() {
		return new RectangleSize(Integer.parseInt(System.getProperty("screen.width")),Integer.parseInt(System.getProperty("screen.height")));
	}

	public Eyes getEyes() {
		return eyes;
	}
}
