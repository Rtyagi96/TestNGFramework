package Framework.helper.browserConfig.config;

import Framework.helper.browserConfig.BrowserType;

public interface ConfigReader {
    public int getImplicitWait();
    public int getExplicitWait();
    public int getPageLoadTime();
    public BrowserType getBrowserType();

}
