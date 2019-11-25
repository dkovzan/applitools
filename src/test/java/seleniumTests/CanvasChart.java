package seleniumTests;

import model.DataSet;
import org.junit.Assert;
import org.junit.Test;
import pageObjects.AppPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanvasChart extends WebBase {

    @Test
    public void chartData1718IsCorrect() {
        AppPage appPage = page.loginPage().loginWithValidCredentials();
        appPage.compareExpensesBtn.click();

        List<DataSet> actualChartData = appPage.getChartData();
        List<DataSet> expectedChartData = getExpectedChartData1718();

        Assert.assertEquals(expectedChartData,actualChartData);
    }

    @Test
	public void chartData171819IsCorrect() {
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		appPage.compareExpensesBtn.click();
		appPage.showDataForNextYearBtn.click();

		List<DataSet> actualChartData = appPage.getChartData();
		List<DataSet> expectedChartData = getExpectedChartData171819();

		Assert.assertEquals(expectedChartData,actualChartData);
	}

    private static List<DataSet> getExpectedChartData1718() {

        List<DataSet> dataSets = new ArrayList<>();

        DataSet ds2017 = new DataSet();
        ds2017.setLabel("2017");
        ds2017.setBackgroundColor("rgba(255, 99, 132, 0.5)");
        ds2017.setBorderColor("rgb(255, 99, 132)");
        ds2017.setBorderWidth((long)1);
        ds2017.setData(Arrays.stream(new long[]{10, 20, 30, 40, 50, 60, 70}).boxed().collect(Collectors.toList()));

        DataSet ds2018 = new DataSet();
        ds2018.setLabel("2018");
        ds2018.setBackgroundColor("rgba(54, 162, 235, 0.5)");
        ds2018.setBorderColor("rgb(54, 162, 235)");
        ds2018.setBorderWidth((long) 1);
        ds2018.setData(Arrays.stream(new long[]{8, 9, -10, 10, 40, 60, 40}).boxed().collect(Collectors.toList()));

        dataSets.add(ds2017);
        dataSets.add(ds2018);

        return dataSets;
    }

    private static List<DataSet> getExpectedChartData171819() {
        DataSet ds2019 = new DataSet();
        ds2019.setLabel("2019");
        ds2019.setBackgroundColor("rgba(255, 205, 86, 0.5)");
        ds2019.setBorderColor("rgb(255, 205, 86)");
        ds2019.setBorderWidth((long) 1);
        ds2019.setData(Arrays.stream(new long[]{5, 10, 15, 20, 25, 30, 35}).boxed().collect(Collectors.toList()));

        List<DataSet> dataSet = getExpectedChartData1718();
        dataSet.add(ds2019);
        return dataSet;
    }
}
