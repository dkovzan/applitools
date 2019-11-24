import java.io.IOException;
import java.util.Properties;

public class Util {

	public static final Properties props = Util.getAppProperties();
	public static final String host = props.getProperty("host");
	public static final String loginPageUrl = host + props.getProperty("loginPage");
	public static final String loginPageWithAd = loginPageUrl + "?showAd=true";
	public static final String appPageUrl = host + props.getProperty("appPage");

	private static Properties getAppProperties() {
		Properties prop = new Properties();
		try {
			//load a properties file from class path, inside static method
			prop.load(Util.class.getClassLoader().getResourceAsStream("application.properties"));
			//System.setProperties(prop);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
}
