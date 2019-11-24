import org.junit.Assert;
import org.junit.Test;

public class DynamicContent extends WebBaseTests {

	@Test
	public void isFlashSaleDisplayed() {
		driver.get(Util.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertTrue(Page.isDisplayed(appPage.flashSaleElem));
	}

	@Test
	public void isFlashSale2Displayed() {
		driver.get(Util.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertTrue(Page.isDisplayed(appPage.flashSale2Elem));
	}

	@Test
	public void isFlashSaleGifCorrect() {
		driver.get(Util.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertEquals(
				Util.host + "/img/flashSale.gif",
				Page.getImageSource(Page.getChildImage(appPage.flashSaleElem)));
	}

	@Test
	public void isFlashSale2GifCorrect() {
		driver.get(Util.loginPageWithAd);
		AppPage appPage = page.loginPage().loginWithValidCredentials();
		Assert.assertEquals(
				Util.host + "/img/flashSale2.gif",
				Page.getImageSource(Page.getChildImage(appPage.flashSale2Elem)));
	}
}
