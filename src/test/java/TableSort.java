import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class TableSort extends WebBaseTests {

    @Test
    public void checkSortingOfAmountColumn() {
        page.loginPage().login("test","test");
        Map<Double, String> tableContentBeforeSorting = page.appPage().getTransactionsTableContent();
        Assert.assertTrue("Sorting of amount values is wrong", page.appPage().isAmountColumnSorted());
        Assert.assertTrue("Table content after sorting is wrong", page.appPage().isTableContentCorrectAfterSorting(tableContentBeforeSorting));
    }
}
