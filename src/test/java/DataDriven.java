import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DataDriven extends WebBaseTests {

    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"", "", "Both Username and Password must be present"}, {"qwe", "", "Password must be present"}, {"", "qwe", "Username must be present"}, {"qwe", "qwe", null}
        });
    }

    @Parameter
    public String username;

    @Parameter(1)
    public String password;

    @Parameter(2)
    public String alertText;

    @Test
    public void checkLogin() {
        AppPage appPage = page.loginPage().login(username, password);
        if (appPage == null) {
            Assert.assertTrue(page.loginPage().warningIsDisplayed());
            Assert.assertEquals(alertText, page.loginPage().alertWarning.getText());
        }
    }
}
