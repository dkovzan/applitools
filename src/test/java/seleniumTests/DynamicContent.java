package seleniumTests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.AppPage;
import pageObjects.Page;

public class DynamicContent extends WebBase {

	@Test
	public void isFlashSaleDisplayed() {
		driver.get(driver.getCurrentUrl() + "?showAd=true");
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertTrue(Page.isDisplayed(appPage.flashSaleElem));
	}

	@Test
	public void isFlashSale2Displayed() {
		driver.get(driver.getCurrentUrl() + "?showAd=true");
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertTrue(Page.isDisplayed(appPage.flashSale2Elem));
	}

	@Test
	public void isFlashSaleGifCorrect() {
		driver.get(driver.getCurrentUrl() + "?showAd=true");
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertEquals(
				Page.Host + "/img/flashSale.gif",
				Page.getImageSource(Page.getChildImage(appPage.flashSaleElem)));
	}

	@Test
	public void isFlashSale2GifCorrect() {
		driver.get(driver.getCurrentUrl() + "?showAd=true");
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertEquals(
				Page.Host + "/img/flashSale2.gif",
				Page.getImageSource(Page.getChildImage(appPage.flashSale2Elem)));
	}
}
