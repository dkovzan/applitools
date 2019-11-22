import model.DataSet;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CanvasChart extends WebBaseTests {

    @Parameters
    public static Collection<DataSet> testDataPerYear() {
        List<DataSet> dataSets = new ArrayList<DataSet>();
        DataSet ds2017 = new DataSet(
                "2017",
                "color(window.chartColors.red).alpha(0.5).rgbString()",
                "window.chartColors.red",
                1,
                Arrays.asList(10, 20, 30, 40, 50, 60, 70)
        );
        DataSet ds2018 = new DataSet(
                "2018",
                "color(window.chartColors.blue).alpha(0.5).rgbString()",
                "window.chartColors.blue",
                1,
                Arrays.asList(8, 9, -10, 10, 40, 60, 40)
        );
        DataSet ds2019 = new DataSet(
                "2019",
                "color(dsColor).alpha(0.5).rgbString()",
                "window.chartColors.blue",
                1,
                Arrays.asList(5, 10, 15, 20, 25, 30, 35)
        );
        dataSets.add(ds2017);
        dataSets.add(ds2018);
        dataSets.add(ds2019);
        return dataSets;
    }

    @Test
    public void chartDataIsCorrect() {
        AppPage appPage = page.loginPage().loginWithValidCredentials();
        appPage.compareExpensesBtn.click();
        List<Object> chartData = appPage.getChartData();
    }
}
