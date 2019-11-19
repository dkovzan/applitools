import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

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
	WebElement header;

	@FindBy(xpath = logoXpath)
	WebElement logo;

	@FindBy(xpath = usernameLabelXpath)
	WebElement usernameLabel;

	@FindBy(xpath = usernameFieldXpath)
	WebElement usernameField;

	@FindBy(xpath = usernameIconXpath)
	WebElement usernameIcon;

	@FindBy(xpath = passwordLabelXpath)
	WebElement passwordLabel;

	@FindBy(xpath = passwordFieldXpath)
	WebElement passwordField;

	@FindBy(xpath = passwordIconXpath)
	WebElement passwordIcon;

	@FindBy(css = loginBtnCssSel)
	WebElement loginBtn;

	@FindBy(xpath = rememberMeCheckXpath)
	WebElement rememberMeCheckbox;

	@FindBy(xpath = rememberMeLabelXpath)
	WebElement rememberMeLabel;

	@FindBy(xpath = twitterIconXpath)
	WebElement twitterIcon;

	@FindBy(xpath = facebookIconXpath)
	WebElement facebookIcon;

	@FindBy(xpath = linkedinIconXpath)
	WebElement linkedinIcon;

	@FindBy(xpath = alertWarningXpath)
	WebElement alertWarning;

	AppPage login(String username, String password) {
		Page.enterText(username, usernameField);
		Page.enterText(password, passwordField);
		loginBtn.click();
		return driver.getCurrentUrl().equals("https://demo.applitools.com/hackathonApp.html") ? new AppPage(driver) : null;
	}

	boolean warningIsDisplayed() {
		return Page.isDisplayed(alertWarning);
	}

}
