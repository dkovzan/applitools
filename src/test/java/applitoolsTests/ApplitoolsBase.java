package applitoolsTests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import seleniumTests.WebBase;
import utils.Config;

public class ApplitoolsBase extends WebBase {

    private static EyesRunner runner;
    Eyes eyes;
    private static BatchInfo batch;

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void setBatch() {
        batch = new BatchInfo("Applitools Tests Suite");
    }

    @Before
    public void applitoolsSetUp() {
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey(Config.props.getProperty("applitoolsApiKey"));
        eyes.setBatch(batch);
        eyes.open(driver, "demo.applitoolsTests.com", name.getMethodName(), new RectangleSize(1024,768));
        eyes.setForceFullPageScreenshot(true);
        driver.get(Config.loginPageUrl);
    }

    @After
    public void applitoolsTearDown() {
        eyes.closeAsync();
        if (driver != null)
            driver.quit();
        eyes.abortIfNotClosed();

        //TestResultsSummary allTestResults = runner.getAllTestResults();
        //System.out.println(allTestResults);
    }
}
