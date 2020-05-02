package Framework.helper.alert;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class AlertHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(AlertHelper.class);

    public AlertHelper(WebDriver driver){
        this.driver = driver;
    }

    public Alert getAlert(){
        log.info("Alert test: "+ driver.switchTo().alert().getText());
        return driver.switchTo().alert();
    }
    public void acceptAlert(){
        getAlert().accept();
        log.info("Accepted the alert message");
    }
    public void dismissAlert(){
        getAlert().dismiss();
        log.info("Alert message rejected");
    }
    public String getAlertText(){
        String alertText = getAlert().getText();
        log.info("alert text is : "+ alertText);
        return alertText;
    }
    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            log.info("alert is present");
            return true;
        }
        catch(NoAlertPresentException e){
            log.info((Supplier<String>) e.getCause());//e.getCause()
            return false;
        }
    }
    public void acceptIfAlertPresent(){
        if(isAlertPresent()){
            acceptAlert();
            log.info("Alert accepted when it was present");
        }else{
            log.info("Alert not present");
        }
    }
    public void dismissAlertIfPresent(){
        if(isAlertPresent()){
            dismissAlert();
            log.info("Dismiss alert if it was present");
        }else{
            log.info("Alert not present");
        }
    }
    public void acceptPrompt(String text){
        if(isAlertPresent()){
            Alert alert = getAlert();
            alert.sendKeys(text);
            alert.accept();
            log.info("Alert text "+ text);
        }
    }
}
