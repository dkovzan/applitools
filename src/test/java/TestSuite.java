import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@org.junit.runners.Suite.SuiteClasses( {
        UIElements.class,
        DataDriven.class,
        TableSort.class,
		CanvasChart.class,
		DynamicContent.class
})
public class TestSuite {
}
