# Applitools hackaton

The challenge is to write five (5) automated tests for both versions of the app:

1. One suite using your preferred traditional functional testing approach
2. Another suite which covers the same tests but uses visual AI testing with Applitools

# Preconditions:
1. Download and install Java 8 (e.g. [jdk1.8.0_231](https://java.com/ru/download/)) and maven (e.g. [apache-maven-3.6.3](https://maven.apache.org/download.cgi)).<br>

2. Setup JAVA_HOME and MAVEN_HOME environment variables e.g. [Guide](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html) and check them via commands:
```
echo %JAVA_HOME%
echo %MAVEN_HOME%
```
3. Download and install Google Chrome browser v78.x.
If any other, then place chromedriver in resources/driders/chromedriver folder and specify path to it in resources/test.properties file:<br>
```webdriver.chrome.driver = path/to/chromedriver```

# Steps to run:
**Main configuration file is located at resources/test.properties.**

1. Clone repository to your PC.

2. Open repository.

3. Specify you API key in resources/test.properties file:<br>
```applitools.api.key=your-key-here```

4. Specify in resources/test.properties file following values:<br>
 ```host=https://demo.applitools.com```
 default=https://demo.applitools.com.
```loginPage=/hackathonV2.html``` 
default for V2 = /hackathonV2.html, for V1 = /hackathon.html

5.1. For Linux specify:<br>
```webdriver.chrome.driver=resources/drivers/chromedriver/chromedriver78Linux in resources/test.properties file```
5.2. For Windows specify:<br>
```webdriver.chrome.driver=resources/drivers/chromedriver/chromedriver78Win64.exe in resources/test.properties file```

6. Specify screen resolution in test.properties:<br>
```screen.width=1024```
default=1024
```screen.height=768```
default=768

7. Run test framework:<br>
- Run "startTraditionalTests.sh" script in terminal for TraditionalTests with Selenium + Java.<br>
```startTraditionalTests.sh```
- Run "startVisualAITests.sh" script in terminal for VisualAITests.<br>
```startVisualAITests.sh```

# Example of test.properties file for Windows with Chrome v78:

```
host=https://demo.applitools.com
loginPage=/hackathonV2.html
webdriver.chrome.driver=resources/drivers/chromedriver/chromedriver78Win64.exe
applitools.api.key=your-key-here
screen.width=1024
screen.height=768
```
