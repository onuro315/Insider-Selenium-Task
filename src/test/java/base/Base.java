package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import test.InterfaceTest;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class Base {

    protected static WebDriver webDriver;
    private final Logger logger = LoggerFactory.getLogger(InterfaceTest.class);
    public static WebDriver getWebDriver() { return webDriver; }
    public static void setWebDriver(WebDriver webDriver) { Base.webDriver = webDriver; }

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser){

        if(browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-translate");
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");

            setWebDriver(new ChromeDriver(options));
        }else if(browser.equals("firefox")){

            setWebDriver(new FirefoxDriver());
        }

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.navigate().to("https://useinsider.com/");
    }

    @BeforeMethod
    public void beforeLog(ITestResult testResult){
        logger.info("Start of: " + testResult.getMethod().getMethodName());
    }


    public void testFail(ITestResult result){
        Date currentDate = new Date();
        String currentDateForFile = currentDate.toString().replace(" ", "-").replace(":", "-");
        File ssFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(ssFile, new File("./Screenshots/ERROR_" + result.getMethod().getMethodName() + currentDateForFile+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void endTest(){ if(webDriver != null){
        webDriver.quit();
    }}
}
