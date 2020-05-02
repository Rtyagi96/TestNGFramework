package Framework.helper.browserConfig;

import Framework.helper.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {
        public ChromeOptions getChromeOptions() {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--test-type");
            option.addArguments("--disable-popup-blocking");

            DesiredCapabilities chrome = DesiredCapabilities.chrome();
            chrome.setJavascriptEnabled(true);

            option.setCapability(ChromeOptions.CAPABILITY, chrome);

            if (System.getProperty("os.name").contains("Linux")) {
                option.addArguments("--headless", "windows-size=1028,768", "--no sandbox");
            }
            return option;
        }
        public WebDriver getChromeDriver(ChromeOptions cap){
            if(System.getProperty("os.name").contains("Mac")){
                System.setProperty("webdriver.chrome.drive", ResourceHelper.getResourcePath("/src/main/driver/chromedriver"));
                return new ChromeDriver(cap);
            }
            else if (System.getProperty("os.name").contains("window")){
                System.setProperty("webdriver.chrome.drive", ResourceHelper.getResourcePath("//src//main//driver//chromedriver.exe"));
                return new ChromeDriver(cap);
            }
            else if (System.getProperty("os.name").contains("Linux")){
                System.setProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("/usr/bin/chrome"));
                return new ChromeDriver(cap);
            }
                return null;
        }
}
