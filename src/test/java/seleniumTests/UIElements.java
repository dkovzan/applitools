package seleniumTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.Page;

public class UIElements extends WebBase {

	private static String loginFormHeader = "Login Form";
	private static String usernameLabel = "Username";
	private static String usernameFieldPlaceholder = "Enter your username";
	private static String passwordLabel = "Password";
	private static String passwordFieldPlaceholder = "Enter you password";
	private static String loginBtnName = "Log In";
	private static String rememberMeLabel = "Remember Me";


	@Test
	public void logoIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().logo));
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
		Assert.assertEquals(loginFormHeader, page.loginPage().header.getText());
	}

	@Test
	public void usernameLabelIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().usernameLabel));
	}

	@Test
	public void usernameLabelTextIsCorrect() {
		Assert.assertEquals(usernameLabel, page.loginPage().usernameLabel.getText());
	}

	@Test
	public void usernameFieldIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().usernameField));
	}

	@Test
	public void usernameFieldHasCorrectPlaceholder() {
		Assert.assertEquals(usernameFieldPlaceholder, Page.getPlaceholder(page.loginPage().usernameField));
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
		Assert.assertEquals(passwordLabel, page.loginPage().passwordLabel.getText());
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
		Assert.assertEquals(passwordFieldPlaceholder, Page.getPlaceholder(page.loginPage().passwordField));
	}

	@Test
	public void loginBtnIsDisplayed() {
		Assert.assertTrue("Login button is missing", Page.isDisplayed(page.loginPage().loginBtn));
	}

	@Test
	public void loginBtnNameIsCorrect() {
		Assert.assertEquals("Login button name is incorrect", loginBtnName, page.loginPage().loginBtn.getText());
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
		Assert.assertEquals(rememberMeLabel, page.loginPage().rememberMeLabel.getText());
	}

	@Test
	public void twitterIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().twitterIcon));
	}

	@Test
	public void facebookIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().facebookIcon));
	}

	@Test
	public void linkedinIconIsDisplayed() {
		Assert.assertTrue(Page.isDisplayed(page.loginPage().linkedinIcon));
	}

}
