package applitoolsTests;

import org.junit.Test;
import pageObjects.AppPage;
import utils.Config;

public class VisualAITests extends ApplitoolsBase {

    //Login Page UI Elements Test
    @Test
    public void checkLoginPageUIElements() {
        eyes.checkWindow(name.getMethodName());
    }

    //Data-Driven Tests
    @Test
    public void loginWithEmptyCredentials() {
        page.loginPage().login(null, null);
        eyes.checkWindow(name.getMethodName());
    }

    @Test
    public void loginWithEmptyPass() {
        page.loginPage().login("test", null);
        eyes.checkWindow(name.getMethodName());
    }

    @Test
    public void loginWithEmptyUsername() {
        page.loginPage().login(null, "test");
        eyes.checkWindow(name.getMethodName());
    }

    @Test
    public void successfulLoginWithValidCredentials() {
        page.loginPage().loginWithValidCredentials();
        eyes.checkWindow(name.getMethodName());
    }

    //Table Sort Test
    @Test
    public void expensesTableIsCorrect() {
        AppPage appPage  = page.loginPage().loginWithValidCredentials();
        eyes.checkWindow(name.getMethodName());
    }

    @Test
    public void tableSortingByAmountIsCorrect() {
        AppPage appPage  = page.loginPage().loginWithValidCredentials();
        appPage.transactionsAmountHeader.click();
        eyes.checkWindow(name.getMethodName());
    }

    //Canvas Chart Test
    @Test
    public void canvasChart1718IsCorrect() {
        AppPage appPage  = page.loginPage().loginWithValidCredentials();
        appPage.compareExpensesBtn.click();
        eyes.checkWindow(name.getMethodName());
    }

    @Test
    public void canvasChart19IsAdded() {
        AppPage appPage = page.loginPage().loginWithValidCredentials();
        appPage.compareExpensesBtn.click();
        appPage.showDataForNextYearBtn.click();
        eyes.checkWindow(name.getMethodName());
    }

    //Dynamic Content Test
    @Test
    public void gifsAreDisplayed() {
        driver.get(Config.loginPageWithAd);
        AppPage appPage = page.loginPage().loginWithValidCredentials();
        eyes.checkWindow(name.getMethodName());
    }
}
