package applitoolsTests;

import com.applitools.eyes.BatchInfo;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import pageObjects.LoginPage;
import seleniumTests.WebBase;

public class ApplitoolsBase extends WebBase {

	static EyesManager eyesManager;
	private static BatchInfo batch;

	@BeforeClass
	public static void setBatch() {
		batch = new BatchInfo("Hackathon");
	}

	@Before
	public void initEyes() {
		eyesManager = new EyesManager(driver, "demo.applitoolsTests.com");
		eyesManager.setBatchName(batch);
		driver.get(LoginPage.Url);
	}

	@After
	public void applitoolsTearDown() {
		eyesManager.abort();
	}
}
