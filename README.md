#Applitools hackaton

The challenge is to write five (5) automated tests for both versions of the app:

1. One suite using your preferred traditional functional testing approach
2. Another suite which covers the same tests but uses visual AI testing with Applitools

**Preconditions:**
Main configuration file is located at resources/test.properties.

1. Chrome browser version should be 78.
If any other, then place chromedriver in resources/driders/chromedriver folder and specify path to it in resources/test.properties file:
webdriver.chrome.driver = "path/to/chromedriver"

2. Specify you API key in resources/test.properties file:
applitools.api.key

3. Specify in resources/test.properties file following values:
 - host (default="https://demo.applitools.com");
 - loginPage(default="/hackathonV2.html") 

4.1. For Linux:
    - specify webdriver.chrome.driver = "resources/drivers/chromedriver/chromedriver78Linux" in resources/test.properties file.
    
4.2. For Windows:
    - specify webdriver.chrome.driver = "resources/drivers/chromedriver/chromedriver78Win64.exe" in resources/test.properties file

5. Specify screen resolution in test.properties:
screen.width (default=1024) and screen.height (default=768)
**How to run:**
- Run "startTraditionalTests.sh" in terminal for TraditionalTests with Selenium + Java.
- Run "startVisualAITests.sh" in terminal for VisualAITests.
