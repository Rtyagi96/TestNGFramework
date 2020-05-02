package Framework.helper.assertion;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class VerificationHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

    public VerificationHelper(WebDriver driver){
        this.driver = driver;
    }
    public boolean isDisplayed(WebElement element){
        try{
            element.isDisplayed();
            log.info("Element is visible on web page"+ element.getText());
            return true;
        }
        catch (Exception e) {
            log.info("Element not visible"+ e.getCause());
            return false;

        }
    }
    public boolean isNotDisplayed(WebElement element){
        try{
            element.isDisplayed();
            log.info("Web Element is visible on web page"+ element.getText());
            return false;
        }
        catch(Exception e) {
            log.info("Web Element is not visible"+ e.getCause());
            return true;

        }
    }
    public String readTextFromElement(WebElement element){
        if(null == element){
            log.info("Web element is null ");
            return null;
        }
        boolean status = isDisplayed(element);
        if(status){
            log.info("Element text is : "+ element.getText());
            return element.getText();
        }else
            return null;
    }
    public String getText(WebElement element){
        if(null == element){
            log.info("Web element is null ");
            return null;
        }
        boolean status = isDisplayed(element);
        if(status){
            log.info("Element text is : "+ element.getText());
            return element.getText();
        }else
            return null;
    }
    public String getTitle(){
        log.info("Title of the page is: "+ driver.getTitle());
        return driver.getTitle();
    }
}
