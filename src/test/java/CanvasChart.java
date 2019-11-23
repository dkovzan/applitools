import model.DataSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanvasChart extends WebBaseTests {

    private static List<DataSet> getExpectedChartData() {

        List<DataSet> dataSets = new ArrayList<DataSet>();
        DataSet ds2017 = new DataSet(
                "2017",
                "rgba(255, 99, 132, 0.5)",
                "rgb(255, 99, 132)",
                1,
                Arrays.asList(10, 20, 30, 40, 50, 60, 70)
        );
        DataSet ds2018 = new DataSet(
                "2018",
                "rgba(54, 162, 235, 0.5)",
                "rgb(54, 162, 235)",
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
        //dataSets.add(ds2019);
        return dataSets;
    }

    @Test
    public void chartDataIsCorrect() {
        AppPage appPage = page.loginPage().loginWithValidCredentials();
        appPage.compareExpensesBtn.click();
        List<DataSet> actualChartData = appPage.getChartData();
        Assert.assertEquals(getExpectedChartData(), actualChartData);
    }
}
