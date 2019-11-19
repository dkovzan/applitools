import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class UIElements extends WebBaseTests {

	// Login Page UI Elements Test

	@Test
	public void titleIsCorrect() {
		Assert.assertEquals("ACME demo app", driver.getTitle());
	}

	@Test
	public void logoIsDisplayed() {
		Assert.assertTrue(page.loginPage().logo.isDisplayed());
	}

	@Test
	public void logoHasCorrectLink() {
		Assert.assertEquals(host + "/index.html", Page.getChildLinkUrl(page.loginPage().logo));
	}

	@Test
	public void logoIconIsDisplayed() {
		Assert.assertTrue(page.loginPage().logo.findElement(By.xpath("a/img")).isDisplayed());
	}

	@Test
	public void headerIsDisplayed() {
		Assert.assertTrue(page.loginPage().header.isDisplayed());
	}

	@Test
	public void headerTextIsCorrect() {
		Assert.assertEquals("Login Form", page.loginPage().header.getText());
	}

	@Test
	public void usernameLabelIsDisplayed() {
		Assert.assertTrue(page.loginPage().usernameLabel.isDisplayed());
	}

	@Test
	public void usernameLabelTextIsCorrect() {
		Assert.assertEquals("Username", page.loginPage().usernameLabel.getText());
	}

	@Test
	public void usernameFieldIsDisplayed() {
		Assert.assertTrue(page.loginPage().usernameField.isDisplayed());
	}

	@Test
	public void usernameFieldHasCorrectPlaceholder() {
		Assert.assertEquals("Enter your username", Page.getPlaceholder(page.loginPage().usernameField));
	}

	@Test
	public void usernameIconIsDisplayed() {
		Assert.assertTrue(page.loginPage().usernameIcon.isDisplayed());
	}

	@Test
	public void passwordLabelIsDisplayed() {
		Assert.assertTrue(page.loginPage().passwordLabel.isDisplayed());
	}

	@Test
	public void passwordLabelTextIsCorrect() {
		Assert.assertEquals("Password", page.loginPage().passwordLabel.getText());
	}

	@Test
	public void passwordFieldIsDisplayed() {
		Assert.assertTrue(page.loginPage().passwordField.isDisplayed());
	}

	@Test
	public void passwordIconIsDisplayed() {
		Assert.assertTrue(page.loginPage().passwordIcon.isDisplayed());
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
		Assert.assertTrue(page.loginPage().rememberMeCheckbox.isDisplayed());
	}

	@Test
	public void rememberMeCheckboxIsEnabled() {
		Assert.assertTrue(page.loginPage().rememberMeCheckbox.isEnabled());
	}

	@Test
	public void rememberMeLabelIsDisplayed() {
		Assert.assertTrue(page.loginPage().rememberMeLabel.isDisplayed());
	}

	@Test
	public void rememberMeLabelTextIsCorrect() {
		Assert.assertEquals("Remember Me", page.loginPage().rememberMeLabel.getText());
	}

	@Test
	public void twitterIconIsDisplayed() {
		Assert.assertTrue(page.loginPage().twitterIcon.isDisplayed());
	}

	@Test
	public void twitterIconHasCorrectLink() {
		Assert.assertEquals(applicationUnderTest + "#", Page.getParentLinkUrl(page.loginPage().twitterIcon));
	}

	@Test
	public void facebookIconIsDisplayed() {
		Assert.assertTrue(page.loginPage().facebookIcon.isDisplayed());
	}

	@Test
	public void facebookIconHasCorrectLink() {
		Assert.assertEquals(applicationUnderTest + "#", Page.getParentLinkUrl(page.loginPage().facebookIcon));
	}

	@Test
	public void linkedinIconIsDisplayed() {
		Assert.assertTrue(page.loginPage().linkedinIcon.isDisplayed());
	}

	@Test
	public void linkedinIconHasCorrectLink() {
		Assert.assertEquals(applicationUnderTest + "#", Page.getParentLinkUrl(page.loginPage().linkedinIcon));
	}
}
