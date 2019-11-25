package utils;

import java.io.IOException;
import java.util.Properties;

public class Config {

	public static final Properties props = getAppProperties();
	public static final String host = props.getProperty("host");
	public static final String loginPageUrl = host + props.getProperty("loginPage");
	public static final String loginPageWithAd = loginPageUrl + "?showAd=true";
	public static final String appPageUrl = host + props.getProperty("appPage");

	private static Properties getAppProperties() {
		Properties prop = new Properties();
		try {
			prop.load(Config.class.getClassLoader().getResourceAsStream("application.properties"));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
}
