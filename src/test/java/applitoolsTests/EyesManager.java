package applitoolsTests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EyesManager {

    private static final Logger logger = LoggerFactory.getLogger(EyesManager.class);

    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    public EyesManager(WebDriver driver, String appName) {
        this.driver = driver;
        this.appName = appName;

        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
        eyes.setForceFullPageScreenshot(true);

        logger.info("Applitools Eyes are successfuly initialised.");
    }

    public void setBatchName(String batchName) {
        eyes.setBatch(new BatchInfo(batchName));
    }

    public void validateWindow() {
        String testName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Test " + testName + " execution was started.");
        eyes.open(driver, appName, testName, new RectangleSize(1024,768));
        eyes.checkWindow();
        eyes.closeAsync();
        logger.info("Test execution was completed.");
    }

    public void abort() {
        eyes.abortIfNotClosed();
        logger.info("Aborting eyes if not closed.");
    }

    public Eyes getEyes() {
        return eyes;
    }
}
