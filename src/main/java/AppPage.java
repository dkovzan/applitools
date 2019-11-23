import model.DataSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AppPage extends Page {

    AppPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String transactionsRowsCssSel = "#transactionsTable>tbody>tr";
    private static final String transactionsAmountHeaderCssSel = "#amount";
    private static final String transactionAmountCellInRowCssSel = "td>span.text-danger, span.text-success";
    private static final String canvasChartCssSel = "#canvas";
    private static final String showDataForNextYearBtnCssSel = ".btn, .btn-warning";
    private static final String compareExpensesBtnCssSel = "#showExpensesChart";

    @FindBy(css = transactionsRowsCssSel)
    List<WebElement> transactionsRows;

    @FindBy(css = transactionsAmountHeaderCssSel)
    WebElement transactionsAmountHeader;

    @FindBy(css = canvasChartCssSel)
    WebElement canvasChart;

    @FindBy(css = showDataForNextYearBtnCssSel)
    WebElement showDataForNextYearBtn;

    @FindBy(css = compareExpensesBtnCssSel)
    WebElement compareExpensesBtn;

    List<DataSet> getChartData() {
        appPage().waitVisibilityOf(canvasChart);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<DataSet> test = (List<DataSet>) js.executeScript("return barChartData.datasets.map(x => [x.label, x.backgroundColor, x.borderColor, x.borderWidth, x.data]);");
        return test;
    }

    Map<Double, String> getTransactionsTableContent() {
        Map<Double, String> table = new HashMap<Double, String>();
        for (WebElement row : transactionsRows) {
            table.put(getAmountCellValue(row), row.getText());
        }
        return table;
    }

    boolean isAmountColumnSorted() {

        double[] amounts = new double[transactionsRows.size()];

        for (int i = 0; i < transactionsRows.size(); i++) {

            if (!Page.isDisplayed(transactionsRows.get(i)))
                moveToElement(transactionsRows.get(i));

            double amount = getAmountCellValue(transactionsRows.get(i));
            amounts[i] = amount;
        }
        return isArraySorted(amounts);
    }

    boolean isTableContentCorrectAfterSorting(Map<Double, String> tableBeforeSorting) {
        boolean result = true;

        Map<Double, String> tableAfterSorting = getTransactionsTableContent();

        for(Map.Entry<Double, String> entry : tableAfterSorting.entrySet()) {
            for (Double amount : tableBeforeSorting.keySet()) {
                if (!tableAfterSorting.get(amount).equals(tableBeforeSorting.get(amount))) {
                    result = false;
                }
            }
        }
        return result;
    }

    private static double getAmountCellValue(WebElement amountCell) {
        return Double.parseDouble(amountCell.findElement(By.cssSelector(transactionAmountCellInRowCssSel)).getText().trim().replaceAll("[ +USD,]", ""));
    }

    private boolean isArraySorted(double[] arr) {
        return arraySortedOrNot(arr, arr.length) != 0;
    }

    private Integer arraySortedOrNot(double[] arr, int n) {
        if (n == 1 || n == 0)
            return 1;

        if (arr[n - 1] < arr[n - 2])
            return 0;

        return arraySortedOrNot(arr, n - 1);
    }

}
