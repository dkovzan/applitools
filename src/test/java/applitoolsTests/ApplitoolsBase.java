package applitoolsTests;

import org.junit.*;
import org.junit.rules.TestName;
import pageObjects.LoginPage;
import seleniumTests.WebBase;

public class ApplitoolsBase extends WebBase {

    protected static EyesManager eyesManager;

    @Rule
    public TestName name = new TestName();

    @Before
    public void initEyes() {
        eyesManager = new EyesManager(driver, "demo.applitoolsTests.com");
        eyesManager.setBatchName("Hackaton");
        driver.get(LoginPage.Url);
    }

    @After
    public void applitoolsTearDown() {
        eyesManager.abort();
    }
}
