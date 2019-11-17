import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Website {

	LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private final String headerXpath = "//h4[@class='auth-header']";
	private final String logoXpath = "//div[@class='logo-w']";
	private final String loginBtnCssSel = "#log-in";
	private final String usernameLabelXpath = "//form/div[@class='form-group'][1]/label";
	private final String usernameFieldXpath = "//form/div[@class='form-group'][1]/input";
	private final String usernameIconXpath = "//form/div[@class='form-group'][1]/div";
	private final String passwordLabelXpath = "//form/div[@class='form-group'][2]/label";
	private final String passwordFieldXpath = "//form/div[@class='form-group'][2]/input";
	private final String passwordIconXpath = "//form/div[@class='form-group'][2]/div";
	private final String alertWarningXpath = "//div[@class='alert alert-warning']";
	private final String rememberMeCheckXpath = "//input[@class='form-check-input']";
	private final String rememberMeLabelXpath = "//label[@class='form-check-label']";
	private final String twitterIconXpath = "//img[@src='img/social-icons/twitter.png']";
	private final String facebookIconXpath = "//img[@src='img/social-icons/facebook.png']";
	private final String linkedinIconXpath = "//img[@src='img/social-icons/linkedin.png']";

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

	void loginWithEmptyPassword() {
		Website.enterText("qwe", usernameField);
		loginBtn.click();
	}

	boolean alertIsDisplayedAfterloginAttemptWithEmptyCredentials() {
		loginBtn.click();
		return Website.isDisplayed(alertWarning);
	}

	boolean alertIsDisplayedAfterLoginAttemptWithEmptyPassword() {
		loginWithEmptyPassword();
		return Website.isDisplayed(alertWarning);
	}

}
