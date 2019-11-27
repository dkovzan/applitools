package seleniumTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		UIElements.class,
		DataDriven.class,
		TableSort.class,
		CanvasChart.class,
		DynamicContent.class
})
public class TraditionalTests {
}
