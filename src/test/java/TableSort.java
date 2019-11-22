import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class TableSort extends WebBaseTests {

    @Test
    public void checkSortingOfAmountColumn() {
        AppPage appPage = page.loginPage().loginWithValidCredentials();
        Map<Double, String> tableContentBeforeSorting = appPage.getTransactionsTableContent();
        appPage.transactionsAmountHeader.click();
        Assert.assertTrue("Sorting of amount values is wrong", appPage.isAmountColumnSorted());
        Assert.assertTrue("Table content after sorting is wrong", appPage.isTableContentCorrectAfterSorting(tableContentBeforeSorting));
    }
}
