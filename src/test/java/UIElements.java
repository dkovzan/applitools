import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class UIElements extends WebBaseTests {

	@Test
	public void titleIsCorrect() {
		Assert.assertEquals("ACME demo app", driver.getTitle());
	}

	@Test
	public void logoIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().logo));
	}

	@Test
	public void logoHasCorrectLink() {
		Assert.assertEquals(Util.host + "/index.html", Page.getChildLinkUrl(page.loginPage().logo));
	}

	@Test
	public void logoIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().logo.findElement(By.xpath("a/img"))));
	}

	@Test
	public void headerIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().header));
	}

	@Test
	public void headerTextIsCorrect() {
		Assert.assertEquals("Login Form", page.loginPage().header.getText());
	}

	@Test
	public void usernameLabelIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().usernameLabel));
	}

	@Test
	public void usernameLabelTextIsCorrect() {
		Assert.assertEquals("Username", page.loginPage().usernameLabel.getText());
	}

	@Test
	public void usernameFieldIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().usernameField));
	}

	@Test
	public void usernameFieldHasCorrectPlaceholder() {
		Assert.assertEquals("Enter your username", Page.getPlaceholder(page.loginPage().usernameField));
	}

	@Test
	public void usernameIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().usernameIcon));
	}

	@Test
	public void passwordLabelIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().passwordLabel));
	}

	@Test
	public void passwordLabelTextIsCorrect() {
		Assert.assertEquals("Password", page.loginPage().passwordLabel.getText());
	}

	@Test
	public void passwordFieldIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().passwordField));
	}

	@Test
	public void passwordIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().passwordIcon));
	}

	@Test
	public void passwordFieldHasCorrectPlaceholder() {
		Assert.assertEquals("Enter your password", Page.getPlaceholder(page.loginPage().passwordField));
	}

	@Test
	public void loginBtnIsDisplayed() {
		Assert.assertTrue("Login button is missing", Page.isDisplayed(page.loginPage().loginBtn));
	}

	@Test
	public void loginBtnNameIsCorrect() {
		Assert.assertEquals("Login button name is incorrect", "Log In", page.loginPage().loginBtn.getText());
	}

	@Test
	public void rememberMeCheckboxIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().rememberMeCheckbox));
	}

	@Test
	public void rememberMeCheckboxIsEnabled() {
		Assert.assertTrue(page.loginPage().rememberMeCheckbox.isEnabled());
	}

	@Test
	public void rememberMeLabelIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().rememberMeLabel));
	}

	@Test
	public void rememberMeLabelTextIsCorrect() {
		Assert.assertEquals("Remember Me", page.loginPage().rememberMeLabel.getText());
	}

	@Test
	public void twitterIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().twitterIcon));
	}

	@Test
	public void twitterIconHasCorrectLink() {
		Assert.assertEquals(Util.loginPageUrl + "#", Page.getParentLinkUrl(page.loginPage().twitterIcon));
	}

	@Test
	public void facebookIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().facebookIcon));
	}

	@Test
	public void facebookIconHasCorrectLink() {
		Assert.assertEquals(Util.loginPageUrl + "#", Page.getParentLinkUrl(page.loginPage().facebookIcon));
	}

	@Test
	public void linkedinIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().linkedinIcon));
	}

	@Test
	public void linkedinIconHasCorrectLink() {
		Assert.assertEquals(Util.loginPageUrl + "#", Page.getParentLinkUrl(page.loginPage().linkedinIcon));
	}
}
