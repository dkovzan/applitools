package applitoolsTests;

import org.junit.Test;
import pageObjects.AppPage;

public class VisualAITests extends ApplitoolsBase {

	//Login Page UI Elements Test
	@Test
	public void checkLoginPageUIElements() {
		eyesManager.validateWindow();
	}

	//Data-Driven Tests
	@Test
	public void loginWithEmptyCredentials() {
		page.loginPage().login("", "");
		eyesManager.validateWindow();
	}

	@Test
	public void loginWithEmptyPass() {
		page.loginPage().login("test", "");
		eyesManager.validateWindow();
	}

	@Test
	public void loginWithEmptyUsername() {
		page.loginPage().login("", "test");
		eyesManager.validateWindow();
	}

	@Test
	public void successfulLoginWithValidCredentials() {
		page.loginPage().loginWithValidCredentials();
		eyesManager.validateWindow();
	}

	//Table Sort Test
	@Test
	public void expensesTableIsCorrect() {
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		eyesManager.validateRegion(appPage.getExpensesTableLocator());
	}

	@Test
	public void tableSortingByAmountIsCorrect() {
		AppPage appPage  = page.loginPage().loginWithValidCredentials();
		appPage.transactionsAmountHeader.click();
		eyesManager.validateRegion(appPage.getExpensesTableLocator());
	}

	//Canvas Chart Test
	@Test
	public void canvasChart1718IsCorrect() {
		AppPage appPage  = page.loginPage().loginWithValidCredentials();
		appPage.compareExpensesBtn.click();
		eyesManager.validateRegion(appPage.getCanvasChartLocator());
	}

	@Test
	public void canvasChart19IsAdded() {
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		appPage.compareExpensesBtn.click();
		appPage.showDataForNextYearBtn.click();
		eyesManager.validateRegion(appPage.getCanvasChartLocator());
	}

	//Dynamic Content Test
	@Test
	public void gifsAreDisplayed() {
		driver.get(driver.getCurrentUrl() + "?showAd=true");
		page.loginPage().loginWithValidCredentials();
		eyesManager.validateWindow();
	}
}
