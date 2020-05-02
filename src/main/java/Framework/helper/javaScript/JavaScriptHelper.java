package Framework.helper.javaScript;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;

public class JavaScriptHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver){
        this.driver = driver;
        log.info("JavaScriptHelper initialized");
    }

    /**
     * Object is the super class of all the classes
     * @param script
     * @return
     */
    public Object executeScript(String script){
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        return exe.executeScript(script);
    }
    public Object executeScript(String script, Object...args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }
    public void scrollToElement(WebElement element){
        log.info("Scroll to webelement "+ element.toString());
        executeScript("window.scrollTo(arguments[0], arguments[1])", element.getLocation().x,element.getLocation().y);
    }
    public void scrollToElementAndClick(WebElement element){
        scrollToElement(element);
        element.click();
        log.info("element is clicked "+ element.toString());
    }
    public void scrollIntoView(WebElement element){
        log.info("scroll till web element");
        executeScript("arguments[0].scrollIntoView()",element);
    }
    public void scrollIntoViewAndClick(WebElement element){
        scrollIntoView(element);
        element.click();
        log.info("element is clicked "+ element.toString());
    }
    public void scrollToBottom(){
        log.info("scrolling to the bottom of the page");
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollToTop(){
        executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        log.info("scrolling to the top of the page");
    }
    public void scrollDownByPixel(int pixel){
        executeScript("window.scrollBY(0, "+pixel+")");
    }
    public void scrollUpByPixel(int pixel) {
        executeScript("window.scrollBY(0, -" + pixel + ")");
    }
    public void zoomInBy100Percentage(){
        executeScript("document.body.style.zoom='100%'");
    }
    public void zoomInBy60Percentage(){
        executeScript("document.body.style.zoom ='60%'");
    }
    public void clickElement(WebElement element){
        executeScript("arguments[0].click();",element);
    }
}
