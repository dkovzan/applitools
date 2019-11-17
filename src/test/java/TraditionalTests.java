import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TraditionalTests extends WebBaseTests {

	// Login Website UI Elements Test

	@Test
	public void titleIsCorrect() {
		Assert.assertEquals("ACME demo app", driver.getTitle());
	}

	@Test
	public void logoIsDisplayed() {
		Assert.assertTrue(website.loginPage().logo.isDisplayed());
	}

	@Test
	public void logoHasCorrectLink() {
		Assert.assertEquals(host + "/index.html", website.loginPage().logo.findElement(By.xpath("a")).getAttribute("href"));
	}

	@Test
	public void logoIconIsDisplayed() {
		Assert.assertTrue(website.loginPage().logo.findElement(By.xpath("a/img")).isDisplayed());
	}

	@Test
	public void headerIsDisplayed() {
		Assert.assertTrue(website.loginPage().header.isDisplayed());
	}

	@Test
	public void headerTextIsCorrect() {
		Assert.assertEquals("Login Form", website.loginPage().header.getText());
	}

	@Test
	public void usernameLabelIsDisplayed() {
		Assert.assertTrue(website.loginPage().usernameLabel.isDisplayed());
	}

	@Test
	public void usernameLabelTextIsCorrect() {
		Assert.assertEquals("Username", website.loginPage().usernameLabel.getText());
	}

	@Test
	public void usernameFieldIsDisplayed() {
		Assert.assertTrue(website.loginPage().usernameField.isDisplayed());
	}

	@Test
	public void usernameFieldHasCorrectPlaceholder() {
		Assert.assertEquals("Enter your username", website.loginPage().usernameField.getAttribute("placeholder"));
	}

	@Test
	public void usernameIconIsDisplayed() {
		Assert.assertTrue(website.loginPage().usernameIcon.isDisplayed());
	}

	@Test
	public void passwordLabelIsDisplayed() {
		Assert.assertTrue(website.loginPage().passwordLabel.isDisplayed());
	}

	@Test
	public void passwordLabelTextIsCorrect() {
		Assert.assertEquals("Password", website.loginPage().passwordLabel.getText());
	}

	@Test
	public void passwordFieldIsDisplayed() {
		Assert.assertTrue(website.loginPage().passwordField.isDisplayed());
	}

	@Test
	public void passwordIconIsDisplayed() {
		Assert.assertTrue(website.loginPage().passwordIcon.isDisplayed());
	}

	@Test
	public void passwordFieldHasCorrectPlaceholder() {
		Assert.assertEquals("Enter your password", website.loginPage().passwordField.getAttribute("placeholder"));
	}

	@Test
	public void loginBtnIsDisplayed() {
		Assert.assertTrue("Login button is missing", Website.isDisplayed(website.loginPage().loginBtn));
	}

	@Test
	public void loginBtnNameIsCorrect() {
		Assert.assertEquals("Login button name is incorrect", "Log In", website.loginPage().loginBtn.getText());
	}

	@Test
	public void rememberMeCheckboxIsDisplayed() {
		Assert.assertTrue(website.loginPage().rememberMeCheckbox.isDisplayed());
	}

	@Test
	public void rememberMeCheckboxIsEnabled() {
		Assert.assertTrue(website.loginPage().rememberMeCheckbox.isEnabled());
	}

	@Test
	public void rememberMeLabelIsDisplayed() {
		Assert.assertTrue(website.loginPage().rememberMeLabel.isDisplayed());
	}

	@Test
	public void rememberMeLabelTextIsCorrect() {
		Assert.assertEquals("Remember Me", website.loginPage().rememberMeLabel.getText());
	}

	@Test
	public void twitterIconIsDisplayed() {
		Assert.assertTrue(website.loginPage().twitterIcon.isDisplayed());
	}

	@Test
	public void twitterIconHasCorrectLink() {
		Assert.assertEquals(pageUnderTest + "#", website.loginPage().twitterIcon.findElement(By.xpath("parent::a")).getAttribute("href"));
	}

	@Test
	public void facebookIconIsDisplayed() {
		Assert.assertTrue(website.loginPage().facebookIcon.isDisplayed());
	}

	@Test
	public void facebookIconHasCorrectLink() {
		Assert.assertEquals(pageUnderTest + "#", website.loginPage().facebookIcon.findElement(By.xpath("parent::a")).getAttribute("href"));
	}

	@Test
	public void linkedinIconIsDisplayed() {
		Assert.assertTrue(website.loginPage().linkedinIcon.isDisplayed());
	}

	@Test
	public void linkedinIconHasCorrectLink() {
		Assert.assertEquals(pageUnderTest + "#", website.loginPage().linkedinIcon.findElement(By.xpath("parent::a")).getAttribute("href"));
	}


	// Data Driven test

	@Test
	public void warningMessageIsDisplayedAfterLoginWithEmptyCredentials() {
		Assert.assertTrue(website.loginPage().alertIsDisplayedAfterloginAttemptWithEmptyCredentials());
	}

	@Test
	public void warningMessageTextAfterLoginWithEmptyCredentialsIsCorrect() {
		website.loginPage().loginBtn.click();
		Assert.assertEquals("Both Username and Password must be present", website.loginPage().alertWarning.getText());
	}

	@Test
	public void warningMessageIsDisplayedAfterLoginWithEmptyPassword() {
		Assert.assertTrue(website.loginPage().alertIsDisplayedAfterLoginAttemptWithEmptyPassword());
	}

	@Test
	public void warningMessageTextAfterLoginWithEmptyPasswordIsCorrect() {
		website.loginPage().loginWithEmptyPassword();
		Assert.assertEquals("Password must be present", website.loginPage().alertWarning.getText());
	}
}
