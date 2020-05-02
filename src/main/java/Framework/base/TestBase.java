package Framework.base;

import Framework.helper.browserConfig.BrowserType;
import Framework.helper.browserConfig.ChromeBrowser;
import Framework.helper.browserConfig.FirefoxBrowser;
import Framework.helper.browserConfig.IEBrowser;
import Framework.helper.browserConfig.config.ConfigReader;
import Framework.helper.browserConfig.config.ObjectReader;
import Framework.helper.browserConfig.config.PropertyReader;
import Framework.helper.logger.LoggerHelper;
import Framework.helper.wait.WaitHelper;
import Framework.utlis.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(TestBase.class);

    public TestBase(WebDriver driver){
        this.driver = driver;
    }
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void beforeSuite(){
        extent= ExtentManager.getInstance();
    }
    @BeforeClass
    public void beforeClass(){
        test = extent.createTest(getClass().getName());
    }
    @BeforeTest
    public void beforeTest(){
        //ConfigReader reader = new PropertyReader();
        ObjectReader.reader = new PropertyReader();
    }
    @BeforeMethod
    public void beforeMethod(Method method){
        test.log(Status.INFO, method.getName()+ " test started");
    }
    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS,result.getName()+ " is pass");
        }
        else if (result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP,result.getThrowable());
        }
        extent.flush();
    }
    public WebDriver getBrowserObject(BrowserType browserType) throws Exception {
        try {
            switch (browserType){
                case Chrome:
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance();
                    ChromeOptions option = chrome.getChromeOptions();
                    return chrome.getChromeDriver(option);
                case Firefox:
                    FirefoxBrowser firefoxBrowser = FirefoxBrowser.class.newInstance();
                    FirefoxOptions options = firefoxBrowser.getFirefoxOptions();
                    return firefoxBrowser.getFirefoxDriver(options);
                case IE:
                    IEBrowser ieBrowser = IEBrowser.class.newInstance();
                    InternetExplorerOptions cap = ieBrowser.internetExplorerOptions();
                    return ieBrowser.getInternetExplorerDriver(cap);
                default:
                    throw new Exception("Driver not found"+ browserType.name());
            }
        }
        catch (Exception e){
            log.info(e.getMessage());
            throw e;
        }
    }
    public void setUpDriver(BrowserType browserType) throws Exception {
        driver = getBrowserObject(browserType);
        log.info("Initializing the web driver"+ driver.hashCode());
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
        waitHelper.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public String captureScreen(String fileName){
        if(driver == null){
            log.info("driver is null");
            return null;
        }
        if (fileName.equals("")){
            fileName ="blank";
        }
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        return fileName;
    }
}
