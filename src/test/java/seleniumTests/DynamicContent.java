package seleniumTests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.AppPage;
import pageObjects.Page;
import utils.Config;

public class DynamicContent extends WebBase {

	@Test
	public void isFlashSaleDisplayed() {
		driver.get(Config.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertTrue(Page.isDisplayed(appPage.flashSaleElem));
	}

	@Test
	public void isFlashSale2Displayed() {
		driver.get(Config.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertTrue(Page.isDisplayed(appPage.flashSale2Elem));
	}

	@Test
	public void isFlashSaleGifCorrect() {
		driver.get(Config.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertEquals(
				Config.host + "/img/flashSale.gif",
				Page.getImageSource(Page.getChildImage(appPage.flashSaleElem)));
	}

	@Test
	public void isFlashSale2GifCorrect() {
		driver.get(Config.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertEquals(
				Config.host + "/img/flashSale2.gif",
				Page.getImageSource(Page.getChildImage(appPage.flashSale2Elem)));
	}
}
