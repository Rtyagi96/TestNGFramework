package Framework.helper.wait;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class WaitHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(WaitHelper.class);

    /**
     * constructor is used for initialization of the Webdriver from any
     * other class that might use this Wait Helper class
     * @param driver
     */
    public WaitHelper(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Implicit wait method
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit){
        log.info("Implicit wait has been set to "+ timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }

    /**
     * This will give you explicit wait object and it will be used within the class hence private.
     * @param timeOutInSecond
     * @param pollingEveryInMiliSec
     * @return
     */
    private WebDriverWait getWait(int timeOutInSecond, int pollingEveryInMiliSec){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }
    public void WaitForElementVisible(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + "seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now");
    }
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + "seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is clickable now");
    }
    public boolean WaitForElementNotPresent(WebElement element, long timeOutInSeconds){
        log.info("waiting for " + element.toString() + "for" + timeOutInSeconds + "seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        boolean  status = wait.until(ExpectedConditions.invisibilityOf(element));
        return status;
    }

    /**
     * This method will give us Fluent wait object and it will be used within the class hence private.
     * @param timeOutInSecond
     * @param pollingEveryInMiliSec
     * @return
     */
    private Wait<WebDriver> getFluentWait(int timeOutInSecond, int pollingEveryInMiliSec){
        Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(timeOutInSecond))
                .pollingEvery(Duration.ofMillis(pollingEveryInMiliSec))
                .ignoring(NoSuchElementException.class);
        return fWait;
    }
    public WebElement waitForElement(WebElement element, int timeOutInSecond, int pollingEveryInMiliSec){
        Wait<WebDriver> fWait = getFluentWait(timeOutInSecond, pollingEveryInMiliSec);
        fWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public void pageLoadTime(long timeout, TimeUnit unit){
        log.info("Waiting for page to load "+ unit + "seconds");
        driver.manage().timeouts().implicitlyWait(timeout, unit);
        log.info("Page loaded successfully");
    }
}
