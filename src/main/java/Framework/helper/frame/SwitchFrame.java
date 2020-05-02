package Framework.helper.frame;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;

public class SwitchFrame {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(SwitchFrame.class);

    /**
     * constructor is used for initialization of the Web driver from any
     * other class that might use this Switch Frame Helper class
     * @param driver
     */
    public SwitchFrame(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This will switch to frame based on frame Index
     * @param frameIndex
     */
    public void switchToFrame(int frameIndex){
        driver.switchTo().frame(frameIndex);
        log.info("switched to " + frameIndex + "frame");
    }

    /**
     * This will switch to frame based on frame name
     * @param frameName
     */
    public void switchToFrame(String frameName){
        driver.switchTo().frame(frameName);
        log.info("switched to "+ frameName + "frame");
    }

    /**
     * This will switch to frame based on frame web element
     * @param element
     */
    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
        log.info("switched to " + element.toString());
    }
}
