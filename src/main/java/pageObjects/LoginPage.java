package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends Page {

	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

	public static final String Url = Host + System.getProperty("loginPage");

	LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private static final String headerXpath = "//h4[@class='auth-header']";
	private static final String logoXpath = "//div[@class='logo-w']";
	private static final String loginBtnCssSel = "#log-in";
	private static final String usernameLabelXpath = "//form/div[@class='form-group'][1]/label";
	private static final String usernameFieldXpath = "//form/div[@class='form-group'][1]/input";
	private static final String usernameIconXpath = "//form/div[@class='form-group'][1]/div";
	private static final String passwordLabelXpath = "//form/div[@class='form-group'][2]/label";
	private static final String passwordFieldXpath = "//form/div[@class='form-group'][2]/input";
	private static final String passwordIconXpath = "//form/div[@class='form-group'][2]/div";
	private static final String alertWarningXpath = "//div[@class='alert alert-warning']";
	private static final String rememberMeCheckXpath = "//input[@class='form-check-input']";
	private static final String rememberMeLabelXpath = "//label[@class='form-check-label']";
	private static final String twitterIconXpath = "//img[@src='img/social-icons/twitter.png']";
	private static final String facebookIconXpath = "//img[@src='img/social-icons/facebook.png']";
	private static final String linkedinIconXpath = "//img[@src='img/social-icons/linkedin.png']";

	@FindBy(xpath = headerXpath)
	public WebElement header;

	@FindBy(xpath = logoXpath)
	public WebElement logo;

	@FindBy(xpath = usernameLabelXpath)
	public WebElement usernameLabel;

	@FindBy(xpath = usernameFieldXpath)
	public WebElement usernameField;

	@FindBy(xpath = usernameIconXpath)
	public WebElement usernameIcon;

	@FindBy(xpath = passwordLabelXpath)
	public WebElement passwordLabel;

	@FindBy(xpath = passwordFieldXpath)
	public WebElement passwordField;

	@FindBy(xpath = passwordIconXpath)
	public WebElement passwordIcon;

	@FindBy(css = loginBtnCssSel)
	public WebElement loginBtn;

	@FindBy(xpath = rememberMeCheckXpath)
	public WebElement rememberMeCheckbox;

	@FindBy(xpath = rememberMeLabelXpath)
	public WebElement rememberMeLabel;

	@FindBy(xpath = twitterIconXpath)
	public WebElement twitterIcon;

	@FindBy(xpath = facebookIconXpath)
	public WebElement facebookIcon;

	@FindBy(xpath = linkedinIconXpath)
	public WebElement linkedinIcon;

	@FindBy(xpath = alertWarningXpath)
	public WebElement alertWarning;

	public AppPage login(String username, String password) {
		Page.enterText(username, usernameField);
		Page.enterText(password, passwordField);
		loginBtn.click();
		AppPage appPage = Page.isDisplayed(appPage().userAvatarOfHeader) ? new AppPage(driver) : null;
		if (appPage != null)
			logger.info("User " + username + " successfully logged in.");
		else
			logger.info("User is not logged in.");
		return appPage;
	}

	public AppPage loginWithValidCredentials() {
		return login("test", "test");
	}

	public boolean warningIsDisplayed() {
		return Page.isDisplayed(alertWarning);
	}

}
