# applitools
Applitools hackaton:

The challenge is to write five (5) automated tests for both versions of the app:

1. One suite using your preferred traditional functional testing approach
2. Another suite which covers the same tests but uses visual AI testing with Applitools

**Preconditions:**
1. Chrome browser version should be 78.
If any other, then place chromedriver in resources folder and specify path to it in resources/test.properties file:
webdriver.chrome.driver = "path/to/chromedriver"
2. Specify in resources/test.properties file following values:
 - host (default="https://demo.applitools.com"), 
 - loginPage(default="/hackathonV2.html"), 
 - appPage(default="/hackathonAppV2.html) 
3.
For Linux:
    - specify webdriver.chrome.driver = "resources/drivers/chromedriver/chromedriver78Linux" in resources/test.properties file 
For Windows:
    - specify webdriver.chrome.driver = "resources/drivers/chromedriver/chromedriver78Win64.exe" in resources/test.properties file

**How to run:**
1. Run "startTraditionalTests.sh" in terminal for TraditionalTests with Selenium + Java.
2. Run "startVisualAITests.sh" in terminal for VisualAITests.
