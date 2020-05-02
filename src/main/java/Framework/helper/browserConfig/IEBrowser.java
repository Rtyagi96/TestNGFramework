package Framework.helper.browserConfig;

import Framework.helper.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEBrowser {
    public InternetExplorerOptions internetExplorerOptions() {
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();

        FirefoxProfile profile = new FirefoxProfile();
        cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        cap.setJavascriptEnabled(true);

        return new InternetExplorerOptions(cap);
    }
    public WebDriver getInternetExplorerDriver(InternetExplorerOptions cap){
            System.setProperty("webdriver.ie.driver",ResourceHelper.getResourcePath("/usr/bin/ie.exe"));
            return new InternetExplorerDriver(cap);
    }
}
