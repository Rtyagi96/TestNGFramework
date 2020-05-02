package Framework.helper.select;

import Framework.helper.logger.LoggerHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class DropdownHelper {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(DropdownHelper.class);

    public DropdownHelper(WebDriver driver){
        this.driver = driver;
    }

    public void selectUsingValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("selectUsingValue and value selected is : "+ value);
    }
    public void selectByIndex(WebElement element, int index){
        Select select =new Select(element);
        select.selectByIndex(index);
        log.info("selectByIndex and index is : "+ index);
    }
    public void selectUsingVisibleText(WebElement element, String visibleText){
        Select select =new Select(element);
        select.selectByVisibleText(visibleText);
        log.info("selectUsingVisibleText and text is : "+ visibleText);
    }
    public void deSelectUsingValue(WebElement element, String value){
        Select select =new Select(element);
        select.deselectByValue(value);
        log.info("deSelectUsingValue and value is : "+ value);
    }
    public void deSelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.deselectByIndex(index);
        log.info("deSelectUsingIndex and index is : "+ index);
    }
    public void deSelectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.deselectByVisibleText(visibleText);
        log.info("deSelectUsingVisibleText and text is : " + visibleText);
    }
    public void deSelectAll(WebElement element){
        Select select = new Select(element);
        select.deselectAll();
        log.info("deselecting all values..");
    }
    public List<String> getAllDropDownData(WebElement element){
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for(WebElement e: elementList){
            log.info(""+ e.getText());
            valueList.add(e.getText());
        }
        return valueList;
    }
}

