package Framework.helper.navigation;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.WebDriver;
import java.util.Set;
import java.util.logging.Logger;

public class Navigation {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(Navigation.class);

    public Navigation(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method will switch the focus to the parent window or the main window of the browser.
     */
    public void switchToParentWindow(){
        log.info("switching to parent window");
        driver.switchTo().defaultContent();
    }

    /**
     * This method will switch to the window based on the index of the window
     * @param  index
     */
    public void switchToWindow(int index){
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for(String window: windows){
            if(i == index){
                log.info("switched to the:"+ index + "tab");
                driver.switchTo().window(window);
            }
            else{
                i++;
            }
        }
    }

    /**
     * This method will close all the child tabs in the browser and switch the focus on the parent window.
     */
    public void closeTabAndToParent(){
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        for(String window: windows){
            if(!window.equalsIgnoreCase(parentWindow)){
                log.info("Closed the child tab:"+ window);
                driver.close();
            }
        }
        log.info("Switched to the parent window");
        driver.switchTo().window(parentWindow);
    }

    /**
     * this method will help to navigate forward on a web page
     */
    public void navigateForward(){
        log.info("Navigating to"+ driver.getTitle()+ "page");
        driver.navigate().forward();
    }
    /**
     * this method will help to navigate backward on a web page
     */
    public void navigateBack() {
        log.info("Navigating to" + driver.getTitle() + "page");
        driver.navigate().back();
    }
    /**
     * this method will help to reload web page
     */
    public void refresh() {
        log.info("Reloading" + driver.getTitle() + "page");
        driver.navigate().refresh();
    }
}
